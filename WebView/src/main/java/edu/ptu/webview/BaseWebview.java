package edu.ptu.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import edu.ptu.webview.js.JsInterfaceUseAndroid;
import edu.ptu.webview.js.JsObjectName;

/**
 * Created by WangAnshu on 2016/3/24.
 */
public class BaseWebview extends WebView {
    public BaseWebview(Context context) {
        super(context);
    }

    public BaseWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseWebview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public BaseWebview(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
    }


    public void initConfig() {

//        1. 打开网页时不调用系统浏览器， 而是在本WebView中显示：
        this.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        2. 通过java代码调用javascript
        this.addJavascriptInterface(new JsInterfaceUseAndroid(), ((JsObjectName)JsInterfaceUseAndroid.class.getAnnotations()[0]).name());
//        4. 打开页面时， 自适应屏幕：
        WebSettings webSettings =   getSettings();
        webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);
//        5. 便页面支持缩放：
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
//        6.如果webView中需要用户手动输入用户名、密码或其他，则webview必须设置支持获取手势焦点。
        requestFocusFromTouch();

//        主要辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等比如onCloseWindow(关闭WebView)
        this.setWebChromeClient(new WebChromeClient() {

        });
    }
}
