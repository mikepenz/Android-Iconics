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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.10.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconicsAttrsReader {
    protected final static int DEF_COLOR = Integer.MIN_VALUE;
    protected final static int DEF_SIZE = -1;

    @Nullable
    @SuppressWarnings("ConstantConditions")
    public static IconicsDrawable getIconicsDrawable(Context ctx, AttributeSet attrs) {
        final TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.Iconics);

        IconicsDrawable icon = null;

        String i = a.getString(R.styleable.Iconics_ico_icon);
        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.Iconics_ico_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.Iconics_ico_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.Iconics_ico_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.Iconics_ico_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.Iconics_ico_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.Iconics_ico_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.Iconics_ico_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.Iconics_ico_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.Iconics_ico_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }

        a.recycle();
        return icon;
    }

    @NonNull
    protected static IconicsDrawable createIfNeeds(@Nullable IconicsDrawable drawable, Context context){
        if (drawable == null){
            drawable = new IconicsDrawable(context);
        }
        return drawable;
    }
}
