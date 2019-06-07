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

import android.graphics.Typeface
import com.mikepenz.iconics.typeface.IIcon

/**
 * Created by mikepenz on 30.06.15.
 */
class IconicsArrayBuilder(private val iconBase: IconicsDrawable) {
    private val icons = ArrayList<Pair<Any, Typeface?>>()

    fun add(icon: IIcon): IconicsArrayBuilder {
        icons.add(Pair(icon, null))
        return this
    }

    @JvmOverloads
    fun add(icon: String, typeface: Typeface = Typeface.DEFAULT): IconicsArrayBuilder {
        icons.add(Pair(icon, typeface))
        return this
    }

    @JvmOverloads
    fun add(icon: Char, typeface: Typeface = Typeface.DEFAULT): IconicsArrayBuilder {
        icons.add(Pair(icon, typeface))
        return this
    }

    fun build(): Array<IconicsDrawable> {
        val iconicsDrawables = ArrayList<IconicsDrawable>(icons.size)

        icons.forEachIndexed { index, (icon, typeface) ->
            when (icon) {
                is IIcon -> iconicsDrawables.add(index, iconBase.clone().icon(icon))
                is Char -> iconicsDrawables.add(index, iconBase.clone().icon(icon, typeface))
                is String -> iconicsDrawables.add(index, iconBase.clone().iconText(icon, typeface))
            }
        }

        return iconicsDrawables.toTypedArray()
    }
}
