package com.mikepenz.iconics.dsl

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.Typeface
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.IIcon

// Notify user that the DSL is currently experimental
@Experimental(level = Experimental.Level.WARNING)
annotation class ExperimentalIconicsDSL

@ExperimentalIconicsDSL
fun Context.iconicsDrawable(icon: IIcon, block: IconicsDrawableDsl.() -> Unit): IconicsDrawable {
    return IconicsDrawable(this).apply {
        icon(icon)
        IconicsDrawableDsl(this).apply(block)
    }
}

@ExperimentalIconicsDSL
fun Context.iconicsDrawable(
    icon: String,
    typeface: Typeface? = null,
    block: IconicsDrawableDsl.() -> Unit
): IconicsDrawable {
    return IconicsDrawable(this).apply {
        iconText(icon, typeface)
        IconicsDrawableDsl(this).apply(block)
    }
}

internal class NonReadablePropertyException : Exception()

internal fun nonReadable(): Nothing = throw NonReadablePropertyException()

internal const val NON_READABLE = "Non readable property."

@ExperimentalIconicsDSL
open class IconicsDrawableDsl(internal val drawable: IconicsDrawable) {

    fun sizePx(size: Number): IconicsSize = IconicsSize.px(size)
    fun sizeDp(size: Number): IconicsSize = IconicsSize.dp(size)
    fun sizeRes(@DimenRes size: Int): IconicsSize = IconicsSize.res(size)

    fun colorString(color: String): IconicsColor = IconicsColor.parse(color)
    fun colorRes(@ColorRes color: Int): IconicsColor = IconicsColor.colorRes(color)
    fun colorInt(@ColorInt color: Int): IconicsColor = IconicsColor.colorInt(color)
    fun colorList(color: ColorStateList): IconicsColor = IconicsColor.colorList(color)

    var sizeX: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.sizeX(value)
        }

    var sizeY: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.sizeY(value)
        }

    var size: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.size(value)
        }

    var iconOffsetX: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.iconOffsetX(value)
        }

    var iconOffsetY: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.iconOffsetY(value)
        }

    var padding: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.padding(value)
        }

    var color: IconicsColor
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.color(value)
        }

    var roundedCornersRx: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.roundedCornersRx(value)
        }

    var roundedCornerRy: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.roundedCornersRy(value)
        }

    var roundedCorners: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.roundedCorners(value)
        }

    var backgroundColor: IconicsColor
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.backgroundColor(value)
        }

    var contourWidth: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.contourWidth(value)
        }

    var backgroundContourWidth: IconicsSize
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.backgroundContourWidth(value)
        }

    var drawContour: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.drawContour(value)
        }

    var drawBackgroundContour: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.drawBackgroundContour(value)
        }

    var colorFilter: ColorFilter?
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.colorFilter(value)
        }

    var tintList: ColorStateList?
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.setTintList(value)
        }

    var tintMode: PorterDuff.Mode?
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.setTintMode(value)
        }

    var style: Paint.Style
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.style(value)
        }

    var actionBarSize: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            if (value) {
                drawable.actionBar()
            }
        }

    var respectFontBounds: Boolean
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
        set(value) {
            drawable.respectFontBounds(value)
        }
}