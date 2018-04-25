package com.wenge.baseapplication.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.wenge.baseapplication.R;
import com.wenge.baseapplication.base.BaseFragment;
import com.wenge.baseapplication.mvp.presenter.HomeFPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 20180419 on 2018/4/21.
 */

public class NearFragment extends BaseFragment<HomeFPresenter> {



    @BindView(R.id.near_rv)
    RecyclerView mNearRv;
    @BindView(R.id.near_srl)
    SmartRefreshLayout mNearSrl;

    public static NearFragment newInstance() {

        Bundle args = new Bundle();

        NearFragment fragment = new NearFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragent_near;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {


    }
}
