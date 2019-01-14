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

package com.mikepenz.iconics.utils

import android.content.res.ColorStateList
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsSize

/**
 * @author pa.gulko zTrap (13.01.2019)
 */

fun @receiver:Dimension(unit = Dimension.DP) Number.toIconicsSizeDp(): IconicsSize {
    return IconicsSize.dp(this)
}

fun @receiver:Dimension(unit = Dimension.PX) Number.toIconicsSizePx(): IconicsSize {
    return IconicsSize.px(this)
}

fun @receiver:DimenRes Int.toIconicsSizeRes(): IconicsSize {
    return IconicsSize.res(toInt())
}

fun @receiver:ColorInt Int.toIconicsColor(): IconicsColor {
    return IconicsColor.colorInt(this)
}

fun @receiver:ColorInt String.toIconicsColor(): IconicsColor {
    return IconicsColor.parse(this)
}

fun ColorStateList.toIconicsColor(): IconicsColor {
    return IconicsColor.colorList(this)
}

fun @receiver:ColorRes Int.toIconicsColorRes(): IconicsColor {
    return IconicsColor.colorRes(this)
}