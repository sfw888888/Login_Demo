package com.bawie.sunfuwei.sunfuwei_login.model;

import android.util.Log;

import com.bawie.sunfuwei.sunfuwei_login.http.HttpUtils;
import com.bawie.sunfuwei.sunfuwei_login.http.OkLoadListener;
import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by a on 2018/4/19.
 */

public class ModelImpel implements IModel {

    private static final String TAG = "ModelImpel";

    //登录
    @Override
    public void login(String url, final Map<String, String> params, final LoginListener loginListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();

        httpUtils.okPost(url,params);

        httpUtils.setOkLoadListener(new OkLoadListener () {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson = new Gson();

                UserBean userBean = gson.fromJson(json, UserBean.class);

                if(userBean.getCode().equals("0")){
                    loginListener.loginSuccess(json);
                }else{
                    loginListener.loginError(json);
                }

                Log.d(TAG, "loginSuccess:--------- "+json);
            }

            @Override
            public void okLoadError(String error) {
                loginListener.loginError(error);

                Log.d(TAG, "loginSuccess:--------- "+error);
            }
        });
    }

    //注册
    @Override
    public void reg(String url, Map<String, String> params, final RegListener regListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();

        httpUtils.okPost(url,params);

        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson = new Gson();

                RegBean regBean = gson.fromJson(json, RegBean.class);

                if(regBean.getCode().equals("0")){
                    regListener.regSuccess(json);
                }else{
                    regListener.regError(json);
                }
            }

            @Override
            public void okLoadError(String error) {
                regListener.regError(error);
            }
        });
    }
}
