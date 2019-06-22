package com.mikepenz.iconics.dsl

import android.content.Context
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.IIcon

fun Context.iconicsDrawable(icon: IIcon, block: IconicsDrawableDsl.() -> Unit): IconicsDrawable {
    return IconicsDrawable(this).apply {
        icon(icon)
        IconicsDrawableDsl(this).apply(block)
    }
}

internal class NonReadablePropertyException : Exception()

internal fun nonReadable(): Nothing = throw NonReadablePropertyException()

internal const val NON_READABLE = "Non readable property."

class IconicsDrawableDsl(internal val drawable: IconicsDrawable) {

    fun sizePx(px: Number): IconicsSize = IconicsSize.px(px)
    fun sizeDp(dp: Number): IconicsSize = IconicsSize.dp(dp)
    fun sizeRes(res: Int): IconicsSize = IconicsSize.res(res)

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
}