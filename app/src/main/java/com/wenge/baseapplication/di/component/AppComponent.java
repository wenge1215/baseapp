package com.wenge.baseapplication.di.component;

import com.wenge.baseapplication.app.App;
import com.wenge.baseapplication.di.module.AppModule;
import com.wenge.baseapplication.mvp.model.DataManager;
import com.wenge.baseapplication.di.module.HttpModule;
import com.wenge.baseapplication.mvp.model.db.RealmHelper;
import com.wenge.baseapplication.mvp.model.http.RetrofitHelper;
import com.wenge.baseapplication.mvp.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2018/4/17.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类
//
    RealmHelper realmHelper();    //提供数据库帮助类
//
    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
