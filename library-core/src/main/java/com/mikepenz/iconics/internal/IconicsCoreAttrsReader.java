package com.mikepenz.iconics.internal;

import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;

import com.mikepenz.iconics.core.R;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconicsCoreAttrsReader {
    
    //region IconicsImageView
    public static void readIconicsImageView(TypedArray a, IconBundle bundle) {
        bundle.mIconString = a.getString(R.styleable.IconicsImageView_iiv_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsImageView_iiv_color, 0);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_size, -1);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_padding, -1);
            bundle.mContourColor = a.getColor(R.styleable.IconicsImageView_iiv_contour_color, 0);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_contour_width, -1);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsImageView_iiv_background_color, 0);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_corner_radius, -1);
        }
    }
    //endregion
}
