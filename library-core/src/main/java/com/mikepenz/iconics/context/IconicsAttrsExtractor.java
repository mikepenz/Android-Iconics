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
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.animation.IconicsAnimationProcessor;

import java.util.ArrayList;
import java.util.List;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (30.10.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconicsAttrsExtractor {
    private final static int DEF_COLOR = Integer.MIN_VALUE;
    private final static int DEF_SIZE = -1;

    private final @NonNull
    Context mContext;
    private final @NonNull
    TypedArray mTypedArray;

    private @StyleableRes
    int mIconId;
    private @StyleableRes
    int mSizeId;
    private @StyleableRes
    int mColorsId;
    private @StyleableRes
    int mPaddingId;
    private @StyleableRes
    int mOffsetXId;
    private @StyleableRes
    int mOffsetYId;

    private @StyleableRes
    int mContourColorId;
    private @StyleableRes
    int mContourWidthId;

    private @StyleableRes
    int mBackgroundColorId;
    private @StyleableRes
    int mCornerRadiusId;

    private @StyleableRes
    int mBackgroundContourColorId;
    private @StyleableRes
    int mBackgroundContourWidthId;

    private @StyleableRes
    int mShadowRadiusId;
    private @StyleableRes
    int mShadowDxId;
    private @StyleableRes
    int mShadowDyId;
    private @StyleableRes
    int mShadowColorId;

    private @StyleableRes
    int mAnimationsId;


    public IconicsAttrsExtractor(@NonNull Context context, @NonNull TypedArray typedArray) {
        mContext = context;
        mTypedArray = typedArray;
    }

    //region chain setters
    public @NonNull
    IconicsAttrsExtractor iconId(@StyleableRes int iconId) {
        mIconId = iconId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor sizeId(@StyleableRes int sizeId) {
        mSizeId = sizeId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor colorsId(@StyleableRes int colorsId) {
        mColorsId = colorsId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor paddingId(@StyleableRes int paddingId) {
        mPaddingId = paddingId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor offsetXId(@StyleableRes int offsetXId) {
        mOffsetXId = offsetXId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor offsetYId(@StyleableRes int offsetYId) {
        mOffsetYId = offsetYId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor contourColorId(@StyleableRes int contourColorId) {
        mContourColorId = contourColorId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor contourWidthId(@StyleableRes int contourWidthId) {
        mContourWidthId = contourWidthId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor backgroundColorId(@StyleableRes int backgroundColorId) {
        mBackgroundColorId = backgroundColorId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor cornerRadiusId(@StyleableRes int cornerRadiusId) {
        mCornerRadiusId = cornerRadiusId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor backgroundContourColorId(@StyleableRes int backgroundContourColorId) {
        mBackgroundContourColorId = backgroundContourColorId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor backgroundContourWidthId(@StyleableRes int backgroundContourWidthId) {
        mBackgroundContourWidthId = backgroundContourWidthId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor shadowRadiusId(@StyleableRes int shadowRadiusId) {
        mShadowRadiusId = shadowRadiusId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor shadowDxId(@StyleableRes int shadowDxId) {
        mShadowDxId = shadowDxId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor shadowDyId(@StyleableRes int shadowDyId) {
        mShadowDyId = shadowDyId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor shadowColorId(@StyleableRes int shadowColorId) {
        mShadowColorId = shadowColorId;
        return this;
    }

    public @NonNull
    IconicsAttrsExtractor animationsId(@StyleableRes int animationsId) {
        mAnimationsId = animationsId;
        return this;
    }
    //endregion

    public @NonNull
    IconicsDrawable extractNonNull() {
        return extract(null, false, true);
    }

    public @Nullable
    IconicsDrawable extract(@Nullable IconicsDrawable icon) {
        return extract(icon, false, false);
    }

    public @Nullable
    IconicsDrawable extract() {
        return extract(null, false, false);
    }

    public @Nullable
    IconicsDrawable extractWithOffsets() {
        return extract(null, true, false);
    }

    private IconicsDrawable extract(@Nullable IconicsDrawable icon,
                                    boolean extractOffsets,
                                    boolean nonNull) {

        icon = copyIfCan(icon);

        // region icon
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
        // endregion
        // region contour
        ColorStateList contourColor = mTypedArray.getColorStateList(mContourColorId);
        if (contourColor != null) {
            icon = createIfNeeds(icon, mContext).contourColor(contourColor);
        }
        int contourWidth = mTypedArray.getDimensionPixelSize(mContourWidthId, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).contourWidthPx(contourWidth);
        }
        // endregion
        // region background
        ColorStateList backgroundColor = mTypedArray.getColorStateList(mBackgroundColorId);
        if (backgroundColor != null) {
            icon = createIfNeeds(icon, mContext).backgroundColor(backgroundColor);
        }
        int cornerRadius = mTypedArray.getDimensionPixelSize(mCornerRadiusId, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).roundedCornersPx(cornerRadius);
        }
        // endregion
        // region background contour
        ColorStateList backgroundContourColor = mTypedArray.getColorStateList(mBackgroundContourColorId);
        if (backgroundContourColor != null) {
            icon = createIfNeeds(icon, mContext).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = mTypedArray.getDimensionPixelSize(mBackgroundContourWidthId, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            icon = createIfNeeds(icon, mContext).backgroundContourWidthPx(backgroundContourWidth);
        }
        // endregion
        // region shadow
        int shadowRadius = mTypedArray.getDimensionPixelSize(mShadowRadiusId, DEF_SIZE);
        int shadowDx = mTypedArray.getDimensionPixelSize(mShadowDxId, DEF_SIZE);
        int shadowDy = mTypedArray.getDimensionPixelSize(mShadowDyId, DEF_SIZE);
        int shadowColor = mTypedArray.getColor(mShadowColorId, DEF_COLOR);

        if (shadowRadius != DEF_SIZE
                && shadowDx != DEF_SIZE
                && shadowDy != DEF_SIZE
                && shadowColor != DEF_COLOR) {
            icon = createIfNeeds(icon, mContext).shadowPx(
                    shadowRadius,
                    shadowDx,
                    shadowDy,
                    shadowColor);
        }
        // endregion

        // animations should be applied at the end because here we transform the drawable,
        // therefore all properties must be processed before

        // region animations
        String animations = mTypedArray.getString(mAnimationsId);
        if (!TextUtils.isEmpty(animations)) {
            List<IconicsAnimationProcessor> processors = new ArrayList<>();
            String[] animationsList = animations.split("\\|");
            for (String animationTag : animationsList) {
                IconicsAnimationProcessor processor = Iconics.findProcessor(mContext, animationTag);
                if (processor != null) {
                    processors.add(processor);
                }
            }

            icon = createIfNeeds(icon, mContext)
                    .toAnimatedDrawable()
                    .processors(processors.toArray(new IconicsAnimationProcessor[0]));
        }
        // endregion

        if (nonNull) {
            icon = createIfNeeds(icon, mContext);
        }
        return icon;
    }

    private static @Nullable
    IconicsDrawable copyIfCan(@Nullable IconicsDrawable drawable) {
        if (drawable != null) {
            return drawable.clone();
        }
        return null;
    }

    private static @NonNull
    IconicsDrawable createIfNeeds(
            @Nullable IconicsDrawable drawable,
            @NonNull Context context) {
        if (drawable == null) {
            drawable = new IconicsDrawable(context);
        }
        return drawable;
    }
}
