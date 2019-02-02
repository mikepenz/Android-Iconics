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

package com.mikepenz.iconics.ver_four.utils

import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.text.Spanned
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import androidx.annotation.MenuRes
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.LayoutInflaterCompat
import com.mikepenz.iconics.ver_four.Iconics
import com.mikepenz.iconics.ver_four.IconicsArrayBuilder
import com.mikepenz.iconics.ver_four.IconicsDrawable
import com.mikepenz.iconics.ver_four.context.IconicsContextWrapper
import com.mikepenz.iconics.ver_four.context.IconicsLayoutInflater
import com.mikepenz.iconics.ver_four.context.IconicsLayoutInflater2

/** Adaptation for [IconicsContextWrapper] */
fun Context.wrapByIconics(): ContextWrapper {
    return com.mikepenz.iconics.ver_four.context.IconicsContextWrapper.wrap(this)
}

/**
 * Compatible adaptation for setting IconicsLayoutInflater
 * @see IconicsLayoutInflater
 * @see IconicsLayoutInflater2
 * */
@Suppress("DEPRECATION")
fun LayoutInflater.setIconicsFactory(appCompatDelegate: AppCompatDelegate) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LayoutInflaterCompat.setFactory2(this,
                                         com.mikepenz.iconics.ver_four.context.IconicsLayoutInflater2(
                                             appCompatDelegate
                                         )
        )
    } else {
        LayoutInflaterCompat.setFactory(this,
                                        com.mikepenz.iconics.ver_four.context.IconicsLayoutInflater(
                                            appCompatDelegate
                                        )
        )
    }
}

/** Adaptation for [IconicsMenuInflaterUtil.inflate] */
@JvmOverloads
fun MenuInflater.inflateWithIconics(
    context: Context,
    menuId: Int,
    menu: Menu,
    checkSubMenu: Boolean = false
) {
    IconicsMenuInflaterUtil.inflate(this, context, menuId, menu, checkSubMenu)
}

/** Adaptation for [Iconics.Builder] with auto-executing [Iconics.BuilderString.build] */
fun Context.iconicsBuilder(
    block: Iconics.Builder.() -> Iconics.BuilderString
): Spanned {
    val builder = Iconics.Builder().ctx(this)
    return block(builder).build()
}

/** Adaptation for [Iconics.Builder] with auto-executing [Iconics.BuilderView.build] */
fun Context.iconicsBuilder(block: Iconics.Builder.() -> Iconics.BuilderView) {
    val builder = Iconics.Builder().ctx(this)
    block(builder).build()
}

/** Adaptation for [IconicsArrayBuilder] with auto-executing [IconicsArrayBuilder.build] */
fun IconicsDrawable.createArray(
    block: IconicsArrayBuilder.() -> IconicsArrayBuilder
): Array<IconicsDrawable> {
    val builder = IconicsArrayBuilder(this)
    return block(builder).build()
}

@JvmOverloads
fun Menu.parseXmlAndSetIconicsDrawables(
    context: Context,
    @MenuRes menuId: Int,
    checkSubMenu: Boolean = false
) {
    IconicsMenuInflaterUtil.parseXmlAndSetIconicsDrawables(context, menuId, this, checkSubMenu)
}