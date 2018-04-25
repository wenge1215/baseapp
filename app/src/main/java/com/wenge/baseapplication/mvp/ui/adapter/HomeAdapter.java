package com.wenge.baseapplication.mvp.ui.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenge.baseapplication.R;
import com.wenge.baseapplication.app.App;
import com.wenge.baseapplication.component.GlideImageLoader;
import com.wenge.baseapplication.mvp.model.bean.BannerBean;
import com.wenge.baseapplication.mvp.model.http.api.APIServer;
import com.wenge.baseapplication.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/19.
 */

public class HomeAdapter extends RecyclerView.Adapter {
    int header_type = 111;
    int nav_type = 222;
    int title_type = 333;
    int goods_type = 444;
    private List<BannerBean> mBanner;
    private HeaderViewHolder mHeaderViewHolder;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == header_type) {
            View holderView = layoutInflater.inflate(R.layout.home_adapter_item_heard, parent, false);
            return new HeaderViewHolder(holderView);
        } else if (viewType == nav_type) {
            View holderView = layoutInflater.inflate(R.layout.home_adapter_item_nav, parent, false);
            return new NavViewHolder(holderView);
        } else if (viewType == title_type) {
            View holderView = layoutInflater.inflate(R.layout.home_adapter_item_title, parent, false);
            return new TitleViewHoler(holderView);
        } else if (viewType == goods_type) {
            View holderView = layoutInflater.inflate(R.layout.home_adapter_item_goods, parent, false);
            return new GoodsViewHolder(holderView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == header_type) {
            mHeaderViewHolder = (HeaderViewHolder) holder;
            mHeaderViewHolder.setData();
        } else if (itemViewType == nav_type) {
            NavViewHolder navViewHolder = (NavViewHolder) holder;
            navViewHolder.setData();

        } else if (itemViewType == title_type) {
            TitleViewHoler titleViewHoler = (TitleViewHoler) holder;
            titleViewHoler.setData();

        } else if (itemViewType == goods_type) {
            GoodsViewHolder goodsViewHolder = (GoodsViewHolder) holder;
            goodsViewHolder.setData();

        }


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return header_type;
        } else if (position == 1) {
            return nav_type;
        } else if (position == 2) {
            return title_type;
        } else if (position == 3) {
            return goods_type;
        }

        return super.getItemViewType(position);
    }

    public void setBanner(List<BannerBean> banner) {
        mBanner = banner;
        mHeaderViewHolder.refData(banner);
        this.notifyDataSetChanged();
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder implements OnBannerListener {
        @BindView(R.id.banner)
        Banner mBanner;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData() {
            String[] stringArray = App.getInstance().getResources().getStringArray(R.array.url);
//            List list1 = Arrays.asList(stringArray);



            //简单使用
            mBanner.setImages(Arrays.asList(stringArray))
                    .setImageLoader(new GlideImageLoader())
                    .setOnBannerListener(this)
                    .start();



        }

        @Override
        public void OnBannerClick(int position) {
            ToastUtil.shortShow("banner    " + position);
        }

        public void refData(List<BannerBean> beanList) {
           List<String> strings = new ArrayList<>();
            for (int i = 0; i < beanList.size(); i++) {
                strings.add(APIServer.MMTC_HOST+beanList.get(i).getCover());
            }
            List<List<String>> lists = Arrays.asList(strings);

            //简单使用196.168.1.1
            mBanner.setImages(strings)
                    .setImageLoader(new GlideImageLoader())
                    .setOnBannerListener(this)
                    .start();
            mBanner.startAutoPlay();
        }
    }


    static class NavViewHolder extends RecyclerView.ViewHolder {
        public NavViewHolder(View itemView) {
            super(itemView);
        }

        public void setData() {

        }
    }

    static class GoodsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rv_home_adapter_item_goods)
        RecyclerView mRvHomeAdapterItemGoods;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData() {

            mRvHomeAdapterItemGoods.setLayoutManager(new GridLayoutManager(App.getInstance(), 2));
            mRvHomeAdapterItemGoods.setAdapter(new HomeGoodsAdapter());

        }
    }

    static class TitleViewHoler extends RecyclerView.ViewHolder {
        public TitleViewHoler(View itemView) {
            super(itemView);
        }

        public void setData() {

        }
    }

}
