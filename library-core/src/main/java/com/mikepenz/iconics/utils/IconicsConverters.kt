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

@file:Suppress("NOTHING_TO_INLINE")

package com.mikepenz.iconics.utils

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.core.graphics.drawable.IconCompat
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize

// VARIOUS convenient extension functions for quick common setters

inline fun IconicsDrawable.colorString(colorString: String) =
        color(IconicsColor.parse(colorString))

inline fun IconicsDrawable.colorRes(@ColorRes colorRes: Int) =
        color(IconicsColor.colorRes(colorRes))

inline fun IconicsDrawable.colorInt(@ColorInt colorInt: Int) =
        color(IconicsColor.colorInt(colorInt))

inline fun IconicsDrawable.contourColorString(colorString: String) =
        contourColor(IconicsColor.parse(colorString))

inline fun IconicsDrawable.contourColorRes(@ColorRes colorRes: Int) =
        contourColor(IconicsColor.colorRes(colorRes))

inline fun IconicsDrawable.contourColorInt(@ColorInt colorInt: Int) =
        contourColor(IconicsColor.colorInt(colorInt))

inline fun IconicsDrawable.backgroundColorString(colorString: String) =
        backgroundColor(IconicsColor.parse(colorString))

inline fun IconicsDrawable.backgroundColorRes(@ColorRes colorRes: Int) =
        backgroundColor(IconicsColor.colorRes(colorRes))

inline fun IconicsDrawable.backgroundColorInt(@ColorInt colorInt: Int) =
        backgroundColor(IconicsColor.colorInt(colorInt))

inline fun IconicsDrawable.backgroundContourColorString(colorString: String) =
        backgroundContourColor(IconicsColor.parse(colorString))

inline fun IconicsDrawable.backgroundContourColorRes(@ColorRes colorRes: Int) =
        backgroundContourColor(IconicsColor.colorRes(colorRes))

inline fun IconicsDrawable.backgroundContourColorInt(@ColorInt colorInt: Int) =
        backgroundContourColor(IconicsColor.colorInt(colorInt))

inline fun IconicsDrawable.sizeDp(@Dimension(unit = Dimension.DP) sizeDp: Int) =
        size(IconicsSize.dp(sizeDp))

inline fun IconicsDrawable.sizePx(@Dimension(unit = Dimension.PX) sizePx: Int) =
        size(IconicsSize.px(sizePx))

inline fun IconicsDrawable.sizeRes(@DimenRes sizeRes: Int) =
        size(IconicsSize.res(sizeRes))

inline fun IconicsDrawable.paddingDp(@Dimension(unit = Dimension.DP) sizeDp: Int) =
        padding(IconicsSize.dp(sizeDp))

inline fun IconicsDrawable.paddingPx(@Dimension(unit = Dimension.PX) sizePx: Int) =
        padding(IconicsSize.px(sizePx))

inline fun IconicsDrawable.paddingRes(@DimenRes sizeRes: Int) =
        padding(IconicsSize.res(sizeRes))

inline fun IconicsDrawable.roundedCornersDp(@Dimension(unit = Dimension.DP) sizeDp: Int) =
        roundedCorners(IconicsSize.dp(sizeDp))

inline fun IconicsDrawable.roundedCornersPx(@Dimension(unit = Dimension.PX) sizePx: Int) =
        roundedCorners(IconicsSize.px(sizePx))

inline fun IconicsDrawable.roundedCornersRes(@DimenRes sizeRes: Int) =
        roundedCorners(IconicsSize.res(sizeRes))

inline fun IconicsDrawable.contourWidthDp(@Dimension(unit = Dimension.DP) sizeDp: Int) =
        contourWidth(IconicsSize.dp(sizeDp))

inline fun IconicsDrawable.contourWidthPx(@Dimension(unit = Dimension.PX) sizePx: Int) =
        contourWidth(IconicsSize.px(sizePx))

inline fun IconicsDrawable.contourWidthRes(@DimenRes sizeRes: Int) =
        contourWidth(IconicsSize.res(sizeRes))

/**
 * Pretty converter to [androidx.core.graphics.drawable.IconCompat]
 *
 * Note: use [IconCompat.toIcon] to transform into Platform's Icon
 */
inline fun IconicsDrawable.toAndroidIconCompat(): IconCompat {
    return IconCompat.createWithBitmap(toBitmap())
}

/** Pretty converter to [IconicsSize.dp] */
@Deprecated("Use IconicsSize.dp() instead", ReplaceWith("IconicsSize.dp(x)", "com.mikepenz.iconics.IconicsSize"))
@SuppressLint("SupportAnnotationUsage")
inline fun @receiver:Dimension(unit = Dimension.DP) Number.toIconicsSizeDp(): IconicsSize {
    return IconicsSize.dp(this)
}

/** Pretty converter to [IconicsSize.px] */
@Deprecated("Use IconicsSize.px() instead", ReplaceWith("IconicsSize.px(x)", "com.mikepenz.iconics.IconicsSize"))
@SuppressLint("SupportAnnotationUsage")
inline fun @receiver:Dimension(unit = Dimension.PX) Number.toIconicsSizePx(): IconicsSize {
    return IconicsSize.px(this)
}

/** Pretty converter to [IconicsSize.res] */
@Deprecated("Use IconicsSize.res() instead", ReplaceWith("IconicsSize.res(x)", "com.mikepenz.iconics.IconicsSize"))
inline fun @receiver:DimenRes Int.toIconicsSizeRes(): IconicsSize {
    return IconicsSize.res(toInt())
}

/** Pretty converter to [IconicsColor.colorInt] */
@Deprecated("Use IconicsColor.colorInt() instead", ReplaceWith("IconicsColor.colorInt(x)", "com.mikepenz.iconics.IconicsColor"))
inline fun @receiver:ColorInt Int.toIconicsColor(): IconicsColor {
    return IconicsColor.colorInt(this)
}

/** Pretty converter to [IconicsColor.parse] */
@Deprecated("Use IconicsColor.parse() instead", ReplaceWith("IconicsColor.parse(x)", "com.mikepenz.iconics.IconicsColor"))
inline fun String.toIconicsColor(): IconicsColor {
    return IconicsColor.parse(this)
}

/** Pretty converter to [IconicsColor.colorList] */
@Deprecated("Use IconicsColor.colorList() instead", ReplaceWith("IconicsColor.colorList(x)", "com.mikepenz.iconics.IconicsColor"))
inline fun ColorStateList.toIconicsColor(): IconicsColor {
    return IconicsColor.colorList(this)
}

/** Pretty converter to [IconicsColor.colorRes] */
@Deprecated("Use IconicsColor.colorRes() instead", ReplaceWith("IconicsColor.colorRes(x)", "com.mikepenz.iconics.IconicsColor"))
inline fun @receiver:ColorRes Int.toIconicsColorRes(): IconicsColor {
    return IconicsColor.colorRes(this)
}