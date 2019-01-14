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

package com.mikepenz.iconics.context

import android.util.Log
import com.mikepenz.iconics.Iconics

import java.lang.reflect.Field
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Base created by Christopher Jenkins
 * https://github.com/chrisjenx/Calligraphy
 */
internal object ReflectionUtils {

    fun getField(clazz: Class<*>, fieldName: String): Field? {
        kotlin.runCatching {
            val f = clazz.getDeclaredField(fieldName)
            f.isAccessible = true
            return f
        }

        return null
    }

    operator fun getValue(field: Field, obj: Any): Any? {
        return kotlin.runCatching { field.get(obj) }.getOrNull()
    }

    operator fun setValue(field: Field, obj: Any, value: Any) {
        kotlin.runCatching { field.set(obj, value) }
    }

    fun getMethod(clazz: Class<*>, methodName: String): Method? {
        return clazz.methods.firstOrNull { it.name == methodName }?.also { it.isAccessible = true }
    }

    fun invokeMethod(obj: Any, method: Method?, vararg args: Any) {
        try {
            method?.invoke(obj, *args)
        } catch (e: IllegalAccessException) {
            Log.e(Iconics.TAG, "Can't invoke method using reflection", e)
        } catch (e: InvocationTargetException) {
            Log.e(Iconics.TAG, "Can't invoke method using reflection", e)
        }
    }
}