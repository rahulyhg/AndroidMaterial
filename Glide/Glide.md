#Glide分析

Glide加载异步图片
```
    Glide.with(this)
    .load("http://tp2.sinaimg.cn/2097044773/50/40010690517/0")
    .into((ImageView) findViewById(R.id.glide_iv_icon));
```
Glide通过构建者构建,内部封装的属性如下
```
    private static final String TAG = "Glide";
    private static volatile Glide glide;

    private final GenericLoaderFactory loaderFactory;
    private final Engine engine;
    private final BitmapPool bitmapPool;
    private final MemoryCache memoryCache;
    private final DecodeFormat decodeFormat;
    private final ImageViewTargetFactory imageViewTargetFactory = new ImageViewTargetFactory();
    private final TranscoderRegistry transcoderRegistry = new TranscoderRegistry();
    private final DataLoadProviderRegistry dataLoadProviderRegistry;
    private final CenterCrop bitmapCenterCrop;
    private final GifBitmapWrapperTransformation drawableCenterCrop;
    private final FitCenter bitmapFitCenter;
    private final GifBitmapWrapperTransformation drawableFitCenter;
    private final Handler mainHandler;
    private final BitmapPreFiller bitmapPreFiller;
```
Glide.with(this)返回的是一个RequestManager
```
    public static RequestManager with(FragmentActivity activity) {
        RequestManagerRetriever retriever = RequestManagerRetriever.get();
        return retriever.get(activity);
    }
```
RequestManagerRetriever.get();获取RequestManagerRetriever单例，饿汉加载方式。
```
    // Visible for testing.
    RequestManagerRetriever() {
        handler = new Handler(Looper.getMainLooper(), this /* Callback */);
    }
```
构造方法只创建了Handler。接着看with方法通过RequestManagerRetriever的get方法，获取RequestManager并返回。
```
    public RequestManager get(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        } else if (Util.isOnMainThread() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return get((FragmentActivity) context);
            } else if (context instanceof Activity) {
                return get((Activity) context);
            } else if (context instanceof ContextWrapper) {
                return get(((ContextWrapper) context).getBaseContext());
            }
        }

        return getApplicationManager(context);
    }
    public RequestManager get(FragmentActivity activity) {
        if (Util.isOnBackgroundThread()) {
            return get(activity.getApplicationContext());
        } else {
            assertNotDestroyed(activity);
            FragmentManager fm = activity.getSupportFragmentManager();
            return supportFragmentGet(activity, fm);
        }
    }
    RequestManager supportFragmentGet(Context context, FragmentManager fm) {
        SupportRequestManagerFragment current = getSupportRequestManagerFragment(fm);
        RequestManager requestManager = current.getRequestManager();
        if (requestManager == null) {
            requestManager = new RequestManager(context, current.getLifecycle(), current.getRequestManagerTreeNode());
            current.setRequestManager(requestManager);
        }
        return requestManager;
    }
    private RequestManager getApplicationManager(Context context) {
        // Either an application context or we're on a background thread.
        if (applicationManager == null) {
            synchronized (this) {
                if (applicationManager == null) {
                    // Normally pause/resume is taken care of by the fragment we add to the fragment or activity.
                    // However, in this case since the manager attached to the application will not receive lifecycle
                    // events, we must force the manager to start resumed using ApplicationLifecycle.
                    applicationManager = new RequestManager(context.getApplicationContext(),
                            new ApplicationLifecycle(), new EmptyRequestManagerTreeNode());
                }
            }
        }

        return applicationManager;
    }
```
大体上，前台用supportFragmentGet，运行于后台用getApplicationManager。

```
    SupportRequestManagerFragment getSupportRequestManagerFragment(final FragmentManager fm) {
        SupportRequestManagerFragment current = (SupportRequestManagerFragment) fm.findFragmentByTag(
            FRAGMENT_TAG);
        if (current == null) {
            current = pendingSupportRequestManagerFragments.get(fm);
            if (current == null) {
                current = new SupportRequestManagerFragment();
                pendingSupportRequestManagerFragments.put(fm, current);
                fm.beginTransaction().add(current, FRAGMENT_TAG).commitAllowingStateLoss();
                handler.obtainMessage(ID_REMOVE_SUPPORT_FRAGMENT_MANAGER, fm).sendToTarget();
            }
        }
        return current;
    }
```
SupportRequestManagerFragment的构造方法
```
    private RequestManager requestManager;
    private final ActivityFragmentLifecycle lifecycle;
    private final RequestManagerTreeNode requestManagerTreeNode =
            new SupportFragmentRequestManagerTreeNode();
    private final HashSet<SupportRequestManagerFragment> childRequestManagerFragments =
        new HashSet<SupportRequestManagerFragment>();
    private SupportRequestManagerFragment rootRequestManagerFragment;
    
    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }
    // For testing only.
    @SuppressLint("ValidFragment")
    public SupportRequestManagerFragment(ActivityFragmentLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }
```
RequestManager属性接下来会创建，lifecycle在构造方法里面创建，rootRequestManagerFragment保存顶端fragment。
接着看supportFragmentGet方法，首次加载时候RequestManager将走初始化，并设置为requestManagerFragment的属性
```
    public RequestManager(Context context, Lifecycle lifecycle, RequestManagerTreeNode treeNode) {
        this(context, lifecycle, treeNode, new RequestTracker(), new ConnectivityMonitorFactory());
    }
    RequestManager(Context context, final Lifecycle lifecycle, RequestManagerTreeNode treeNode,
                RequestTracker requestTracker, ConnectivityMonitorFactory factory) {
            this.context = context.getApplicationContext();
            this.lifecycle = lifecycle;
            this.treeNode = treeNode;
            this.requestTracker = requestTracker;
            this.glide = Glide.get(context);
            this.optionsApplier = new OptionsApplier();
    
            ConnectivityMonitor connectivityMonitor = factory.build(context,
                    new RequestManagerConnectivityListener(requestTracker));
    
            // If we're the application level request manager, we may be created on a background thread. In that case we
            // cannot risk synchronously pausing or resuming requests, so we hack around the issue by delaying adding
            // ourselves as a lifecycle listener by posting to the main thread. This should be entirely safe.
            if (Util.isOnBackgroundThread()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        lifecycle.addListener(RequestManager.this);
                    }
                });
            } else {
                lifecycle.addListener(this);
            }
            lifecycle.addListener(connectivityMonitor);
        }
```
RequestManager构造方法，除了options属性，其他的都初始化了。RequestTracker