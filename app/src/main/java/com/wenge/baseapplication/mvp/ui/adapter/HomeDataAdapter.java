package com.wenge.baseapplication.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wenge.baseapplication.R;
import com.wenge.baseapplication.app.App;
import com.wenge.baseapplication.component.GlideImageLoader;
import com.wenge.baseapplication.mvp.model.bean.HemoBean;
import com.wenge.baseapplication.utils.SnackbarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/18.
 */

public class HomeDataAdapter extends RecyclerView.Adapter<HomeDataAdapter.HomeViewHolder> {

    private List<HemoBean.IssueListBean.ItemListBean> mItemListBean;

    public HomeDataAdapter(List<HemoBean.IssueListBean.ItemListBean> bean) {
        mItemListBean = bean;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(App.getInstance()).inflate(R.layout.item_home, null, false);
        return new HomeViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.setData(mItemListBean.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemListBean == null ? 0 : mItemListBean.size();
    }


    static class HomeViewHolder extends RecyclerView.ViewHolder {
        private final View mItemView;
        @BindView(R.id.iv_photo)
        ImageView mIvPhoto;
        @BindView(R.id.iv_user)
        ImageView mIvUser;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_detail)
        TextView mTvDetail;

        public HomeViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            ButterKnife.bind(this,itemView);
        }

        public void setData(HemoBean.IssueListBean.ItemListBean itemListBean) {
            mTvTitle.setText(itemListBean.getData().getTitle());
            mTvDetail.setText(itemListBean.getData().getCategory() + itemListBean.getData().getDuration());
            GlideImageLoader.load(mItemView.getContext(),itemListBean.getData().getCover().getFeed(),mIvPhoto);
            if (itemListBean.getData().getAuthor() != null) {
                GlideImageLoader.load(mItemView.getContext(), itemListBean.getData().getAuthor().getIcon(), mIvUser);
            } else {
                mIvUser.setVisibility(View.GONE);
            }

            mIvPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SnackbarUtil.show(mItemView.getRootView(),"图片被点击了");
                }
            });
        }
    }
}
