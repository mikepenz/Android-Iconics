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

@file:Suppress("NOTHING_TO_INLINE", "LargeClass")

package com.mikepenz.iconics.utils

import android.graphics.Typeface
import android.util.Log
import androidx.annotation.ColorInt
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.dsl.NON_READABLE
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface

/**
 * Loads and draws given text
 *
 * @return The current IconicsDrawable for chaining.
 */
fun IconicsDrawable.icon(icon: String): IconicsDrawable {
    try {
        Iconics.findFont(icon.iconPrefix)?.let { icon(it.getIcon(icon.clearedIconName)) }
    } catch (ex: Exception) {
        Iconics.logger.log(Log.ERROR, Iconics.TAG, "Wrong icon name: $icon")
    }

    return this
}

/**
 * Loads and draws given icon
 *
 * @return The current IconicsDrawable for chaining.
 */
fun IconicsDrawable.icon(icon: IIcon): IconicsDrawable {
    this.icon = icon
    return this
}

/**
 * Loads and draws given icon
 *
 * @return The current IconicsDrawable for chaining.
 */
fun IconicsDrawable.icon(typeface: ITypeface, icon: IIcon): IconicsDrawable {
    iconBrush.paint.typeface = typeface.rawTypeface
    this.icon = icon
    return this
}

/**
 * Loads and draws given text
 *
 * @return The current IconicsDrawable for chaining.
 */
fun IconicsDrawable.iconText(icon: String, typeface: Typeface? = null): IconicsDrawable {
    iconBrush.paint.typeface = typeface ?: Typeface.DEFAULT
    iconText = icon
    return this
}

/**
 * Loads and draws given char
 *
 * @return The current IconicsDrawable for chaining.
 */
fun IconicsDrawable.icon(icon: Char): IconicsDrawable {
    iconText = icon.toString()
    return this
}

/**
 * Set the size and the padding to the correct values to be used for the actionBar / toolBar
 *
 * @return The current IconicsDrawable for chaining.
 */
fun IconicsDrawable.actionBar(): IconicsDrawable {
    size = IconicsSize.TOOLBAR_ICON_SIZE
    padding = IconicsSize.TOOLBAR_ICON_PADDING
    return this
}

var IconicsDrawable.color: IconicsColor?
    get() = iconBrush.colorsList?.let { IconicsColor.colorList(it) }
    set(value) {
        colorList = value?.extractList(res, theme)
    }

/** @return the icon current color for the current state */
var IconicsDrawable.colorInt: Int
    @ColorInt get() = iconBrush.colorForCurrentState
    set(@ColorInt value) {
        color = IconicsColor.colorInt(value)
    }

var IconicsDrawable.backgroundContourColor: IconicsColor?
    get() = backgroundContourBrush.colorsList?.let { IconicsColor.colorList(it) }
    set(value) {
        backgroundContourColorList = value?.extractList(res, theme)
    }

/** @return the icon background contour color */
var IconicsDrawable.backgroundContourColorInt: Int
    @ColorInt get() = backgroundContourBrush.colorForCurrentState
    set(@ColorInt value) {
        backgroundContourColor = IconicsColor.colorInt(value)
    }

var IconicsDrawable.backgroundColor: IconicsColor?
    get() = backgroundBrush.colorsList?.let { IconicsColor.colorList(it) }
    set(value) {
        backgroundColorList = value?.extractList(res, theme)
    }

/** @return the icon background color */
var IconicsDrawable.backgroundColorInt: Int
    @ColorInt get() = backgroundBrush.colorForCurrentState
    set(@ColorInt value) {
        backgroundColor = IconicsColor.colorInt(value)
    }

var IconicsDrawable.contourColor: IconicsColor?
    get() = contourBrush.colorsList?.let { IconicsColor.colorList(it) }
    set(value) {
        contourColorList = value?.extractList(res, theme)
    }

/** @return the icon contour color */
var IconicsDrawable.contourColorInt: Int
    @ColorInt get() = contourBrush.colorForCurrentState
    set(@ColorInt value) {
        contourColor = IconicsColor.colorInt(value)
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.sizePx: Int
    @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
    get() = throw UnsupportedOperationException("Please get either sizeX or sizeY directly")
    set(value) {
        sizeXPx = value
        sizeYPx = value
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.size: IconicsSize?
    @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
    get() = throw UnsupportedOperationException("Please get either sizeX or sizeY directly")
    set(value) {
        (value?.extract(res) ?: -1).let {
            sizeXPx = it
            sizeYPx = it
        }
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.sizeX: IconicsSize?
    get() = sizeXPx.takeIf { it != -1 }?.let { IconicsSize.px(it) }
    set(value) {
        sizeXPx = value?.extract(res) ?: -1
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.sizeY: IconicsSize?
    get() = sizeYPx.takeIf { it != -1 }?.let { IconicsSize.px(it) }
    set(value) {
        sizeYPx = value?.extract(res) ?: -1
    }

/** Set rounded corner rx as IconicsSize */
var IconicsDrawable.roundedCornersRx: IconicsSize?
    get() = IconicsSize.px(roundedCornerRxPx)
    set(value) {
        roundedCornerRxPx = value?.extractFloat(res) ?: 0f
    }

/** Set rounded corner ry as IconicsSize */
var IconicsDrawable.roundedCornersRy: IconicsSize?
    get() = IconicsSize.px(roundedCornerRyPx)
    set(value) {
        roundedCornerRyPx = value?.extractFloat(res) ?: 0f
    }

/** Set rounded corner rx as IconicsSize */
var IconicsDrawable.roundedCornersPx: Float
    @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
    get() = throw UnsupportedOperationException("Please get either roundedCornerRxPx or roundedCornerRyPx directly")
    set(value) {
        roundedCornerRxPx = value
        roundedCornerRyPx = value
    }

/** Set rounded corner rx and ry as IconicsSize */
var IconicsDrawable.roundedCorners: IconicsSize?
    @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
    get() = throw UnsupportedOperationException("Please get either roundedCornerRxPx or roundedCornerRyPx directly")
    set(value) {
        (value?.extractFloat(res) ?: 0f).let {
            roundedCornerRxPx = it
            roundedCornerRyPx = it
        }
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.padding: IconicsSize?
    get() = paddingPx.takeIf { it != 0 }?.let { IconicsSize.px(it) }
    set(value) {
        paddingPx = value?.extract(res) ?: 0
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.contourWidth: IconicsSize?
    get() = contourWidthPx.takeIf { it != 0 }?.let { IconicsSize.px(it) }
    set(value) {
        contourWidthPx = value?.extract(res) ?: 0
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.backgroundContourWidth: IconicsSize?
    get() = backgroundContourWidthPx.takeIf { it != 0 }?.let { IconicsSize.px(it) }
    set(value) {
        backgroundContourWidthPx = value?.extract(res) ?: 0
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.iconOffsetX: IconicsSize?
    get() = iconOffsetXPx.takeIf { it != 0 }?.let { IconicsSize.px(it) }
    set(value) {
        iconOffsetXPx = value?.extract(res) ?: 0
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.iconOffsetY: IconicsSize?
    get() = iconOffsetYPx.takeIf { it != 0 }?.let { IconicsSize.px(it) }
    set(value) {
        iconOffsetYPx = value?.extract(res) ?: 0
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.shadowRadius: IconicsSize?
    get() = shadowRadiusPx.takeIf { it != 0f }?.let { IconicsSize.px(it) }
    set(value) {
        shadowRadiusPx = value?.extractFloat(res) ?: 0f
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.shadowDx: IconicsSize?
    get() = shadowDxPx.takeIf { it != 0f }?.let { IconicsSize.px(it) }
    set(value) {
        shadowDxPx = value?.extractFloat(res) ?: 0f
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.shadowDy: IconicsSize?
    get() = shadowDyPx.takeIf { it != 0f }?.let { IconicsSize.px(it) }
    set(value) {
        shadowDyPx = value?.extractFloat(res) ?: 0f
    }

/** Set the size by Y axis of the drawable.*/
var IconicsDrawable.shadowColor: IconicsColor?
    get() = shadowColorInt.takeIf { it != 0 }?.let { IconicsColor.colorInt(it) }
    set(value) {
        shadowColorInt = value?.extract(res, theme) ?: 0
    }

/** Clear the shadow for the icon*/
fun IconicsDrawable.clearShadow(): IconicsDrawable {
    iconBrush.paint.clearShadowLayer()
    invalidateThis()
    return this
}