package com.mikepenz.iconics.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;

import com.mikepenz.iconics.IconicsDrawable;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconBundle {
    public String mIconString = null;
    public Drawable mIcon = null;
    @ColorInt
    public int mColor = IconicsView.DEFAULT_COLOR;
    public int mSize = IconicsView.DEFAULT_SIZE;
    public int mPadding = IconicsView.DEFAULT_PADDING;
    @ColorInt
    public int mContourColor = IconicsView.DEFAULT_CONTOUR_COLOR;
    public int mContourWidth = IconicsView.DEFAULT_CONTOUR_WIDTH;
    @ColorInt
    public int mBackgroundColor = IconicsView.DEFAULT_BACKGROUND_COLOR;
    public int mCornerRadius = IconicsView.DEFAULT_CORNER_RADIUS;

    //region create icon
    public boolean createIcon(Context context) {
        return createIconFromBundle(this, context);
    }

    public static boolean createIconFromBundle(IconBundle bundle, Context ctx) {
        if (bundle.mIconString != null && !TextUtils.isEmpty(bundle.mIconString.trim())) {
            bundle.mIcon = new IconicsDrawable(ctx, bundle.mIconString);
            return applyNonDefaultProperties(bundle);
        } else {
            return false;
        }
    }

    public boolean applyProperties() {
        return applyProperties(this);
    }

    public static boolean applyProperties(IconBundle bundle) {
        if (!(bundle.mIcon instanceof IconicsDrawable)) {
            return false;
        }
        IconicsDrawable iconicsDrawable = (IconicsDrawable) bundle.mIcon;
        iconicsDrawable.color(bundle.mColor);
        iconicsDrawable.sizePx(bundle.mSize);
        iconicsDrawable.paddingPx(bundle.mPadding);
        iconicsDrawable.contourColor(bundle.mContourColor);
        iconicsDrawable.contourWidthPx(bundle.mContourWidth);
        iconicsDrawable.backgroundColor(bundle.mBackgroundColor);
        iconicsDrawable.roundedCornersPx(bundle.mCornerRadius);
        return true;
    }
    //endregion

    //region apply properties
    public boolean applyNonDefaultProperties() {
        return applyNonDefaultProperties(this);
    }

    public static boolean applyNonDefaultProperties(IconBundle bundle) {
        if (!(bundle.mIcon instanceof IconicsDrawable)) {
            return false;
        }
        IconicsDrawable iconicsDrawable = (IconicsDrawable) bundle.mIcon;
        if (bundle.mColor != IconicsView.DEFAULT_COLOR) {
            iconicsDrawable.color(bundle.mColor);
        }
        if (bundle.mSize != IconicsView.DEFAULT_SIZE) {
            iconicsDrawable.sizePx(bundle.mSize);
        }
        if (bundle.mPadding != IconicsView.DEFAULT_PADDING) {
            iconicsDrawable.paddingPx(bundle.mPadding);
        }
        if (bundle.mContourColor != IconicsView.DEFAULT_CONTOUR_COLOR) {
            iconicsDrawable.contourColor(bundle.mContourColor);
        }
        if (bundle.mContourWidth != IconicsView.DEFAULT_CONTOUR_WIDTH) {
            iconicsDrawable.contourWidthPx(bundle.mContourWidth);
        }
        if (bundle.mBackgroundColor != IconicsView.DEFAULT_BACKGROUND_COLOR) {
            iconicsDrawable.backgroundColor(bundle.mBackgroundColor);
        }
        if (bundle.mCornerRadius != IconicsView.DEFAULT_CORNER_RADIUS) {
            iconicsDrawable.roundedCornersPx(bundle.mCornerRadius);
        }
        return true;
    }
    //endregion
}