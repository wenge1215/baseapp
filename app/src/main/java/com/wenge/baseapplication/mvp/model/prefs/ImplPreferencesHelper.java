package com.wenge.baseapplication.mvp.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.wenge.baseapplication.app.App;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/4/18.
 */

public class ImplPreferencesHelper implements PreferencesHelper{
    private static final String SHAREDPREFERENCES_NAME = "my_sp";

    private final SharedPreferences mSPrefs;
    private boolean mNoImageState;

    @Inject
    public ImplPreferencesHelper() {
        mSPrefs = App.getInstance().getSharedPreferences(SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public boolean getNoImageState() {
        return mNoImageState;
    }
}
