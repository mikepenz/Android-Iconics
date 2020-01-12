/*
 * Copyright 2019 Mike Penz
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

import android.content.res.Resources
import android.content.res.Resources.Theme
import android.content.res.TypedArray
import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP
import androidx.annotation.StyleableRes
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.utils.icon
import com.mikepenz.iconics.utils.roundedCornersPx
import com.mikepenz.iconics.utils.sizePx

/**
 * @author pa.gulko zTrap (30.10.2017)
 */
@RestrictTo(LIBRARY_GROUP)
class IconicsAttrsExtractor(
    private val res: Resources,
    private val theme: Theme?,
    private val typedArray: TypedArray,

    @StyleableRes private var iconId: Int = 0,
    @StyleableRes private var sizeId: Int = 0,
    @StyleableRes private var colorsId: Int = 0,
    @StyleableRes private var paddingId: Int = 0,
    @StyleableRes private var offsetXId: Int = 0,
    @StyleableRes private var offsetYId: Int = 0,

    @StyleableRes private var contourColorId: Int = 0,
    @StyleableRes private var contourWidthId: Int = 0,

    @StyleableRes private var backgroundColorId: Int = 0,
    @StyleableRes private var cornerRadiusId: Int = 0,

    @StyleableRes private var backgroundContourColorId: Int = 0,
    @StyleableRes private var backgroundContourWidthId: Int = 0,

    @StyleableRes private var shadowRadiusId: Int = 0,
    @StyleableRes private var shadowDxId: Int = 0,
    @StyleableRes private var shadowDyId: Int = 0,
    @StyleableRes private var shadowColorId: Int = 0,

    @StyleableRes private var animationsId: Int = 0,

    @StyleableRes private var autoMirrorId: Int = 0
) {

    companion object {
        private const val DEF_COLOR = Integer.MIN_VALUE
        private const val DEF_SIZE = -1
    }

    fun extractNonNull(): IconicsDrawable {
        return extract(null, false, true).createIfNeeds(res, theme)
    }

    fun extract(icon: IconicsDrawable?): IconicsDrawable? {
        return extract(icon, false, true)
    }

    fun extractInto(icon: IconicsDrawable): IconicsDrawable? {
        return extract(icon, false, false)
    }

    fun extract(): IconicsDrawable? {
        return extract(null, false, true)
    }

    fun extractWithOffsets(): IconicsDrawable? {
        return extract(null, true, true)
    }

    private fun extract(icon: IconicsDrawable?, extractOffsets: Boolean, viaCopy: Boolean): IconicsDrawable? {
        val processedIcon = (if (viaCopy) icon?.clone() else icon).createIfNeeds(res, theme)
        processedIcon.apply {
            // region icon
            val i = typedArray.getString(iconId)
            if (!i.isNullOrEmpty()) {
                this.icon(i)
            }
            typedArray.getColorStateList(colorsId)?.let {
                this.colorList = it
            }
            typedArray.getDimensionPixelSize(sizeId)?.let {
                this.sizePx = it
            }
            typedArray.getDimensionPixelSize(paddingId)?.let {
                this.paddingPx = it
            }
            if (extractOffsets) {
                typedArray.getDimensionPixelSize(offsetXId)?.let {
                    this.iconOffsetXPx = it
                }
                typedArray.getDimensionPixelSize(offsetYId)?.let {
                    this.iconOffsetYPx = it
                }
            }
            // endregion
            // region contour
            typedArray.getColorStateList(contourColorId)?.let {
                contourColorList = it
            }
            typedArray.getDimensionPixelSize(contourWidthId)?.let {
                contourWidthPx = it
            }
            // endregion
            // region background
            typedArray.getColorStateList(backgroundColorId)?.let {
                backgroundColorList = it
            }
            typedArray.getDimensionPixelSize(cornerRadiusId)?.let {
                roundedCornersPx = it.toFloat()
            }
            // endregion
            // region background contour
            typedArray.getColorStateList(backgroundContourColorId)?.let {
                backgroundContourColorList = it
            }
            typedArray.getDimensionPixelSize(backgroundContourWidthId)?.let {
                backgroundContourWidthPx = it
            }
            // endregion
            // region shadow
            val localShadowRadius = typedArray.getDimensionPixelSize(shadowRadiusId)
            val localShadowDx = typedArray.getDimensionPixelSize(shadowDxId)
            val localShadowDy = typedArray.getDimensionPixelSize(shadowDyId)
            val localShadowColor = typedArray.getColor(shadowColorId, DEF_COLOR)

            @Suppress("ComplexCondition")
            if (localShadowRadius != null && localShadowDx != null && localShadowDy != null && localShadowColor != DEF_COLOR) {
                applyShadow {
                    shadowRadiusPx = localShadowRadius.toFloat()
                    shadowDxPx = localShadowDx.toFloat()
                    shadowDyPx = localShadowDy.toFloat()
                    shadowColorInt = localShadowColor
                }
            }
            // endregion

            //region autoMirror
            autoMirroredCompat = typedArray.getBoolean(autoMirrorId, false)
            // endregion
        }

        // animations should be applied at the end because here we transform the drawable,
        // therefore all properties must be processed before

        // region animations
        val animations = typedArray.getString(animationsId)
        if (!animations.isNullOrBlank()) {
            val processors = animations
                    .split("\\|".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .mapNotNull { Iconics.findProcessor(it) }
            return processedIcon.toAnimatedDrawable().processors(*processors.toTypedArray())
        }
        // endregion

        return processedIcon
    }

    private fun TypedArray.getDimensionPixelSize(@StyleableRes index: Int): Int? {
        return getDimensionPixelSize(index, DEF_SIZE).takeIf { it != DEF_SIZE }
    }

    private fun IconicsDrawable?.createIfNeeds(res: Resources, theme: Theme?): IconicsDrawable {
        return this ?: IconicsDrawable(res, theme)
    }
}