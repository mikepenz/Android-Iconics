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

@file:Suppress("DEPRECATION")

package com.mikepenz.iconics.context

import android.content.Context
import android.util.AttributeSet
import android.view.View

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.LayoutInflaterFactory

/**
 * Created by mikepenz on 01.12.15.
 */
class IconicsLayoutInflater(
    private val appCompatDelegate: AppCompatDelegate
) : LayoutInflaterFactory {

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        val view = appCompatDelegate.createView(parent, name, context, attrs)
        return IconicsFactory.onViewCreated(view, context, attrs)
    }
}
