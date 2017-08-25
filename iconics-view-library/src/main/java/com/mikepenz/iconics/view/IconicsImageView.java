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
    private IconicsDrawable mIcon;

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
        mIcon = new IconicsDrawable(context);
        applyAttr(context, attrs, defStyle);
        //set the scale type for this view
        setScaleType(ScaleType.CENTER_INSIDE);
        //set our values for this view
        setImageDrawable(mIcon);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsImageView, defStyle, 0);
        IconicsViewsAttrsReader.readIconicsImageView(a, mIcon);
        a.recycle();
    }

    public void setIcon(@Nullable IconicsDrawable icon) {
        //set the imageDrawable
        setImageDrawable(mIcon = icon);
    }

    //region deprecated methods
    /**
     * @deprecated use {@link IconicsDrawable#icon(Character) getIcon().icon(Character)} instead
     * */
    @Deprecated
    public void setIcon(Character icon) {
        if (mIcon != null) {
            mIcon.icon(icon);
        } else {
            setIcon(new IconicsDrawable(getContext(), icon));
        }
    }

    /**
     * @deprecated use {@link IconicsDrawable#icon(String) getIcon().icon(String)} instead
     * */
    @Deprecated
    public void setIcon(String icon) {
        if (mIcon != null) {
            mIcon.icon(icon);
        } else {
            setIcon(new IconicsDrawable(getContext(), icon));
        }
    }

    /**
     * @deprecated use {@link IconicsDrawable#icon(IIcon) getIcon().icon(IIcon)} instead
     * */
    @Deprecated
    public void setIcon(IIcon icon) {
        if (mIcon != null) {
            mIcon.icon(icon);
        } else {
            setIcon(new IconicsDrawable(getContext(), icon));
        }
    }

    /**
     * @deprecated use {@link IconicsDrawable#iconText(String) getIcon().iconText(String)} instead
     * */
    @Deprecated
    public void setIconText(String iconText) {
        setIcon(new IconicsDrawable(getContext()).iconText(iconText));
    }

    /**
     * @deprecated use {@link IconicsDrawable#color(int) getIcon().color(@ColorInt int)} instead
     * */
    @Deprecated
    public void setColor(@ColorInt int color) {
        mIcon.color(color);
    }

    /**
     * @deprecated use {@link IconicsDrawable#colorRes(int) getIcon().colorRes(@ColorRes int)} instead
     * */
    @Deprecated
    public void setColorRes(@ColorRes int colorRes) {
        mIcon.colorRes(colorRes);
    }

    /**
     * @deprecated use {@link IconicsDrawable#paddingPx(int) getIcon().paddingPx(int)} instead
     * */
    @Deprecated
    public void setPaddingPx(int padding) {
        mIcon.paddingPx(padding);
    }

    /**
     * @deprecated use {@link IconicsDrawable#paddingDp(int) getIcon().paddingDp(int)} instead
     * */
    @Deprecated
    public void setPaddingDp(int paddingDp) {
        mIcon.paddingDp(paddingDp);
    }

    /**
     * @deprecated use {@link IconicsDrawable#paddingRes(int)}  getIcon().paddingRes(@DimenRes int)} instead
     * */
    @Deprecated
    public void setPaddingRes(@DimenRes int paddingRes) {
        mIcon.paddingRes(paddingRes);
    }

    /**
     * @deprecated use {@link IconicsDrawable#contourColor(int) getIcon().contourColor(@ColorInt int)} instead
     * */
    @Deprecated
    public void setContourColor(@ColorInt int color) {
        mIcon.contourColor(color);
    }

    /**
     * @deprecated use {@link IconicsDrawable#contourColorRes(int) getIcon().contourColorRes(@ColorRes int)} instead
     * */
    @Deprecated
    public void setContourColorRes(@ColorRes int colorRes) {
        mIcon.contourColorRes(colorRes);
    }

    /**
     * @deprecated use {@link IconicsDrawable#contourWidthPx(int) getIcon().contourWidthPx(int)} instead
     * */
    @Deprecated
    public void setContourWidthPx(int contourWidth) {
        mIcon.contourWidthPx(contourWidth);
    }

    /**
     * @deprecated use {@link IconicsDrawable#contourWidthDp(int) getIcon().contourWidthDp(int)} instead
     * */
    @Deprecated
    public void setContourWidthDp(int contourWidthDp) {
        mIcon.contourWidthDp(contourWidthDp);
    }

    /**
     * @deprecated use {@link IconicsDrawable#contourWidthRes(int) getIcon().contourWidthRes(@DimenRes int)} instead
     * */
    @Deprecated
    public void setContourWidthRes(@DimenRes int contourWidthRes) {
        mIcon.contourWidthRes(contourWidthRes);
    }

    /**
     * @deprecated use {@link IconicsDrawable#backgroundColor(int) getIcon().backgroundColor(@ColorInt int) instead
     * */
    @Deprecated
    public void setBackgroundColor(@ColorInt int color) {
        mIcon.backgroundColor(color);
    }

    /**
     * @deprecated use {@link IconicsDrawable#backgroundColorRes(int) getIcon().backgroundColorRes(@ColorRes int)} instead
     * */
    @Deprecated
    public void setBackgroundColorRes(@ColorRes int colorRes) {
        mIcon.backgroundColorRes(colorRes);
    }

    /**
     * @deprecated use {@link IconicsDrawable#roundedCornersPx(int) getIcon()roundedCornersPx(int)} instead
     * */
    @Deprecated
    public void setRoundedCornersPx(int cornerRadius) {
        mIcon.roundedCornersPx(cornerRadius);
    }

    /**
     * @deprecated use {@link IconicsDrawable#roundedCornersDp(int) getIcon().roundedCornersDp(int)} instead
     * */
    @Deprecated
    public void setRoundedCornersDp(int cornerRadiusDp) {
        mIcon.roundedCornersDp(cornerRadiusDp);
    }

    /**
     * @deprecated use {@link IconicsDrawable#roundedCornersRes(int) getIcon().roundedCornersRes(@DimenRes int)} instead
     * */
    @Deprecated
    public void setRoundedCornersRes(@DimenRes int cornerRadiusRes) {
        mIcon.roundedCornersRes(cornerRadiusRes);
    }
    //endregion

    @Nullable
    public IconicsDrawable getIcon() {
        if (getDrawable() instanceof IconicsDrawable) {
            return ((IconicsDrawable) getDrawable());
        } else {
            return null;
        }
    }
}
