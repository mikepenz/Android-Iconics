package com.mikepenz.iconics.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.TextViewCompat;
import android.widget.TextView;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class CompoundIconsBundle {
    public IconBundle mStartIconBundle = new IconBundle();
    public IconBundle mTopIconBundle = new IconBundle();
    public IconBundle mEndIconBundle = new IconBundle();
    public IconBundle mBottomIconBundle = new IconBundle();

    public void createIcons(Context ctx) {
        mStartIconBundle.createIcon(ctx);
        mTopIconBundle.createIcon(ctx);
        mEndIconBundle.createIcon(ctx);
        mBottomIconBundle.createIcon(ctx);
    }

    public void setIcons(TextView textView) {
        Drawable[] drawables = TextViewCompat.getCompoundDrawablesRelative(textView);

        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView,
                mStartIconBundle.mIcon != null ? mStartIconBundle.mIcon : drawables[0],
                mTopIconBundle.mIcon != null ? mTopIconBundle.mIcon : drawables[1],
                mEndIconBundle.mIcon != null ? mEndIconBundle.mIcon : drawables[2],
                mBottomIconBundle.mIcon != null ? mBottomIconBundle.mIcon : drawables[3]
        );

    }
}
