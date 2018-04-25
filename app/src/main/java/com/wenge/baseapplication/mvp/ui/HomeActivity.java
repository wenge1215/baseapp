package com.wenge.baseapplication.mvp.ui;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wenge.baseapplication.R;
import com.wenge.baseapplication.base.BaseActivity;
import com.wenge.baseapplication.mvp.contract.HomeContract;
import com.wenge.baseapplication.mvp.model.bean.BannerBean;

import com.wenge.baseapplication.mvp.presenter.HomePresenter;
import com.wenge.baseapplication.mvp.ui.adapter.HomeAdapter;
import com.wenge.baseapplication.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {


//    @BindView(R.id.tool_bar)
//    Toolbar mToolBar;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.home_smart_refresh)
    SmartRefreshLayout mHomeSmartRefresh;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    private HomeAdapter mHomeAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initEventAndData() {
//        setToolBar(mToolBar, "美美天成");
        initListener();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHomeAdapter = new HomeAdapter();

        mRecyclerView.setAdapter(mHomeAdapter);
        mPresenter.requestBanner();

    }

    private void initListener() {
        mBottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(int tabId) {
                if (tabId == R.id.tab_home) {

                } else if (tabId == R.id.tab_fj) {

                } else if (tabId == R.id.tab_dd) {

                } else if (tabId == R.id.tab_me) {

                }
            }
        });
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    public void setBanner(List<BannerBean> beanList) {
        ToastUtil.shortShow(beanList.toString());
        mHomeAdapter.setBanner(beanList);
    }

}
