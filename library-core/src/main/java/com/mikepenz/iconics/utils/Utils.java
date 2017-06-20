package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StyleableRes;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;

public class Utils {
    public static int convertDpToPx(Context context, float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
    
    public static String getString(TypedArray a, @StyleableRes int index,  @StyleableRes int defIndex){
        if (a.hasValue(index)){
            return a.getString(index);
        } else {
            return a.getString(defIndex);
        }
    }
}
