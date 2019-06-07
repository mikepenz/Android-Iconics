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
import android.content.res.XmlResourceParser
import android.util.AttributeSet
import android.util.Log
import android.util.Xml
import android.view.Menu
import android.view.MenuInflater
import com.mikepenz.iconics.Iconics
import com.mikepenz.iconics.context.IconicsAttrsApplier
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException

/**
 * Created by flisar on 23.05.2017.
 */
object IconicsMenuInflaterUtil {

    /** Menu tag name in XML. */
    private const val XML_MENU = "menu"

    /** Item tag name in XML. */
    private const val XML_ITEM = "item"

    private val EOD get() = RuntimeException("Unexpected end of document")

    /**
     * Inflates an menu by resource id and uses the styleable tags to get the iconics data of menu
     * items
     *
     * By default, menus don't show icons for sub menus, but this can be enabled via reflection
     * So use this function if you want that sub menu icons are checked as well
     */
    @JvmStatic
    @JvmOverloads
    fun inflate(
        inflater: MenuInflater,
        context: Context,
        menuId: Int,
        menu: Menu,
        checkSubMenus: Boolean = false
    ) {
        inflater.inflate(menuId, menu)
        parseXmlAndSetIconicsDrawables(context, menuId, menu, checkSubMenus)
    }

    /**
     * Uses the styleable tags to get the iconics data of menu items. Useful for set icons into
     * `BottomNavigationView`
     *
     *
     * By default, menus don't show icons for sub menus, but this can be enabled via reflection
     * So use this function if you want that sub menu icons are checked as well
     */
    @JvmStatic
    @JvmOverloads
    fun parseXmlAndSetIconicsDrawables(
        context: Context,
        menuId: Int,
        menu: Menu,
        checkSubMenus: Boolean = false
    ) {
        var parser: XmlResourceParser? = null
        try {
            parser = context.resources.getLayout(menuId)
            parser.let { parseMenu(context, Xml.asAttributeSet(it), it, menu, checkSubMenus) }
        } catch (e: XmlPullParserException) {
            Iconics.logger.log(Log.ERROR, Iconics.TAG, "Error while parse menu", e)
        } catch (e: IOException) {
            Iconics.logger.log(Log.ERROR, Iconics.TAG, "Error while parse menu", e)
        } finally {
            parser?.close()
        }
    }

    @JvmStatic
    private fun parseMenu(
        context: Context,
        attrs: AttributeSet,
        parser: XmlPullParser,
        menu: Menu,
        checkSubMenus: Boolean
    ) {
        var currentParserEvent = parser.skipToStartMenu()
        var tagName: String
        var lookingForEndOfUnknownTag = false
        var unknownTagName: String? = null

        var reachedEndOfMenu = false
        while (!reachedEndOfMenu) {

            when (currentParserEvent) {
                XmlPullParser.START_TAG -> {
                    if (!lookingForEndOfUnknownTag) {
                        tagName = parser.name

                        when (tagName) {
                            XML_ITEM -> {
                                parseItem(context, attrs, menu)
                            }
                            XML_MENU -> {
                                if (checkSubMenus) {
                                    parseMenu(context, attrs, parser, menu, true)
                                }
                            }
                            else -> {
                                lookingForEndOfUnknownTag = true
                                unknownTagName = tagName
                            }
                        }
                    }
                }
                XmlPullParser.END_TAG -> {
                    tagName = parser.name
                    if (lookingForEndOfUnknownTag && tagName == unknownTagName) {
                        lookingForEndOfUnknownTag = false
                        unknownTagName = null
                    } else if (XML_MENU == tagName) {
                        reachedEndOfMenu = true
                    }
                }
                XmlPullParser.END_DOCUMENT -> {
                    throw EOD
                }
            }

            currentParserEvent = parser.next()
        }
    }

    @JvmStatic
    private fun XmlPullParser.skipToStartMenu(): Int {
        do {
            if (eventType == XmlPullParser.START_TAG) {
                if (XML_MENU == name) {
                    return next()
                }

                throw RuntimeException("Expected <menu> tag but got $name")
            }
        } while (next() != XmlPullParser.END_DOCUMENT)

        throw EOD
    }

    @JvmStatic
    private fun parseItem(
        context: Context,
        attrs: AttributeSet,
        menu: Menu
    ) {
        val attrsMap = mutableMapOf<String, String>()
        repeat(attrs.attributeCount) {
            attrsMap[attrs.getAttributeName(it)] = attrs.getAttributeValue(it)
        }

        attrsMap["id"]
                ?.replace("@", "")
                ?.removePrefix("+id/")
                ?.let { context.resources.getIdentifier(it, "id", context.packageName) }
                ?.let { menu.findItem(it) }
                ?.let { menuItem ->
                    IconicsAttrsApplier.getIconicsDrawable(context, attrs)?.let {
                        menuItem.icon = it
                    }
                }
    }
}