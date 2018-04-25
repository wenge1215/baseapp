package com.wenge.baseapplication.mvp.presenter;

import com.wenge.baseapplication.base.RxPresenter;
import com.wenge.baseapplication.mvp.contract.MeContract;
import com.wenge.baseapplication.mvp.contract.OrderContract;
import com.wenge.baseapplication.mvp.model.DataManager;

import javax.inject.Inject;

/**
 * Created by 20180419 on 2018/4/21.
 */

public class MePresenter extends RxPresenter<MeContract.View> implements MeContract.Presenter {
    private final DataManager mDataManager;

    @Inject
    public MePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }
}
