/*
 * Copyright 2019 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics.utils

import android.content.Context
import java.lang.reflect.Field

/**
 * Created by mikepenz on 03.08.15.
 */
object GenericsUtil {

    /** Helper to get the string fields with name starts "define_font_" from the R class */
    @JvmStatic fun getDefinedFonts(ctx: Context): Array<out String> {
        return resolveRClass(ctx.packageName)?.let { getDefinedFonts(ctx, it.fields) }.orEmpty()
    }

    /** Helper to get the string fields with name starts "define_processor_" from the R class */
    @JvmStatic fun getDefinedProcessors(ctx: Context): Array<out String> {
        return resolveRClass(ctx.packageName)?.let { getDefinedProcessors(ctx, it.fields) }
                .orEmpty()
    }

    /** Helper to resolve the correct R Class for the package */
    @JvmStatic private fun resolveRClass(packageName: String): Class<*>? {
        var tempPackageName = packageName
        do {
            try {
                return Class.forName("$tempPackageName.R\$string")
            } catch (e: ClassNotFoundException) {
                tempPackageName = tempPackageName.substringBeforeLast('.', "")
            }
        } while (tempPackageName.isNotBlank())

        return null
    }

    /**
     * Helper to get a array of strings out of a fieldArray
     *
     * @param fields R.strings.class.getFields()
     * @return a array of strings with the string ids we need
     */
    @JvmStatic private fun getDefinedFonts(ctx: Context, fields: Array<Field>): Array<String> {
        return fields.filter { it.name.contains("define_font_") }
                .map { getStringResourceByName(ctx, it.name) }
                .toTypedArray()
    }

    /**
     * A helper method to get a String[] out of a fieldArray
     *
     * @param fields R.strings.class.getFields()
     * @return a array of strings with the string ids we need
     */
    @JvmStatic private fun getDefinedProcessors(ctx: Context, fields: Array<Field>): Array<String> {
        return fields.filter { it.name.contains("define_processor_") }
                .map { getStringResourceByName(ctx, it.name) }
                .toTypedArray()
    }

    /** A helper method to retrieve a string by it's resource name */
    @JvmStatic private fun getStringResourceByName(ctx: Context, resourceName: String): String {
        val resId = ctx.resources.getIdentifier(resourceName, "string", ctx.packageName)
        return if (resId == 0) "" else ctx.getString(resId)
    }
}