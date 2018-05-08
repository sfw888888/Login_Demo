package com.bawie.sunfuwei.sunfuwei_login.model;

/**
 * Created by a on 2018/4/19.
 */

public interface LoginListener {
    //登陆成功
    void loginSuccess(String json);

    //登录失败
    void loginError(String error);
}
