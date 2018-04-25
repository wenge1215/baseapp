package com.wenge.baseapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;


import com.wenge.baseapplication.app.App;
import com.wenge.baseapplication.di.component.DaggerFragmentComponent;
import com.wenge.baseapplication.di.component.FragmentComponent;
import com.wenge.baseapplication.di.module.FragmentModule;
import com.wenge.baseapplication.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * Created by 20180419 on 2018/4/21.
 */

public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {
    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent() {

//        return null;

        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    protected FragmentModule getFragmentModule(){
        return new FragmentModule(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    protected abstract void initInject();
}
