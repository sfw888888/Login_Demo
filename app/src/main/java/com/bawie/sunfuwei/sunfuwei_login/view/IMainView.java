package com.bawie.sunfuwei.sunfuwei_login.view;

/**
 * Created by a on 2018/4/19.
 */

public interface IMainView {
     //得到数据
     String getMobile();

     String getPwd();

     void loginSuccess();

     void loginError();
}
