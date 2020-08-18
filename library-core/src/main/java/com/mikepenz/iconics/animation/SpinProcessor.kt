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

package com.mikepenz.iconics.animation

import android.animation.TimeInterpolator
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import com.mikepenz.iconics.IconicsBrush
import com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode.RESTART
import com.mikepenz.iconics.animation.SpinProcessor.Direction.CLOCKWISE

/**
 * @author pa.gulko zTrap (30.11.2018)
 */
open class SpinProcessor(
    /** The direction of the spin */
    open var direction: SpinProcessor.Direction = CLOCKWISE,

    override var interpolator: TimeInterpolator = DEFAULT_INTERPOLATOR,
    override var duration: Long = DEFAULT_DURATION,
    override var repeatCount: Int = INFINITE,
    override var repeatMode: IconicsAnimationProcessor.RepeatMode = RESTART,
    override var isStartImmediately: Boolean = true
) : IconicsAnimationProcessor(interpolator, duration, repeatCount, repeatMode, isStartImmediately) {

    companion object {
        /** Duration used for all instances of this processor by default. 2000 ms by default. */
        @JvmField var DEFAULT_DURATION = 2000L
    }

    private var isDrawableShadowCleared = false

    override val animationTag: String = "spin"

    override fun processPreDraw(
        canvas: Canvas,
        iconBrush: IconicsBrush<TextPaint>,
        iconContourBrush: IconicsBrush<Paint>,
        backgroundBrush: IconicsBrush<Paint>,
        backgroundContourBrush: IconicsBrush<Paint>
    ) {

        // Shadow are not recalculate while drawable are spinning. It looks ugly!
        // Turn off ugly shadow!
        if (!isDrawableShadowCleared) {
            iconBrush.paint.clearShadowLayer()
            isDrawableShadowCleared = true
        }

        canvas.save()

        val bounds = drawableBounds
        val degrees = animatedPercent * 3.6f * direction.sign

        bounds?.let {
            canvas.rotate(degrees, (it.width() / 2).toFloat(), (it.height() / 2).toFloat())
        }
    }

    override fun processPostDraw(canvas: Canvas) {
        canvas.restore()
    }

    override fun onDrawableDetached() {
        isDrawableShadowCleared = false
    }

    enum class Direction(internal val sign: Int) { CLOCKWISE(+1), COUNTER_CLOCKWISE(-1) }
}
