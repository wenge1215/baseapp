package com.wenge.baseapplication.base;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface BaseView {

    void showErrorMsg(String msg);

    void useNightMode(boolean isNight);

    //=======  State  =======
    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
