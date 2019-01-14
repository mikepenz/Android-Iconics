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

package com.mikepenz.iconics

import android.content.Context
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import com.mikepenz.iconics.utils.IconicsUtils

/**
 * @author pa.gulko zTrap (20.01.2018)
 */
class IconicsSize private constructor() : IconicsExtractor {

    companion object {

        /** Size of [androidx.appcompat.widget.Toolbar] icon in dp */
        @JvmField val TOOLBAR_ICON_SIZE = IconicsSize.dp(24f)

        /** Size of [androidx.appcompat.widget.Toolbar] icon padding in dp */
        @JvmField val TOOLBAR_ICON_PADDING = IconicsSize.dp(1f)

        /** @param dp The size in density-independent pixels (dp). */
        @JvmStatic fun dp(@Dimension(unit = Dimension.DP) dp: Number): IconicsSize =
                IconicsSize().also { it.dp = dp }

        /** @param px The size in pixels (px). */
        @JvmStatic fun px(@Dimension(unit = Dimension.PX) px: Number): IconicsSize =
                IconicsSize().also { it.px = px }

        /** @param res The dimension resource. */
        @JvmStatic fun res(@DimenRes res: Int): IconicsSize =
                IconicsSize().also { it.dimenRes = res }
    }

    @Dimension(unit = Dimension.DP) private var dp = IconicsExtractor.DEF_SIZE
    @Dimension(unit = Dimension.PX) private var px = IconicsExtractor.DEF_SIZE
    @DimenRes private var dimenRes = IconicsExtractor.DEF_RESOURCE

    internal fun extractFloat(context: Context): Float {
        if (px == IconicsExtractor.DEF_SIZE) {
            if (dp != IconicsExtractor.DEF_SIZE) {
                return IconicsUtils.convertDpToPx(context, dp).toFloat().also { px = it }
            }
            if (dimenRes != IconicsExtractor.DEF_RESOURCE) {
                return context.resources.getDimensionPixelSize(dimenRes).toFloat().also { px = it }
            }
        }
        return px.toFloat()
    }

    internal fun extract(context: Context): Int {
        return extractFloat(context).toInt()
    }
}
