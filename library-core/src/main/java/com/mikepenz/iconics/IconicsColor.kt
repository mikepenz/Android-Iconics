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

package com.mikepenz.iconics

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * Describes a color. Might be a colorInt, colorRes, or colorStateList
 */
sealed class IconicsColor {
    companion object {

        /** @param colorInt The color, usually from [android.graphics.Color] or 0xFF012345. */
        @JvmStatic fun colorInt(@ColorInt colorInt: Int): IconicsColor {
            return IconicsColorInt(colorInt)
        }

        /** @param colorRes The color resource, from your R file. */
        @JvmStatic fun colorRes(@ColorRes colorRes: Int): IconicsColor {
            return IconicsColorRes(colorRes)
        }

        /** @param colorList The color state list. */
        @JvmStatic fun colorList(colorList: ColorStateList): IconicsColor {
            return IconicsColorList(colorList)
        }

        /**
         * Parse the color string, and return the corresponding color-int. If the string cannot be
         * parsed, throws an IllegalArgumentException exception. Supported formats are: #RRGGBB
         * #AARRGGBB or one of the following names: 'red', 'blue', 'green', 'black', 'white',
         * 'gray', 'cyan', 'magenta', 'yellow', 'lightgray', 'darkgray', 'grey', 'lightgrey',
         * 'darkgrey', 'aqua', 'fuchsia', 'lime', 'maroon', 'navy', 'olive', 'purple', 'silver',
         * 'teal'.
         */
        @JvmStatic fun parse(colorString: String): IconicsColor {
            return colorInt(Color.parseColor(colorString))
        }
    }

    internal abstract fun extractList(context: Context): ColorStateList?

    internal abstract fun extract(context: Context): Int
}

class IconicsColorInt internal constructor(@ColorInt private val color: Int) : IconicsColor() {
    override fun extractList(context: Context): ColorStateList? = ColorStateList.valueOf(color)

    override fun extract(context: Context): Int = color
}

class IconicsColorRes internal constructor(@ColorRes private val colorRes: Int) : IconicsColor() {
    override fun extractList(context: Context): ColorStateList? =
            ContextCompat.getColorStateList(context, colorRes)

    override fun extract(context: Context): Int = ContextCompat.getColor(context, colorRes)
}

class IconicsColorList internal constructor(private val colorList: ColorStateList) : IconicsColor() {
    override fun extractList(context: Context): ColorStateList? = colorList

    override fun extract(context: Context): Int =
            colorList.defaultColor // use the default color in this case
}