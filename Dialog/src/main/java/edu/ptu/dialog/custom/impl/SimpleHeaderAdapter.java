package edu.ptu.dialog.custom.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import edu.ptu.dialog.custom.DialogHeaderAdapter;
import edu.ptu.dialog.R;

/**
 * Created by WangAnshu on 2016/3/25.
 */
public final class SimpleHeaderAdapter implements DialogHeaderAdapter {
    private String title;
    private boolean hasCloseBtn;

    /**
     *
     * @param title 标题文字
     * @param hasClose 标题栏是否显示关闭按钮
     */
    public SimpleHeaderAdapter(String title, boolean hasClose){
        this.title=title;
        this.hasCloseBtn=hasClose;
    }
    @Override
    public View getView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.dialog_title, null);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isShowClose() {
        return hasCloseBtn;
    }

    @Override
    public TextView titleView(View vg) {
        return (TextView) vg.findViewById(R.id.dialog_title_tv);
    }

    @Override
    public View closeView(View vg) {
        return vg.findViewById(R.id.dialog_title_iv_close);
    }
}
