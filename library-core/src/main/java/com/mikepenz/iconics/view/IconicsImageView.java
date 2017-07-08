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
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.internal.AttributeSetReader;
import com.mikepenz.iconics.internal.IconBundle;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.utils.Utils;

public class IconicsImageView extends AppCompatImageView {
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
            applyAttrs(context, attrs, defStyle);
        }
    }
    
    private void applyAttrs(Context context, AttributeSet attrs, int defStyle) {
        // Attribute initialization
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsImageView, defStyle, 0);
    
        //set the color even if we had no image yet
        AttributeSetReader.readIconicsImageView(a, mIconBundle);
    
        //recycle the typedArray
        a.recycle();
    
        //set the scale type for this view
        setScaleType(ScaleType.CENTER_INSIDE);
    
        //if we have no icon return now
        if (!mIconBundle.createIcon(context)) {
            return;
        }
    
        //set our values for this view
        setImageDrawable(mIconBundle.mIcon);
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
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).color(color);
        }
        mIconBundle.mColor = color;
    }

    public void setColorRes(@ColorRes int colorRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).colorRes(colorRes);
        }
        mIconBundle.mColor = ContextCompat.getColor(getContext(), colorRes);
    }

    public void setPaddingPx(int padding) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).paddingPx(padding);
        }
        mIconBundle.mPadding = padding;
    }

    public void setPaddingDp(int paddingDp) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).paddingDp(paddingDp);
        }
        mIconBundle.mPadding = Utils.convertDpToPx(getContext(), paddingDp);
    }

    public void setPaddingRes(@DimenRes int paddingRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).paddingRes(paddingRes);
        }
        mIconBundle.mPadding = getContext().getResources().getDimensionPixelSize(paddingRes);
    }

    public void setContourColor(@ColorInt int color) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourColor(color);
        }
        mIconBundle.mContourColor = color;
    }

    public void setContourColorRes(@ColorRes int colorRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourColorRes(colorRes);
        }
        mIconBundle.mContourColor = ContextCompat.getColor(getContext(), colorRes);
    }

    public void setContourWidthPx(int contourWidth) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourWidthPx(contourWidth);
        }
        mIconBundle.mContourWidth = contourWidth;
    }

    public void setContourWidthDp(int contourWidthDp) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourWidthDp(contourWidthDp);
        }
        mIconBundle.mContourWidth = Utils.convertDpToPx(getContext(), contourWidthDp);
    }

    public void setContourWidthRes(@DimenRes int contourWidthRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).contourWidthRes(contourWidthRes);
        }
        mIconBundle.mContourWidth = getContext().getResources().getDimensionPixelSize(contourWidthRes);
    }

    public void setBackgroundColor(@ColorInt int color) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).backgroundColor(color);
        }
        mIconBundle.mBackgroundColor = color;
    }

    public void setBackgroundColorRes(@ColorRes int colorRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).backgroundColorRes(colorRes);
        }
        mIconBundle.mBackgroundColor = ContextCompat.getColor(getContext(), colorRes);
    }

    public void setRoundedCornersPx(int cornerRadius) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).roundedCornersDp(cornerRadius);
        }
        mIconBundle.mCornerRadius = cornerRadius;
    }

    public void setRoundedCornersDp(int cornerRadiusDp) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).roundedCornersDp(cornerRadiusDp);
        }
        mIconBundle.mCornerRadius = Utils.convertDpToPx(getContext(), cornerRadiusDp);
    }

    public void setRoundedCornersRes(@DimenRes int cornerRadiusRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).roundedCornersRes(cornerRadiusRes);
        }
        mIconBundle.mCornerRadius = getContext().getResources().getDimensionPixelSize(cornerRadiusRes);
    }

    public IconicsDrawable getIcon() {
        if (getDrawable() instanceof IconicsDrawable) {
            return ((IconicsDrawable) getDrawable());
        }
        return mIconBundle.mIcon;
    }
}
