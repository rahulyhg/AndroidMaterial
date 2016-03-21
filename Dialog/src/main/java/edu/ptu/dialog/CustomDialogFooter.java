package edu.ptu.dialog;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by WangAnshu on 2016/3/21.
 */
public class CustomDialogFooter {
    private View view;

    private CustomDialogFooter() {

    }

    public static class BtnBean {
        //样式统一，严禁修改
//        private int textColor;
//        private float textSize;
//        private int viewBackground;
//        private String text;
        private View.OnClickListener onClickListener;
    }

    public static class CustomDialogFooterBuilder {
        private final CustomDialogFooter customDialogFooter;

        CustomDialogFooterBuilder() {
            customDialogFooter = new CustomDialogFooter();
        }

        public CustomDialogFooter buildSingleBtn(final Dialog dialog) {
            View view = dialog.getLayoutInflater().inflate(R.layout.dialog_foot_single,null);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            customDialogFooter.view=view;
            return customDialogFooter;
        }

        public CustomDialogFooter buildTwoBtn(Dialog dialog, final BtnBean firstBean, final BtnBean rightBean) {
            ViewGroup vg = (ViewGroup) dialog.getLayoutInflater().inflate(R.layout.dialog_foot_single,null);
            vg.getChildAt(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    firstBean.onClickListener.onClick(v);
                }
            });
            vg.getChildAt(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rightBean.onClickListener.onClick(v);
                }
            });
            customDialogFooter.view=vg;
            return customDialogFooter;
        }
    }
}
