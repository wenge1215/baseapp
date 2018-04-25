package com.wenge.baseapplication.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wenge.baseapplication.R;
import com.wenge.baseapplication.base.BaseFragment;
import com.wenge.baseapplication.mvp.presenter.HomeFPresenter;
import com.wenge.baseapplication.mvp.ui.adapter.HomeAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 20180419 on 2018/4/21.
 */

public class HomeFragment extends BaseFragment<HomeFPresenter> {


    @BindView(R.id.homef_rv)
    RecyclerView mHomefRv;
    @BindView(R.id.homef_sfl)
    SmartRefreshLayout mHomefSfl;
    Unbinder unbinder;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragent_home;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {

        mHomefRv.setLayoutManager(new LinearLayoutManager(getContext()));
        HomeAdapter homeAdapter = new HomeAdapter();

        mHomefRv.setAdapter(homeAdapter);
    }
}
