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

package com.mikepenz.iconics.view

import android.content.Context
import android.util.AttributeSet
import androidx.core.view.forEach
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mikepenz.iconics.ver_four.utils.parseXmlAndSetIconicsDrawables

/**
 * @author pa.gulko zTrap (14.01.2019)
 */
class IconicsBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr) {

    override fun inflateMenu(resId: Int) {
        //itemIconTintList = null
        super.inflateMenu(resId)
        menu.parseXmlAndSetIconicsDrawables(context, resId)
        menu.forEach {
            it.icon.clearColorFilter()
        }

    }
}