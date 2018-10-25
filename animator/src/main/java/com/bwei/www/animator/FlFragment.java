package com.bwei.www.animator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.www.animator.Rmvp.RightPresenter;
import com.bwei.www.animator.adapter.LeftAdapter;
import com.bwei.www.animator.adapter.RightAdapter;
import com.bwei.www.animator.bean.LeftBean;
import com.bwei.www.animator.bean.RightBean;
import com.bwei.www.animator.mvp.IView;
import com.bwei.www.animator.mvp.LeftPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by asus on 2018/10/25.
 */

public class FlFragment extends Fragment implements IView, com.bwei.www.animator.Rmvp.IView {
    private RecyclerView recleft;
    private LinearLayout layoutright;
    private List<LeftBean.DataBean> beanList;
    private List<RightBean.DataBean> beanright;
    private LeftAdapter leftAdapter;
    private LeftPresenter presenter;
    private RightAdapter rightAdapter;
    private RightPresenter rightPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_fl,container,false);
        recleft = v.findViewById(R.id.rec_left);
        layoutright = v.findViewById(R.id.right_lnl);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),1, LinearLayoutManager.VERTICAL,false);
        recleft.setLayoutManager(layoutManager);
        beanList = new ArrayList<>();
        beanright = new ArrayList<>();

        leftAdapter = new LeftAdapter(getActivity(),beanList);


        presenter = new LeftPresenter();
        presenter.attach(this);
        presenter.getLeft();
        recleft.setAdapter(leftAdapter);
        rightPresenter = new RightPresenter();
     rightPresenter.attach(this);

    }

    @Override
    public void getleft(List<LeftBean.DataBean> list) {
        if (list!= null){
            beanList.clear();
            beanList.addAll(list);
            leftAdapter.notifyDataSetChanged();

        }

    }

    @Override
    public void getright(List<RightBean.DataBean> list) {
        if (list!= null){
            layoutright.removeAllViews();
            for (int i = 0 ;i<list.size();i++){
                TextView txtView = new TextView(getActivity());
                txtView.setText(list.get(i).getName());
                RecyclerView rvNextb = new RecyclerView(getActivity());
                RecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(getActivity(),3);
                rvNextb.setLayoutManager(layoutManager2);
                rightAdapter = new RightAdapter(getActivity(),list.get(i).getList());

                leftAdapter.setOnItemClickListeren(new LeftAdapter.OnItemClickListeren() {
                    @Override
                    public void onItemClick(View itemviiew, int position) {
                        LeftBean.DataBean dataBean = beanList.get(position);
                        rightPresenter.getright("http://www.zhaoapi.cn/product/getProductCatagory?cid="+dataBean.getCid());
                    }
                });


                rvNextb.setAdapter(rightAdapter);
                beanright.clear();
                beanright.addAll(list);
                rightAdapter.notifyDataSetChanged();
                layoutright.addView(txtView);
                layoutright.addView(rvNextb);
            }

        }
    }

    @Override
    public void failed(Exception e) {

    }

    @Override
    public void onResume() {
        super.onResume();
        rightPresenter.getright("http://www.zhaoapi.cn/product/getProductCatagory?cid=1");
    }
}
