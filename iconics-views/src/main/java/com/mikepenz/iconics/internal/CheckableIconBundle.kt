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

package com.mikepenz.iconics.internal

import android.content.Context
import android.graphics.drawable.StateListDrawable
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.utils.IconicsUtils

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
internal class CheckableIconBundle {
    var animateChanges: Boolean = false
    var checkedIcon: IconicsDrawable? = null
    var uncheckedIcon: IconicsDrawable? = null

    fun createIcons(ctx: Context) {
        checkedIcon = IconicsDrawable(ctx)
        uncheckedIcon = IconicsDrawable(ctx)
    }

    fun createStates(ctx: Context): StateListDrawable {
        return IconicsUtils.getCheckableIconStateList(
            ctx,
            uncheckedIcon,
            checkedIcon,
            animateChanges
        )
    }
}
