package com.mikepenz.iconics.utils

import android.util.Log

/**
 * @author pa.gulko zTrap (01.04.2019)
 */
interface IconicsLogger {
    fun log(priority: Int, tag: String, msg: String, t: Throwable? = null)

    companion object {
        @JvmField val DEFAULT = object : IconicsLogger {
            override fun log(priority: Int, tag: String, msg: String, t: Throwable?) {
                Log.println(priority, tag, msg)
                t?.let { Log.println(priority, tag, Log.getStackTraceString(it)) }
            }
        }
    }
}