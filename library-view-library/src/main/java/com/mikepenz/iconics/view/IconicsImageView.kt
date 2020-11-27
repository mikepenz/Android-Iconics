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

package com.mikepenz.iconics.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.animation.tryToEnableIconicsAnimation
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier

open class IconicsImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatImageView(context, attrs, defStyle) {

    var icon: IconicsDrawable?
        get() = drawable as? IconicsDrawable
        set(icon) = setImageDrawable(tryToEnableIconicsAnimation(icon))

    init {
        //set the scale type for this view
        scaleType = ImageView.ScaleType.CENTER_INSIDE

        icon = IconicsViewsAttrsApplier.getIconicsImageViewDrawable(context, attrs)
    }
}
