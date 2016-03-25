package edu.ptu.dialog.custom.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.ptu.dialog.custom.DialogContentAdapter;
import edu.ptu.dialog.R;

/**
 * Created by WangAnshu on 2016/3/25.
 */
public final class SimpleContentAdapter implements DialogContentAdapter {


    private final String content;
    private View vg;
    public SimpleContentAdapter(String content){
        this.content=content;
    }

    @Override
    public View getView(Context context) {
        vg = LayoutInflater.from(context).inflate(R.layout.dialog_content, null);
        return vg;
    }

    @Override
    public void setContent() {
        TextView contentView = (TextView) getContentView((ViewGroup) vg);
        contentView.setText(content);
    }

    @Override
    public View getContentView(ViewGroup viewGroup) {
        return viewGroup;
    }
}
