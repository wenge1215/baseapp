package com.wenge.baseapplication.mvp.presenter;

import com.wenge.baseapplication.base.BasePresenter;
import com.wenge.baseapplication.base.RxPresenter;
import com.wenge.baseapplication.mvp.contract.HomeFContract;
import com.wenge.baseapplication.mvp.model.DataManager;

import javax.inject.Inject;

/**
 * Created by 20180419 on 2018/4/21.
 */

public class HomeFPresenter extends RxPresenter<HomeFContract.View> implements HomeFContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public HomeFPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }
}
