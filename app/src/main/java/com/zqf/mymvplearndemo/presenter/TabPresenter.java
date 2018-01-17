package com.zqf.mymvplearndemo.presenter;

import android.content.Context;
import android.util.Log;

import com.zqf.mymvplearndemo.model.api.ApiHelp;
import com.zqf.mymvplearndemo.model.bean.TabBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * class from
 * Created by zqf
 * Time 2018/1/16 16:38
 */

public class TabPresenter {

    private TabViewInterface mTabViewInterface;
    private ApiHelp mApiHelp;
    private Call<TabBean> mTabBeanCall;

    public TabPresenter(Context context, TabViewInterface mTabViewInterface) {
        this.mTabViewInterface = mTabViewInterface;
        mApiHelp = ApiHelp.getInstance(context);
    }

    public void ClickRequest() {
        mTabViewInterface.requestLoading();
        mApiHelp.getServer().getTabData("1b8a769191c30", "1", 1, 10).enqueue(new Callback<TabBean>() {
            @Override
            public void onResponse(Call<TabBean> call, Response<TabBean> response) {
                mTabViewInterface.resultSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TabBean> call, Throwable t) {
                mTabViewInterface.resultFailure(Log.getStackTraceString(t));
            }
        });
    }

    /**
     * 取消网络请求
     */
    public void interruptHttp() {
        if (mTabBeanCall != null && !mTabBeanCall.isCanceled()) {
            mTabBeanCall.cancel();
        }
    }
}
