package com.mikepenz.iconics.internal;

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author zTrap (09.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public interface CheckedCompoundIconicsDrawables {
    @Nullable
    IconicsDrawable getCheckedIconicsDrawableStart();

    @Nullable
    IconicsDrawable getCheckedIconicsDrawableTop();

    @Nullable
    IconicsDrawable getCheckedIconicsDrawableEnd();

    @Nullable
    IconicsDrawable getCheckedIconicsDrawableBottom();

    void setCheckedDrawableStart(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableTop(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableEnd(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableBottom(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableForAll(@Nullable IconicsDrawable drawable);
}
