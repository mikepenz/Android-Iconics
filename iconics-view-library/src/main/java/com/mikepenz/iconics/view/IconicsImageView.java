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
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.IconBundle;
import com.mikepenz.iconics.internal.IconicsView;
import com.mikepenz.iconics.internal.IconicsViewsAttrsReader;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.utils.Utils;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

public class IconicsImageView extends AppCompatImageView implements IconicsView {
    private IconBundle mIconBundle = new IconBundle();

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
        applyAttr(context, attrs, defStyle);
        //set the scale type for this view
        setScaleType(ScaleType.CENTER_INSIDE);

        //if we have no icon return now
        if (!mIconBundle.createIcon(context)) {
            return;
        }

        //set our values for this view
        setImageDrawable(mIconBundle.mIcon);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        // Attribute initialization
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsImageView, defStyle, 0);

        //set the color even if we had no image yet
        IconicsViewsAttrsReader.readIconicsImageView(a, mIconBundle);

        //recycle the typedArray
        a.recycle();
    }

    public void setIcon(Character icon) {
        setIcon(icon, true);
    }

    public void setIcon(Character icon, boolean resetAttributes) {
        setIcon(new IconicsDrawable(getContext(), icon), resetAttributes);
    }

    public void setIcon(String icon) {
        setIcon(icon, true);
    }

    public void setIcon(String icon, boolean resetAttributes) {
        setIcon(new IconicsDrawable(getContext(), icon), resetAttributes);
    }

    public void setIcon(IIcon icon) {
        setIcon(icon, true);
    }

    public void setIcon(IIcon icon, boolean resetAttributes) {
        setIcon(new IconicsDrawable(getContext(), icon), resetAttributes);
    }

    public void setIcon(IconicsDrawable icon) {
        setIcon(icon, true);
    }

    public void setIcon(IconicsDrawable icon, boolean resetAttributes) {
        mIconBundle.mIcon = icon;
        //reset the attributes defined via the layout
        if (resetAttributes) {
            mIconBundle.createIcon(getContext());
        }
        //set the imageDrawable
        setImageDrawable(mIconBundle.mIcon);
    }

    public void setIconText(String iconText) {
        setIconText(iconText, true);
    }

    public void setIconText(String iconText, boolean resetAttributes) {
        setIcon(new IconicsDrawable(getContext()).iconText(iconText), resetAttributes);
    }

    public void setColor(@ColorInt int color) {
        mIconBundle.mColor = color;
        mIconBundle.applyProperties();
    }

    public void setColorRes(@ColorRes int colorRes) {
        mIconBundle.mColor = ContextCompat.getColor(getContext(), colorRes);
        mIconBundle.applyProperties();
    }

    public void setPaddingPx(int padding) {
        mIconBundle.mPadding = padding;
        mIconBundle.applyProperties();
    }

    public void setPaddingDp(int paddingDp) {
        mIconBundle.mPadding = Utils.convertDpToPx(getContext(), paddingDp);
        mIconBundle.applyProperties();
    }

    public void setPaddingRes(@DimenRes int paddingRes) {
        mIconBundle.mPadding = getContext().getResources().getDimensionPixelSize(paddingRes);
        mIconBundle.applyProperties();
    }

    public void setContourColor(@ColorInt int color) {
        mIconBundle.mContourColor = color;
        mIconBundle.applyProperties();
    }

    public void setContourColorRes(@ColorRes int colorRes) {
        mIconBundle.mContourColor = ContextCompat.getColor(getContext(), colorRes);
        mIconBundle.applyProperties();
    }

    public void setContourWidthPx(int contourWidth) {
        mIconBundle.mContourWidth = contourWidth;
        mIconBundle.applyProperties();
    }

    public void setContourWidthDp(int contourWidthDp) {
        mIconBundle.mContourWidth = Utils.convertDpToPx(getContext(), contourWidthDp);
        mIconBundle.applyProperties();
    }

    public void setContourWidthRes(@DimenRes int contourWidthRes) {
        mIconBundle.mContourWidth = getContext().getResources().getDimensionPixelSize(contourWidthRes);
        mIconBundle.applyProperties();
    }

    public void setBackgroundColor(@ColorInt int color) {
        mIconBundle.mBackgroundColor = color;
        mIconBundle.applyProperties();
    }

    public void setBackgroundColorRes(@ColorRes int colorRes) {
        mIconBundle.mBackgroundColor = ContextCompat.getColor(getContext(), colorRes);
        mIconBundle.applyProperties();
    }

    public void setRoundedCornersPx(int cornerRadius) {
        mIconBundle.mCornerRadius = cornerRadius;
        mIconBundle.applyProperties();
    }

    public void setRoundedCornersDp(int cornerRadiusDp) {
        mIconBundle.mCornerRadius = Utils.convertDpToPx(getContext(), cornerRadiusDp);
        mIconBundle.applyProperties();
    }

    public void setRoundedCornersRes(@DimenRes int cornerRadiusRes) {
        mIconBundle.mCornerRadius = getContext().getResources().getDimensionPixelSize(cornerRadiusRes);
        mIconBundle.applyProperties();
    }

    @Nullable
    public IconicsDrawable getIcon() {
        if (getDrawable() instanceof IconicsDrawable) {
            return ((IconicsDrawable) getDrawable());
        }
        if (mIconBundle.mIcon instanceof IconicsDrawable) {
            return (IconicsDrawable) mIconBundle.mIcon;
        } else {
            return null;
        }
    }
}
