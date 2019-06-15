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

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import com.mikepenz.iconics.utils.IconicsUtils

/**
 * @author pa.gulko zTrap (20.01.2018)
 */
sealed class IconicsSize : IconicsExtractor {

    companion object {
        /** Size of [androidx.appcompat.widget.Toolbar] icon in dp */
        @JvmField val TOOLBAR_ICON_SIZE: IconicsSize = dp(24f)

        /** Size of [androidx.appcompat.widget.Toolbar] icon padding in dp */
        @JvmField val TOOLBAR_ICON_PADDING: IconicsSize = dp(1f)

        /** @param dp The size in density-independent pixels (dp). */
        @SuppressLint("SupportAnnotationUsage")
        @JvmStatic
        fun dp(@Dimension(unit = Dimension.DP) dp: Number): IconicsSize {
            return IconicsSizeDp(dp)
        }

        /** @param px The size in pixels (px). */
        @SuppressLint("SupportAnnotationUsage")
        @JvmStatic
        fun px(@Dimension(unit = Dimension.PX) px: Number): IconicsSize {
            return IconicsSizePx(px)
        }

        /** @param res The dimension resource. */
        @JvmStatic
        fun res(@DimenRes res: Int): IconicsSize {
            return IconicsSizeRes(res)
        }
    }

    internal abstract fun extractFloat(context: Context): Float

    internal abstract fun extract(context: Context): Int
}

class IconicsSizeDp internal constructor(
    @SuppressLint("SupportAnnotationUsage")
    @Dimension(unit = Dimension.DP)
    private val dp: Number
) : IconicsSize() {
    var pxCache: Int? = null

    override fun extractFloat(context: Context): Float = extract(context).toFloat()

    override fun extract(context: Context): Int {
        val pxCache = pxCache ?: IconicsUtils.convertDpToPx(context, dp)
        this.pxCache = pxCache
        return pxCache
    }
}

class IconicsSizePx internal constructor(
    @SuppressLint("SupportAnnotationUsage")
    @Dimension(unit = Dimension.PX)
    private val px: Number
) : IconicsSize() {
    override fun extractFloat(context: Context): Float = px.toFloat()

    override fun extract(context: Context): Int = px.toInt()
}

class IconicsSizeRes internal constructor(
    @DimenRes private val res: Int
) : IconicsSize() {
    // note we should not cache the value, as a configurationchange could mean different values

    override fun extractFloat(context: Context): Float {
        return extract(context).toFloat()
    }

    override fun extract(context: Context): Int = context.resources.getDimensionPixelSize(res)
}
