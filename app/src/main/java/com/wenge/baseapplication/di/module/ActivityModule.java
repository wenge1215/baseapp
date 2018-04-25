package com.wenge.baseapplication.di.module;

import android.app.Activity;

import com.wenge.baseapplication.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/4/18.
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
