package com.lixiaohui8636.swiperecyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * 类描述：
 * 创建人：xh_l
 * 创建时间：2016/6/3 11:10
 * 修改人：xh_l
 * 修改时间：2016/6/3 11:10
 * 修改备注：
 */
public class RecyclerViewItemDecoration extends RecyclerView.ItemDecoration{
    protected int space;

    public RecyclerViewItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.top = space/2;
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space/2;
    }
}
