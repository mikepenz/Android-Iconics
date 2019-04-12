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

import android.animation.Animator
import android.animation.TimeInterpolator
import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.text.TextPaint
import android.view.animation.LinearInterpolator
import androidx.annotation.FloatRange
import androidx.annotation.RequiresApi
import com.mikepenz.iconics.IconicsBrush
import com.mikepenz.iconics.animation.IconicsAnimationProcessor.Companion.INFINITE
import com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode
import com.mikepenz.iconics.animation.IconicsAnimationProcessor.RepeatMode.RESTART

/**
 * @author pa.gulko zTrap (28.11.2018)
 */
abstract class IconicsAnimationProcessor(
    /**
     * The time interpolator used in calculating the elapsed fraction of this animation. The
     * interpolator determines whether the animation runs with linear or non-linear motion, such
     * as acceleration and deceleration. The default value is
     * [android.view.animation.LinearInterpolator]
     */
    open var interpolator: TimeInterpolator = DEFAULT_INTERPOLATOR,

    /**
     * The length of the animation. The default duration is 300 milliseconds. This value
     * cannot be negative.
     */
    open var duration: Long = 300,

    /**
     * Sets how many times the animation should be repeated. If the repeat
     * count is `0`, the animation is never repeated. If the repeat count is
     * greater than `0` or [INFINITE], the repeat mode will be taken
     * into account. The repeat count is [INFINITE] by default.
     */
    open var repeatCount: Int = INFINITE,

    /**
     * Defines what this animation should do when it reaches the end. This
     * setting is applied only when the repeat count is either greater than
     * `0` or [INFINITE]. Defaults to [RepeatMode.RESTART].
     *
     * @see RepeatMode
     */
    open var repeatMode: RepeatMode = RESTART,

    /**
     * Set the flag for starting animation immediately after attach to drawable and after drawable
     * with the view is attached to window. Default value is `true`.
     */
    open var isStartImmediately: Boolean = true
) {

    companion object {
        @JvmField val DEFAULT_INTERPOLATOR = LinearInterpolator()
        /**
         * This value used used with the [repeatCount] property to repeat the animation
         * indefinitely.
         */
        const val INFINITE = ValueAnimator.INFINITE
    }

    private val animator: ValueAnimator = ValueAnimator.ofFloat(0f, 100f)

    private var drawable: IconicsAnimatedDrawable? = null
    private var isStartRequested: Boolean = false

    /** The set of listeners to be sent events through the life of an animation. */
    private var listeners: MutableList<IconicsAnimationListener>? = null

    /** The set of listeners to be sent pause/resume events through the life of an animation. */
    private var pauseListeners: MutableList<IconicsAnimationPauseListener>? = null

    private val proxyListener = object : Animator.AnimatorListener {

        override fun onAnimationStart(animation: Animator, isReverse: Boolean) {
            listeners?.forEach { it.onAnimationStart(this@IconicsAnimationProcessor, isReverse) }
        }

        override fun onAnimationEnd(animation: Animator, isReverse: Boolean) {
            listeners?.forEach { it.onAnimationEnd(this@IconicsAnimationProcessor, isReverse) }
        }

        override fun onAnimationStart(animation: Animator) {
            listeners?.forEach { it.onAnimationStart(this@IconicsAnimationProcessor) }
        }

        override fun onAnimationEnd(animation: Animator) {
            listeners?.forEach { it.onAnimationEnd(this@IconicsAnimationProcessor) }
        }

        override fun onAnimationCancel(animation: Animator) {
            listeners?.forEach { it.onAnimationCancel(this@IconicsAnimationProcessor) }
        }

        override fun onAnimationRepeat(animation: Animator) {
            listeners?.forEach { it.onAnimationRepeat(this@IconicsAnimationProcessor) }
        }
    }

    private val proxyPauseListener by lazy {
        @RequiresApi(Build.VERSION_CODES.KITKAT)
        object : Animator.AnimatorPauseListener {

            override fun onAnimationPause(animation: Animator) {
                pauseListeners?.forEach { it.onAnimationPause(this@IconicsAnimationProcessor) }
            }

            override fun onAnimationResume(animation: Animator) {
                pauseListeners?.forEach { it.onAnimationResume(this@IconicsAnimationProcessor) }
            }
        }
    }

    /** Whether the processor has been started and not yet ended. */
    val isStarted: Boolean
        get() = animator.isStarted

    /** Whether the processor is running. */
    val isRunning: Boolean
        get() = animator.isRunning

    /**
     * Returns whether this processor is currently in a paused state.
     *
     * @return True if the processor is currently paused, false otherwise.
     * @see pause
     * @see resume
     */
    val isPaused: Boolean
        @RequiresApi(Build.VERSION_CODES.KITKAT)
        get() = animator.isPaused

    /**
     * Return the drawable's current state
     *
     * Nullability contract: calling this into [processPreDraw] or [processPostDraw] is
     * guaranteed return `@NonNull` value, otherwise it can be `@Nullable`.
     *
     * @return The current state of the drawable
     */
    protected val drawableState: IntArray?
        get() = drawable?.state

    /**
     * Return the drawable's bounds Rect. Note: for efficiency, the returned object may be the same
     * object stored in the drawable (though this is not guaranteed).
     *
     * Nullability contract: calling this into [processPreDraw] or [processPostDraw] is
     * guaranteed return `@NonNull` value, otherwise it can be `@Nullable`.
     *
     * @return The bounds of the drawable (which may change later, so caller beware). DO NOT ALTER
     * the returned object as it may change the stored bounds of this drawable.
     */
    protected val drawableBounds: Rect?
        get() = drawable?.bounds

    /** Completed percent of animation */
    @get:FloatRange(from = 0.0, to = 100.0)
    protected val animatedPercent: Float
        get() = animator.animatedValue as Float

    /** Tag which will be used to apply this processor via xml */
    abstract val animationTag: String

    /**
     * Starts the animation, if processor is attached to drawable, otherwise sets flag to start
     * animation immediately after attaching
     */
    fun start(): IconicsAnimationProcessor {
        animator.interpolator = interpolator
        animator.duration = duration
        animator.repeatCount = repeatCount
        animator.repeatMode = repeatMode.valueAnimatorConst

        if (drawable != null) {
            isStartRequested = false
            animator.start()
        } else {
            isStartRequested = true
        }
        return this
    }

    /**
     * Adds a listener to the set of listeners that are sent events through the life of an
     * processor, such as start, repeat, and end.
     *
     * @param listener the listener to be added to the current set of listeners for this processor.
     */
    fun addListener(listener: IconicsAnimationListener): IconicsAnimationProcessor {
        if (listeners == null) {
            listeners = ArrayList()
            animator.addListener(proxyListener)
        }
        listeners?.add(listener)
        return this
    }

    /**
     * Removes a listener from the set listening to this processor.
     *
     * @param listener the listener to be removed from the current set of listeners for this
     * processor.
     */
    fun removeListener(listener: IconicsAnimationListener) {
        listeners?.remove(listener)
        if (listeners?.size == 0) {
            listeners = null
            animator.removeListener(proxyListener)
        }
    }

    /**
     * Adds a pause listener to this processor.
     *
     * @param listener the listener to be added to the current set of pause listeners for this
     * processor.
     */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun addPauseListener(listener: IconicsAnimationPauseListener): IconicsAnimationProcessor {
        if (pauseListeners == null) {
            pauseListeners = ArrayList()
            animator.addPauseListener(proxyPauseListener)
        }
        pauseListeners?.add(listener)
        return this
    }

    /**
     * Removes a pause listener from the set listening to this processor.
     *
     * @param listener the listener to be removed from the current set of pause listeners for
     * this processor.
     */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun removePauseListener(listener: IconicsAnimationPauseListener) {
        pauseListeners?.remove(listener)
        if (pauseListeners?.size == 0) {
            pauseListeners = null
            animator.removePauseListener(proxyPauseListener)
        }
    }

    /**
     * Removes all [listeners][addListener] and [pauseListeners][addPauseListener] from this
     * processor.
     */
    fun removeAllListeners() {
        if (listeners != null) {
            listeners?.clear()
            listeners = null
            animator.removeListener(proxyListener)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (pauseListeners != null) {
                pauseListeners?.clear()
                pauseListeners = null
                animator.removePauseListener(proxyPauseListener)
            }
        }
    }

    /**
     * Cancels the animation. Unlike [end], [cancel] causes the animation to stop in its tracks,
     * sending an [IconicsAnimationListener.onAnimationCancel] to its listeners, followed by an
     * [IconicsAnimationListener.onAnimationEnd] message.
     *
     * This method must be called on the thread that is running the processor.
     */
    fun cancel() = animator.cancel()

    /**
     * Ends the animation. This causes the processor to assign the end value of the property being
     * animated, then calling the [IconicsAnimationListener.onAnimationEnd] method on its listeners.
     *
     * This method must be called on the thread that is running the processor.
     */
    fun end() = animator.end()

    /**
     * Plays the processor in reverse. If the processor is already running, it will stop itself
     * and play backwards from the point reached when reverse was called. If the processor is not
     * currently running, then it will start from the end and play backwards.
     */
    fun reverse() = animator.reverse()

    /**
     * Pauses a running processor. This method should only be called on the same thread on which
     * the animation was started. If the animation has not yet been [started][isStarted] or has
     * since ended, then the call is ignored. Paused processors can be resumed by calling [resume].
     *
     * @see resume
     * @see isPaused
     */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun pause() = animator.pause()

    /**
     * Resumes a paused processor, causing the processor to pick up where it left off when it was
     * paused. This method should only be called on the same thread on which the processor was
     * started. Calls to [resume] on an processor that is not currently paused will be ignored.
     *
     * @see pause
     * @see isPaused
     */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun resume() = animator.resume()

    /**
     * Will be called before [draw(Canvas)][android.graphics.drawable.Drawable.draw].
     * Useful for some changes, based on [Paint][android.graphics.Paint]
     */
    open fun processPreDraw(
        canvas: Canvas,
        iconBrush: IconicsBrush<TextPaint>,
        iconContourBrush: IconicsBrush<Paint>,
        backgroundBrush: IconicsBrush<Paint>,
        backgroundContourBrush: IconicsBrush<Paint>
    ) {
    }

    /**
     * Will be called after [draw(Canvas)][android.graphics.drawable.Drawable.draw].
     * Useful for some changes, based on canvas and need to restore canvas after drawing the icon
     * (scale, rotate etc.).
     */
    open fun processPostDraw(canvas: Canvas) {}

    /**
     * Called when a drawable was attached and now [drawableBounds] and [drawableState] will
     * return valid values. Good place to set some drawable-dependent fields
     */
    protected fun onDrawableAttached() {}

    /**
     * Called when a drawable was detached and now [drawableBounds] and [drawableState] will
     * return `null`. Good place to clear some drawable-dependent fields
     */
    protected open fun onDrawableDetached() {}

    /** Internal set an drawable to this processor */
    internal fun setDrawable(drawable: IconicsAnimatedDrawable?) {
        if (this.drawable != null) {
            this.drawable = null
            onDrawableDetached()
        }

        this.drawable = drawable

        if (drawable != null) {
            onDrawableAttached()

            if (isStartImmediately || isStartRequested) {
                start()
            }
        } else {
            animator.cancel()
        }
    }

    enum class RepeatMode(internal val valueAnimatorConst: Int) {
        /**
         * When the animation reaches the end and [repeatCount] is [INFINITE]
         * or a positive value, the animation restarts from the beginning.
         */
        RESTART(ValueAnimator.RESTART),
        /**
         * When the animation reaches the end and [repeatCount] is [INFINITE]
         * or a positive value, the animation reverses direction on every iteration.
         */
        REVERSE(ValueAnimator.REVERSE)
    }
}
