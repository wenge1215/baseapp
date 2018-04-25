package com.wenge.baseapplication.mvp.model.http;


import com.wenge.baseapplication.mvp.model.bean.BannerBean;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;
import com.wenge.baseapplication.mvp.model.http.api.APIServer;
import com.wenge.baseapplication.mvp.model.http.response.MMTCRseponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/18.
 */

public class RetrofitHelper implements HttpHelper {

    private final APIServer mServer;

    @Inject
    public RetrofitHelper(APIServer server) {
        this.mServer = server;
    }


    @Override
    public Flowable<HemoBean> getHomeBean() {
        Flowable<HemoBean> hemoData = mServer.getHemoData();
        return hemoData;
    }

    @Override
    public  Flowable<MMTCRseponse<List<BannerBean>>> getBanner() {
        Flowable<MMTCRseponse<List<BannerBean>>> bammer = mServer.getBammer();
        return bammer;
    }
}
