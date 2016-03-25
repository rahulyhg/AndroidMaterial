package edu.ptu.dialog.custom.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.ptu.dialog.custom.DialogFootAdapter;
import edu.ptu.dialog.R;

/**
 * Created by WangAnshu on 2016/3/25.
 */
public final class SimpleFooterAdapter implements DialogFootAdapter {
    ArrayList<BtnBean> btns = new ArrayList<BtnBean>(2);
    public SimpleFooterAdapter(String cancelStr){
        BtnBean object = new BtnBean();
        this.btns.add(object);
    }
    @Override
    public View getView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.dialog_foot_single, null);
    }

    @Override
    public View getBtnView(ViewGroup vg, int index) {
        if (index == 0) {
            View txtview = vg.findViewById(R.id.dialog_footer_tv_cancel);
            return txtview;
        }
        return vg.getChildAt(index);
    }

    @Override
    public BtnBean getBean(int index) {

        return btns.get(index);
    }

    @Override
    public int getBeanSize() {
        return btns.size();
    }
}
