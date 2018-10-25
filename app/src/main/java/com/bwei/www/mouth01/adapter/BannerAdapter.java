package com.bwei.www.mouth01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwei.www.mouth01.Utils.StringUtils;
import com.bwei.www.mouth01.bean.News;

import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public class BannerAdapter extends PagerAdapter {
    private Context context;
    private List<News.DataBean> list;

    public BannerAdapter(Context context, List<News.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        String s = StringUtils.https2Http(list.get(position).getIcon());
        Glide.with(context).load(s).into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
