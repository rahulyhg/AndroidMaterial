package edu.ptu.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_title);
        long last=System.currentTimeMillis();
        new CustomDialog.DialogBuilder(this)
                .setHeader(new DialogHeaderAdapter() {
                    @Override
                    public View getView() {
                        return LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_title, null);
                    }

                    @Override
                    public String getTitle() {
                        return "还好";
                    }

                    @Override
                    public boolean isShowClose() {
                        return false;
                    }

                    @Override
                    public TextView titleView(View vg) {
                        return (TextView) vg.findViewById(R.id.dialog_title_tv);
                    }

                    @Override
                    public View closeView(View vg) {
                         return vg.findViewById(R.id.dialog_title_iv_close);
                    }
                })
                .setContenter(new DialogContentAdapter() {

                    private View vg;

                    @Override
                    public View getView() {
                        vg = getLayoutInflater().inflate(R.layout.dialog_foot_single, null);
                        return vg;
                    }

                    @Override
                    public void setContent() {
                        TextView contentView = (TextView) getContentView((ViewGroup) vg);
                        contentView.setText("你好啊");
                    }

                    @Override
                    public View getContentView(ViewGroup viewGroup) {
                        return viewGroup;
                    }
                })
                .setFooter(new DialogFootAdapter() {
                    final ArrayList<BtnBean> btns = new ArrayList<BtnBean>(2);

                    @Override
                    public View getView() {
                        return getLayoutInflater().inflate(R.layout.dialog_foot_single, null);
                    }

                    @Override
                    public View getBtnView(ViewGroup vg, int index) {
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
                })
                .build();
        System.out.println(System.currentTimeMillis() - last);
        last=System.currentTimeMillis();
        Dialog dialog = new Dialog(this);
        dialog.setContentView(LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_title, null));
        dialog.setContentView(LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_foot_single, null));
        dialog.setContentView(LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_title, null));
        System.out.println(System.currentTimeMillis() - last);
    }
}
