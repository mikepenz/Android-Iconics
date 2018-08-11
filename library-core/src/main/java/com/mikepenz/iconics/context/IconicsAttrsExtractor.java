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

package com.mikepenz.iconics.context;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import android.text.TextUtils;

import com.mikepenz.iconics.IconicsDrawable;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (30.10.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconicsAttrsExtractor {
    private final static int DEF_COLOR = Integer.MIN_VALUE;
    private final static int DEF_SIZE = -1;

    @NonNull private final Context mContext;
    @NonNull private final TypedArray mTypedArray;

    @StyleableRes private int mIconId;
    @StyleableRes private int mSizeId;
    @StyleableRes private int mColorsId;
    @StyleableRes private int mPaddingId;
    @StyleableRes private int mContourColorId;
    @StyleableRes private int mContourWidthId;
    @StyleableRes private int mBackgroundColorId;
    @StyleableRes private int mCornerRadiusId;
    @StyleableRes private int mBackgroundContourColorId;
    @StyleableRes private int mBackgroundContourWidthId;

    @StyleableRes private int mOffsetXId;
    @StyleableRes private int mOffsetYId;


    public IconicsAttrsExtractor(@NonNull Context context, @NonNull TypedArray typedArray) {
        mContext = context;
        mTypedArray = typedArray;
    }

    //region chain setters
    public IconicsAttrsExtractor iconId(@StyleableRes int iconId) {
        mIconId = iconId;
        return this;
    }

    public IconicsAttrsExtractor sizeId(@StyleableRes int sizeId) {
        mSizeId = sizeId;
        return this;
    }

    public IconicsAttrsExtractor colorsId(@StyleableRes int colorsId) {
        mColorsId = colorsId;
        return this;
    }

    public IconicsAttrsExtractor paddingId(@StyleableRes int paddingId) {
        mPaddingId = paddingId;
        return this;
    }

    public IconicsAttrsExtractor contourColorId(@StyleableRes int contourColorId) {
        mContourColorId = contourColorId;
        return this;
    }

    public IconicsAttrsExtractor contourWidthId(@StyleableRes int contourWidthId) {
        mContourWidthId = contourWidthId;
        return this;
    }

    public IconicsAttrsExtractor backgroundColorId(@StyleableRes int backgroundColorId) {
        mBackgroundColorId = backgroundColorId;
        return this;
    }

    public IconicsAttrsExtractor cornerRadiusId(@StyleableRes int cornerRadiusId) {
        mCornerRadiusId = cornerRadiusId;
        return this;
    }

    public IconicsAttrsExtractor backgroundContourColorId(@StyleableRes int backgroundContourColorId) {
        mBackgroundContourColorId = backgroundContourColorId;
        return this;
    }

    public IconicsAttrsExtractor backgroundContourWidthId(@StyleableRes int backgroundContourWidthId) {
        mBackgroundContourWidthId = backgroundContourWidthId;
        return this;
    }

    public IconicsAttrsExtractor offsetXId(@StyleableRes int offsetXId) {
        mOffsetXId = offsetXId;
        return this;
    }

    public IconicsAttrsExtractor offsetYId(@StyleableRes int offsetYId) {
        mOffsetYId = offsetYId;
        return this;
    }
    //endregion

    @NonNull
    public IconicsDrawable extractNonNull() {
        return extract(null, false, true);
    }

    @Nullable
    public IconicsDrawable extract(@Nullable IconicsDrawable icon) {
        return extract(icon, false, false);
    }

    @Nullable
    public IconicsDrawable extract() {
        return extract(null, false, false);
    }

    @Nullable
    public IconicsDrawable extractWithOffsets() {
        return extract(null, true, false);
    }

    private IconicsDrawable extract(@Nullable IconicsDrawable icon, boolean extractOffsets, boolean nonNull) {

        icon = copyIfCan(icon);

        String i = mTypedArray.getString(mIconId);
        if (!TextUtils.isEmpty(i)) {
            icon = createIfNeeds(icon, mContext).icon(i);
        }
        ColorStateList colors = mTypedArray.getColorStateList(mColorsId);
        if (colors != null) {
            icon = createIfNeeds(icon, mContext).color(colors);
        }
        int size = mTypedArray.getDimensionPixelSize(mSizeId, DEF_SIZE);
        if (size != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).sizePx(size);
        }
        int padding = mTypedArray.getDimensionPixelSize(mPaddingId, DEF_SIZE);
        if (padding != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).paddingPx(padding);
        }
        int contourColor = mTypedArray.getColor(mContourColorId, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            icon = createIfNeeds(icon, mContext).contourColor(contourColor);
        }
        int contourWidth = mTypedArray.getDimensionPixelSize(mContourWidthId, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).contourWidthPx(contourWidth);
        }
        int backgroundColor = mTypedArray.getColor(mBackgroundColorId, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            icon = createIfNeeds(icon, mContext).backgroundColor(backgroundColor);
        }
        int cornerRadius = mTypedArray.getDimensionPixelSize(mCornerRadiusId, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = mTypedArray.getColor(mBackgroundContourColorId, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            icon = createIfNeeds(icon, mContext).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = mTypedArray.getDimensionPixelSize(mBackgroundContourWidthId, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).backgroundContourWidthPx(backgroundContourWidth);
        }
        if (extractOffsets) {
            int offsetY = mTypedArray.getDimensionPixelSize(mOffsetYId, DEF_SIZE);
            if (offsetY != DEF_SIZE) {
                icon = createIfNeeds(icon, mContext).iconOffsetYPx(offsetY);
            }
            int offsetX = mTypedArray.getDimensionPixelSize(mOffsetXId, DEF_SIZE);
            if (offsetX != DEF_SIZE) {
                icon = createIfNeeds(icon, mContext).iconOffsetXPx(offsetX);
            }
        }
        if (nonNull) {
            icon = createIfNeeds(icon, mContext);
        }
        return icon;
    }

    @Nullable
    private static IconicsDrawable copyIfCan(@Nullable IconicsDrawable drawable) {
        if (drawable != null) {
            return drawable.clone();
        }
        return null;
    }

    @NonNull
    private static IconicsDrawable createIfNeeds(@Nullable IconicsDrawable drawable, Context context){
        if (drawable == null){
            drawable = new IconicsDrawable(context);
        }
        return drawable;
    }
}
