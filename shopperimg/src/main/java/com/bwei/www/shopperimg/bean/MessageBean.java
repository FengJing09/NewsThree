package com.bwei.www.shopperimg.bean;

/**
 * Created by asus on 2018/10/25.
 */

public class MessageBean<T> {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private String code;
    private T data;

}
