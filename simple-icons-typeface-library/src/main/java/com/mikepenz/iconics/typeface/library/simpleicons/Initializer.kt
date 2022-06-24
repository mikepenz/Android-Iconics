package com.mikepenz.iconics.typeface.library.simpleicons

import android.content.Context
import androidx.startup.Initializer
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.typeface.IconicsHolder
import com.mikepenz.iconics.typeface.IconicsInitializer

class Initializer : Initializer<ITypeface> {
    override fun create(context: Context): ITypeface {
        IconicsHolder.registerFont(SimpleIcons)
        return SimpleIcons
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(IconicsInitializer::class.java)
    }
}
