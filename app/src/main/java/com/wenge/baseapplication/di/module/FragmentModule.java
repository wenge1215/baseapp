package com.wenge.baseapplication.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.wenge.baseapplication.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/4/18.
 */
@Module
public class FragmentModule {
    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
