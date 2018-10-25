package com.bwei.www.mouth01.mvp;

import com.bwei.www.mouth01.bean.News;

import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public interface IView {
    void failed(Exception e);

    void getBanner(List<News.DataBean> list);

}
