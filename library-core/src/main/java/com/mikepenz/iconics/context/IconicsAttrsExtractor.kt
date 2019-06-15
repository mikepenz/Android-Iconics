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

import android.content.Context
import android.content.res.TypedArray
import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP
import androidx.annotation.StyleableRes
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize

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
        var processedIcon = icon?.clone()

        // region icon
        val i = typedArray.getString(iconId)
        if (!i.isNullOrEmpty()) {
            processedIcon = processedIcon.createIfNeeds(context).icon(i)
        }
        typedArray.getColorStateList(colorsId)?.let {
            processedIcon = processedIcon.createIfNeeds(context).color(IconicsColor.colorList(it))
        }
        typedArray.getDimensionPixelSize(sizeId)?.let {
            processedIcon = processedIcon.createIfNeeds(context).size(IconicsSize.px(it))
        }
        typedArray.getDimensionPixelSize(paddingId)?.let {
            processedIcon = processedIcon.createIfNeeds(context).padding(IconicsSize.px(it))
        }
        if (extractOffsets) {
            typedArray.getDimensionPixelSize(offsetYId)?.let {
                processedIcon = processedIcon.createIfNeeds(context)
                        .iconOffsetY(IconicsSize.px(it))
            }
            typedArray.getDimensionPixelSize(offsetXId)?.let {
                processedIcon = processedIcon.createIfNeeds(context)
                        .iconOffsetX(IconicsSize.px(it))
            }
        }
        // endregion
        // region contour
        typedArray.getColorStateList(contourColorId)?.let {
            processedIcon =
                    processedIcon.createIfNeeds(context).contourColor(IconicsColor.colorList(it))
        }
        typedArray.getDimensionPixelSize(contourWidthId)?.let {
            processedIcon = processedIcon.createIfNeeds(context).contourWidth(IconicsSize.px(it))
        }
        // endregion
        // region background
        typedArray.getColorStateList(backgroundColorId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .backgroundColor(IconicsColor.colorList(it))
        }
        typedArray.getDimensionPixelSize(cornerRadiusId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .roundedCorners(IconicsSize.px(it))
        }
        // endregion
        // region background contour
        typedArray.getColorStateList(backgroundContourColorId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .backgroundContourColor(IconicsColor.colorList(it))
        }
        typedArray.getDimensionPixelSize(backgroundContourWidthId)?.let {
            processedIcon = processedIcon.createIfNeeds(context)
                    .backgroundContourWidth(IconicsSize.px(it))
        }
        // endregion
        // region shadow
        val shadowRadius = typedArray.getDimensionPixelSize(shadowRadiusId)
        val shadowDx = typedArray.getDimensionPixelSize(shadowDxId)
        val shadowDy = typedArray.getDimensionPixelSize(shadowDyId)
        val shadowColor = typedArray.getColor(shadowColorId, DEF_COLOR)

        @Suppress("ComplexCondition")
        if (shadowRadius != null
                && shadowDx != null
                && shadowDy != null
                && shadowColor != DEF_COLOR) {
            processedIcon = processedIcon.createIfNeeds(context).shadow(
                IconicsSize.px(shadowRadius),
                IconicsSize.px(shadowDx),
                IconicsSize.px(shadowDy),
                IconicsColor.colorInt(shadowColor)
            )
        }
        // endregion

        // animations should be applied at the end because here we transform the drawable,
        // therefore all properties must be processed before

        // region animations
        val animations = typedArray.getString(animationsId)
        if (!animations.isNullOrBlank()) {
            val processors = animations.split("\\|".toRegex())
                    .dropLastWhile { it.isEmpty() }
                    .mapNotNull { Iconics.findProcessor(it) }

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

    private fun IconicsDrawable?.createIfNeeds(context: Context): IconicsDrawable {
        return this ?: IconicsDrawable(context)
    }
}