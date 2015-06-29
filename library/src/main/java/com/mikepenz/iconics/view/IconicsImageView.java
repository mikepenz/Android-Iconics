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
import android.util.AttributeSet;
import android.widget.ImageView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.R;
import com.mikepenz.iconics.typeface.IIcon;

public class IconicsImageView extends ImageView {

    private IconicsDrawable mIcon = null;
    private int mColor = 0;
    private int mSize = -1;
    private int mPadding = -1;


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
            if (icon == null) {
                return;
            }
            mColor = a.getColor(R.styleable.IconicsImageView_iiv_color, 0);
            mSize = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_size, -1);
            mPadding = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_padding, -1);

            //get the drawable
            mIcon = new IconicsDrawable(context, icon);
            if (mColor != 0) {
                mIcon.color(mColor);
            }
            if (mSize != -1) {
                mIcon.sizePx(mSize);
            }
            if (mSize != -1) {
                mIcon.paddingPx(mPadding);
            }

            a.recycle();

            //set our values for this view
            setImageDrawable(mIcon);
            setScaleType(ScaleType.MATRIX);
        }
    }

    public void setIcon(String icon) {
        setIcon(new IconicsDrawable(getContext(), icon));
    }

    public void setIcon(IIcon icon) {
        setIcon(new IconicsDrawable(getContext(), icon));
    }

    public void setIcon(IconicsDrawable icon) {
        if (mColor != 0) {
            icon.color(mColor);
        }
        mIcon = icon;
        setImageDrawable(mIcon);
    }

    public void setColor(int color) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).color(color);
        }
    }

    public void setColorRes(int colorRes) {
        if (getDrawable() instanceof IconicsDrawable) {
            ((IconicsDrawable) getDrawable()).colorRes(colorRes);
        }
    }

    public IconicsDrawable getIcon() {
        if (getDrawable() instanceof IconicsDrawable) {
            return ((IconicsDrawable) getDrawable());
        }
        return null;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        if (getDrawable() instanceof IconicsDrawable) {
            //set the size
            if (w > h) {
                ((IconicsDrawable) getDrawable()).sizePx(w);
            } else {
                ((IconicsDrawable) getDrawable()).sizePx(h);
            }
        }
    }
}
