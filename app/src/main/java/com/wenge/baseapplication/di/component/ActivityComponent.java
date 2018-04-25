package com.wenge.baseapplication.di.component;

import android.app.Activity;

import com.wenge.baseapplication.di.module.ActivityModule;
import com.wenge.baseapplication.di.scope.ActivityScope;
import com.wenge.baseapplication.mvp.ui.HomeActivity;
import com.wenge.baseapplication.mvp.ui.MainActivity;

import dagger.Component;

/**
 * Created by Administrator on 2018/4/18.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);

    void inject(HomeActivity homeActivity);
}
