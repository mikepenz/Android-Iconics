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

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.CompoundIconicsDrawables;
import com.mikepenz.iconics.internal.CompoundIconsBundle;
import com.mikepenz.iconics.internal.IconicsView;
import com.mikepenz.iconics.internal.IconicsViewsAttrsReader;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

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
        if (!isInEditMode()) {
            initialize(context, attrs, defStyle);
        }
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void initialize(Context context, AttributeSet attrs, int defStyle) {
        applyAttr(context, attrs, defStyle);
        //setting created icons
        setIcons();
    }

    @SuppressLint("CustomViewStyleable")
    @RestrictTo(LIBRARY_GROUP)
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsTextView, defStyle, 0);
        IconicsViewsAttrsReader.readIconicsTextView(context, a, mIconsBundle);
        a.recycle();
    }

    private void setIcons() {
        mIconsBundle.setIcons(this);
    }

    //region CompoundIconicsDrawablesImpl
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableStart() {
        if (mIconsBundle.mStartIconBundle != null) {
            return mIconsBundle.mStartIconBundle;
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableTop() {
        if (mIconsBundle.mTopIconBundle != null) {
            return mIconsBundle.mTopIconBundle;
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableEnd() {
        if (mIconsBundle.mEndIconBundle != null) {
            return mIconsBundle.mEndIconBundle;
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableBottom() {
        if (mIconsBundle.mBottomIconBundle != null) {
            return mIconsBundle.mBottomIconBundle;
        } else {
            return null;
        }
    }

    @Override
    public void setDrawableStart(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mStartIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setDrawableTop(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mTopIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setDrawableEnd(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mEndIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setDrawableBottom(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mBottomIconBundle = drawable;
        setIcons();
    }

    @Override
    public void setDrawableForAll(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mStartIconBundle = drawable;
        mIconsBundle.mTopIconBundle = drawable;
        mIconsBundle.mEndIconBundle = drawable;
        mIconsBundle.mBottomIconBundle = drawable;
        setIcons();
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
