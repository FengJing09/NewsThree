package com.bwei.www.mouth01.Utils;

import android.os.Handler;

import com.bwei.www.mouth01.Inter.ICallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ThinkPad on 2018/10/13.
 */

public class HttpUtils {
    private Handler handler = new Handler();
    private static volatile HttpUtils instance;
    private OkHttpClient client;
    private HttpUtils (){
        client = new OkHttpClient();
    }
    public static HttpUtils getInstance(){
        if(instance == null){
            synchronized (HttpUtils.class){
                if(null == instance){
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    public void get(String urlstr , final ICallBack callBack, final Type type){
        Request request = new Request.Builder()
                .get()
                .url(urlstr)
                .build();
        Call call =  client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(str,type);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.success(o);
                    }
                });
            }
        });
    }


}
