/*
 * Copyright 2017 Mike Penz
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

package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuInflater;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.IconicsViewsAttrsReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by flisar on 23.05.2017.
 */
public class IconicsMenuInflaterUtil {

    /**
     * Menu tag name in XML.
     */
    private static final String XML_MENU = "menu";

    /**
     * Item tag name in XML.
     */
    private static final String XML_ITEM = "item";

    /*
     * Default menu inflater
     * Uses the IconicsImageView styleable tags to get the iconics data of menu items
     */
    public static void inflate(MenuInflater inflater, Context context, int menuId, Menu menu) {
        inflate(inflater, context, menuId, menu, false);
    }

    /*
     * Default menu inflater
     * Uses the IconicsImageView styleable tags to get the iconics data of menu items
     *
     * By default, menus don't show icons for sub menus, but this can be enabled via reflection
     * So use this function if you want that sub menu icons are checked as well
     */
    public static void inflate(MenuInflater inflater, Context context, int menuId, Menu menu, boolean checkSubMenus) {
        inflater.inflate(menuId, menu);
        try {
            XmlResourceParser parser = context.getResources().getXml(menuId);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            parseMenu(context, attrs, parser, menu, checkSubMenus);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseMenu(Context context, AttributeSet attrs, XmlPullParser parser, Menu menu, boolean checkSubMenus) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        String tagName;
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;

        // This loop will skip to the menu start tag
        do {
            if (eventType == XmlPullParser.START_TAG) {
                tagName = parser.getName();
                if (XML_MENU.equals(tagName)) {
                    // Go to next tag
                    eventType = parser.next();
                    break;
                }

                throw new RuntimeException("Expecting menu, got " + tagName);
            }
            eventType = parser.next();
        } while (eventType != XmlPullParser.END_DOCUMENT);

        boolean reachedEndOfMenu = false;
        while (!reachedEndOfMenu) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (lookingForEndOfUnknownTag) {
                        break;
                    }
                    tagName = parser.getName();
                    switch (tagName) {
                        case XML_ITEM:
                            HashMap<String, String> attrsMap = new HashMap<>();
                            for (int i = 0; i < parser.getAttributeCount(); i++) {
                                attrsMap.put(parser.getAttributeName(i), parser.getAttributeValue(i));
                            }
                            IconicsDrawable icon = IconicsViewsAttrsReader.getIconicsImageViewDrawable(context, attrs);
                            if (icon != null) {
                                int id = Integer.parseInt(attrsMap.get("id").replace("@", ""));
                                menu.findItem(id).setIcon(icon);
                            }
                            break;

                        case XML_MENU:
                            // TODO: maybe we must pass in the sub menu in this case, not sure if the function menu.findItem(id) will search through sub items
                            if (checkSubMenus) {
                                parseMenu(context, attrs, parser, menu, checkSubMenus);
                            }
                            break;

                        default:
                            lookingForEndOfUnknownTag = true;
                            unknownTagName = tagName;
                            break;
                    }
                    break;

                case XmlPullParser.END_TAG:
                    tagName = parser.getName();
                    if (lookingForEndOfUnknownTag && tagName.equals(unknownTagName)) {
                        lookingForEndOfUnknownTag = false;
                        unknownTagName = null;
                    } else if (XML_MENU.equals(tagName)) {
                        reachedEndOfMenu = true;
                    }
                    break;

                case XmlPullParser.END_DOCUMENT:
                    throw new RuntimeException("Unexpected end of document");
            }
            eventType = parser.next();
        }
    }
}