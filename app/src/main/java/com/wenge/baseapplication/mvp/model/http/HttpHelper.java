package com.wenge.baseapplication.mvp.model.http;

import com.wenge.baseapplication.mvp.model.bean.BannerBean;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;
import com.wenge.baseapplication.mvp.model.http.response.MMTCRseponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/18.
 * 所有网络请求的接口
 */

public interface HttpHelper {
    Flowable<HemoBean> getHomeBean();
    Flowable<MMTCRseponse<List<BannerBean>>> getBanner();
}
