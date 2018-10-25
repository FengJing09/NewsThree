package com.bwei.www.animator.mvp;

import com.bwei.www.animator.Inter.ICallBack;
import com.bwei.www.animator.bean.LeftBean;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by asus on 2018/10/25.
 */

public class LeftPresenter {
    private IView iv;
    private LeftModel leftModel;
    public void attach(IView iv){
        this.iv = iv;
        leftModel = new LeftModel();
    }
    public void getLeft(){
        Type type = new TypeToken<LeftBean>(){}.getType();
        leftModel.getlefts("http://www.zhaoapi.cn/product/getCatagory", new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
              LeftBean leftBean = (LeftBean) obj;
                if (leftBean!= null){
                    iv.getleft(leftBean.getData());
                }

            }

            @Override
            public void onFailed(Exception e) {

                iv.failed(e);
            }
        },type);

    }
    public void detach(){
        if (iv!= null){
            iv = null;
        }

    }
}
