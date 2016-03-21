package edu.ptu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;


/**
 * Created by WangAnshu on 2016/3/18.
 */
public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class DialogBuilder{
        private CustomDialog customDialog;

        public DialogBuilder(Context context) {
            LayoutInflater.from(context).inflate(R.layout.dialog_templet,null);
            customDialog = new CustomDialog(context);
        }
        public DialogBuilder setHeader(DialogTitle dialogTitle){
            return this;
        }
        public DialogBuilder setContenter(){
            return this;
        }
        public DialogBuilder setFooter(CustomDialogFooter.CustomDialogFooterBuilder footerBuilder){
            return this;
        }
    }
}
