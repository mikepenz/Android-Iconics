/*
 * Copyright (c) 2020 Mike Penz
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

package com.mikepenz.iconics.typeface

import android.content.Context
import com.mikepenz.iconics.typeface.utils.IconicsPreconditions

/**
 * @author pa.gulko zTrap (02.05.2020)
 */
object IconicsHolder {
    private var context: Context? = null

    val FONTS = HashMap<String, ITypeface>()

    @JvmStatic var applicationContext: Context
        get() = context ?: errorContextNotInitialized()
        set(value) {
            if (context == null) {
                context = value.applicationContext
            }
        }

    private fun errorContextNotInitialized(): Nothing {
        val message = buildString {
            append("A 'Iconics.init(context)' has to happen first. ")
            append("Call from your application. ")
            append("Usually this happens via an 'IconicsDrawable' usage.")
        }
        throw RuntimeException(message)
    }

    /** Registers a fonts into the FONTS array for performance */
    @JvmStatic fun registerFont(font: ITypeface): Boolean {
        FONTS[font.mappingPrefix] = font.validate()
        return true
    }

    /** Perform a basic sanity check for a font. */
    @JvmStatic private fun ITypeface.validate(): ITypeface {
        IconicsPreconditions.checkMappingPrefix(mappingPrefix)
        return this
    }
}