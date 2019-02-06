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

package com.mikepenz.iconics.sample.typeface

import android.graphics.Typeface
import com.mikepenz.iconics.sample.R
import com.mikepenz.iconics.ver_four.typeface.IIcon
import com.mikepenz.iconics.ver_four.typeface.ITypeface
import java.util.HashMap
import java.util.LinkedList

/**
 * Created by mikepenz on 01.11.14.
 */
@Suppress("EnumEntryName", "LeakingThis")
class CustomFont : ITypeface {

    override var typeface: Typeface? = null

    override val fontRes: Int = R.font.fontello

    override val characters: HashMap<String, Char>
        get() {
            if (chars == null) {
                val aChars = HashMap<String, Char>()
                Icon.values().associateTo(aChars) { it.name to it.character }
                chars = aChars
            }

            return chars!!
        }

    override val mappingPrefix: String
        get() = "fon"

    override val fontName: String
        get() = "CustomFont"

    override val version: String
        get() = "1.0.0"

    override val iconCount: Int
        get() = characters.size

    override val icons: Collection<String> by lazy {
        val icons = LinkedList<String>()

        for (value in Icon.values()) {
            icons.add(value.name)
        }
        icons
    }

    override val author: String
        get() = "SampleCustomFont"

    override val url: String
        get() = ""

    override val description: String
        get() = ""

    override val license: String
        get() = ""

    override val licenseUrl: String
        get() = ""

    override fun getIcon(key: String): IIcon = Icon.valueOf(key)

    enum class Icon constructor(character: Char) : IIcon {
        fon_test1('\ue800'),
        fon_test2('\ue801');

        override var character: Char = ' '
            internal set

        init {
            this.character = character
        }

        override val typeface: ITypeface
            get() = savedTypeface

        companion object {
            // remember the typeface so we can use it later
            private val savedTypeface: ITypeface by lazy { CustomFont() }
        }
    }

    companion object {
        private var chars: HashMap<String, Char>? = null
    }
}