package com.bwei.www.mouth01.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwei.www.mouth01.FloatLayout;
import com.bwei.www.mouth01.R;
import com.bwei.www.mouth01.adapter.BannerAdapter;
import com.bwei.www.mouth01.bean.News;
import com.bwei.www.mouth01.mvp.IView;
import com.bwei.www.mouth01.mvp.Presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public class HomeFragment extends Fragment implements IView {

    private SearchView sou;
    private ViewPager vpBanner;
    private List<News.DataBean> list;
    private BannerAdapter adapter;
    private Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_home,container,false);
//        sou = v.findViewById(R.id.sousuo);
        vpBanner = v.findViewById(R.id.vp_banner);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        sou.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),FloatLayout.class);
//                startActivity(intent);
//            }
//        });
        list = new ArrayList<>();
        adapter = new BannerAdapter(getActivity(),list);
        vpBanner.setAdapter(adapter);
        presenter = new Presenter();
        presenter.attach(this);
        presenter.getBanner();
    }

    @Override
    public void failed(Exception e) {

    }

    @Override
    public void getBanner(List<News.DataBean> list) {
        list.clear();
        list.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
