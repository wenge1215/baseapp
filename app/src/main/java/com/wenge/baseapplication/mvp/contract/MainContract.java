package com.wenge.baseapplication.mvp.contract;


import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wenge.baseapplication.base.BasePresenter;
import com.wenge.baseapplication.base.BaseView;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;

/**
 * Created by Administrator on 2018/4/18.
 */

public interface MainContract {
    interface View extends BaseView {

        void showUpdateDialog(String versionContent);

        void startDownloadService();
        void showData(HemoBean bean);
    }

    interface  Presenter extends BasePresenter<View> {

        void checkVersion(String currentVersion);

        void checkPermissions(RxPermissions rxPermissions);

        void setNightModeState(boolean b);

        void setCurrentItem(int index);

        int getCurrentItem();

        void setVersionPoint(boolean b);

        boolean getVersionPoint();
        void getHomeData();
    }
}
