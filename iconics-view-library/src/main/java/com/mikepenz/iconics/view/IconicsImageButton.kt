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
import android.widget.ImageButton

open class IconicsImageButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = android.R.attr.buttonStyle
) : IconicsImageView(context, attrs, defStyle) {

    init {
        isFocusable = true
    }

    override fun onSetAlpha(alpha: Int): Boolean = false

    override fun getAccessibilityClassName(): CharSequence = ImageButton::class.java.name
}
