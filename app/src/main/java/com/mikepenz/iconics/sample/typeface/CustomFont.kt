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

import android.content.Context
import android.graphics.Typeface
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import java.util.*

/**
 * Created by mikepenz on 01.11.14.
 */
class CustomFont : ITypeface {

    override val characters: HashMap<String, Char>
        get() {
            if (mChars == null) {
                val aChars = HashMap<String, Char>()
                for (v in Icon.values()) {
                    aChars[v.name] = v.character
                }
                mChars = aChars
            }

            return mChars
        }

    override val mappingPrefix: String
        get() = "fon"

    override val fontName: String
        get() = "CustomFont"

    override val version: String
        get() = "1.0.0"

    override val iconCount: Int
        get() = mChars!!.size

    override val icons: Collection<String>
        get() {
            val icons = LinkedList<String>()

            for (value in Icon.values()) {
                icons.add(value.name)
            }

            return icons
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

    override fun getIcon(key: String): IIcon {
        return Icon.valueOf(key)
    }

    override fun getTypeface(context: Context): Typeface? {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.assets, "fonts/$TTF_FILE")
            } catch (e: Exception) {
                return null
            }

        }
        return typeface
    }

    enum class Icon private constructor(character: Char) : IIcon {
        fon_test1('\ue800'),
        fon_test2('\ue801');

        override var character: Char = ' '
            internal set

        override val formattedName: String
            get() = "{$name}"

        override val name: String
            get() = name

        init {
            this.character = character
        }

        override fun getTypeface(): ITypeface {
            if (typeface == null) {
                typeface = CustomFont()
            }
            return typeface
        }

        companion object {

            // remember the typeface so we can use it later
            private var typeface: ITypeface? = null
        }
    }

    companion object {
        private val TTF_FILE = "fontello.ttf"

        private var typeface: Typeface? = null

        private var mChars: HashMap<String, Char>? = null
    }
}
