package com.mikepenz.iconics;

import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

/**
 * Note: This wrapper class is required to fix a compile time issue of a non correct nullable annotation in the [Drawable] class.
 *
 * @suppress
 */
public abstract class WrappedDrawable extends Drawable {

    // Note `IntArray` here can be null!!
    // Caused by: java.lang.IllegalArgumentException: Parameter specified as non-null is null: method kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull, parameter stateSet
    //        at com.mikepenz.iconics.IconicsDrawable.setState(IconicsDrawable.kt)
    // Keep library at Compile 28 to allow nullable type
    @Override
    public boolean setState(@Nullable int[] stateSet) {
        if (stateSet != null) {
            return super.setState(stateSet);
        } else {
            return false;
        }
    }
}
