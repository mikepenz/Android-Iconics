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

import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Typeface
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.IIcon

/** Loads and draws given text */
@JvmName("iconFromString")
fun IconicsDrawable.icon(iconProducer: () -> String?): IconicsDrawable {
    iconProducer()?.let { icon(it) }
    return this
}

/** Loads and draws given char */
@JvmName("iconFromChar")
fun IconicsDrawable.icon(iconProducer: () -> Char?): IconicsDrawable {
    iconProducer()?.let { icon(it) }
    return this
}

/** Loads and draws given text */
@JvmName("iconTextFromString")
fun IconicsDrawable.iconText(iconTextProducer: () -> String?): IconicsDrawable {
    iconTextProducer()?.let { iconText(it) }
    return this
}

/** Loads and draws given icon */
fun IconicsDrawable.icon(iconProducer: () -> IIcon?): IconicsDrawable {
    iconProducer()?.let { icon(it) }
    return this
}

/** Set the color of the drawable.*/
fun IconicsDrawable.color(colorProducer: () -> IconicsColor?): IconicsDrawable {
    colorProducer()?.let { color = it }
    return this
}

/** Set the icon offset for X axis */
fun IconicsDrawable.iconOffsetX(iconOffsetXProducer: () -> IconicsSize?): IconicsDrawable {
    iconOffsetXProducer()?.let { iconOffsetX = it }
    return this
}

/** Set the icon offset for Y axis */
fun IconicsDrawable.iconOffsetY(iconOffsetYProducer: () -> IconicsSize?): IconicsDrawable {
    iconOffsetYProducer()?.let { iconOffsetY = it }
    return this
}

/** Set the padding for the drawable. */
fun IconicsDrawable.padding(paddingProducer: () -> IconicsSize?): IconicsDrawable {
    paddingProducer()?.let { padding = it }
    return this
}

/** Set the size by X and Y axis of the drawable.*/
fun IconicsDrawable.size(sizeProducer: () -> IconicsSize?): IconicsDrawable {
    sizeProducer()?.let { size = it }
    return this
}

/**
 * Set if it should respect the original bounds of the icon. (DEFAULT is false)
 * This will break the "padding" functionality, but keep the padding defined by the font itself
 * Check it out with the oct_arrow_down and oct_arrow_small_down of the Octicons font
 */
fun IconicsDrawable.respectFontBounds(respectFontBoundsProducer: () -> Boolean?): IconicsDrawable {
    respectFontBoundsProducer()?.let { respectFontBounds = it }
    return this
}

/** Set the size by X axis of the drawable. */
fun IconicsDrawable.sizeX(sizeXProducer: () -> IconicsSize?): IconicsDrawable {
    sizeXProducer()?.let { sizeX = it }
    return this
}

/** Set the size by Y axis of the drawable. */
fun IconicsDrawable.sizeY(sizeYProducer: () -> IconicsSize?): IconicsDrawable {
    sizeYProducer()?.let { sizeY = it }
    return this
}

/** Set background contour colors. */
fun IconicsDrawable.backgroundContourColor(backgroundContourColorProducer: () -> IconicsColor?): IconicsDrawable {
    backgroundContourColorProducer()?.let { backgroundContourColor = it }
    return this
}

/** Set contour colors */
fun IconicsDrawable.contourColor(contourColorProducer: () -> IconicsColor?): IconicsDrawable {
    contourColorProducer()?.let { contourColor = it }
    return this
}

/**Set the shadow for the icon
 * This requires shadow support to be enabled on the view holding this `IconicsDrawable`*/
fun IconicsDrawable.shadow(
    radiusProducer: () -> IconicsSize? = { IconicsSize.px(shadowRadiusPx) },
    dxProducer: () -> IconicsSize? = { IconicsSize.px(shadowDxPx) },
    dyProducer: () -> IconicsSize? = { IconicsSize.px(shadowDyPx) },
    colorProducer: () -> IconicsColor? = { IconicsColor.colorInt(shadowColorInt) }
): IconicsDrawable {
    val radius = radiusProducer()
    val dx = dxProducer()
    val dy = dyProducer()
    val color = colorProducer()

    @Suppress("ComplexCondition")
    if (radius != null && dx != null && dy != null && color != null) {
        applyShadow {
            shadowRadius = radius
            shadowDx = dx
            shadowDy = dy
            shadowColor = color
        }
    }

    return this
}

/** Set background colors. */
fun IconicsDrawable.backgroundColor(backgroundColorProducer: () -> IconicsColor?): IconicsDrawable {
    backgroundColorProducer()?.let { backgroundColor = it }
    return this
}

/** Set rounded corners. */
fun IconicsDrawable.roundedCornersRx(roundedCornersRxProducer: () -> IconicsSize?): IconicsDrawable {
    roundedCornersRxProducer()?.let { roundedCornersRx = it }
    return this
}

/** Set rounded corner from px */
fun IconicsDrawable.roundedCornersRy(roundedCornersRyProducer: () -> IconicsSize?): IconicsDrawable {
    roundedCornersRyProducer()?.let { roundedCornersRy = it }
    return this
}

/** Set rounded corner from px */
fun IconicsDrawable.roundedCorners(roundedCornersProducer: () -> IconicsSize?): IconicsDrawable {
    roundedCornersProducer()?.let { roundedCorners = it }
    return this
}

/** Set contour width for the icon. */
fun IconicsDrawable.contourWidth(contourWidthProducer: () -> IconicsSize?): IconicsDrawable {
    contourWidthProducer()?.let { contourWidth = it }
    return this
}

/** Set background contour width for the icon. */
fun IconicsDrawable.backgroundContourWidth(backgroundContourWidthProducer: () -> IconicsSize?): IconicsDrawable {
    backgroundContourWidthProducer()?.let { backgroundContourWidth = it }
    return this
}

/** Enable/disable contour drawing. */
fun IconicsDrawable.drawContour(drawContourProducer: () -> Boolean?): IconicsDrawable {
    drawContourProducer()?.let { drawContour = it }
    return this
}

/** Enable/disable background contour drawing. */
fun IconicsDrawable.drawBackgroundContour(drawBackgroundContourProducer: () -> Boolean?): IconicsDrawable {
    drawBackgroundContourProducer()?.let { drawBackgroundContour = it }
    return this
}

/** Set the ColorFilter */
fun IconicsDrawable.colorFilter(colorFilterProducer: () -> ColorFilter?): IconicsDrawable {
    colorFilterProducer()?.let { colorFilter = it }
    return this
}

/**
 * Set the opacity
 * **NOTE** if you define a color (or as part of a colorStateList) with alpha
 * the alpha value of that color will ALWAYS WIN! */
fun IconicsDrawable.alpha(alphaProducer: () -> Int?): IconicsDrawable {
    alphaProducer()?.let { compatAlpha = it }
    return this
}

/** Set the style */
fun IconicsDrawable.style(styleProducer: () -> Paint.Style?): IconicsDrawable {
    styleProducer()?.let { style = it }
    return this
}

/** Set the typeface of the drawable
 * NOTE THIS WILL OVERWRITE THE ICONFONT! */
fun IconicsDrawable.typeface(typefaceProducer: () -> Typeface?): IconicsDrawable {
    typefaceProducer()?.let { typeface = it }
    return this
}