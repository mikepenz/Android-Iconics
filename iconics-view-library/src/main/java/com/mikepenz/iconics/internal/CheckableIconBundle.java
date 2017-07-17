package com.mikepenz.iconics.internal;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.utils.Utils;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class CheckableIconBundle {
    public boolean mAnimateChanges;
    public IconBundle mCheckedIconBundle = new IconBundle();
    public IconBundle mUncheckedIconBundle = new IconBundle();
    
    public boolean createIcons(Context ctx){
        boolean uncheckedCreated = mUncheckedIconBundle.createIcon(ctx);
        boolean checkedCreated = mCheckedIconBundle.createIcon(ctx);
        return checkedCreated || uncheckedCreated;
    }
    
    public StateListDrawable createStates(Context ctx) {
        return Utils.getCheckableIconStateList(ctx, mUncheckedIconBundle.mIcon,
                mCheckedIconBundle.mIcon, mAnimateChanges);
    }
}
