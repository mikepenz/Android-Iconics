package com.mikepenz.iconics.view;

import android.support.annotation.ColorInt;

import com.mikepenz.iconics.IconicsDrawable;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
class IconBundle {
    String mIconString = null;
    IconicsDrawable mIcon = null;
    @ColorInt
    int mColor = 0;
    int mSize = -1;
    int mPadding = -1;
    @ColorInt
    int mContourColor = 0;
    int mContourWidth = -1;
    @ColorInt
    int mBackgroundColor = 0;
    int mCornerRadius = -1;
}