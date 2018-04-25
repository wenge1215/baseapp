package com.wenge.baseapplication.component;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wenge.baseapplication.app.App;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2018/4/18.
 */

public class GlideImageLoader extends ImageLoader {
    public static void load(Context context, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if (!App.getAppComponent().preferencesHelper().getNoImageState()) {
            Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        }
    }

    public static void load(Activity activity, String url, ImageView iv) {    //使用Glide加载圆形ImageView(如头像)时，不要使用占位图
        if(!activity.isDestroyed()) {
            Glide.with(activity).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        }
    }

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
//        BannerBean path1 = (BannerBean) path;
//        StringBuffer append = new StringBuffer().append(APIServer.MMTC_HOST).append(path1.getCover());
        Glide.with(context.getApplicationContext())
                .load(path)
                .into(imageView);
    }
}
