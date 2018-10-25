package com.bwei.www.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by asus on 2018/10/25.
 */

public class FlowLayoutTwo extends ViewGroup {
    public FlowLayoutTwo(Context context) {
        this(context,null);
    }

    public FlowLayoutTwo(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayoutTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        measureChildren(0,0);

        int totalWidth = 0;
        int totalHeight = 0;

        for (int i = 0; i <getChildCount() ; i++) {
            View v =getChildAt(i);
            if (totalWidth + v.getMeasuredWidth() >= getMeasuredWidth()){
                totalWidth = 0;
                totalHeight += v.getMeasuredHeight()+20;

            }

            v.layout(
                    totalWidth,
                    totalHeight,
                    totalWidth+v.getMeasuredWidth(),
                    totalHeight + v.getMeasuredHeight());
                    totalWidth += getMeasuredWidth();

        }

    }
}
