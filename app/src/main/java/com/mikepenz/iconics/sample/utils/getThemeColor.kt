package com.mikepenz.iconics.sample.utils

import android.content.Context
import android.util.TypedValue
import androidx.core.content.ContextCompat

fun Context.getThemeColor(attr: Int): Int {
    val tv = TypedValue()
    return if (this.theme.resolveAttribute(attr, tv, true)) {
        if (tv.resourceId != 0) {
            ContextCompat.getColor(this, tv.resourceId)
        } else {
            tv.data
        }
    } else {
        0
    }
}