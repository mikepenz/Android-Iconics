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
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsAttrsApplier;
import com.mikepenz.iconics.context.IconicsAttrsExtractor;
import com.mikepenz.iconics.view.R;
import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
@SuppressWarnings("ConstantConditions")
public class IconicsViewsAttrsApplier extends IconicsAttrsApplier {

    //region IconicsImageView
    @Nullable
    public static IconicsDrawable getIconicsImageViewDrawable(@NonNull Context ctx,
                                                              @Nullable AttributeSet attrs) {
        final TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.IconicsImageView);
        try {
            return new IconicsAttrsExtractor(ctx, a)
                    .iconId(R.styleable.IconicsImageView_iiv_icon)
                    .colorsId(R.styleable.IconicsImageView_iiv_color)
                    .sizeId(R.styleable.IconicsImageView_iiv_size)
                    .paddingId(R.styleable.IconicsImageView_iiv_padding)
                    .contourColorId(R.styleable.IconicsImageView_iiv_contour_color)
                    .contourWidthId(R.styleable.IconicsImageView_iiv_contour_width)
                    .backgroundColorId(R.styleable.IconicsImageView_iiv_background_color)
                    .cornerRadiusId(R.styleable.IconicsImageView_iiv_corner_radius)
                    .backgroundContourColorId(R.styleable.IconicsImageView_iiv_background_contour_color)
                    .backgroundContourWidthId(R.styleable.IconicsImageView_iiv_background_contour_width)
                    .shadowRadiusId(R.styleable.IconicsImageView_iiv_shadow_radius)
                    .shadowDxId(R.styleable.IconicsImageView_iiv_shadow_dx)
                    .shadowDyId(R.styleable.IconicsImageView_iiv_shadow_dy)
                    .shadowColorId(R.styleable.IconicsImageView_iiv_shadow_color)
                    .animationsId(R.styleable.IconicsImageView_iiv_animations)
                    .extract();
        } finally {
            a.recycle();
        }
    }
    //endregion

    //region IconicsTextView

    /**
     * Attributes priority:
     * <p>
     * Attributes with mark 'all' attributes with some else mark ('start', 'top' etc)<br>
     * Working like as 'style' xml-attribute - local overrides global
     * <p>
     * <b>IMPORTANT TRICK</b>
     * <p>
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    public static void readIconicsTextView(@NonNull Context ctx,
                                           @Nullable AttributeSet attrs,
                                           @NonNull CompoundIconsBundle bundle) {
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
    public static IconicsDrawable getIconicsTextViewAllDrawable(@NonNull Context ctx,
                                                                @Nullable TypedArray a) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsTextView_iiv_all_icon)
                .colorsId(R.styleable.IconicsTextView_iiv_all_color)
                .sizeId(R.styleable.IconicsTextView_iiv_all_size)
                .paddingId(R.styleable.IconicsTextView_iiv_all_padding)
                .contourColorId(R.styleable.IconicsTextView_iiv_all_contour_color)
                .contourWidthId(R.styleable.IconicsTextView_iiv_all_contour_width)
                .backgroundColorId(R.styleable.IconicsTextView_iiv_all_background_color)
                .cornerRadiusId(R.styleable.IconicsTextView_iiv_all_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsTextView_iiv_all_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsTextView_iiv_all_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsTextView_iiv_all_shadow_radius)
                .shadowDxId(R.styleable.IconicsTextView_iiv_all_shadow_dx)
                .shadowDyId(R.styleable.IconicsTextView_iiv_all_shadow_dy)
                .shadowColorId(R.styleable.IconicsTextView_iiv_all_shadow_color)
                .animationsId(R.styleable.IconicsTextView_iiv_all_animations)
                .extract();
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewStartDrawable(@NonNull Context ctx,
                                                                  @Nullable TypedArray a,
                                                                  @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsTextView_iiv_start_icon)
                .colorsId(R.styleable.IconicsTextView_iiv_start_color)
                .sizeId(R.styleable.IconicsTextView_iiv_start_size)
                .paddingId(R.styleable.IconicsTextView_iiv_start_padding)
                .contourColorId(R.styleable.IconicsTextView_iiv_start_contour_color)
                .contourWidthId(R.styleable.IconicsTextView_iiv_start_contour_width)
                .backgroundColorId(R.styleable.IconicsTextView_iiv_start_background_color)
                .cornerRadiusId(R.styleable.IconicsTextView_iiv_start_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsTextView_iiv_start_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsTextView_iiv_start_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsTextView_iiv_start_shadow_radius)
                .shadowDxId(R.styleable.IconicsTextView_iiv_start_shadow_dx)
                .shadowDyId(R.styleable.IconicsTextView_iiv_start_shadow_dy)
                .shadowColorId(R.styleable.IconicsTextView_iiv_start_shadow_color)
                .animationsId(R.styleable.IconicsTextView_iiv_start_animations)
                .extract(icon);
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewTopDrawable(@NonNull Context ctx,
                                                                @Nullable TypedArray a,
                                                                @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsTextView_iiv_top_icon)
                .colorsId(R.styleable.IconicsTextView_iiv_top_color)
                .sizeId(R.styleable.IconicsTextView_iiv_top_size)
                .paddingId(R.styleable.IconicsTextView_iiv_top_padding)
                .contourColorId(R.styleable.IconicsTextView_iiv_top_contour_color)
                .contourWidthId(R.styleable.IconicsTextView_iiv_top_contour_width)
                .backgroundColorId(R.styleable.IconicsTextView_iiv_top_background_color)
                .cornerRadiusId(R.styleable.IconicsTextView_iiv_top_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsTextView_iiv_top_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsTextView_iiv_top_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsTextView_iiv_top_shadow_radius)
                .shadowDxId(R.styleable.IconicsTextView_iiv_top_shadow_dx)
                .shadowDyId(R.styleable.IconicsTextView_iiv_top_shadow_dy)
                .shadowColorId(R.styleable.IconicsTextView_iiv_top_shadow_color)
                .animationsId(R.styleable.IconicsTextView_iiv_top_animations)
                .extract(icon);
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewEndDrawable(@NonNull Context ctx,
                                                                @Nullable TypedArray a,
                                                                @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsTextView_iiv_end_icon)
                .colorsId(R.styleable.IconicsTextView_iiv_end_color)
                .sizeId(R.styleable.IconicsTextView_iiv_end_size)
                .paddingId(R.styleable.IconicsTextView_iiv_end_padding)
                .contourColorId(R.styleable.IconicsTextView_iiv_end_contour_color)
                .contourWidthId(R.styleable.IconicsTextView_iiv_end_contour_width)
                .backgroundColorId(R.styleable.IconicsTextView_iiv_end_background_color)
                .cornerRadiusId(R.styleable.IconicsTextView_iiv_end_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsTextView_iiv_end_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsTextView_iiv_end_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsTextView_iiv_end_shadow_radius)
                .shadowDxId(R.styleable.IconicsTextView_iiv_end_shadow_dx)
                .shadowDyId(R.styleable.IconicsTextView_iiv_end_shadow_dy)
                .shadowColorId(R.styleable.IconicsTextView_iiv_end_shadow_color)
                .animationsId(R.styleable.IconicsTextView_iiv_end_animations)
                .extract(icon);
    }

    @Nullable
    public static IconicsDrawable getIconicsTextViewBottomDrawable(@NonNull Context ctx,
                                                                   @Nullable TypedArray a,
                                                                   @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsTextView_iiv_bottom_icon)
                .colorsId(R.styleable.IconicsTextView_iiv_bottom_color)
                .sizeId(R.styleable.IconicsTextView_iiv_bottom_size)
                .paddingId(R.styleable.IconicsTextView_iiv_bottom_padding)
                .contourColorId(R.styleable.IconicsTextView_iiv_bottom_contour_color)
                .contourWidthId(R.styleable.IconicsTextView_iiv_bottom_contour_width)
                .backgroundColorId(R.styleable.IconicsTextView_iiv_bottom_background_color)
                .cornerRadiusId(R.styleable.IconicsTextView_iiv_bottom_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsTextView_iiv_bottom_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsTextView_iiv_bottom_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsTextView_iiv_bottom_shadow_radius)
                .shadowDxId(R.styleable.IconicsTextView_iiv_bottom_shadow_dx)
                .shadowDyId(R.styleable.IconicsTextView_iiv_bottom_shadow_dy)
                .shadowColorId(R.styleable.IconicsTextView_iiv_bottom_shadow_color)
                .animationsId(R.styleable.IconicsTextView_iiv_bottom_animations)
                .extract(icon);
    }
    //endregion

    //region IconicsCompoundButton
    public static void readIconicsCompoundButton(@NonNull Context ctx,
                                                 @Nullable AttributeSet attrs,
                                                 @NonNull CheckableIconBundle icon) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.IconicsCompoundButton, 0, 0);

        //obtaining attributes for Unchecked icon state
        icon.mUncheckedIcon = getIconicsCompoundButtonUncheckedDrawable(ctx, a);

        //obtaining attributes for Checked icon state
        icon.mCheckedIcon = getIconicsCompoundButtonCheckedDrawable(ctx, a);

        a.recycle();
    }

    @NonNull
    public static IconicsDrawable getIconicsCompoundButtonUncheckedDrawable(@NonNull Context ctx,
                                                                            @Nullable TypedArray a) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsCompoundButton_iiv_unchecked_icon)
                .colorsId(R.styleable.IconicsCompoundButton_iiv_unchecked_color)
                .sizeId(R.styleable.IconicsCompoundButton_iiv_unchecked_size)
                .paddingId(R.styleable.IconicsCompoundButton_iiv_unchecked_padding)
                .contourColorId(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_color)
                .contourWidthId(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_width)
                .backgroundColorId(R.styleable.IconicsCompoundButton_iiv_unchecked_background_color)
                .cornerRadiusId(R.styleable.IconicsCompoundButton_iiv_unchecked_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsCompoundButton_iiv_unchecked_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsCompoundButton_iiv_unchecked_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_radius)
                .shadowDxId(R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_dx)
                .shadowDyId(R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_dy)
                .shadowColorId(R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_color)
                .animationsId(R.styleable.IconicsCompoundButton_iiv_unchecked_animations)
                .extractNonNull();
    }

    @NonNull
    public static IconicsDrawable getIconicsCompoundButtonCheckedDrawable(@NonNull Context ctx,
                                                                          @Nullable TypedArray a) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsCompoundButton_iiv_checked_icon)
                .colorsId(R.styleable.IconicsCompoundButton_iiv_checked_color)
                .sizeId(R.styleable.IconicsCompoundButton_iiv_checked_size)
                .paddingId(R.styleable.IconicsCompoundButton_iiv_checked_padding)
                .contourColorId(R.styleable.IconicsCompoundButton_iiv_checked_contour_color)
                .contourWidthId(R.styleable.IconicsCompoundButton_iiv_checked_contour_width)
                .backgroundColorId(R.styleable.IconicsCompoundButton_iiv_checked_background_color)
                .cornerRadiusId(R.styleable.IconicsCompoundButton_iiv_checked_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsCompoundButton_iiv_checked_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsCompoundButton_iiv_checked_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsCompoundButton_iiv_checked_shadow_radius)
                .shadowDxId(R.styleable.IconicsCompoundButton_iiv_checked_shadow_dx)
                .shadowDyId(R.styleable.IconicsCompoundButton_iiv_checked_shadow_dy)
                .shadowColorId(R.styleable.IconicsCompoundButton_iiv_checked_shadow_color)
                .animationsId(R.styleable.IconicsCompoundButton_iiv_checked_animations)
                .extractNonNull();
    }
    //endregion

    //region IconicsCheckableTextView

    /**
     * Attributes priority:
     * <p>
     * Attributes with mark 'all' attributes with some else mark ('start', 'top' etc)<br>
     * Working like as 'style' xml-attribute - local overrides global
     * <p>
     * <b>IMPORTANT TRICK</b>
     * <p>
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    public static void readIconicsCheckableTextView(@NonNull Context ctx,
                                                    @Nullable AttributeSet attrs,
                                                    @NonNull CompoundIconsBundle bundle) {
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
    public static IconicsDrawable getIconicsCheckableTextViewAllDrawable(@NonNull Context ctx,
                                                                         @Nullable TypedArray a) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsCheckableTextView_iiv_all_checked_icon)
                .colorsId(R.styleable.IconicsCheckableTextView_iiv_all_checked_color)
                .sizeId(R.styleable.IconicsCheckableTextView_iiv_all_checked_size)
                .paddingId(R.styleable.IconicsCheckableTextView_iiv_all_checked_padding)
                .contourColorId(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_color)
                .contourWidthId(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_width)
                .backgroundColorId(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_color)
                .cornerRadiusId(R.styleable.IconicsCheckableTextView_iiv_all_checked_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_radius)
                .shadowDxId(R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_dx)
                .shadowDyId(R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_dy)
                .shadowColorId(R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_color)
                .animationsId(R.styleable.IconicsCheckableTextView_iiv_all_checked_animations)
                .extract();
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewStartDrawable(@NonNull Context ctx,
                                                                           @Nullable TypedArray a,
                                                                           @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsCheckableTextView_iiv_start_checked_icon)
                .colorsId(R.styleable.IconicsCheckableTextView_iiv_start_checked_color)
                .sizeId(R.styleable.IconicsCheckableTextView_iiv_start_checked_size)
                .paddingId(R.styleable.IconicsCheckableTextView_iiv_start_checked_padding)
                .contourColorId(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_color)
                .contourWidthId(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_width)
                .backgroundColorId(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_color)
                .cornerRadiusId(R.styleable.IconicsCheckableTextView_iiv_start_checked_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_radius)
                .shadowDxId(R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_dx)
                .shadowDyId(R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_dy)
                .shadowColorId(R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_color)
                .animationsId(R.styleable.IconicsCheckableTextView_iiv_start_checked_animations)
                .extract(icon);
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewTopDrawable(@NonNull Context ctx,
                                                                         @Nullable TypedArray a,
                                                                         @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsCheckableTextView_iiv_top_checked_icon)
                .colorsId(R.styleable.IconicsCheckableTextView_iiv_top_checked_color)
                .sizeId(R.styleable.IconicsCheckableTextView_iiv_top_checked_size)
                .paddingId(R.styleable.IconicsCheckableTextView_iiv_top_checked_padding)
                .contourColorId(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_color)
                .contourWidthId(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_width)
                .backgroundColorId(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_color)
                .cornerRadiusId(R.styleable.IconicsCheckableTextView_iiv_top_checked_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_radius)
                .shadowDxId(R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_dx)
                .shadowDyId(R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_dy)
                .shadowColorId(R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_color)
                .animationsId(R.styleable.IconicsCheckableTextView_iiv_top_checked_animations)
                .extract(icon);
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewEndDrawable(@NonNull Context ctx,
                                                                         @Nullable TypedArray a,
                                                                         @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsCheckableTextView_iiv_end_checked_icon)
                .colorsId(R.styleable.IconicsCheckableTextView_iiv_end_checked_color)
                .sizeId(R.styleable.IconicsCheckableTextView_iiv_end_checked_size)
                .paddingId(R.styleable.IconicsCheckableTextView_iiv_end_checked_padding)
                .contourColorId(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_color)
                .contourWidthId(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_width)
                .backgroundColorId(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_color)
                .cornerRadiusId(R.styleable.IconicsCheckableTextView_iiv_end_checked_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_radius)
                .shadowDxId(R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_dx)
                .shadowDyId(R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_dy)
                .shadowColorId(R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_color)
                .animationsId(R.styleable.IconicsCheckableTextView_iiv_end_checked_animations)
                .extract(icon);
    }

    @Nullable
    public static IconicsDrawable getIconicsCheckableTextViewBottomDrawable(@NonNull Context ctx,
                                                                            @Nullable TypedArray a,
                                                                            @Nullable IconicsDrawable icon) {
        return new IconicsAttrsExtractor(ctx, a)
                .iconId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_icon)
                .colorsId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_color)
                .sizeId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_size)
                .paddingId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_padding)
                .contourColorId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_color)
                .contourWidthId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_width)
                .backgroundColorId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_color)
                .cornerRadiusId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_corner_radius)
                .backgroundContourColorId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_contour_color)
                .backgroundContourWidthId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_contour_width)
                .shadowRadiusId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_radius)
                .shadowDxId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_dx)
                .shadowDyId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_dy)
                .shadowColorId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_color)
                .animationsId(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_animations)
                .extract(icon);
    }
    //endregion

    public static boolean isIconicsAnimateChanges(@NonNull Context context,
                                                  @Nullable AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsAnimateChanges, 0, 0);
        try {
            return a.getBoolean(R.styleable.IconicsAnimateChanges_iiv_animate_icon_changes, true);
        } finally {
            a.recycle();
        }
    }
}