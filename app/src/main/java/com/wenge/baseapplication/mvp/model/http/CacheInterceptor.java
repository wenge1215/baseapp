package com.wenge.baseapplication.mvp.model.http;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/4/18.
 */

public class CacheInterceptor implements Interceptor {

    private final Context mContext;

    public CacheInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (chain != null) {
            Request request = chain.request();

        }
        return null;
    }
}
