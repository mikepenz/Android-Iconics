/*
 * Copyright 2017 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.view;

import android.content.Context;
import android.util.AttributeSet;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.animation.IconicsAnimatedDrawable;
import com.mikepenz.iconics.internal.CompoundIconicsDrawables;
import com.mikepenz.iconics.internal.CompoundIconsBundle;
import com.mikepenz.iconics.internal.IconicsView;
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatButton;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

public class IconicsButton extends AppCompatButton implements IconicsView, CompoundIconicsDrawables {
    private final CompoundIconsBundle mIconsBundle = new CompoundIconsBundle();

    public IconicsButton(Context context) {
        this(context, null);
    }

    public IconicsButton(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.buttonStyle);
    }

    public IconicsButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context, attrs, defStyle);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void initialize(Context context, AttributeSet attrs, int defStyle) {
        applyAttr(context, attrs, defStyle);
        //setting created icons
        checkAnimation(mIconsBundle.mBottomIcon);
        checkAnimation(mIconsBundle.mTopIcon);
        checkAnimation(mIconsBundle.mEndIcon);
        checkAnimation(mIconsBundle.mStartIcon);
        setIcons();
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        IconicsViewsAttrsApplier.readIconicsTextView(context, attrs, mIconsBundle);
    }

    private void setIcons() {
        mIconsBundle.setIcons(this);
    }

    //region CompoundIconicsDrawablesImpl
    @Override
    public IconicsDrawable getIconicsDrawableStart() {
        if (mIconsBundle.mStartIcon != null) {
            return mIconsBundle.mStartIcon;
        } else {
            return null;
        }
    }

    @Override
    public IconicsDrawable getIconicsDrawableTop() {
        if (mIconsBundle.mTopIcon != null) {
            return mIconsBundle.mTopIcon;
        } else {
            return null;
        }
    }

    @Override
    public IconicsDrawable getIconicsDrawableEnd() {
        if (mIconsBundle.mEndIcon != null) {
            return mIconsBundle.mEndIcon;
        } else {
            return null;
        }
    }

    @Override
    public IconicsDrawable getIconicsDrawableBottom() {
        if (mIconsBundle.mBottomIcon != null) {
            return mIconsBundle.mBottomIcon;
        } else {
            return null;
        }
    }

    @Override
    public void setDrawableStart(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mStartIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setDrawableTop(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mTopIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setDrawableEnd(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mEndIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setDrawableBottom(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mBottomIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setDrawableForAll(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mStartIcon = checkAnimation(drawable);
        mIconsBundle.mTopIcon = checkAnimation(drawable);
        mIconsBundle.mEndIcon = checkAnimation(drawable);
        mIconsBundle.mBottomIcon = checkAnimation(drawable);
        setIcons();
    }

    private @Nullable IconicsDrawable checkAnimation(@Nullable IconicsDrawable drawable) {
        if (drawable == null) return null;
        if (drawable instanceof IconicsAnimatedDrawable) {
            ((IconicsAnimatedDrawable) drawable).animateIn(this);
        }
        return drawable;
    }
    //endregion

    @Override
    public void setText(CharSequence text, BufferType type) {
        // NOTES:
        // 1. Need to disable the All Caps option to make Spannable work properly!
        // 2. This method will be called from the constructor of the super class
        setAllCaps(false);

        if (!isInEditMode()) {
            super.setText(new Iconics.IconicsBuilder().ctx(getContext()).on(text).build(), type);
        } else {
            super.setText(text, type);
        }
    }
}
