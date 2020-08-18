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
import androidx.appcompat.widget.AppCompatButton
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.animation.tryToEnableIconicsAnimation
import com.mikepenz.iconics.internal.CompoundIconicsDrawables
import com.mikepenz.iconics.internal.CompoundIconsBundle
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier
import com.mikepenz.iconics.utils.buildIconics

open class IconicsButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = R.attr.buttonStyle
) : AppCompatButton(context, attrs, defStyle), CompoundIconicsDrawables {
    private val iconsBundle = CompoundIconsBundle()

    //region CompoundIconicsDrawablesImpl
    override var iconicsDrawableStart: IconicsDrawable?
        get() = iconsBundle.startIcon
        set(value) {
            iconsBundle.startIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    override var iconicsDrawableTop: IconicsDrawable?
        get() = iconsBundle.startIcon
        set(value) {
            iconsBundle.startIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    override var iconicsDrawableEnd: IconicsDrawable?
        get() = iconsBundle.startIcon
        set(value) {
            iconsBundle.startIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    override var iconicsDrawableBottom: IconicsDrawable?
        get() = iconsBundle.startIcon
        set(value) {
            iconsBundle.startIcon = tryToEnableIconicsAnimation(value)
            setIcons()
        }

    init {
        IconicsViewsAttrsApplier.readIconicsTextView(context, attrs, iconsBundle)
        //setting created icons
        iconsBundle.apply { tryToEnableIconicsAnimation(bottomIcon, topIcon, endIcon, startIcon) }
        setIcons()
    }

    private fun setIcons() {
        iconsBundle.setIcons(this)
    }

    override fun setDrawableForAll(drawable: IconicsDrawable?) {
        iconsBundle.apply {
            startIcon = tryToEnableIconicsAnimation(drawable)
            topIcon = tryToEnableIconicsAnimation(drawable)
            endIcon = tryToEnableIconicsAnimation(drawable)
            bottomIcon = tryToEnableIconicsAnimation(drawable)
        }
        setIcons()
    }
    //endregion

    override fun setText(text: CharSequence, type: TextView.BufferType) {
        // NOTES:
        // 1. Need to disable the All Caps option to make Spannable work properly!
        // 2. This method will be called from the constructor of the super class
        isAllCaps = false

        if (!isInEditMode) {
            super.setText(text.buildIconics(), type)
        } else {
            super.setText(text, type)
        }
    }
}
