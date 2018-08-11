package com.mikepenz.iconics.sample;

import android.content.res.Resources;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * @author pa.gulko zTrap (28.10.2017)
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int space = (int) Math.ceil(8 * Resources.getSystem().getDisplayMetrics().density); // 8 dp
        int position = parent.getChildAdapterPosition(view);
        if (position < 2) {
            outRect.top = space;
        }
        if ((position + 1) % 2 == 0) {
            outRect.right = space;
        }
        outRect.bottom = outRect.left = space;
    }
}
