package edu.ptu.dialog;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by WangAnshu on 2016/3/22.
 */
public interface DialogFootAdapter {
    public View getView();
    public View getBtnView(ViewGroup vg,int index);
    public BtnBean getBean(int index);
    public int getBeanSize();
    public static class BtnBean {
        //样式统一，严禁修改
//        private int textColor;
//        private float textSize;
//        private int viewBackground;
//        private String text;
        public View.OnClickListener onClickListener;
    }
}
