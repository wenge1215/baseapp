package com.wenge.baseapplication.di.component;

import android.app.Activity;

import com.wenge.baseapplication.di.module.FragmentModule;
import com.wenge.baseapplication.di.scope.FragmentScope;
import com.wenge.baseapplication.mvp.ui.fragment.HomeFragment;
import com.wenge.baseapplication.mvp.ui.fragment.MeFragment;
import com.wenge.baseapplication.mvp.ui.fragment.NearFragment;
import com.wenge.baseapplication.mvp.ui.fragment.OrderFragment;

import dagger.Component;

/**
 * Created by Administrator on 2018/4/18.
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(HomeFragment homeFragment);

    void inject(NearFragment nearFragment);

    void inject(OrderFragment orderFragment);

    void inject(MeFragment meFragment);
}
