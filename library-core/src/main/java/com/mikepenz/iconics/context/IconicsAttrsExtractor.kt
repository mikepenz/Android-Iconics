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

package com.mikepenz.iconics.context

import android.content.Context
import android.content.res.TypedArray
import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP
import androidx.annotation.StyleableRes
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.animation.IconicsAnimationProcessor
import com.mikepenz.iconics.utils.toIconicsColor
import com.mikepenz.iconics.utils.toIconicsSizePx

/**
 * @author pa.gulko zTrap (30.10.2017)
 */
@RestrictTo(LIBRARY_GROUP)
class IconicsAttrsExtractor(
    private val context: Context,
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

    @StyleableRes private var animationsId: Int = 0
) {

    companion object {
        private const val DEF_COLOR = Integer.MIN_VALUE
        private const val DEF_SIZE = -1
    }

    fun extractNonNull(): IconicsDrawable {
        return extract(null, false).createIfNeeds(context)
    }

    fun extract(icon: IconicsDrawable?): IconicsDrawable? {
        return extract(icon, false)
    }

    fun extract(): IconicsDrawable? {
        return extract(null, false)
    }

    fun extractWithOffsets(): IconicsDrawable? {
        return extract(null, true)
    }

    private fun extract(icon: IconicsDrawable?, extractOffsets: Boolean): IconicsDrawable? {
        var processedIcon = icon

        processedIcon = copyIfCan(processedIcon)

        // region icon
        val i = typedArray.getString(iconId)
        if (!i.isNullOrEmpty()) {
            processedIcon = processedIcon.createIfNeeds(context).icon(i)
        }
        typedArray.getColorStateList(colorsId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .color(it.toIconicsColor())
        }
        typedArray.getDimensionPixelSize(sizeId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .size(it.toIconicsSizePx())
        }
        typedArray.getDimensionPixelSize(paddingId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .padding(it.toIconicsSizePx())
        }
        if (extractOffsets) {
            typedArray.getDimensionPixelSize(offsetYId)?.let {
                processedIcon = processedIcon.createIfNeeds(context)
                        .iconOffsetY(it.toIconicsSizePx())
            }
            typedArray.getDimensionPixelSize(offsetXId)?.let {
                processedIcon = processedIcon.createIfNeeds(context)
                        .iconOffsetX(it.toIconicsSizePx())
            }
        }
        // endregion
        // region contour
        typedArray.getColorStateList(contourColorId)?.let {
            processedIcon = processedIcon.createIfNeeds(context).contourColor(it.toIconicsColor())
        }
        typedArray.getDimensionPixelSize(contourWidthId)?.let {
            processedIcon = processedIcon.createIfNeeds(context).contourWidth(it.toIconicsSizePx())
        }
        // endregion
        // region background
        typedArray.getColorStateList(backgroundColorId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .backgroundColor(it.toIconicsColor())
        }
        typedArray.getDimensionPixelSize(cornerRadiusId)?.let {
            processedIcon = processedIcon.createIfNeeds(
                context
            ).roundedCorners(it.toIconicsSizePx())
        }
        // endregion
        // region background contour
        typedArray.getColorStateList(backgroundContourColorId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .backgroundContourColor(it.toIconicsColor())
        }
        typedArray.getDimensionPixelSize(backgroundContourWidthId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .backgroundContourWidth(it.toIconicsSizePx())
        }
        // endregion
        // region shadow
        val shadowRadius = typedArray.getDimensionPixelSize(shadowRadiusId)
        val shadowDx = typedArray.getDimensionPixelSize(shadowDxId)
        val shadowDy = typedArray.getDimensionPixelSize(shadowDyId)
        val shadowColor = typedArray.getColor(shadowColorId, DEF_COLOR)

        if (shadowRadius != null
                && shadowDx != null
                && shadowDy != null
                && shadowColor != DEF_COLOR) {
            processedIcon = processedIcon.createIfNeeds(context).shadow(
                shadowRadius.toIconicsSizePx(),
                shadowDx.toIconicsSizePx(),
                shadowDy.toIconicsSizePx(),
                shadowColor.toIconicsColor()
            )
        }
        // endregion

        // animations should be applied at the end because here we transform the drawable,
        // therefore all properties must be processed before

        // region animations
        val animations = typedArray.getString(animationsId)
        if (!animations.isNullOrBlank()) {
            val processors = ArrayList<IconicsAnimationProcessor>()

            val animationsList = animations.split("\\|".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .toTypedArray()

            animationsList.mapNotNull { Iconics.findProcessor(context, it) }
                    .toCollection(processors)

            processedIcon = processedIcon.createIfNeeds(context)
                    .toAnimatedDrawable()
                    .processors(*processors.toTypedArray())
        }
        // endregion
        return processedIcon
    }

    private fun TypedArray.getDimensionPixelSize(@StyleableRes index: Int): Int? {
        return getDimensionPixelSize(index, DEF_SIZE).takeIf { it != DEF_SIZE }
    }

    private fun copyIfCan(drawable: IconicsDrawable?): IconicsDrawable? {
        return drawable?.clone()
    }

    private fun IconicsDrawable?.createIfNeeds(context: Context): IconicsDrawable {
        return this ?: IconicsDrawable(context)
    }
}