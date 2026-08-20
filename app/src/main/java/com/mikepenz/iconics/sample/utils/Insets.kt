/*
 * Copyright (c) 2026 Mike Penz
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

package com.mikepenz.iconics.sample.utils

import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding

/**
 * Applies edge-to-edge insets: [topView] takes the status bar, [bottomView] the navigation bar,
 * both take the horizontal cutout/bar insets. Listener is installed on [root] so it also survives
 * `DrawerLayout` consuming the insets for its slider.
 */
fun applyEdgeToEdgeInsets(root: View, topView: View, bottomView: View) {
    ViewCompat.setOnApplyWindowInsetsListener(root) { _, windowInsets ->
        val insets = windowInsets.getInsets(
            WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
        )
        topView.updatePadding(left = insets.left, top = insets.top, right = insets.right)
        bottomView.updatePadding(left = insets.left, right = insets.right, bottom = insets.bottom)
        windowInsets
    }
}
