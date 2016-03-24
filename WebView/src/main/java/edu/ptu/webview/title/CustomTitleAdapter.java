package edu.ptu.webview.title;

import android.view.View;

import java.util.List;

/**
 * Created by WangAnshu on 2016/3/24.
 */
public abstract class CustomTitleAdapter {
    public abstract List<TitleItem> getLeftView();
    public abstract List<TitleItem> getRightView();
    public String titleStr;
    public static class TitleItem{
        public static int TYPE_TITLE=0;
        public static int TYPE_IMG=1;
        public int type;
        public String content;//String ,
        public int imgSrc;//image,默认使用apk已有的图片
        public View.OnClickListener onClickListener;
    }
}
