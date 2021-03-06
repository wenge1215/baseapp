package com.wenge.baseapplication.weight;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2018/4/19.
 */

public class MaxRecyclerView extends RecyclerView {
    public MaxRecyclerView(android.content.Context context, android.util.AttributeSet attrs){
        super(context, attrs);
    }
    public MaxRecyclerView(android.content.Context context){
        super(context);
    }
    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
