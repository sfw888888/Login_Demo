package com.bawie.sunfuwei.sunfuwei_login.presenter;

import android.util.Log;


import com.bawie.sunfuwei.sunfuwei_login.http.HttpConfig;
import com.bawie.sunfuwei.sunfuwei_login.model.IModel;
import com.bawie.sunfuwei.sunfuwei_login.model.LoginListener;
import com.bawie.sunfuwei.sunfuwei_login.model.RegListener;
import com.bawie.sunfuwei.sunfuwei_login.view.IMainView;
import com.bawie.sunfuwei.sunfuwei_login.view.IRegView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a on 2018/4/19.
 */

public class PresenterImpel implements IPresenter {
    private static final String TAG = "PresenterImpel";

    @Override
    public void loginPresenter(IModel iModel, final IMainView iMainView) {
        Log.d("tag----------", "loginSuccess:--------- ");
        Map<String, String> params = new HashMap<>();

        params.put("mobile",iMainView.getMobile());

        params.put("password",iMainView.getPwd());

        iModel.login(HttpConfig.url, params, new LoginListener () {
            @Override
            public void loginSuccess(String json) {
                iMainView.loginSuccess();

                Log.d(TAG, "loginSuccess:--------- "+json);
            }

            @Override
            public void loginError(String error) {
                iMainView.loginError();

                Log.d(TAG, "loginError:+++++++ "+error);
            }
        });
    }

    @Override
    public void regPresenter(IModel iModel, final IRegView iRegView) {
        Map<String, String> params = new HashMap<>();

        params.put("mobile",iRegView.getMobile());

        params.put("password",iRegView.getPwd());

       iModel.reg(HttpConfig.reg_url, params, new RegListener () {
           @Override
           public void regSuccess(String json) {
               iRegView.RegSuccess();
           }

           @Override
           public void regError(String error) {
                iRegView.RegError();
           }
       });

    }
}
