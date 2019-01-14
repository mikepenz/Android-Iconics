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

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Paint
import androidx.annotation.IntRange
import com.mikepenz.iconics.animation.IconicsAnimationProcessor

/**
 * Helper class to control applying state changes to colors and paint. Also for compact providing
 * into [AnimationProcessor][IconicsAnimationProcessor]
 *
 * @author pa.gulko zTrap (28.11.2018)
 */
class IconicsBrush<T : Paint>(
        /** @return paint. Will be used for drawing something (icon, background etc.) */
        val paint: T
) {
    /** @return colors which applied on [.getPaint] for drawing current state */
    var colorsList: ColorStateList? = null
        private set
    private var state: IntArray? = null

    /** alpha channel for colors */
    @IntRange(from = 0, to = 255)
    var alpha: Int = 0
        set(alpha) {
            field = alpha
            paint.alpha = alpha
        }

    internal val isStateful: Boolean
        get() = colorsList?.isStateful == true

    internal val colorForCurrentState: Int
        get() = colorsList?.defaultColor?.let { getColorForCurrentState(it) } ?: Color.TRANSPARENT

    /** @param colors which will be applied on [.getPaint] for drawing current state */
    fun setColors(colors: ColorStateList?) {
        colorsList = colors
        applyState(state!!)
    }

    internal fun getColorForCurrentState(defaultColor: Int): Int {
        return colorsList?.getColorForState(state, defaultColor) ?: defaultColor
    }

    internal fun applyState(state: IntArray): Boolean {
        this.state = state

        var isInvalidate = false

        val colorForState = colorForCurrentState
        val red = Color.red(colorForState)
        val green = Color.green(colorForState)
        val blue = Color.blue(colorForState)

        val colorRgb = Color.rgb(red, green, blue)
        if (colorRgb != paint.color) {
            paint.color = colorRgb
            isInvalidate = true
        }

        val alpha = Color.alpha(colorForState)
        if (alpha != 255 && alpha != this.alpha) {
            this.alpha = alpha
            isInvalidate = true
        }
        return isInvalidate
    }
}
