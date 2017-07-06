package com.mikepenz.iconics.view;

import android.support.annotation.Nullable;

import com.mikepenz.iconics.IconicsDrawable;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
public interface SideIconicsDrawables {
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
