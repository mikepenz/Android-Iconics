/*
 * Copyright (c) 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.internal

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.core.content.res.use
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.context.IconicsAttrsExtractor
import com.mikepenz.iconics.view.R

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@SuppressLint("Recycle")
internal object IconicsViewsAttrsApplier {

    //region IconicsImageView
    fun getIconicsImageViewDrawable(ctx: Context, attrs: AttributeSet?): IconicsDrawable? {
        return ctx.obtainStyledAttributes(attrs, R.styleable.IconicsImageView).use {
            IconicsAttrsExtractor(
                context = ctx,
                typedArray = it,
                iconId = R.styleable.IconicsImageView_iiv_icon,
                colorsId = R.styleable.IconicsImageView_iiv_color,
                sizeId = R.styleable.IconicsImageView_iiv_size,
                paddingId = R.styleable.IconicsImageView_iiv_padding,
                contourColorId = R.styleable.IconicsImageView_iiv_contour_color,
                contourWidthId = R.styleable.IconicsImageView_iiv_contour_width,
                backgroundColorId = R.styleable.IconicsImageView_iiv_background_color,
                cornerRadiusId = R.styleable.IconicsImageView_iiv_corner_radius,
                backgroundContourColorId = R.styleable.IconicsImageView_iiv_background_contour_color,
                backgroundContourWidthId = R.styleable.IconicsImageView_iiv_background_contour_width,
                shadowRadiusId = R.styleable.IconicsImageView_iiv_shadow_radius,
                shadowDxId = R.styleable.IconicsImageView_iiv_shadow_dx,
                shadowDyId = R.styleable.IconicsImageView_iiv_shadow_dy,
                shadowColorId = R.styleable.IconicsImageView_iiv_shadow_color,
                animationsId = R.styleable.IconicsImageView_iiv_animations
            ).extract()
        }
    }
    //endregion

    //region IconicsTextView

    /**
     * Attributes priority:
     *
     * Attributes with mark 'all' attributes with some else mark ('start', 'top' etc)<br></br>
     * Working like as 'style' xml-attribute - local overrides global
     *
     * **IMPORTANT TRICK**
     *
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    fun readIconicsTextView(ctx: Context, attrs: AttributeSet?, bundle: CompoundIconsBundle) {
        ctx.obtainStyledAttributes(attrs, R.styleable.IconicsTextView).use {

            //obtaining attributes for all icons
            val allIcon = getIconicsTextViewAllDrawable(ctx, it)

            //obtaining attributes for start icons
            bundle.startIcon = getIconicsTextViewStartDrawable(ctx, it, allIcon)

            //obtaining attributes for top icons
            bundle.topIcon = getIconicsTextViewTopDrawable(ctx, it, allIcon)

            //obtaining attributes for end icons
            bundle.endIcon = getIconicsTextViewEndDrawable(ctx, it, allIcon)

            //obtaining attributes for bottom icons
            bundle.bottomIcon = getIconicsTextViewBottomDrawable(ctx, it, allIcon)
        }
    }

    private fun getIconicsTextViewAllDrawable(ctx: Context, a: TypedArray): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsTextView_iiv_all_icon,
            colorsId = R.styleable.IconicsTextView_iiv_all_color,
            sizeId = R.styleable.IconicsTextView_iiv_all_size,
            paddingId = R.styleable.IconicsTextView_iiv_all_padding,
            contourColorId = R.styleable.IconicsTextView_iiv_all_contour_color,
            contourWidthId = R.styleable.IconicsTextView_iiv_all_contour_width,
            backgroundColorId = R.styleable.IconicsTextView_iiv_all_background_color,
            cornerRadiusId = R.styleable.IconicsTextView_iiv_all_corner_radius,
            backgroundContourColorId = R.styleable.IconicsTextView_iiv_all_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsTextView_iiv_all_background_contour_width,
            shadowRadiusId = R.styleable.IconicsTextView_iiv_all_shadow_radius,
            shadowDxId = R.styleable.IconicsTextView_iiv_all_shadow_dx,
            shadowDyId = R.styleable.IconicsTextView_iiv_all_shadow_dy,
            shadowColorId = R.styleable.IconicsTextView_iiv_all_shadow_color,
            animationsId = R.styleable.IconicsTextView_iiv_all_animations
        ).extract()
    }

    private fun getIconicsTextViewStartDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsTextView_iiv_start_icon,
            colorsId = R.styleable.IconicsTextView_iiv_start_color,
            sizeId = R.styleable.IconicsTextView_iiv_start_size,
            paddingId = R.styleable.IconicsTextView_iiv_start_padding,
            contourColorId = R.styleable.IconicsTextView_iiv_start_contour_color,
            contourWidthId = R.styleable.IconicsTextView_iiv_start_contour_width,
            backgroundColorId = R.styleable.IconicsTextView_iiv_start_background_color,
            cornerRadiusId = R.styleable.IconicsTextView_iiv_start_corner_radius,
            backgroundContourColorId = R.styleable.IconicsTextView_iiv_start_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsTextView_iiv_start_background_contour_width,
            shadowRadiusId = R.styleable.IconicsTextView_iiv_start_shadow_radius,
            shadowDxId = R.styleable.IconicsTextView_iiv_start_shadow_dx,
            shadowDyId = R.styleable.IconicsTextView_iiv_start_shadow_dy,
            shadowColorId = R.styleable.IconicsTextView_iiv_start_shadow_color,
            animationsId = R.styleable.IconicsTextView_iiv_start_animations
        ).extract(icon)
    }

    private fun getIconicsTextViewTopDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsTextView_iiv_top_icon,
            colorsId = R.styleable.IconicsTextView_iiv_top_color,
            sizeId = R.styleable.IconicsTextView_iiv_top_size,
            paddingId = R.styleable.IconicsTextView_iiv_top_padding,
            contourColorId = R.styleable.IconicsTextView_iiv_top_contour_color,
            contourWidthId = R.styleable.IconicsTextView_iiv_top_contour_width,
            backgroundColorId = R.styleable.IconicsTextView_iiv_top_background_color,
            cornerRadiusId = R.styleable.IconicsTextView_iiv_top_corner_radius,
            backgroundContourColorId = R.styleable.IconicsTextView_iiv_top_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsTextView_iiv_top_background_contour_width,
            shadowRadiusId = R.styleable.IconicsTextView_iiv_top_shadow_radius,
            shadowDxId = R.styleable.IconicsTextView_iiv_top_shadow_dx,
            shadowDyId = R.styleable.IconicsTextView_iiv_top_shadow_dy,
            shadowColorId = R.styleable.IconicsTextView_iiv_top_shadow_color,
            animationsId = R.styleable.IconicsTextView_iiv_top_animations
        ).extract(icon)
    }

    private fun getIconicsTextViewEndDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsTextView_iiv_end_icon,
            colorsId = R.styleable.IconicsTextView_iiv_end_color,
            sizeId = R.styleable.IconicsTextView_iiv_end_size,
            paddingId = R.styleable.IconicsTextView_iiv_end_padding,
            contourColorId = R.styleable.IconicsTextView_iiv_end_contour_color,
            contourWidthId = R.styleable.IconicsTextView_iiv_end_contour_width,
            backgroundColorId = R.styleable.IconicsTextView_iiv_end_background_color,
            cornerRadiusId = R.styleable.IconicsTextView_iiv_end_corner_radius,
            backgroundContourColorId = R.styleable.IconicsTextView_iiv_end_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsTextView_iiv_end_background_contour_width,
            shadowRadiusId = R.styleable.IconicsTextView_iiv_end_shadow_radius,
            shadowDxId = R.styleable.IconicsTextView_iiv_end_shadow_dx,
            shadowDyId = R.styleable.IconicsTextView_iiv_end_shadow_dy,
            shadowColorId = R.styleable.IconicsTextView_iiv_end_shadow_color,
            animationsId = R.styleable.IconicsTextView_iiv_end_animations
        ).extract(icon)
    }

    private fun getIconicsTextViewBottomDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsTextView_iiv_bottom_icon,
            colorsId = R.styleable.IconicsTextView_iiv_bottom_color,
            sizeId = R.styleable.IconicsTextView_iiv_bottom_size,
            paddingId = R.styleable.IconicsTextView_iiv_bottom_padding,
            contourColorId = R.styleable.IconicsTextView_iiv_bottom_contour_color,
            contourWidthId = R.styleable.IconicsTextView_iiv_bottom_contour_width,
            backgroundColorId = R.styleable.IconicsTextView_iiv_bottom_background_color,
            cornerRadiusId = R.styleable.IconicsTextView_iiv_bottom_corner_radius,
            backgroundContourColorId = R.styleable.IconicsTextView_iiv_bottom_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsTextView_iiv_bottom_background_contour_width,
            shadowRadiusId = R.styleable.IconicsTextView_iiv_bottom_shadow_radius,
            shadowDxId = R.styleable.IconicsTextView_iiv_bottom_shadow_dx,
            shadowDyId = R.styleable.IconicsTextView_iiv_bottom_shadow_dy,
            shadowColorId = R.styleable.IconicsTextView_iiv_bottom_shadow_color,
            animationsId = R.styleable.IconicsTextView_iiv_bottom_animations
        ).extract(icon)
    }
    //endregion

    //region IconicsCompoundButton
    fun readIconicsCompoundButton(ctx: Context, attrs: AttributeSet?, icon: CheckableIconBundle) {
        ctx.obtainStyledAttributes(attrs, R.styleable.IconicsCompoundButton).use {

            //obtaining attributes for Unchecked icon state
            icon.uncheckedIcon = getIconicsCompoundButtonUncheckedDrawable(ctx, it)

            //obtaining attributes for Checked icon state
            icon.checkedIcon = getIconicsCompoundButtonCheckedDrawable(ctx, it)
        }
    }

    private fun getIconicsCompoundButtonUncheckedDrawable(
        ctx: Context,
        a: TypedArray
    ): IconicsDrawable {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsCompoundButton_iiv_unchecked_icon,
            colorsId = R.styleable.IconicsCompoundButton_iiv_unchecked_color,
            sizeId = R.styleable.IconicsCompoundButton_iiv_unchecked_size,
            paddingId = R.styleable.IconicsCompoundButton_iiv_unchecked_padding,
            contourColorId = R.styleable.IconicsCompoundButton_iiv_unchecked_contour_color,
            contourWidthId = R.styleable.IconicsCompoundButton_iiv_unchecked_contour_width,
            backgroundColorId = R.styleable.IconicsCompoundButton_iiv_unchecked_background_color,
            cornerRadiusId = R.styleable.IconicsCompoundButton_iiv_unchecked_corner_radius,
            backgroundContourColorId = R.styleable.IconicsCompoundButton_iiv_unchecked_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsCompoundButton_iiv_unchecked_background_contour_width,
            shadowRadiusId = R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_radius,
            shadowDxId = R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_dx,
            shadowDyId = R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_dy,
            shadowColorId = R.styleable.IconicsCompoundButton_iiv_unchecked_shadow_color,
            animationsId = R.styleable.IconicsCompoundButton_iiv_unchecked_animations
        ).extractNonNull()
    }

    private fun getIconicsCompoundButtonCheckedDrawable(
        ctx: Context,
        a: TypedArray
    ): IconicsDrawable {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsCompoundButton_iiv_checked_icon,
            colorsId = R.styleable.IconicsCompoundButton_iiv_checked_color,
            sizeId = R.styleable.IconicsCompoundButton_iiv_checked_size,
            paddingId = R.styleable.IconicsCompoundButton_iiv_checked_padding,
            contourColorId = R.styleable.IconicsCompoundButton_iiv_checked_contour_color,
            contourWidthId = R.styleable.IconicsCompoundButton_iiv_checked_contour_width,
            backgroundColorId = R.styleable.IconicsCompoundButton_iiv_checked_background_color,
            cornerRadiusId = R.styleable.IconicsCompoundButton_iiv_checked_corner_radius,
            backgroundContourColorId = R.styleable.IconicsCompoundButton_iiv_checked_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsCompoundButton_iiv_checked_background_contour_width,
            shadowRadiusId = R.styleable.IconicsCompoundButton_iiv_checked_shadow_radius,
            shadowDxId = R.styleable.IconicsCompoundButton_iiv_checked_shadow_dx,
            shadowDyId = R.styleable.IconicsCompoundButton_iiv_checked_shadow_dy,
            shadowColorId = R.styleable.IconicsCompoundButton_iiv_checked_shadow_color,
            animationsId = R.styleable.IconicsCompoundButton_iiv_checked_animations
        ).extractNonNull()
    }
    //endregion

    //region IconicsCheckableTextView

    /**
     * Attributes priority:
     *
     * Attributes with mark 'all' attributes with some else mark ('start', 'top' etc)<br></br>
     * Working like as 'style' xml-attribute - local overrides global
     *
     * **IMPORTANT TRICK**
     *
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    fun readIconicsCheckableTextView(
        ctx: Context,
        attrs: AttributeSet?,
        bundle: CompoundIconsBundle
    ) {
        ctx.obtainStyledAttributes(attrs, R.styleable.IconicsCheckableTextView).use {

            //obtaining attributes for all icons
            val allIcon = getIconicsCheckableTextViewAllDrawable(ctx, it)

            //obtaining attributes for start icons
            bundle.startIcon = getIconicsCheckableTextViewStartDrawable(ctx, it, allIcon)

            //obtaining attributes for top icons
            bundle.topIcon = getIconicsCheckableTextViewTopDrawable(ctx, it, allIcon)

            //obtaining attributes for end icons
            bundle.endIcon = getIconicsCheckableTextViewEndDrawable(ctx, it, allIcon)

            //obtaining attributes for bottom icons
            bundle.bottomIcon = getIconicsCheckableTextViewBottomDrawable(ctx, it, allIcon)
        }
    }

    private fun getIconicsCheckableTextViewAllDrawable(
        ctx: Context,
        a: TypedArray
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsCheckableTextView_iiv_all_checked_icon,
            colorsId = R.styleable.IconicsCheckableTextView_iiv_all_checked_color,
            sizeId = R.styleable.IconicsCheckableTextView_iiv_all_checked_size,
            paddingId = R.styleable.IconicsCheckableTextView_iiv_all_checked_padding,
            contourColorId = R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_color,
            contourWidthId = R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_width,
            backgroundColorId = R.styleable.IconicsCheckableTextView_iiv_all_checked_background_color,
            cornerRadiusId = R.styleable.IconicsCheckableTextView_iiv_all_checked_corner_radius,
            backgroundContourColorId = R.styleable.IconicsCheckableTextView_iiv_all_checked_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsCheckableTextView_iiv_all_checked_background_contour_width,
            shadowRadiusId = R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_radius,
            shadowDxId = R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_dx,
            shadowDyId = R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_dy,
            shadowColorId = R.styleable.IconicsCheckableTextView_iiv_all_checked_shadow_color,
            animationsId = R.styleable.IconicsCheckableTextView_iiv_all_checked_animations
        ).extract()
    }

    private fun getIconicsCheckableTextViewStartDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsCheckableTextView_iiv_start_checked_icon,
            colorsId = R.styleable.IconicsCheckableTextView_iiv_start_checked_color,
            sizeId = R.styleable.IconicsCheckableTextView_iiv_start_checked_size,
            paddingId = R.styleable.IconicsCheckableTextView_iiv_start_checked_padding,
            contourColorId = R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_color,
            contourWidthId = R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_width,
            backgroundColorId = R.styleable.IconicsCheckableTextView_iiv_start_checked_background_color,
            cornerRadiusId = R.styleable.IconicsCheckableTextView_iiv_start_checked_corner_radius,
            backgroundContourColorId = R.styleable.IconicsCheckableTextView_iiv_start_checked_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsCheckableTextView_iiv_start_checked_background_contour_width,
            shadowRadiusId = R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_radius,
            shadowDxId = R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_dx,
            shadowDyId = R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_dy,
            shadowColorId = R.styleable.IconicsCheckableTextView_iiv_start_checked_shadow_color,
            animationsId = R.styleable.IconicsCheckableTextView_iiv_start_checked_animations
        ).extract(icon)
    }

    private fun getIconicsCheckableTextViewTopDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsCheckableTextView_iiv_top_checked_icon,
            colorsId = R.styleable.IconicsCheckableTextView_iiv_top_checked_color,
            sizeId = R.styleable.IconicsCheckableTextView_iiv_top_checked_size,
            paddingId = R.styleable.IconicsCheckableTextView_iiv_top_checked_padding,
            contourColorId = R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_color,
            contourWidthId = R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_width,
            backgroundColorId = R.styleable.IconicsCheckableTextView_iiv_top_checked_background_color,
            cornerRadiusId = R.styleable.IconicsCheckableTextView_iiv_top_checked_corner_radius,
            backgroundContourColorId = R.styleable.IconicsCheckableTextView_iiv_top_checked_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsCheckableTextView_iiv_top_checked_background_contour_width,
            shadowRadiusId = R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_radius,
            shadowDxId = R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_dx,
            shadowDyId = R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_dy,
            shadowColorId = R.styleable.IconicsCheckableTextView_iiv_top_checked_shadow_color,
            animationsId = R.styleable.IconicsCheckableTextView_iiv_top_checked_animations
        ).extract(icon)
    }

    private fun getIconicsCheckableTextViewEndDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsCheckableTextView_iiv_end_checked_icon,
            colorsId = R.styleable.IconicsCheckableTextView_iiv_end_checked_color,
            sizeId = R.styleable.IconicsCheckableTextView_iiv_end_checked_size,
            paddingId = R.styleable.IconicsCheckableTextView_iiv_end_checked_padding,
            contourColorId = R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_color,
            contourWidthId = R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_width,
            backgroundColorId = R.styleable.IconicsCheckableTextView_iiv_end_checked_background_color,
            cornerRadiusId = R.styleable.IconicsCheckableTextView_iiv_end_checked_corner_radius,
            backgroundContourColorId = R.styleable.IconicsCheckableTextView_iiv_end_checked_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsCheckableTextView_iiv_end_checked_background_contour_width,
            shadowRadiusId = R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_radius,
            shadowDxId = R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_dx,
            shadowDyId = R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_dy,
            shadowColorId = R.styleable.IconicsCheckableTextView_iiv_end_checked_shadow_color,
            animationsId = R.styleable.IconicsCheckableTextView_iiv_end_checked_animations
        ).extract(icon)
    }

    private fun getIconicsCheckableTextViewBottomDrawable(
        ctx: Context,
        a: TypedArray,
        icon: IconicsDrawable?
    ): IconicsDrawable? {
        return IconicsAttrsExtractor(
            context = ctx,
            typedArray = a,
            iconId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_icon,
            colorsId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_color,
            sizeId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_size,
            paddingId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_padding,
            contourColorId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_color,
            contourWidthId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_width,
            backgroundColorId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_color,
            cornerRadiusId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_corner_radius,
            backgroundContourColorId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_contour_color,
            backgroundContourWidthId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_contour_width,
            shadowRadiusId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_radius,
            shadowDxId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_dx,
            shadowDyId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_dy,
            shadowColorId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_shadow_color,
            animationsId = R.styleable.IconicsCheckableTextView_iiv_bottom_checked_animations
        ).extract(icon)
    }
    //endregion

    fun isIconicsAnimateChanges(context: Context, attrs: AttributeSet?): Boolean {
        return context.obtainStyledAttributes(attrs, R.styleable.IconicsAnimateChanges).use {
            it.getBoolean(R.styleable.IconicsAnimateChanges_iiv_animate_icon_changes, true)
        }
    }
}
