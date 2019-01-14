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

package com.mikepenz.iconics.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP
import androidx.appcompat.widget.AppCompatTextView
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.internal.CompoundIconicsDrawables
import com.mikepenz.iconics.internal.CompoundIconsBundle
import com.mikepenz.iconics.internal.IconicsView
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier

open class IconicsTextView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = android.R.attr.textViewStyle
) : AppCompatTextView(context, attrs, defStyle), CompoundIconicsDrawables, IconicsView {
    internal val iconsBundle = CompoundIconsBundle()

    //region CompoundIconicsDrawablesImpl
    override var iconicsDrawableStart: IconicsDrawable?
        get() = iconsBundle.startIcon
        set(value) {
            iconsBundle.startIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    override var iconicsDrawableTop: IconicsDrawable?
        get() = iconsBundle.topIcon
        set(value) {
            iconsBundle.topIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    override var iconicsDrawableEnd: IconicsDrawable?
        get() = iconsBundle.endIcon
        set(value) {
            iconsBundle.endIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    override var iconicsDrawableBottom: IconicsDrawable?
        get() = iconsBundle.bottomIcon
        set(value) {
            iconsBundle.bottomIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    init {
        @Suppress("LeakingThis")
        initialize(context, attrs, defStyle)
    }

    @RestrictTo(LIBRARY_GROUP)
    override fun initialize(context: Context, attrs: AttributeSet?, defStyle: Int) {
        applyAttr(context, attrs, defStyle)
        tryToEnableIconicsAnimation(
                iconsBundle.bottomIcon,
                iconsBundle.topIcon,
                iconsBundle.endIcon,
                iconsBundle.startIcon
        )
        setIcons()
    }

    @RestrictTo(LIBRARY_GROUP)
    override fun applyAttr(context: Context, attrs: AttributeSet?, defStyle: Int) {
        IconicsViewsAttrsApplier.readIconicsTextView(context, attrs, iconsBundle)
    }

    private fun setIcons() {
        iconsBundle.setIcons(this)
    }

    override fun setDrawableForAll(drawable: IconicsDrawable?) {
        iconsBundle.startIcon = tryToEnableIconicsAnimation(drawable)
        iconsBundle.topIcon = tryToEnableIconicsAnimation(drawable)
        iconsBundle.endIcon = tryToEnableIconicsAnimation(drawable)
        iconsBundle.bottomIcon = tryToEnableIconicsAnimation(drawable)
        setIcons()
    }
    //endregion

    override fun setText(text: CharSequence, type: TextView.BufferType) {
        if (!isInEditMode) {
            super.setText(Iconics.IconicsBuilder().ctx(context).on(text).build(), type)
        } else {
            super.setText(text, type)
        }
    }
}
