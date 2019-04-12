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

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Paint
import androidx.annotation.IntRange

/**
 * Helper class to control applying state changes to colors and paint. Also for compact providing
 * into [AnimationProcessor][com.mikepenz.iconics.animation.IconicsAnimationProcessor]
 *
 * @author pa.gulko zTrap (28.11.2018)
 */
class IconicsBrush<T : Paint>(
    /** Will be used for drawing something (icon, background etc.) */
    val paint: T
) {
    private var state: IntArray? = null

    init {
        paint.alpha = 255
    }

    /** Colors which applied on [paint] for drawing current state */
    var colorsList: ColorStateList? = null

    /** Alpha channel for colors */
    var alpha: Int
        get() {
            return paint.alpha
        }
        set(@IntRange(from = 0, to = 255) alpha) {
            if (paint.alpha != alpha) {
                paint.alpha = alpha
            }
        }

    val isStateful: Boolean
        get() = colorsList?.isStateful == true

    val colorForCurrentState: Int
        get() = getColorForCurrentState(colorsList?.defaultColor ?: Color.TRANSPARENT)

    private fun getColorForCurrentState(defaultColor: Int): Int {
        return colorsList?.getColorForState(state, defaultColor) ?: defaultColor
    }

    fun applyState(state: IntArray?): Boolean {
        this.state = state

        val colorForState = colorForCurrentState
        val oldColor = paint.color
        paint.color = colorForState
        return paint.color != oldColor
    }

    override fun toString(): String {
        return "color=#${Integer.toHexString(paint.color)}, state=$state, colorList=$colorsList"
    }
}
