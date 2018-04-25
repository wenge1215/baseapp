package com.wenge.baseapplication.mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wenge.baseapplication.R;
import com.wenge.baseapplication.weight.expandtabview.ChildView;
import com.wenge.baseapplication.weight.expandtabview.ExpandTabView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ExpanTabTestActivity extends AppCompatActivity implements ChildView.OnSelectListener {

    @BindView(R.id.expandtab_view)
    ExpandTabView mExpandtabView;
    private Unbinder mBind;
    private ArrayList<View> mViewArray = new ArrayList<View>();
    private ChildView viewLeft;
    private ChildView viewLeft1;
    private ChildView viewLeft2;
    private ChildView viewLeft3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expan_tab_test);
        mBind = ButterKnife.bind(this);
        initView();
        initVaule();
        initListener();
    }
    private void initView() {

        viewLeft = new ChildView(this);
        viewLeft1 = new ChildView(this);
        viewLeft2 = new ChildView(this);
        viewLeft3 = new ChildView(this);


    }

    private void initVaule() {

        mViewArray.add(viewLeft);
        mViewArray.add(viewLeft1);
        mViewArray.add(viewLeft2);
        mViewArray.add(viewLeft3);

        //设置顶部数据信息
        ArrayList<String> mTextArray = new ArrayList<String>();
        mTextArray.add("全部");
        mTextArray.add("半永久");
        mTextArray.add("筛选");
        mTextArray.add("销量最高");

        mExpandtabView.setValue(mTextArray, mViewArray);
        mExpandtabView.setTitle(viewLeft.getShowText(), 0);

    }

    private void initListener() {


//        viewLeft.setOnSelectListener(new ChildView.OnSelectListener() {
//
//            @Override
//            public void getValue(String showText) {
//
//                onRefresh(viewLeft,showText);
//
//            }
//        });
        viewLeft.setOnSelectListener(this);
        viewLeft1.setOnSelectListener(this);
        viewLeft2.setOnSelectListener(this);
        viewLeft3.setOnSelectListener(this);


    }

    //视图被点击后刷新数据
    private void onRefresh(View view, String showText) {

        Toast.makeText(ExpanTabTestActivity.this, showText, Toast.LENGTH_SHORT).show();

    }

    //获取当前的view
    private int getPositon(View tView) {
        for (int i = 0; i < mViewArray.size(); i++) {
            if (mViewArray.get(i) == tView) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onBackPressed() {

        if (!mExpandtabView.onPressBack()) {
            finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }

    @Override
    public void getValue(String showText) {
        onRefresh(viewLeft,showText);
        mExpandtabView.onPressBack();
    }
}
