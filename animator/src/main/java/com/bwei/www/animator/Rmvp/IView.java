package com.bwei.www.animator.Rmvp;

import com.bwei.www.animator.bean.RightBean;

import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public interface IView {
    void getright(List<RightBean.DataBean> list);
    void failed(Exception e);
}
