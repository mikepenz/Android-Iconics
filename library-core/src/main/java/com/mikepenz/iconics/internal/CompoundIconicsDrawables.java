package com.mikepenz.iconics.internal;

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
    
    void setIconicsDrawableStart(@Nullable IconicsDrawable drawable);
    
    void setIconicsDrawableTop(@Nullable IconicsDrawable drawable);
    
    void setIconicsDrawableEnd(@Nullable IconicsDrawable drawable);
    
    void setIconicsDrawableBottom(@Nullable IconicsDrawable drawable);
}
