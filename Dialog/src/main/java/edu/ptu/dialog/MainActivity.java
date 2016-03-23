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

    private CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_title);


        getWindow().getDecorView().findViewById(android.R.id.content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCustomDialog();
//                createStandarDialog();
                dialog.show();
//                startActivity(new Intent(v.getContext(), MainActivity.class));
            }
        });
    }

    private void createStandarDialog() {
        long last =System.currentTimeMillis();
        Dialog dialog = new Dialog(this);
        dialog.setContentView(LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_title, null));
//        dialog.setContentView(LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_foot_single, null));
//        dialog.setContentView(LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_title, null));
        System.out.println(System.currentTimeMillis() - last);
    }

    private void createCustomDialog() {
        long last= System.currentTimeMillis();
        dialog = new CustomDialog.DialogBuilder(this)
                .setHeader(new DialogHeaderAdapter() {
                    @Override
                    public View getView() {
                        return LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_title, null);
                    }

                    @Override
                    public String getTitle() {
                        return "功能简介";
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
                        vg = getLayoutInflater().inflate(R.layout.dialog_content, null);
                        return vg;
                    }

                    @Override
                    public void setContent() {
                        TextView contentView = (TextView) getContentView((ViewGroup) vg);
                        contentView.setText("新功能，一切至简，易用");
                    }

                    @Override
                    public View getContentView(ViewGroup viewGroup) {
                        return viewGroup;
                    }
                })
                .setFooter(new DialogFootAdapter() {
                    ArrayList<BtnBean> btns = new ArrayList<BtnBean>(2) {{
                        BtnBean object = new BtnBean();
                        add(object);
                    }};

                    @Override
                    public View getView() {
                        return getLayoutInflater().inflate(R.layout.dialog_foot_single, null);
                    }

                    @Override
                    public View getBtnView(ViewGroup vg, int index) {
                        if (index == 0) {
                            return vg.findViewById(R.id.dialog_footer_tv_cancel);
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
                })
                .build();
        System.out.println(System.currentTimeMillis() - last);
    }

    @Override
    protected void onDestroy() {
        dialog.dismiss();
        super.onDestroy();
    }
}
