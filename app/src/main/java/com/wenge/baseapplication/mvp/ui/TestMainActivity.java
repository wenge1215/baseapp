package com.wenge.baseapplication.mvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.wenge.baseapplication.R;
import com.wenge.baseapplication.base.SimpleActivity;
import com.wenge.baseapplication.mvp.ui.fragment.HomeFragment;
import com.wenge.baseapplication.mvp.ui.fragment.MeFragment;
import com.wenge.baseapplication.mvp.ui.fragment.NearFragment;
import com.wenge.baseapplication.mvp.ui.fragment.OrderFragment;

import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

public class TestMainActivity extends SimpleActivity {


    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;
    @BindView(R.id.content)
    FrameLayout mContent;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    private SupportFragment[] mFragments = new SupportFragment[4];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SupportFragment firstFragment = findFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = NearFragment.newInstance();
            mFragments[2] = OrderFragment.newInstance();
            mFragments[3] = MeFragment.newInstance();

            loadMultipleRootFragment(R.id.content, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[0] = firstFragment;
            mFragments[1] = findFragment(NearFragment.class);
            mFragments[2] = findFragment(OrderFragment.class);
            mFragments[3] = findFragment(MeFragment.class);
        }
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_test_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolBar, "美美天成");
        initBottomBar();

    }

    private void initBottomBar() {

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                int id = 0;
                if (tabId == R.id.tab_home) {
                    id = 0;
                } else if (tabId == R.id.tab_fj) {
                    id = 1;
                } else if (tabId == R.id.tab_dd) {
                    id = 2;
                } else if (tabId == R.id.tab_me) {
                    id = 3;
                }
                showHideFragment(mFragments[id]);

            }
        });

    }

}
