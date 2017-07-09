package com.mikepenz.iconics.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;

import com.mikepenz.iconics.IconicsDrawable;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public class IconBundle {
    public String mIconString = null;
    public Drawable mIcon = null;
    @ColorInt
    public int mColor = 0;
    public int mSize = -1;
    public int mPadding = -1;
    @ColorInt
    public int mContourColor = 0;
    public int mContourWidth = -1;
    @ColorInt
    public int mBackgroundColor = 0;
    public int mCornerRadius = -1;
    
    //region create icon
    public boolean createIcon(Context context){
        return createIconFromBundle(this, context);
    }
    
    public static boolean createIconFromBundle(IconBundle bundle, Context ctx) {
        if (bundle.mIconString != null && !TextUtils.isEmpty(bundle.mIconString.trim())) {
            bundle.mIcon = new IconicsDrawable(ctx, bundle.mIconString);
        } else {
            return false;
        }
        return applyProperties(bundle);
    }
    //endregion
    
    //region apply properties
    public boolean applyProperties(){
        return applyProperties(this);
    }
    
    public static boolean applyProperties(IconBundle bundle){
        if (!(bundle.mIcon instanceof IconicsDrawable)){
            return false;
        }
        if (bundle.mColor != 0) {
            ((IconicsDrawable)bundle.mIcon).color(bundle.mColor);
        }
        if (bundle.mSize != -1) {
            ((IconicsDrawable)bundle.mIcon).sizePx(bundle.mSize);
        }
        if (bundle.mPadding != -1) {
            ((IconicsDrawable)bundle.mIcon).paddingPx(bundle.mPadding);
        }
        if (bundle.mContourColor != 0) {
            ((IconicsDrawable)bundle.mIcon).contourColor(bundle.mContourColor);
        }
        if (bundle.mContourWidth != -1) {
            ((IconicsDrawable)bundle.mIcon).contourWidthPx(bundle.mContourWidth);
        }
        if (bundle.mBackgroundColor != 0) {
            ((IconicsDrawable)bundle.mIcon).backgroundColor(bundle.mBackgroundColor);
        }
        if (bundle.mCornerRadius != -1) {
            ((IconicsDrawable)bundle.mIcon).roundedCornersPx(bundle.mCornerRadius);
        }
        return true;
    }
    //endregion
}