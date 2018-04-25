package com.wenge.baseapplication.mvp.contract;



import com.wenge.baseapplication.base.BasePresenter;
import com.wenge.baseapplication.base.BaseView;
import com.wenge.baseapplication.mvp.model.bean.BannerBean;

import java.util.List;

/**
 * Created by 20180419 on 2018/4/20.
 */

public interface OrderContract {
    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
