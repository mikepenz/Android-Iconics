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
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.utils.Utils;

public class IconicsImageView extends ImageView {

    private IconicsDrawable mIcon = null;
    @ColorInt
    private int mColor = 0;
    private int mSize = -1;
    private int mPadding = -1;
    @ColorInt
    private int mContourColor = 0;
    private int mContourWidth = -1;
    @ColorInt
    private int mBackgroundColor = 0;
    private int mCornerRadius = -1;

    public IconicsImageView(Context context) {
        this(context, null);
    }

    public IconicsImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconicsImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            // Attribute initialization
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsImageView, defStyle, 0);
            String icon = a.getString(R.styleable.IconicsImageView_iiv_icon);

            //set the color even if we had no image yet
            mColor = a.getColor(R.styleable.IconicsImageView_iiv_color, 0);
            mSize = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_size, -1);
            mPadding = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_padding, -1);
            mContourColor = a.getColor(R.styleable.IconicsImageView_iiv_contour_color, 0);
            mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_contour_width, -1);
            mBackgroundColor = a.getColor(R.styleable.IconicsImageView_iiv_background_color, 0);
            mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_corner_radius, -1);

            //recycle the typedArray
            a.recycle();

            //set the scale type for this view
            setScaleType(ScaleType.CENTER_INSIDE);

            //if we have no icon return now
            if (icon == null) {
                return;
            }


            //get the drawable
            mIcon = new IconicsDrawable(context, icon);

            //set attributes
            setAttributes();

            //set our values for this view
            setImageDrawable(mIcon);
        }
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
        mIcon = icon;
        //reset the attributes defined via the layout
        if (resetAttributes) {
            setAttributes();
        }
        //set the imageDrawable
        setImageDrawable(mIcon);
    }

    public void setIconText(String iconText) {
        setIconText(iconText, true);
    }

    public void setIconText(String iconText, boolean resetAttributes) {
        setIcon(new IconicsDrawable(getContext()).iconText(iconText), resetAttributes);
    }

    private void setAttributes() {
        if (mColor != 0) {
            mIcon.color(mColor);
        }
        if (mSize != -1) {
            mIcon.sizePx(mSize);
        }
        if (mPadding != -1) {
            mIcon.paddingPx(mPadding);
        }
        if (mContourColor != 0) {
            mIcon.contourColor(mContourColor);
        }
        if (mContourWidth != -1) {
            mIcon.contourWidthPx(mContourWidth);
        }
        if (mBackgroundColor != 0) {
            mIcon.backgroundColor(mBackgroundColor);
        }
        if (mCornerRadius != -1) {
            mIcon.roundedCornersPx(mCornerRadius);
        }
    }

    public void setColor(@ColorInt int color) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).color(color);
        }
        mColor = color;
    }

    public void setColorRes(@ColorRes int colorRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).colorRes(colorRes);
        }
        mColor = ContextCompat.getColor(getContext(), colorRes);
    }

    public void setPaddingPx(int padding) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).paddingPx(padding);
        }
        mPadding = padding;
    }

    public void setPaddingDp(int paddingDp) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).paddingDp(paddingDp);
        }
        mPadding = Utils.convertDpToPx(getContext(), paddingDp);
    }

    public void setPaddingRes(@DimenRes int paddingRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).paddingRes(paddingRes);
        }
        mPadding = getContext().getResources().getDimensionPixelSize(paddingRes);
    }

    public void setContourColor(@ColorInt int color) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourColor(color);
        }
        mContourColor = color;
    }

    public void setContourColorRes(@ColorRes int colorRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourColorRes(colorRes);
        }
        mContourColor = ContextCompat.getColor(getContext(), colorRes);
    }

    public void setContourWidthPx(int contourWidth) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourWidthPx(contourWidth);
        }
        mContourWidth = contourWidth;
    }

    public void setContourWidthDp(int contourWidthDp) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourWidthDp(contourWidthDp);
        }
        mContourWidth = Utils.convertDpToPx(getContext(), contourWidthDp);
    }

    public void setContourWidthRes(@DimenRes int contourWidthRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourWidthRes(contourWidthRes);
        }
        mContourWidth = getContext().getResources().getDimensionPixelSize(contourWidthRes);
    }

    public void setBackgroundColor(@ColorInt int color) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).backgroundColor(color);
        }
        mBackgroundColor = color;
    }

    public void setBackgroundColorRes(@ColorRes int colorRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).backgroundColorRes(colorRes);
        }
        mBackgroundColor = ContextCompat.getColor(getContext(), colorRes);
    }

    public void setRoundedCornersPx(int cornerRadius) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).roundedCornersDp(cornerRadius);
        }
        mCornerRadius = cornerRadius;
    }

    public void setRoundedCornersDp(int cornerRadiusDp) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).roundedCornersDp(cornerRadiusDp);
        }
        mCornerRadius = Utils.convertDpToPx(getContext(), cornerRadiusDp);
    }

    public void setRoundedCornersRes(@DimenRes int cornerRadiusRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).roundedCornersPx(cornerRadiusRes);
        }
        mCornerRadius = getContext().getResources().getDimensionPixelSize(cornerRadiusRes);
    }

    public IconicsDrawable getIcon() {
        if (getDrawable() instanceof IconicsDrawable) {
            return ((IconicsDrawable) getDrawable());
        }
        return mIcon;
    }
}
