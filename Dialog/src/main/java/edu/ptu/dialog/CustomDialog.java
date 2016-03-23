package edu.ptu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


/**
 * Created by WangAnshu on 2016/3/18.
 */
public class CustomDialog extends Dialog {

    protected CustomDialog(Context context) {
        super(context);
    }

    protected CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class DialogBuilder{
        private CustomDialog customDialog;
        private final LinearLayout vg;

        public DialogBuilder(Context context) {
            vg = (LinearLayout)LayoutInflater.from(context).inflate(R.layout.dialog_templet, null);
            customDialog = new CustomDialog(context);
            customDialog.setContentView(vg);
        }
        public DialogBuilder setHeader(DialogHeaderAdapter dialogTitle){
            View view = dialogTitle.getView();
            vg.addView(view);
            if (!"".equals(dialogTitle.getTitle()))
                dialogTitle.titleView(view).setText(dialogTitle.getTitle());
            if (!dialogTitle.isShowClose())
                return this;
            View closeView = dialogTitle.closeView(vg);
            closeView.setVisibility(View.VISIBLE);
            closeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customDialog.dismiss();
                }
            });
            return this;
        }
        public DialogBuilder setContenter(DialogContentAdapter dialogContent){
            vg.addView(dialogContent.getView());
            return this;
        }
        public DialogBuilder setFooter(final DialogFootAdapter footer){
            View view = footer.getView();
            vg.addView(view);
            for (int i = 0; i < footer.getBeanSize(); i++) {
                final int finalI = i;
                footer.getBtnView(vg,i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View.OnClickListener onClickListener = footer.getBean(finalI).onClickListener;
                        if (onClickListener !=null)
                            onClickListener.onClick(v);
                        customDialog.dismiss();
                    }
                });
            }
            return this;
        }
        public CustomDialog build(){
            return customDialog;
        }
    }
}
