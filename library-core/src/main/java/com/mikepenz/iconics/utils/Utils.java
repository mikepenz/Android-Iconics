package com.mikepenz.iconics.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;

public class Utils {

    public static int convertDpToPx(Context context, float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static StateListDrawable getCheckableIconStateList(Context ctx, Drawable icon, Drawable checkedIcon) {
        return getCheckableIconStateList(ctx, icon, checkedIcon, true);
    }

    public static StateListDrawable getCheckableIconStateList(Context ctx, Drawable icon, Drawable checkedIcon, boolean animate) {
        StateListDrawable iconStateListDrawable = new StateListDrawable();
        iconStateListDrawable.addState(new int[]{android.R.attr.state_checked}, checkedIcon);
        iconStateListDrawable.addState(new int[]{-android.R.attr.state_checked}, icon);

        if (animate) {
            int duration = ctx.getResources().getInteger(android.R.integer.config_shortAnimTime);
            iconStateListDrawable.setEnterFadeDuration(duration);
            iconStateListDrawable.setExitFadeDuration(duration);
        }

        return iconStateListDrawable;
    }
}
