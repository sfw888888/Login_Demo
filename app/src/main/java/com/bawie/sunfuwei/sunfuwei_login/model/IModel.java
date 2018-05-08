package com.bawie.sunfuwei.sunfuwei_login.model;

import java.util.Map;

/**
 * Created by a on 2018/4/19.
 */

public interface IModel {
    //登录
    void login(String url, Map<String, String> params, LoginListener loginListener);

    //注册
    void reg(String url, Map<String, String> params, RegListener regListener);

}
