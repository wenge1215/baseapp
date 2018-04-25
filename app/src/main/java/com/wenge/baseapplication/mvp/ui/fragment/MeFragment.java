package com.wenge.baseapplication.mvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenge.baseapplication.R;
import com.wenge.baseapplication.base.BaseFragment;
import com.wenge.baseapplication.mvp.presenter.MePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 20180419 on 2018/4/21.
 */

public class MeFragment extends BaseFragment<MePresenter> {
;

    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragent_me;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {


    }

}
