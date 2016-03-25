package edu.ptu.dialog.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by WangAnshu on 2016/3/22.
 */
public interface DialogContentAdapter {
    public View getView(Context context);
    public void setContent();
    public View getContentView(ViewGroup viewGroup);
}
