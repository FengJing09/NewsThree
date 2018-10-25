package com.bwei.www.animator.Rmvp;

import com.bwei.www.animator.FlFragment;
import com.bwei.www.animator.Inter.ICallBack;
import com.bwei.www.animator.bean.RightBean;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by asus on 2018/10/25.
 */

public class RightPresenter {
    private IView iv;
    private RightModel rightModel;
    public void attach(IView iv){
        this.iv = iv;
        rightModel = new RightModel();
    }
    public void getright(String url){
        Type type = new TypeToken<RightBean>(){}.getType();
        rightModel.getright(url, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                RightBean rightBean = (RightBean) obj;
                if (rightBean != null){
                    iv.getright(rightBean.getData());
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
