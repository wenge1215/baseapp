package com.wenge.baseapplication.mvp.presenter;

import com.wenge.baseapplication.base.RxPresenter;
import com.wenge.baseapplication.component.CommonSubscriber;

import com.wenge.baseapplication.mvp.contract.HomeContract;
import com.wenge.baseapplication.mvp.model.DataManager;
import com.wenge.baseapplication.mvp.model.bean.BannerBean;
import com.wenge.baseapplication.mvp.model.http.response.MMTCRseponse;
import com.wenge.baseapplication.utils.RxUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by 20180419 on 2018/4/20.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter {

    private final DataManager mDataManager;

    @Inject
    public HomePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void requestBanner() {
        Flowable<MMTCRseponse<List<BannerBean>>> flowable = mDataManager.getBanner();
        flowable.compose(RxUtil.<List<BannerBean>>handleMMTCResult())
                .compose(RxUtil.<List<BannerBean>>rxSchedulerHelper())
                .subscribeWith(new CommonSubscriber<List<BannerBean>>(mView) {
                    @Override
                    public void onNext(List<BannerBean> bannerBeans) {
                        mView.setBanner(bannerBeans);
                    }
                });
    }
}
