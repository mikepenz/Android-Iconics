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

package com.mikepenz.iconics.typeface

import android.graphics.Typeface
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import com.mikepenz.iconics.Iconics

/**
 * Created by mikepenz on 01.11.14.
 */
interface ITypeface {

    val rawTypeface: Typeface
        get() = runCatching {
            ResourcesCompat.getFont(Iconics.applicationContext, fontRes)
        }.getOrNull() ?: Typeface.DEFAULT

    @get:FontRes val fontRes: Int

    val characters: Map<String, Char>

    /** The Mapping Prefix to identify this font must have a length of 3 */
    val mappingPrefix: String

    val fontName: String

    val version: String

    val iconCount: Int

    val icons: List<String>

    val author: String

    val url: String

    val description: String

    val license: String

    val licenseUrl: String

    fun getIcon(key: String): IIcon
}