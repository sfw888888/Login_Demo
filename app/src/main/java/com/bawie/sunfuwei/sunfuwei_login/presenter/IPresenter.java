package com.bawie.sunfuwei.sunfuwei_login.presenter;


import com.bawie.sunfuwei.sunfuwei_login.model.IModel;
import com.bawie.sunfuwei.sunfuwei_login.view.IMainView;
import com.bawie.sunfuwei.sunfuwei_login.view.IRegView;

/**
 * Created by a on 2018/4/19.
 */

public interface IPresenter {
    void loginPresenter(IModel iModel, IMainView iMainView);

    void regPresenter(IModel iModel, IRegView iRegView);
}
