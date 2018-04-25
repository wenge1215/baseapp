package com.wenge.baseapplication.mvp.contract;

import com.wenge.baseapplication.base.BasePresenter;
import com.wenge.baseapplication.base.BaseView;

/**
 * Created by 20180419 on 2018/4/21.
 */

public interface HomeFContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
