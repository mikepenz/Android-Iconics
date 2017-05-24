package com.mikepenz.iconics.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.IconicsDrawable;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by flisar on 23.05.2017.
 */

public class IconicsMenuInflatorUtil
{
    /*
     * Default menu inflator
     * Uses the IconicsImageView styleable tags to get the iconics data of menu items
     */
    public static void inflate(MenuInflater inflator, Context context, int menuId, Menu menu) {
        inflate(inflator, context, menuId, menu, false);
    }

    /*
     * Default menu inflator
     * Uses the IconicsImageView styleable tags to get the iconics data of menu items
     *
     * By default, menus don't show icons for sub menus, but this can be enabled via reflection
     * So use this function if you want that sub menu icons are checked as well
     */
    public static void inflate(MenuInflater inflator, Context context, int menuId, Menu menu, boolean checkSubMenus) {
        inflator.inflate(menuId, menu);
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

    private static void parseMenu(Context context,  AttributeSet attrs, XmlPullParser parser, Menu menu, boolean checkSubMenus) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        String tagName;
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;

        // This loop will skip to the menu start tag
        do {
            if (eventType == XmlPullParser.START_TAG) {
                tagName = parser.getName();
                if (tagName.equals("menu")) {
                    // Go to next tag
                    eventType = parser.next();
                    break;
                }

                throw new RuntimeException("Expecting menu, got " + tagName);
            }
            eventType = parser.next();
        } while (eventType != XmlPullParser.END_DOCUMENT);

        int color = 0;
        int size = -1;
        int padding = -1;
        int contourColor = 0;
        int contourWidth = -1;
        int backgroundColor = 0;
        int cornerRadius = -1;

        boolean reachedEndOfMenu = false;
        while (!reachedEndOfMenu) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (lookingForEndOfUnknownTag) {
                        break;
                    }

                    tagName = parser.getName();
                    if (tagName.equals("group")) {
                       //
                    } else if (tagName.equals("item")) {

                        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsImageView);
                        String icon = a.getString(R.styleable.IconicsImageView_iiv_icon);
                        if (icon != null) {
                            color = a.getColor(R.styleable.IconicsImageView_iiv_color, 0);
                            size = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_size, -1);
                            padding = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_padding, -1);
                            contourColor = a.getColor(R.styleable.IconicsImageView_iiv_contour_color, 0);
                            contourWidth = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_contour_width, -1);
                            backgroundColor = a.getColor(R.styleable.IconicsImageView_iiv_background_color, 0);
                            cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_corner_radius, -1);

                            int id = Integer.parseInt(parser.getAttributeValue(null, "id").replace("@", ""));
                            MenuItem item = menu.findItem(id);
                            IconicsDrawable iconicsDrawable = new IconicsDrawable(context).icon(icon);
                            setAttributes(iconicsDrawable, color, size, padding, contourColor, contourWidth, backgroundColor, cornerRadius);
                            item.setIcon(iconicsDrawable);
                        }
                        a.recycle();

                    } else if (tagName.equals("menu")) {

                        // TODO: maybe we must pass in the sub menu in this case, not sure if the function menu.findItem(id) will search through sub items
                        if (checkSubMenus)
                            parseMenu(context, attrs, parser, menu, checkSubMenus);
                    } else {
                        lookingForEndOfUnknownTag = true;
                        unknownTagName = tagName;
                    }
                    break;

                case XmlPullParser.END_TAG:
                    tagName = parser.getName();
                    if (lookingForEndOfUnknownTag && tagName.equals(unknownTagName)) {
                        lookingForEndOfUnknownTag = false;
                        unknownTagName = null;
                    } else if (tagName.equals("group")) {
                       //
                    } else if (tagName.equals("item")) {
                        // Add the item if it hasn't been added (if the item was
                        // a submenu, it would have been added already)
                        //if (!menuState.hasAddedItem()) {
                           // menuState.addItem();
                        //}
                    } else if (tagName.equals("menu")) {
                        reachedEndOfMenu = true;
                    }
                    break;

                case XmlPullParser.END_DOCUMENT:
                    throw new RuntimeException("Unexpected end of document");
            }

            eventType = parser.next();
        }
    }

    private static void setAttributes(IconicsDrawable icon, int color, int size, int padding, int contourColor, int contourWidth, int backgroundColor, int cornerRadius) {
        if (color != 0) {
            icon.color(color);
        }
        if (size != -1) {
            icon.sizePx(size);
        }
        if (padding != -1) {
            icon.paddingPx(padding);
        }
        if (contourColor != 0) {
            icon.contourColor(contourColor);
        }
        if (contourWidth != -1) {
            icon.contourWidthPx(contourWidth);
        }
        if (backgroundColor != 0) {
            icon.backgroundColor(backgroundColor);
        }
        if (cornerRadius != -1) {
            icon.roundedCornersPx(cornerRadius);
        }
    }
}