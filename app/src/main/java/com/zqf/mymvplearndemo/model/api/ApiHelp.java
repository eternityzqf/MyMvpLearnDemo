package com.zqf.mymvplearndemo.model.api;

import android.content.Context;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * class from
 * Created by zqf
 * Time 2018/1/16 16:30
 */

public class ApiHelp {

    /**
     * GsonConverterFactory解析器
     */
    private GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());
    /**
     * ApiClientHelp 对象引用
     */
    private static ApiHelp instance = null;
    /**
     * Retrofit
     */
    private Retrofit mRetrofit = null;

    public static ApiHelp getInstance(Context context) {
        if (instance == null) {
            instance = new ApiHelp(context);
        }
        return instance;
    }

    private ApiHelp(Context mContext) {
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        resetApp();
    }

    /**
     * 初始化Retrofit的配置
     */
    private void resetApp() {
        //请求接口
        mRetrofit = new Retrofit.Builder()
                //代表root地址
                .baseUrl("http://apicloud.mob.com/wx/article/search")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * get--ApiService对象
     *
     * @return ApiService
     */
    public ApiService getServer() {
        return mRetrofit.create(ApiService.class);
    }
}
