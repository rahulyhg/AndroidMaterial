package edu.ptu.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

import edu.ptu.dialog.custom.CustomDialog;
import edu.ptu.dialog.custom.DialogFootAdapter;
import edu.ptu.dialog.custom.impl.SimpleContentAdapter;
import edu.ptu.dialog.custom.impl.SimpleFooterAdapter;
import edu.ptu.dialog.custom.impl.SimpleHeaderAdapter;

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
                .setHeader(this,new SimpleHeaderAdapter("标题",true))
                .setContenter(this,new SimpleContentAdapter("内容"))
                .setFooter(this,new SimpleFooterAdapter("知道了"))
                .build();
        System.out.println(System.currentTimeMillis() - last);
    }

    @Override
    protected void onDestroy() {
        dialog.dismiss();
        super.onDestroy();
    }
}
