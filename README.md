# AndroidMaterial
use meterial design
##RecyclerView
要加上下面这段代码，才能显示
```
RecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
```
如果使用android.support.design.widget.CoordinatorLayout进行界面布局时候，内容区域需要加上 app:layout_behavior="@string/appbar_scrolling_view_behavior"
```
     <fragment
         android:name="edu.ptu.newfuture.RecycleviewListFragment"
         android:layout_width="match_parent"
         app:layout_behavior="@string/appbar_scrolling_view_behavior"
         android:layout_height="match_parent"
         android:tag="frgm_recleview" />
```