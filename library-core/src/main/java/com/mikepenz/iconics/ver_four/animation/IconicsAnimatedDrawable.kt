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

import android.content.Context
import android.graphics.Canvas
import android.view.View
import androidx.core.view.ViewCompat
import com.mikepenz.iconics.ver_four.typeface.IIcon
import com.mikepenz.iconics.ver_four.typeface.ITypeface
import com.mikepenz.iconics.ver_four.IconicsDrawable
import java.util.*

/**
 * @author pa.gulko zTrap (28.11.2018)
 */
open class IconicsAnimatedDrawable : IconicsDrawable {
    private val processors = ArrayList<com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor>()

    constructor(context: Context) : super(context)

    constructor(context: Context, icon: Char) : super(context, icon)

    constructor(context: Context, icon: String) : super(context, icon)

    constructor(context: Context, icon: IIcon) : super(context, icon)

    protected constructor(context: Context, typeface: ITypeface, icon: IIcon) : super(
        context,
        typeface,
        icon
    )

    override fun getAlpha(): Int = iconBrush.alpha

    // FI-LO
    override fun draw(canvas: Canvas) {
        processors.forEach {
            it.processPreDraw(
                canvas,
                iconBrush,
                contourBrush,
                backgroundBrush,
                backgroundContourBrush
            )
        }

        super.draw(canvas)

        processors.reversed().forEach { it.processPostDraw(canvas) }
    }

    /** Attach an [processor][IconicsAnimationProcessor] to this drawable */
    fun processor(processor: com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor): com.mikepenz.iconics.ver_four.animation.IconicsAnimatedDrawable {
        processor.setDrawable(this)
        processors.add(processor)
        return this
    }

    /** Attach an [processors][IconicsAnimationProcessor] to this drawable */
    fun processors(vararg processors: com.mikepenz.iconics.ver_four.animation.IconicsAnimationProcessor): com.mikepenz.iconics.ver_four.animation.IconicsAnimatedDrawable {
        if (processors.isEmpty()) return this
        processors.forEach { processor(it) }
        return this
    }

    /**
     * @return The runner which used for animations. Animations can be easily removed by calling
     * [Runner.unset]
     */
    fun animateIn(view: View): com.mikepenz.iconics.ver_four.animation.IconicsAnimatedDrawable.Runner {
        return com.mikepenz.iconics.ver_four.animation.IconicsAnimatedDrawable.Runner()
                .also { it.setFor(view, this) }
    }

    class Runner internal constructor() {
        private var isAttached = false
        private var view: View? = null
        private var drawable: com.mikepenz.iconics.ver_four.animation.IconicsAnimatedDrawable? = null

        private val listener = object : View.OnAttachStateChangeListener {

            override fun onViewAttachedToWindow(v: View) {
                isAttached = true
                ViewCompat.postOnAnimation(v, object : Runnable {
                    override fun run() {
                        if (isAttached && drawable != null) {
                            v.invalidateDrawable(drawable!!)
                            ViewCompat.postOnAnimation(v, this)
                        }
                    }
                })
            }

            override fun onViewDetachedFromWindow(v: View) {
                isAttached = false
            }
        }

        /**
         * Setup all animations to provided drawable and view
         */
        fun setFor(view: View, drawable: com.mikepenz.iconics.ver_four.animation.IconicsAnimatedDrawable) {
            unset()
            this.view = view
            this.drawable = drawable
            if (ViewCompat.isAttachedToWindow(view)) {
                listener.onViewAttachedToWindow(view)
            }
            view.addOnAttachStateChangeListener(listener)
        }

        /**
         * Clear all animations from previously provided drawable and view
         */
        fun unset() {
            drawable = null
            view?.removeOnAttachStateChangeListener(listener)
            view = null
            isAttached = false
        }
    }
}
