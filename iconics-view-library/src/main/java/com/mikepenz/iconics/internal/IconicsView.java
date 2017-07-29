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
    String DEFAULT_ICON = " ";
    int DEFAULT_SIZE = -1;
    int DEFAULT_PADDING = -1;
    int DEFAULT_CONTOUR_WIDTH = -1;
    int DEFAULT_CORNER_RADIUS = -1;

    @RestrictTo(LIBRARY_GROUP)
    void initialize(Context context, AttributeSet attrs, int defStyle);

    @RestrictTo(LIBRARY_GROUP)
    void applyAttr(Context context, AttributeSet attrs, int defStyle);
}
