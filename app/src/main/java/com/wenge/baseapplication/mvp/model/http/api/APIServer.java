package com.wenge.baseapplication.mvp.model.http.api;

import com.wenge.baseapplication.mvp.model.bean.BannerBean;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;
import com.wenge.baseapplication.mvp.model.http.response.MMTCRseponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface APIServer {
    String BASE_API = "http://baobab.kaiyanapp.com/api/";
    String MMTC_HOST = "https://app.mmtcapp.com/";

    //获取首页第一页数据
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    Flowable<HemoBean> getHemoData();

    @POST("api/wx_shop/banners?_f=1")
    Flowable<MMTCRseponse<List<BannerBean>>> getBammer();
}
