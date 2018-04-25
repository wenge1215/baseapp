package com.wenge.baseapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.wenge.baseapplication.app.App;

import java.io.File;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

import com.wenge.baseapplication.app.Constants;
import com.wenge.baseapplication.mvp.model.http.CacheInterceptor;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2018/4/18.
 */

public class NetworkUtils {

    private static Cache sCache;
    private static HttpLoggingInterceptor sHttpLoggingInterceptor;

    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetConneted(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        } else {
            return activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
        }
    }

    public static boolean isNetworkConnected(Context context, int typeMoblie) {
        if (!isNetConneted(context)) {
            return false;
        }

        ConnectivityManager contextSystemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = contextSystemService.getNetworkInfo(typeMoblie);

        if (networkInfo == null) {
            return false;
        } else {
            return networkInfo.isAvailable() && networkInfo.isConnected();
        }

    }

    /**
     * 创建OKHTTPClient
     */
    public static OkHttpClient getOkhttpClient() {

        /**
         * 日志拦截器
         */
        if (sHttpLoggingInterceptor == null) {
            sHttpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        /**
         * okhttp 对象
         */
        if (sCache == null) {
            File file = new File(App.getInstance().getCacheDir(), "app_cache");
            sCache = new Cache(file, 10 * 1024 * 1024);
        }


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(sHttpLoggingInterceptor)
                .cache(sCache)
                .addInterceptor(new CacheInterceptor(App.getInstance()))
                .addNetworkInterceptor(new CacheInterceptor(App.getInstance()))
                .connectTimeout(Constants.DEFORE_TIME, TimeUnit.SECONDS)
                .writeTimeout(Constants.DEFORE_TIME, TimeUnit.SECONDS)
                .followRedirects(true)
                .build();

        return okHttpClient;
    }


}
