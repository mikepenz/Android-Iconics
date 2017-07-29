package com.mikepenz.iconics.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.util.AttributeSet;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author zTrap (09.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public interface IconicsView {

    @RestrictTo(LIBRARY_GROUP)
    void initialize(Context context, AttributeSet attrs, int defStyle);

    @RestrictTo(LIBRARY_GROUP)
    void applyAttr(Context context, AttributeSet attrs, int defStyle);
}
