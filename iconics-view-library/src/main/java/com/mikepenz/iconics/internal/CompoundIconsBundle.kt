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

package com.mikepenz.iconics.internal

import android.widget.TextView
import androidx.core.widget.TextViewCompat
import com.mikepenz.iconics.IconicsDrawable

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
internal class CompoundIconsBundle {
    var startIcon: IconicsDrawable? = null
    var topIcon: IconicsDrawable? = null
    var endIcon: IconicsDrawable? = null
    var bottomIcon: IconicsDrawable? = null

    fun setIcons(textView: TextView) {
        val drawables = TextViewCompat.getCompoundDrawablesRelative(textView)

        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(
            textView,
            startIcon ?: drawables[0],
            topIcon ?: drawables[1],
            endIcon ?: drawables[2],
            bottomIcon ?: drawables[3]
        )
    }
}
