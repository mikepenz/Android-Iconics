/*
 * Copyright 2014 Mike Penz
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
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.IconicsView;
import com.mikepenz.iconics.internal.IconicsViewsAttrsReader;
import com.mikepenz.iconics.typeface.IIcon;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

public class IconicsImageView extends AppCompatImageView implements IconicsView {
    private IconicsDrawable icon;

    public IconicsImageView(Context context) {
        this(context, null);
    }

    public IconicsImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconicsImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            initialize(context, attrs, defStyle);
        }
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void initialize(Context context, AttributeSet attrs, int defStyle) {
        icon = new IconicsDrawable(context);
        applyAttr(context, attrs, defStyle);
        //set the scale type for this view
        setScaleType(ScaleType.CENTER_INSIDE);
        //set our values for this view
        setImageDrawable(icon);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsImageView, defStyle, 0);
        IconicsViewsAttrsReader.readIconicsImageView(a, icon);
        a.recycle();
    }

    public void setIcon(Character icon) {
        setIcon(new IconicsDrawable(getContext(), icon));
    }

    public void setIcon(String icon) {
        setIcon(new IconicsDrawable(getContext(), icon));
    }

    public void setIcon(IIcon icon) {
        setIcon(new IconicsDrawable(getContext(), icon));
    }

    public void setIcon(IconicsDrawable icon) {
        this.icon = icon;
        //set the imageDrawable
        setImageDrawable(this.icon);
    }

    public void setIconText(String iconText) {
        setIcon(new IconicsDrawable(getContext()).iconText(iconText));
    }

    public void setColor(@ColorInt int color) {
        icon.color(color);
    }

    public void setColorRes(@ColorRes int colorRes) {
        icon.colorRes(colorRes);
    }

    public void setPaddingPx(int padding) {
        icon.paddingPx(padding);
    }

    public void setPaddingDp(int paddingDp) {
        icon.paddingDp(paddingDp);
    }

    public void setPaddingRes(@DimenRes int paddingRes) {
        icon.paddingRes(paddingRes);
    }

    public void setContourColor(@ColorInt int color) {
        icon.contourColor(color);
    }

    public void setContourColorRes(@ColorRes int colorRes) {
        icon.contourColorRes(colorRes);
    }

    public void setContourWidthPx(int contourWidth) {
        icon.contourWidthPx(contourWidth);
    }

    public void setContourWidthDp(int contourWidthDp) {
        icon.contourWidthDp(contourWidthDp);
    }

    public void setContourWidthRes(@DimenRes int contourWidthRes) {
        icon.contourWidthRes(contourWidthRes);
    }

    public void setBackgroundColor(@ColorInt int color) {
        icon.backgroundColor(color);
    }

    public void setBackgroundColorRes(@ColorRes int colorRes) {
        icon.backgroundColorRes(colorRes);
    }

    public void setRoundedCornersPx(int cornerRadius) {
        icon.roundedCornersPx(cornerRadius);
    }

    public void setRoundedCornersDp(int cornerRadiusDp) {
        icon.roundedCornersDp(cornerRadiusDp);
    }

    public void setRoundedCornersRes(@DimenRes int cornerRadiusRes) {
        icon.roundedCornersRes(cornerRadiusRes);
    }

    @Nullable
    public IconicsDrawable getIcon() {
        if (icon != null) {
            return icon;
        } else if (getDrawable() instanceof IconicsDrawable) {
            return ((IconicsDrawable) getDrawable());
        } else {
            return null;
        }
    }
}
