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

package com.mikepenz.iconics.context

import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater

/**
 * Base created by Christopher Jenkins
 * https://github.com/chrisjenx/Calligraphy
 */
class IconicsContextWrapper private constructor(base: Context) : ContextWrapper(base) {

    private val inflater by lazy {
        InternalLayoutInflater(LayoutInflater.from(baseContext), this, false)
    }

    override fun getSystemService(name: String): Any? {
        return if (Context.LAYOUT_INFLATER_SERVICE == name) {
            inflater
        } else {
            super.getSystemService(name)
        }
    }

    companion object {
        @JvmStatic fun wrap(base: Context): ContextWrapper = IconicsContextWrapper(base)
    }
}