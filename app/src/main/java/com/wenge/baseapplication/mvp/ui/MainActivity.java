package com.wenge.baseapplication.mvp.ui;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenge.baseapplication.R;
import com.wenge.baseapplication.base.BaseActivity;

import com.wenge.baseapplication.mvp.contract.MainContract;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;
import com.wenge.baseapplication.mvp.presenter.MainPresenter;
import com.wenge.baseapplication.mvp.ui.adapter.HomeDataAdapter;
import com.wenge.baseapplication.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    List<HemoBean.IssueListBean.ItemListBean> mItemList = new ArrayList<>();
    @BindView(R.id.home_recy)
    RecyclerView mHomeRecy;
    @BindView(R.id.home_sfl)
    SwipeRefreshLayout mHomeSfl;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        LogUtil.e("initEventAndData");
        mPresenter.getHomeData();
    }

    @Override
    protected void initInject() {
        LogUtil.e("initInject");
        getActivityComponent().inject(this);
    }


    @Override
    public void showUpdateDialog(String versionContent) {
        LogUtil.e("showUpdateDialog");
    }

    @Override
    public void startDownloadService() {
        LogUtil.e("startDownloadService");
    }

    @Override
    public void showData(HemoBean bean) {
        List<HemoBean.IssueListBean> issueList = bean.getIssueList();
        for (int i = 0; i < issueList.size(); i++) {
            HemoBean.IssueListBean issueListBean = issueList.get(i);
            List<HemoBean.IssueListBean.ItemListBean> itemList = issueListBean.getItemList();
            for (int j = 0; j < itemList.size(); j++) {
                if ("video".equals(itemList.get(j).getType()))
                mItemList.add(itemList.get(j));
            }
        }
        HomeDataAdapter homeDataAdapter = new HomeDataAdapter(mItemList);
        mHomeRecy.setLayoutManager(new LinearLayoutManager(this));
        mHomeRecy.setAdapter(homeDataAdapter);
    }
}
