package com.wenge.baseapplication.mvp.presenter;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wenge.baseapplication.base.RxPresenter;
import com.wenge.baseapplication.component.CommonSubscriber;

import com.wenge.baseapplication.mvp.contract.MainContract;
import com.wenge.baseapplication.mvp.model.DataManager;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;
import com.wenge.baseapplication.utils.RxUtil;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/18.
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void checkVersion(String currentVersion) {

    }

    @Override
    public void checkPermissions(RxPermissions rxPermissions) {

    }

    @Override
    public void setNightModeState(boolean b) {

    }

    @Override
    public void setCurrentItem(int index) {

    }

    @Override
    public int getCurrentItem() {
        return 0;
    }

    @Override
    public void setVersionPoint(boolean b) {

    }

    @Override
    public boolean getVersionPoint() {
        return false;
    }

    @Override
    public void getHomeData() {

        Flowable<HemoBean> flowable = mDataManager.getHomeBean();
        flowable.compose(RxUtil.<HemoBean>rxSchedulerHelper())
                .compose(RxUtil.<HemoBean>handleKaiYanResult())
                .subscribeWith(new CommonSubscriber<HemoBean>(mView) {
                    @Override
                    public void onNext(HemoBean bean) {
                        mView.showData(bean);
                    }
                });


    }
}
