package com.bwei.www.mouth01.mvp;

import com.bwei.www.mouth01.Inter.ICallBack;
import com.bwei.www.mouth01.bean.News;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by asus on 2018/10/25.
 */

public class Presenter {
    private IView iv;
    private Model model;

    public void attach(IView iv){
        this.iv = iv;
        model = new Model();
    }
    public void getBanner(){
        String url = "http://www.zhaoapi.cn/ad/getAd";

        Type type = new TypeToken<List<News.DataBean>>(){}.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void success(Object obj) {
                News news = (News) obj;
                if (news != null){
                    List<News.DataBean> list = news.getData();
                    iv.getBanner(list);
                }
            }

            @Override
            public void failed(Exception e) {
            iv.failed(e);
            }
        },type);

    }

}
