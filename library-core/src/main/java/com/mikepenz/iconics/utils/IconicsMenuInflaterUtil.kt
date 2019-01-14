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

package com.mikepenz.iconics.utils

import android.content.Context
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
import java.util.*

/**
 * Created by flisar on 23.05.2017.
 */
object IconicsMenuInflaterUtil {

    /** Menu tag name in XML. */
    private const val XML_MENU = "menu"

    /** Item tag name in XML. */
    private const val XML_ITEM = "item"

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
        try {
            val parser = context.resources.getXml(menuId)
            val attrs = Xml.asAttributeSet(parser)
            parseMenu(context, attrs, parser, menu, checkSubMenus)
        } catch (e: XmlPullParserException) {
            Log.e(Iconics.TAG, "Error while parse menu", e)
        } catch (e: IOException) {
            Log.e(Iconics.TAG, "Error while parse menu", e)
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
        var eventType = parser.eventType
        var tagName: String
        var lookingForEndOfUnknownTag = false
        var unknownTagName: String? = null

        // This loop will skip to the menu start tag
        do {
            if (eventType == XmlPullParser.START_TAG) {
                tagName = parser.name
                if (XML_MENU == tagName) {
                    // Go to next tag
                    eventType = parser.next()
                    break
                }

                throw RuntimeException("Expected <menu> tag but got $tagName")
            }
            eventType = parser.next()
        } while (eventType != XmlPullParser.END_DOCUMENT)

        var reachedEndOfMenu = false
        while (!reachedEndOfMenu) {
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    if (!lookingForEndOfUnknownTag) {
                        tagName = parser.name
                        when (tagName) {
                            XML_ITEM -> {
                                val attrsMap = HashMap<String, String>()
                                for (i in 0 until parser.attributeCount) {
                                    attrsMap[parser.getAttributeName(i)] =
                                            parser.getAttributeValue(i)
                                }
                                val icon = IconicsAttrsApplier.getIconicsDrawable(context, attrs)
                                if (icon != null) {
                                    var idAsString = attrsMap["id"]!!.replace("@", "")

                                    //If the id is not in literal format, look it up using the name.
                                    idAsString = idAsString.removePrefix("+id/")

                                    val id = context.resources.getIdentifier(
                                        idAsString,
                                        "id",
                                        context.packageName
                                    )
                                    menu.findItem(id).icon = icon
                                }
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
                XmlPullParser.END_DOCUMENT -> throw RuntimeException("Unexpected end of document")
            }
            eventType = parser.next()
        }
    }
}