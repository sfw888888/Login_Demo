package com.bawie.sunfuwei.sunfuwei_login.model;

/**
 * Created by a on 2018/4/20.
 */

public interface RegListener {
    //注册成功
    void regSuccess(String json);

    //注册失败
    void regError(String error);
}
