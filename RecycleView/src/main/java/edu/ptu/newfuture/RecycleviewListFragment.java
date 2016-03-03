package edu.ptu.newfuture;


import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;


/**
 *
 */
public class RecycleviewListFragment extends Fragment {


    private RecyclePresenter recyclePresenter;

    public RecycleviewListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycle_fragment_recycleview, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        recyclePresenter = new RecyclePresenter();
        RecyclerView rvList = (RecyclerView) view.findViewById(R.id.recycleview_rv_list);
        ///
        rvList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvList.setAdapter(adapter = createAdapter());
        new AsyncTask<Object,Object,Object>(){
            @Override
            protected Object doInBackground(Object... params) {
                recyclePresenter.loadData();
                return null;
            }
        }.execute();
    }

    private ArrayList<RecycleDataEvent> datas = null;
    private RecyclerView.Adapter adapter = null;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshList(ArrayList<RecycleDataEvent> dataEvents) {
        this.datas = dataEvents;
        adapter.notifyDataSetChanged();
    }

    class RecyclerVH extends RecyclerView.ViewHolder {
        public TextView tvDesc;
        public TextView tvTitle;
        public ImageView ivImg;

        public RecyclerVH(View itemView) {
            super(itemView);
            ivImg = (ImageView) itemView.findViewById(R.id.recycleviewitem_iv_imgurl);
            tvTitle = (TextView) itemView.findViewById(R.id.recycleviewitem_tv_title);
            tvDesc = (TextView) itemView.findViewById(R.id.recycleviewitem_tv_desc);
        }
    }

    private RecyclerView.Adapter createAdapter() {
        return new RecyclerView.Adapter() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new RecyclerVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_data, null));
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                RecyclerVH h = (RecyclerVH) holder;
                RecycleDataEvent recycleDataEvent = datas.get(position);
                h.tvTitle.setText(recycleDataEvent.getTitle());
                h.tvDesc.setText(recycleDataEvent.getDesc());
                Glide.
                        with(RecycleviewListFragment.this).
                        load(recycleDataEvent.getImgUrl()).into(h.ivImg);
            }

            @Override
            public int getItemCount() {
                return datas == null ? 0 : datas.size();
            }
        };
    }
}
