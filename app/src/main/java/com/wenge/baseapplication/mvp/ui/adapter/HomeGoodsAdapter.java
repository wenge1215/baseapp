package com.wenge.baseapplication.mvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wenge.baseapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/19.
 */

public class HomeGoodsAdapter extends RecyclerView.Adapter<HomeGoodsAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home_adapter_item_goods_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData();

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_home_adapter_item_goods)
        ImageView mIvHomeAdapterItemGoods;
        @BindView(R.id.tv_project_home_adapter_item_goods)
        TextView mTvProjectHomeAdapterItemGoods;
        @BindView(R.id.tv_name_home_adapter_item_goods)
        TextView mTvNameHomeAdapterItemGoods;
        @BindView(R.id.tv_describe_home_adapter_item_goods)
        TextView mTvDescribeHomeAdapterItemGoods;
        @BindView(R.id.tv_price_home_adapter_item_goods)
        TextView mTvPriceHomeAdapterItemGoods;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData() {

        }
    }
}
