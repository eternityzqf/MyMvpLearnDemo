package com.zqf.mymvplearndemo.presenter;

import com.zqf.mymvplearndemo.model.bean.TabBean;

/**
 * class from
 * Created by zqf
 * Time 2018/1/16 16:40
 */

public interface TabViewInterface {

    void requestLoading();

    void resultSuccess(TabBean result);

    void resultFailure(String result);
}
