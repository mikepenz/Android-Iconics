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

package com.mikepenz.iconics.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsAttrsReader;
import com.mikepenz.iconics.utils.Utils;
import com.mikepenz.iconics.view.R;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
@SuppressWarnings("ConstantConditions")
public class IconicsViewsAttrsReader extends IconicsAttrsReader {

    //region IconicsImageView
    @Nullable
    public static IconicsDrawable getIconicsImageViewDrawable(Context ctx, AttributeSet attrs) {
        final TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.IconicsImageView);

        IconicsDrawable icon = null;

        String i = a.getString(R.styleable.IconicsImageView_iiv_icon);
        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsImageView_iiv_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsImageView_iiv_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsImageView_iiv_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsImageView_iiv_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }

        a.recycle();
        return icon;
    }
    //endregion

    //region IconicsTextView

    /**
     * Attributes priority:
     * <p>
     * Attributes with mark 'all' < attributes with some else mark ('start', 'top' etc)<br>
     * Working like as 'style' xml-attribute - local overrides global
     * <p>
     * <b>IMPORTANT TRICK</b>
     * <p>
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    public static void readIconicsTextView(Context ctx, AttributeSet attrs, CompoundIconsBundle bundle) {
        final TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.IconicsTextView, 0, 0);
        //obtaining attributes for all icons
        IconicsDrawable allIcon = getIconicsTextViewAllDrawable(ctx, a);

        //obtaining attributes for start icons
        bundle.mStartIcon = getIconicsTextViewStartDrawable(ctx, a, allIcon);

        //obtaining attributes for top icons
        bundle.mTopIcon = getIconicsTextViewTopDrawable(ctx, a, allIcon);

        //obtaining attributes for end icons
        bundle.mEndIcon = getIconicsTextViewEndDrawable(ctx, a, allIcon);

        //obtaining attributes for bottom icons
        bundle.mBottomIcon = getIconicsTextViewBottomDrawable(ctx, a, allIcon);

        a.recycle();
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewAllDrawable(Context ctx, TypedArray a) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_all_icon);

        IconicsDrawable icon = null;

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsTextView_iiv_all_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_all_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_all_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsTextView_iiv_all_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewStartDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_start_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsTextView_iiv_start_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_start_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_start_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsTextView_iiv_start_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewTopDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_top_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsTextView_iiv_top_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_top_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_top_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsTextView_iiv_top_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewEndDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_end_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsTextView_iiv_end_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_end_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_end_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsTextView_iiv_end_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewBottomDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_bottom_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsTextView_iiv_bottom_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }
    //endregion

    //region IconicsCompoundButton
    public static void readIconicsCompoundButton(Context ctx, AttributeSet attrs, CheckableIconBundle icon) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.IconicsCompoundButton, 0, 0);

        //obtaining attributes for Checked icon state
        icon.mCheckedIcon = getIconicsCompoundButtonCheckedDrawable(ctx, a, icon.mCheckedIcon);

        //obtaining attributes for Unchecked icon state
        icon.mUncheckedIcon = getIconicsCompoundButtonUncheckedDrawable(ctx, a, icon.mUncheckedIcon);

        a.recycle();
    }

    public static IconicsDrawable getIconicsCompoundButtonCheckedDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsCompoundButton_iiv_checked_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsCompoundButton_iiv_checked_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    public static IconicsDrawable getIconicsCompoundButtonUncheckedDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsCompoundButton_iiv_unchecked_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsCompoundButton_iiv_unchecked_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }
    //endregion

    //region IconicsCheckableTextView

    /**
     * Attributes priority:
     * <p>
     * Attributes with mark 'all' < attributes with some else mark ('start', 'top' etc)<br>
     * Working like as 'style' xml-attribute - local overrides global
     * <p>
     * <b>IMPORTANT TRICK</b>
     * <p>
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    public static void readIconicsCheckableTextView(Context ctx, AttributeSet attrs, CompoundIconsBundle bundle) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.IconicsCheckableTextView, 0, 0);

        //obtaining attributes for all icons
        IconicsDrawable allIcon = getIconicsCheckableTextViewAllDrawable(ctx, a);

        //obtaining attributes for start icons
        bundle.mStartIcon = getIconicsCheckableTextViewStartDrawable(ctx, a, allIcon);

        //obtaining attributes for top icons
        bundle.mTopIcon = getIconicsCheckableTextViewTopDrawable(ctx, a, allIcon);

        //obtaining attributes for end icons
        bundle.mEndIcon = getIconicsCheckableTextViewEndDrawable(ctx, a, allIcon);

        //obtaining attributes for bottom icons
        bundle.mBottomIcon = getIconicsCheckableTextViewBottomDrawable(ctx, a, allIcon);

        a.recycle();
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewAllDrawable(Context ctx, TypedArray a) {
        String i = a.getString(R.styleable.IconicsCheckableTextView_iiv_all_checked_icon);

        IconicsDrawable icon = null;

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsCheckableTextView_iiv_all_checked_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewStartDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_start_checked_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsCheckableTextView_iiv_start_checked_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewTopDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_top_checked_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsCheckableTextView_iiv_top_checked_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewEndDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_end_checked_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsCheckableTextView_iiv_end_checked_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewBottomDrawable(Context ctx, TypedArray a, @Nullable IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_bottom_checked_icon);

        icon = copyIfCan(icon);

        if (!TextUtils.isEmpty(i)) {
            createIfNeeds(icon, ctx).icon(i);
        }
        ColorStateList colors = a.getColorStateList(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_color);
        if (colors != null) {
            createIfNeeds(icon, ctx).color(colors);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_size, DEF_SIZE);
        if (size != DEF_SIZE) {
            createIfNeeds(icon, ctx).sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_padding, DEF_SIZE);
        if (padding != DEF_SIZE) {
            createIfNeeds(icon, ctx).paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_color, DEF_COLOR);
        if (contourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_width, DEF_SIZE);
        if (contourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_color, DEF_COLOR);
        if (backgroundColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_corner_radius, DEF_SIZE);
        if (cornerRadius != DEF_SIZE) {
            createIfNeeds(icon, ctx).roundedCornersPx(cornerRadius);
        }
        int backgroundContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_contour_color, DEF_COLOR);
        if (backgroundContourColor != DEF_COLOR) {
            createIfNeeds(icon, ctx).backgroundContourColor(backgroundContourColor);
        }
        int backgroundContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_contour_width, DEF_SIZE);
        if (backgroundContourWidth != DEF_SIZE) {
            createIfNeeds(icon, ctx).backgroundContourWidthPx(backgroundContourWidth);
        }
        return icon;
    }
    //endregion

    public static boolean isIconicsAnimateChanges(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsAnimateChanges, 0, 0);
        try {
            return a.getBoolean(R.styleable.IconicsAnimateChanges_iiv_animate_icon_changes, true);
        } finally {
            a.recycle();
        }
    }

    @Nullable
    private static IconicsDrawable copyIfCan(@Nullable IconicsDrawable drawable) {
        if (drawable != null) {
            return drawable.clone();
        }
        return null;
    }
}
