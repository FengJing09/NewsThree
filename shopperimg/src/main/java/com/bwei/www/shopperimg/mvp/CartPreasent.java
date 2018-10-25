package com.bwei.www.shopperimg.mvp;

import com.bwei.www.shopperimg.Inter.ICallBack;
import com.bwei.www.shopperimg.bean.MessageBean;
import com.bwei.www.shopperimg.bean.Shopper;
import com.bwei.www.shopperimg.bean.product;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public class CartPreasent {
    private IView iv;
    private CartModel model;

    public void attach(IView iv){
        this.iv = iv;
        model = new CartModel();
    }
    public void getData(){
        String url = "http://www.zhaoapi.cn/product/getCarts?uid=1538";
        Type type = new TypeToken<MessageBean<List<Shopper<List<product>>>>>(){}.getType();

        model.getData(url, new ICallBack() {
            @Override
            public void success(Object obj) {
              MessageBean<List<Shopper<List<product>>>> data = (MessageBean<List<Shopper<List<product>>>>) obj;
                iv.success(data);
            }

            @Override
            public void failed(Exception e) {

                iv.failed(e);
            }
        },type);
    }
    public void deatch(){
        if (iv != null){
            iv = null;

        }

    }

}
