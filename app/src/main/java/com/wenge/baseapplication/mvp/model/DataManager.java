package com.wenge.baseapplication.mvp.model;

import com.wenge.baseapplication.mvp.model.bean.BannerBean;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;
import com.wenge.baseapplication.mvp.model.db.DBHelper;
import com.wenge.baseapplication.mvp.model.http.HttpHelper;
import com.wenge.baseapplication.mvp.model.http.response.MMTCRseponse;
import com.wenge.baseapplication.mvp.model.prefs.PreferencesHelper;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2018/4/18.
 * 数据中心
 */

public class DataManager implements HttpHelper,DBHelper,PreferencesHelper {
    HttpHelper mHttpHelper;
    DBHelper mDbHelper;
    PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper, PreferencesHelper preferencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public Flowable<HemoBean> getHomeBean() {
        return  mHttpHelper.getHomeBean();
    }

    public Flowable<MMTCRseponse<List<BannerBean>>> getBanner() {
        return mHttpHelper.getBanner();
    }
}
