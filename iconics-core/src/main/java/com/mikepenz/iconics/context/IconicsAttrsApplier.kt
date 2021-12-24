/*
 * Copyright 2020 Mike Penz
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

package com.mikepenz.iconics.context

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.util.AttributeSet
import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP
import androidx.core.content.res.use
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.core.R

/**
 * @author pa.gulko zTrap (07.10.2017)
 */
@RestrictTo(LIBRARY_GROUP)
@SuppressLint("Recycle")
object IconicsAttrsApplier {

    @Deprecated("Favor the variant by providing resources and theme", ReplaceWith(
        "getIconicsDrawable(context.resources, context.theme, attrs)",
        "com.mikepenz.iconics.context.IconicsAttrsApplier.getIconicsDrawable"
    )
    )
    @JvmStatic fun getIconicsDrawable(context: Context, attrs: AttributeSet?): IconicsDrawable? {
        return getIconicsDrawable(context.resources, context.theme, attrs)
    }

    @JvmStatic fun getIconicsDrawable(res: Resources, theme: Theme?, attrs: AttributeSet?): IconicsDrawable? {
        return theme?.obtainStyledAttributes(attrs, R.styleable.Iconics, 0, 0)?.use {
            IconicsAttrsExtractor(
                res = res,
                theme = theme,
                typedArray = it,
                iconId = R.styleable.Iconics_ico_icon,
                colorsId = R.styleable.Iconics_ico_color,
                sizeId = R.styleable.Iconics_ico_size,
                paddingId = R.styleable.Iconics_ico_padding,
                offsetXId = R.styleable.Iconics_ico_offset_x,
                offsetYId = R.styleable.Iconics_ico_offset_y,
                contourColorId = R.styleable.Iconics_ico_contour_color,
                contourWidthId = R.styleable.Iconics_ico_contour_width,
                backgroundColorId = R.styleable.Iconics_ico_background_color,
                cornerRadiusId = R.styleable.Iconics_ico_corner_radius,
                backgroundContourColorId = R.styleable.Iconics_ico_background_contour_color,
                backgroundContourWidthId = R.styleable.Iconics_ico_background_contour_width,
                shadowRadiusId = R.styleable.Iconics_ico_shadow_radius,
                shadowDxId = R.styleable.Iconics_ico_shadow_dx,
                shadowDyId = R.styleable.Iconics_ico_shadow_dy,
                shadowColorId = R.styleable.Iconics_ico_shadow_color,
                animationsId = R.styleable.Iconics_ico_animations,
                autoMirrorId = R.styleable.Iconics_ico_automirror
            ).extractWithOffsets()
        }
    }
}