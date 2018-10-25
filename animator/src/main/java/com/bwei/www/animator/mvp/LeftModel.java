package com.bwei.www.animator.mvp;

import com.bwei.www.animator.Inter.ICallBack;
        import com.bwei.www.animator.Utils.HttpUtils;

        import java.lang.reflect.Type;

/**
 * Created by asus on 2018/10/25.
 */

public class LeftModel {
    public void getlefts(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }

}
