package com.mikepenz.iconics.internal;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
public interface CompoundIconicsDrawables {
    @Nullable
    IconicsDrawable getIconicsDrawableStart();
    
    @Nullable
    IconicsDrawable getIconicsDrawableTop();
    
    @Nullable
    IconicsDrawable getIconicsDrawableEnd();
    
    @Nullable
    IconicsDrawable getIconicsDrawableBottom();
    
    void setDrawableStart(@Nullable Drawable drawable);
    
    void setDrawableTop(@Nullable Drawable drawable);
    
    void setDrawableEnd(@Nullable Drawable drawable);
    
    void setDrawableBottom(@Nullable Drawable drawable);
}
