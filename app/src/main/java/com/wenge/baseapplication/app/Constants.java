package com.wenge.baseapplication.app;

import android.os.Environment;

import java.io.File;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface Constants {

    int DEFORE_TIME = 20 ;
    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "mmtc";;

    //================= PATH ====================
     String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
     String PATH_CACHE = PATH_DATA + "/NetCache";
 ;
}
