package edu.ptu.dialog.custom;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by WangAnshu on 2016/3/22.
 */
public interface DialogHeaderAdapter {
    public View getView(Context context);
    public String getTitle();
    public boolean isShowClose();
    public TextView titleView(View view);
    public View closeView(View vg);
}
