package com.bwei.www.shopperimg.mvp;

import com.bwei.www.shopperimg.bean.MessageBean;
import com.bwei.www.shopperimg.bean.Shopper;
import com.bwei.www.shopperimg.bean.product;

import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public interface IView {
        void success(MessageBean<List<Shopper<List<product>>>>data);

        void failed(Exception e);
}
