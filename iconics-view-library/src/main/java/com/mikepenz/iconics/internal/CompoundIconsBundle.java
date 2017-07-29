package com.mikepenz.iconics.internal;

import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.TextViewCompat;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class CompoundIconsBundle {
    public IconicsDrawable mStartIconBundle;
    public IconicsDrawable mTopIconBundle;
    public IconicsDrawable mEndIconBundle;
    public IconicsDrawable mBottomIconBundle;

    public void setIcons(TextView textView) {
        Drawable[] drawables = TextViewCompat.getCompoundDrawablesRelative(textView);

        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView,
                mStartIconBundle != null ? mStartIconBundle : drawables[0],
                mTopIconBundle != null ? mTopIconBundle : drawables[1],
                mEndIconBundle != null ? mEndIconBundle : drawables[2],
                mBottomIconBundle != null ? mBottomIconBundle : drawables[3]
        );
    }
}
