package com.wenge.baseapplication.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wenge.baseapplication.R;
import com.wenge.baseapplication.base.BaseFragment;
import com.wenge.baseapplication.mvp.presenter.HomeFPresenter;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by 20180419 on 2018/4/21.
 */

public class OrderFragment extends BaseFragment<HomeFPresenter> {



    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragent_order;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {

    }
}
