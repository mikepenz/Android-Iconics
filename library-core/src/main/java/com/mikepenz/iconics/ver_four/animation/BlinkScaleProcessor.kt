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

package com.mikepenz.iconics.ver_four.animation

import android.animation.TimeInterpolator
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import androidx.annotation.FloatRange
import com.mikepenz.iconics.ver_four.IconicsBrush

/**
 * @author pa.gulko zTrap (30.11.2018)
 */
open class BlinkScaleProcessor(
    /**
     * @return The minimal available scale.
     */
    @FloatRange(from = 0.0) open var minimumScale: Float = 0f,
    /**
     * @return The maximal available scale.
     */
    @FloatRange(from = 0.0) open var maximumScale: Float = 1f,

    override var interpolator: TimeInterpolator = IconicsAnimationProcessor.DEFAULT_INTERPOLATOR,
    override var duration: Long = BlinkScaleProcessor.DEFAULT_DURATION,
    override var repeatCount: Int = IconicsAnimationProcessor.INFINITE,
    override var repeatMode: IconicsAnimationProcessor.RepeatMode = IconicsAnimationProcessor.RepeatMode.REVERSE,
    override var isStartImmediately: Boolean = true
) : IconicsAnimationProcessor(interpolator, duration, repeatCount, repeatMode, isStartImmediately) {

    companion object {
        /** Duration used for all instances of this processor by default. 500 ms by default. */
        @JvmField var DEFAULT_DURATION = 500L
    }

    override val animationTag: String = "blink_scale"

    override fun processPreDraw(
        canvas: Canvas,
        iconBrush: IconicsBrush<TextPaint>,
        iconContourBrush: IconicsBrush<Paint>,
        backgroundBrush: IconicsBrush<Paint>,
        backgroundContourBrush: IconicsBrush<Paint>
    ) {

        val scaleByPercent = (maximumScale - minimumScale) / 100

        val scale = animatedPercent * scaleByPercent
        val bounds = drawableBounds

        canvas.save()
        canvas.scale(
            scale,
            scale,
            (bounds!!.width() / 2).toFloat(),
            (bounds.height() / 2).toFloat()
        )
    }

    override fun processPostDraw(canvas: Canvas) {
        canvas.restore()
    }
}
