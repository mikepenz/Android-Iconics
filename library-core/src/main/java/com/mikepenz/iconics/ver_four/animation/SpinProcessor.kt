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
import com.mikepenz.iconics.ver_four.IconicsBrush

/**
 * @author pa.gulko zTrap (30.11.2018)
 */
open class SpinProcessor(
    /** The direction of the spin */
    open var direction: com.mikepenz.iconics.ver_four.animation.SpinProcessor.Direction = com.mikepenz.iconics.ver_four.animation.SpinProcessor.Direction.CLOCKWISE,

    override var interpolator: TimeInterpolator = com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor.Companion.DEFAULT_INTERPOLATOR,
    override var duration: Long = com.mikepenz.iconics.ver_four.animation.SpinProcessor.Companion.DEFAULT_DURATION,
    override var repeatCount: Int = com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor.Companion.INFINITE,
    override var repeatMode: com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor.RepeatMode = com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor.RepeatMode.RESTART,
    override var isStartImmediately: Boolean = true
) : com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor(interpolator, duration, repeatCount, repeatMode, isStartImmediately) {

    companion object {
        /** Duration used for all instances of this processor by default. 2000 ms by default. */
        @JvmField var DEFAULT_DURATION = 2000L
    }

    private var isDrawableShadowCleared = false

    override fun animationTag(): String = "spin"

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

        canvas.rotate(degrees, (bounds!!.width() / 2).toFloat(), (bounds.height() / 2).toFloat())
    }

    override fun processPostDraw(canvas: Canvas) {
        canvas.restore()
    }

    override fun onDrawableDetached() {
        isDrawableShadowCleared = false
    }

    enum class Direction(internal val sign: Int) { CLOCKWISE(+1), COUNTER_CLOCKWISE(-1) }
}