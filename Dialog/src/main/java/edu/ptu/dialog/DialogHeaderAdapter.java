package edu.ptu.dialog;

import android.view.View;
import android.widget.TextView;

/**
 * Created by WangAnshu on 2016/3/22.
 */
public interface DialogHeaderAdapter {
    public View getView();
    public String getTitle();
    public boolean isShowClose();
    public TextView titleView(View view);
    public View closeView(View vg);
}
