package com.mikepenz.iconics.internal;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;

/**
 * @author zTrap (09.07.2017)
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public interface CheckedCompoundIconicsDrawables {
    @Nullable
    IconicsDrawable getCheckedIconicsDrawableStart();
    
    @Nullable
    IconicsDrawable getCheckedIconicsDrawableTop();
    
    @Nullable
    IconicsDrawable getCheckedIconicsDrawableEnd();
    
    @Nullable
    IconicsDrawable getCheckedIconicsDrawableBottom();
    
    void setCheckedDrawableStart(@Nullable Drawable drawable);
    
    void setCheckedDrawableTop(@Nullable Drawable drawable);
    
    void setCheckedDrawableEnd(@Nullable Drawable drawable);
    
    void setCheckedDrawableBottom(@Nullable Drawable drawable);
}
