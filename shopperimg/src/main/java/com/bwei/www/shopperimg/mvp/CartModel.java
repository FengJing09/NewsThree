package com.bwei.www.shopperimg.mvp;

import com.bwei.www.shopperimg.Inter.ICallBack;
import com.bwei.www.shopperimg.Utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by asus on 2018/10/25.
 */

public class CartModel {
    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }

}
