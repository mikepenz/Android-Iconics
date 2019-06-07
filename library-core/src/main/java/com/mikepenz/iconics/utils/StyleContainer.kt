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

import android.text.ParcelableSpan
import android.text.Spannable
import android.text.style.CharacterStyle
import com.mikepenz.iconics.typeface.ITypeface

internal class StyleContainer {
    var startIndex: Int = 0
    var endIndex: Int = 0
    var icon: String? = null
    var font: ITypeface? = null
    var span: ParcelableSpan? = null
    var style: CharacterStyle? = null
    var flags = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE

    constructor(startIndex: Int, endIndex: Int, icon: String, font: ITypeface, flags: Int) {
        this.startIndex = startIndex
        this.endIndex = endIndex
        this.icon = icon
        this.font = font
        this.flags = flags
    }

    constructor(startIndex: Int, endIndex: Int, icon: String, font: ITypeface) {
        this.startIndex = startIndex
        this.endIndex = endIndex
        this.icon = icon
        this.font = font
    }

    constructor(startIndex: Int, endIndex: Int, span: ParcelableSpan) {
        this.startIndex = startIndex
        this.endIndex = endIndex
        this.span = span
    }

    constructor(startIndex: Int, endIndex: Int, span: ParcelableSpan, flags: Int) {
        this.startIndex = startIndex
        this.endIndex = endIndex
        this.span = span
        this.flags = flags
    }

    constructor(startIndex: Int, endIndex: Int, style: CharacterStyle) {
        this.startIndex = startIndex
        this.endIndex = endIndex
        this.style = style
    }

    constructor(startIndex: Int, endIndex: Int, style: CharacterStyle, flags: Int) {
        this.startIndex = startIndex
        this.endIndex = endIndex
        this.style = style
        this.flags = flags
    }
}
