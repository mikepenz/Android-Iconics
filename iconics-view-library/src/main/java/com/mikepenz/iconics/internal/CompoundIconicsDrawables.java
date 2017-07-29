package com.mikepenz.iconics.internal;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public interface CompoundIconicsDrawables {
    @Nullable
    IconicsDrawable getIconicsDrawableStart();

    @Nullable
    IconicsDrawable getIconicsDrawableTop();

    @Nullable
    IconicsDrawable getIconicsDrawableEnd();

    @Nullable
    IconicsDrawable getIconicsDrawableBottom();

    void setDrawableStart(@Nullable IconicsDrawable drawable);

    void setDrawableTop(@Nullable IconicsDrawable drawable);

    void setDrawableEnd(@Nullable IconicsDrawable drawable);

    void setDrawableBottom(@Nullable IconicsDrawable drawable);

    void setDrawableForAll(@Nullable IconicsDrawable drawable);
}
