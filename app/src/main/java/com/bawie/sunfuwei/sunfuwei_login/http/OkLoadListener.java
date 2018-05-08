package com.bawie.sunfuwei.sunfuwei_login.http;

/**
 * Created by gjl on 2018/4/19.
 */

public interface OkLoadListener {
    void okLoadSuccess(String json);
    void okLoadError(String error);
}
