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
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AppCompatTextView;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.CompoundIconicsDrawables;
import com.mikepenz.iconics.internal.CompoundIconsBundle;
import com.mikepenz.iconics.internal.IconicsView;
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier;
import com.mikepenz.iconics.internal.IconicsViewsUtils;
import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

public class IconicsTextView extends AppCompatTextView implements CompoundIconicsDrawables, IconicsView {
    protected final CompoundIconsBundle mIconsBundle = new CompoundIconsBundle();

    public IconicsTextView(Context context) {
        this(context, null);
    }

    public IconicsTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public IconicsTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            initialize(context, attrs, defStyle);
        }
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void initialize(Context context, AttributeSet attrs, int defStyle) {
        applyAttr(context, attrs, defStyle);
        IconicsViewsUtils.checkAnimation(mIconsBundle.mBottomIcon, this);
        IconicsViewsUtils.checkAnimation(mIconsBundle.mTopIcon, this);
        IconicsViewsUtils.checkAnimation(mIconsBundle.mEndIcon, this);
        IconicsViewsUtils.checkAnimation(mIconsBundle.mStartIcon, this);
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
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableStart() {
        return mIconsBundle.mStartIcon;
    }

    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableTop() {
        return mIconsBundle.mTopIcon;
    }

    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableEnd() {
        return mIconsBundle.mEndIcon;
    }

    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableBottom() {
        return mIconsBundle.mBottomIcon;
    }

    @Override
    public void setDrawableStart(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mStartIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        setIcons();
    }

    @Override
    public void setDrawableTop(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mTopIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        setIcons();
    }

    @Override
    public void setDrawableEnd(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mEndIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        setIcons();
    }

    @Override
    public void setDrawableBottom(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mBottomIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        setIcons();
    }

    @Override
    public void setDrawableForAll(@Nullable IconicsDrawable drawable) {
        mIconsBundle.mStartIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        mIconsBundle.mTopIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        mIconsBundle.mEndIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        mIconsBundle.mBottomIcon = IconicsViewsUtils.checkAnimation(drawable, this);
        setIcons();
    }
    //endregion

    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!isInEditMode()) {
            super.setText(new Iconics.IconicsBuilder().ctx(getContext()).on(text).build(), type);
        } else {
            super.setText(text, type);
        }
    }
}