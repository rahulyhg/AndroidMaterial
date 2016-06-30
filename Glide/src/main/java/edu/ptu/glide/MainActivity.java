package edu.ptu.glide;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Glide.with(this).load("http://tp2.sinaimg.cn/2097044773/50/40010690517/0").into((ImageView) findViewById(R.id.glide_iv_icon));
        File photoCacheDir = Glide.getPhotoCacheDir(this);
        System.out.println("===> "+photoCacheDir);
    }
}
