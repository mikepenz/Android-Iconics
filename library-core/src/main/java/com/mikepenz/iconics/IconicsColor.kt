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

package com.mikepenz.iconics

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * @author pa.gulko zTrap (20.01.2018)
 */
class IconicsColor private constructor() : IconicsExtractor {

    companion object {

        /** @param colorInt The color, usually from android.graphics.Color or 0xFF012345. */
        @JvmStatic fun colorInt(@ColorInt colorInt: Int): IconicsColor =
                IconicsColor().also { it.colorInt = colorInt }

        /** @param colorRes The color resource, from your R file. */
        @JvmStatic fun colorRes(@ColorRes colorRes: Int): IconicsColor =
                IconicsColor().also { it.colorRes = colorRes }

        /** @param colorList The color state list. */
        @JvmStatic fun colorList(colorList: ColorStateList): IconicsColor =
                IconicsColor().also { it.colorList = colorList }

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

    private var colorList: ColorStateList? = null
    @ColorInt private var colorInt: Int = IconicsExtractor.DEF_COLOR
    @ColorRes private var colorRes: Int = IconicsExtractor.DEF_RESOURCE

    internal fun extractList(context: Context): ColorStateList? {
        var colorStateList = colorList
        if (colorRes != IconicsExtractor.DEF_RESOURCE) {
            colorStateList = ContextCompat.getColorStateList(context, colorRes)
        }
        if (colorInt != IconicsExtractor.DEF_COLOR) {
            colorStateList = ColorStateList.valueOf(colorInt)
        }
        return colorStateList
    }

    internal fun extract(context: Context): Int {
        if (colorRes != IconicsExtractor.DEF_RESOURCE) {
            colorInt = ContextCompat.getColor(context, colorRes)
        }
        return colorInt
    }
}
