package com.zqf.mymvplearndemo.model.api;

import com.zqf.mymvplearndemo.model.bean.TabBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * class from
 * Created by zqf
 * Time 2018/1/16 16:30
 */

public interface ApiService {

    /**
     * 首页对应每个标签下的数据
     *
     * @param key-->Mob申请的Key
     * @param cid-->对应标签的Cid
     * @param page-->页数
     * @param size-->大小
     * @return TabModel对象
     */
    @GET("/wx/article/search")
    Call<TabBean> getTabData(@Query("key") String key,
                             @Query("cid") String cid,
                             @Query("page") int page,
                             @Query("size") int size);
}
