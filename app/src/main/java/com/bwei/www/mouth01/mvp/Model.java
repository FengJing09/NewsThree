package com.bwei.www.mouth01.mvp;

import com.bwei.www.mouth01.Inter.ICallBack;
import com.bwei.www.mouth01.Utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by asus on 2018/10/25.
 */

public class Model {
    public void getData(String url, ICallBack callBack, Type type){

        HttpUtils.getInstance().get(url,callBack,type);
    }

}
