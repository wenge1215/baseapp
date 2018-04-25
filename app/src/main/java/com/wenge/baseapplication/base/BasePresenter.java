package com.wenge.baseapplication.base;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
