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

package com.mikepenz.iconics.utils

import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.core.graphics.drawable.IconCompat
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize

/** Pretty converter to [IconicsSize.dp] */
fun @receiver:Dimension(unit = Dimension.DP) Number.toIconicsSizeDp(): IconicsSize {
    return IconicsSize.dp(this)
}

/** Pretty converter to [IconicsSize.px] */
fun @receiver:Dimension(unit = Dimension.PX) Number.toIconicsSizePx(): IconicsSize {
    return IconicsSize.px(this)
}

/** Pretty converter to [IconicsSize.res] */
fun @receiver:DimenRes Int.toIconicsSizeRes(): IconicsSize {
    return IconicsSize.res(toInt())
}

/** Pretty converter to [IconicsColor.colorInt] */
fun @receiver:ColorInt Int.toIconicsColor(): IconicsColor {
    return IconicsColor.colorInt(this)
}

/** Pretty converter to [IconicsColor.parse] */
fun String.toIconicsColor(): IconicsColor {
    return IconicsColor.parse(this)
}

/** Pretty converter to [IconicsColor.colorList] */
fun ColorStateList.toIconicsColor(): IconicsColor {
    return IconicsColor.colorList(this)
}

/** Pretty converter to [IconicsColor.colorRes] */
fun @receiver:ColorRes Int.toIconicsColorRes(): IconicsColor {
    return IconicsColor.colorRes(this)
}

/**
 * Pretty converter to [androidx.core.graphics.drawable.IconCompat]
 *
 * Note: use [IconCompat.toIcon] to transform into Platform's Icon
 */
fun IconicsDrawable.toAndroidIconCompat(): IconCompat {
    return IconCompat.createWithBitmap(toBitmap())
}