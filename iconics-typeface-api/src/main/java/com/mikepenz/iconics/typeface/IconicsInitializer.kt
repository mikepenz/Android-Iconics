package com.mikepenz.iconics.typeface

import android.content.Context
import androidx.startup.Initializer

class IconicsInitializer : Initializer<IconicsHolder> {
    override fun create(context: Context): IconicsHolder {
        IconicsHolder.applicationContext = context
        return IconicsHolder
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}