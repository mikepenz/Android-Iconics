package com.mikepenz.iconics.dsl

import android.content.Context
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsExtractor
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.IIcon

fun Context.iconicsDrawable(icon: (IconicsIconDsl.() -> IIcon)? = null, block: IconicsDrawable.() -> Unit): IconicsDrawable {
    return IconicsDrawable(this).apply {
        if (icon != null) {
            icon(IconicsIconDsl.icon())
        }
    }.apply(block)
}


object IconicsIconDsl

internal class NonReadablePropertyException : Exception()

internal fun nonReadable(): Nothing = throw NonReadablePropertyException()

internal const val NON_READABLE = "Non readable property."

class IconicsDrawableDsl(internal val drawable: IconicsDrawable) {
    var sizeX: IconicsSize = IconicsSize.px(IconicsExtractor.DEF_SIZE)
        @Deprecated(level = DeprecationLevel.ERROR, message = NON_READABLE)
        get() = nonReadable()
}