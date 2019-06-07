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

import android.content.Context
import android.graphics.drawable.Drawable
import android.graphics.drawable.StateListDrawable
import android.util.TypedValue
import android.view.View

object IconicsUtils {

    /**
     * Enables the [View.LAYER_TYPE_SOFTWARE] for the view holding this icon, to enable correct
     * shadowLayer drawing
     *
     * @param view the view holding `IconicsDrawable`
     * @see View.setLayerType
     */
    @JvmStatic fun enableShadowSupport(view: View) {
        view.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
    }

    @JvmStatic fun convertDpToPx(context: Context, dp: Number): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }

    @JvmStatic
    @JvmOverloads
    fun getCheckableIconStateList(
        ctx: Context,
        icon: Drawable?,
        checkedIcon: Drawable?,
        animate: Boolean = true
    ): StateListDrawable {
        return StateListDrawable().apply {
            addState(intArrayOf(android.R.attr.state_checked), checkedIcon)
            addState(intArrayOf(-android.R.attr.state_checked), icon)

            if (animate) {
                val duration = ctx.resources.getInteger(android.R.integer.config_shortAnimTime)
                setEnterFadeDuration(duration)
                setExitFadeDuration(duration)
            }
        }
    }
}
