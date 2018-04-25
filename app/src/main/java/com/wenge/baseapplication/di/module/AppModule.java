package com.wenge.baseapplication.di.module;

import com.wenge.baseapplication.app.App;
import com.wenge.baseapplication.mvp.model.DataManager;
import com.wenge.baseapplication.mvp.model.db.DBHelper;
import com.wenge.baseapplication.mvp.model.db.RealmHelper;
import com.wenge.baseapplication.mvp.model.http.HttpHelper;
import com.wenge.baseapplication.mvp.model.http.RetrofitHelper;
import com.wenge.baseapplication.mvp.model.prefs.ImplPreferencesHelper;
import com.wenge.baseapplication.mvp.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/4/17.
 */
@Module
public class AppModule {

    private final App mApp;

    public AppModule(App instance) {
        mApp = instance;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return mApp;
    }
    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DBHelper provideDBHelper(RealmHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DBHelper DBHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, DBHelper, preferencesHelper);
    }
}
