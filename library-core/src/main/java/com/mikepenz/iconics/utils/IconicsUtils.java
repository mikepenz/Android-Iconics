package com.mikepenz.iconics.utils;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.util.Log;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mikepenz on 05.11.15.
 */
public class IconicsUtils {
    /**
     * @param editable
     * @param fonts
     * @return
     */
    public static LinkedList<StyleContainer> findIconsFromEditable(Editable editable, HashMap<String, ITypeface> fonts) {
        LinkedList<StyleContainer> styleContainers = new LinkedList<>();
        //the new string built with the replaced icons

        int iconStart = -1;
        for (int i = 0; i < editable.length(); i++) {
            Character c = editable.charAt(i);
            if (c == '{') {
                iconStart = i;
            } else if (c == '}') {
                if (iconStart > -1) {
                    StyleContainer styleContainer = placeFontIcon(editable, iconStart, i, fonts);

                    if (styleContainer != null) {
                        styleContainers.add(styleContainer);

                        //remember how many chars were removed already so we can remove the correct characters
                        i = i - iconStart;
                    }
                }

                iconStart = -1;
            }
        }

        return styleContainers;
    }

    /**
     * @param editable
     * @param iconStart
     * @param iconEnd
     * @param fonts
     * @return
     */
    private static StyleContainer placeFontIcon(Editable editable, int iconStart, int iconEnd, HashMap<String, ITypeface> fonts) {
        //make sure to check only for possible icons
        if (iconEnd - iconStart >= 6) {
            //build the iconString
            String iconString = editable.subSequence(iconStart + 1, iconEnd).toString().replace("-", "_");
            //find out the fontKey
            String fontKey = editable.subSequence(iconStart + 1, iconStart + 4).toString();

            try {
                //get the correct character for this Font and Icon
                ITypeface typeface = fonts.get(fontKey);
                if (typeface != null) {
                    //get the icon for the iconString
                    IIcon icon = typeface.getIcon(iconString);
                    //we can only add an icon which is a font
                    if (icon != null) {
                        //get and add the mapped char to the string
                        char fontChar = icon.getCharacter();
                        editable.replace(iconStart, iconEnd + 1, String.valueOf(fontChar));

                        //add the current icon to the container
                        return new StyleContainer(iconStart, iconStart + 1, iconString, fonts.get(fontKey));
                    } else {
                        Log.e(Iconics.TAG, "Wrong icon name: " + iconString);
                    }
                } else {
                    Log.e(Iconics.TAG, "Wrong fontId: " + iconString);
                }
            } catch (IllegalArgumentException e) {
                Log.e(Iconics.TAG, "Wrong icon name: " + iconString);
            }
        }
        return null;
    }

    /**
     * @param spannable
     * @param fonts
     * @return
     */
    public static TextStyleContainer findIcons(Spannable spannable, HashMap<String, ITypeface> fonts) {
        LinkedList<StyleContainer> styleContainers = new LinkedList<>();
        //the new string built with the replaced icons
        SpannableStringBuilder spannedString = new SpannableStringBuilder();
        SpannableStringBuilder tempIconString = new SpannableStringBuilder();

        for (int i = 0; i < spannable.length(); i++) {
            Character c = spannable.charAt(i);
            if (c == '{') {
                //if something started with { but was no icon replacement
                spannedString.append(tempIconString);
                //start to remember the tempIconString again
                tempIconString = new SpannableStringBuilder();
                tempIconString.append(c);
            } else if (c == '}') {
                tempIconString.append(c);
                //make sure there was a { before and enough chars for the font key
                if (tempIconString.length() > 5) {
                    StyleContainer styleContainer = placeFontIcon(spannedString, tempIconString, fonts);
                    if (styleContainer != null) {
                        styleContainers.add(styleContainer);
                    }
                } else {
                    spannedString.append(tempIconString);
                }
                tempIconString = new SpannableStringBuilder();
            } else {
                if (tempIconString.length() == 0) {
                    spannedString.append(c);
                } else {
                    tempIconString.append(c);
                }
            }
        }
        //make sure to add the last characters which create no complete icon
        spannedString.append(tempIconString);

        return new TextStyleContainer(spannedString, styleContainers);
    }

    /**
     * @param spannedString
     * @param tempIconString
     * @param fonts
     * @return
     */
    private static StyleContainer placeFontIcon(SpannableStringBuilder spannedString, SpannableStringBuilder tempIconString, HashMap<String, ITypeface> fonts) {
        //make sure to check only for possible icons
        if (tempIconString.length() >= 6) {
            //build the iconString
            String iconString = tempIconString.subSequence(1, tempIconString.length() - 1).toString().replace("-", "_");
            //find out the fontKey
            String fontKey = tempIconString.subSequence(1, 4).toString();

            try {
                //get the correct character for this Font and Icon
                ITypeface typeface = fonts.get(fontKey);
                if (typeface != null) {
                    //get the icon for the iconString
                    IIcon icon = typeface.getIcon(iconString);
                    //we can only add an icon which is a font
                    if (icon != null) {
                        //get and add the mapped char to the string
                        char fontChar = icon.getCharacter();
                        spannedString.append(fontChar);

                        //add the current icon to the container
                        return new StyleContainer(spannedString.length() - 1, spannedString.length(), iconString, fonts.get(fontKey));
                    } else {
                        Log.e(Iconics.TAG, "Wrong icon name: " + iconString);
                    }
                } else {
                    Log.e(Iconics.TAG, "Wrong fontId: " + iconString);
                }
            } catch (IllegalArgumentException e) {
                Log.e(Iconics.TAG, "Wrong icon name: " + iconString);
            }
        }

        //if this was no working icon we add the tempIconString and return null
        spannedString.append(tempIconString);
        return null;
    }

    /**
     * @param ctx
     * @param text
     * @param styleContainers
     * @param styles
     * @param stylesFor
     */
    public static void applyStyles(Context ctx, Spannable text, List<StyleContainer> styleContainers, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
        for (StyleContainer styleContainer : styleContainers) {
            text.setSpan(new IconicsTypefaceSpan("sans-serif", styleContainer.getFont().getTypeface(ctx)), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            if (stylesFor != null && stylesFor.containsKey(styleContainer.getIcon())) {
                for (CharacterStyle style : stylesFor.get(styleContainer.getIcon())) {
                    text.setSpan(CharacterStyle.wrap(style), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            } else if (styles != null) {
                for (CharacterStyle style : styles) {
                    text.setSpan(CharacterStyle.wrap(style), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
    }
}
