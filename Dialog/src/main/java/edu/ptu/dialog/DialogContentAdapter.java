package edu.ptu.dialog;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by WangAnshu on 2016/3/22.
 */
public interface DialogContentAdapter {
    public View getView();
    public void setContent();
    public View getContentView(ViewGroup viewGroup);
}
