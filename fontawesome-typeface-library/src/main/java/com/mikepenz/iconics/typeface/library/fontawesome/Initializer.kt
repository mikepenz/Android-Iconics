package com.mikepenz.iconics.typeface.library.fontawesome

import android.content.Context
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.typeface.IconicsHolder
import com.mikepenz.iconics.typeface.IconicsInitializer

class Initializer : androidx.startup.Initializer<ITypeface> {
    override fun create(context: Context): ITypeface {
        IconicsHolder.registerFont(FontAwesome)
        IconicsHolder.registerFont(FontAwesomeBrand)
        IconicsHolder.registerFont(FontAwesomeRegular)
        return FontAwesome
    }

    override fun dependencies(): List<Class<out androidx.startup.Initializer<*>>> {
        return listOf(IconicsInitializer::class.java)
    }
}