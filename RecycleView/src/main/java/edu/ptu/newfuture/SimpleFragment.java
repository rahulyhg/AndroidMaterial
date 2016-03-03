package edu.ptu.newfuture;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class SimpleFragment extends Fragment {

    private ImageView imageView;
    private RecyclePresenter recyclePresenter;

    public SimpleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recyclePresenter = new RecyclePresenter();
        EventBus.getDefault().register(this);
        return inflater.inflate(R.layout.simple_fragment_image,null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
//        layoutParams.width=200;
//        layoutParams.height= 200;
//        imageView.setLayoutParams(layoutParams);
        imageView = (ImageView) view.findViewById(R.id.simplefragm_iv_name);
        imageView.setBackgroundColor(0x000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                recyclePresenter.loadData();
            }
        },1000);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void getList(List<RecycleDataEvent> dataEvent){
        if (dataEvent!=null) {
            SystemClock.sleep(3000);
            RecycleDataEvent recycleDataEvent = dataEvent.get(0);
            recycleDataEvent.getImgUrl();
            Glide.with(this).load(recycleDataEvent.getImgUrl()).into(imageView);
        }

    }

}
