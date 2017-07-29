package com.mikepenz.iconics.internal;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.utils.Utils;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class CheckableIconBundle {
    public boolean mAnimateChanges;
    public IconicsDrawable mCheckedIconBundle;
    public IconicsDrawable mUncheckedIconBundle;

    public void createIcons(Context ctx) {
        mCheckedIconBundle = new IconicsDrawable(ctx);
        mUncheckedIconBundle = new IconicsDrawable(ctx);
    }

    public StateListDrawable createStates(Context ctx) {
        return Utils.getCheckableIconStateList(ctx, mUncheckedIconBundle,
                mCheckedIconBundle, mAnimateChanges);
    }
}
