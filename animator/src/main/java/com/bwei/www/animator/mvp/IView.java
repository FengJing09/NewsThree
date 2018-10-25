package com.bwei.www.animator.mvp;

import com.bwei.www.animator.bean.LeftBean;

import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public interface IView {
    void getleft(List<LeftBean.DataBean> list);
    void failed(Exception e);
}
