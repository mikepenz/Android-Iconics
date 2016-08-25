package com.mikepenz.iconics.utils;

import android.content.Context;
import android.text.Editable;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
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

    public static char ICON_START = '{';
    public static char ICON_END = '}';

    /**
     * finds the icons within a Editable, and tries to map the the available (given via the fonts param) icons on it
     * Use this whenever possible, as this method does update the Editable, and does not have to create a new Spanned
     *
     * @param editable
     * @param fonts
     * @return
     */
    public static LinkedList<StyleContainer> findIconsFromEditable(Editable editable, HashMap<String, ITypeface> fonts) {
        LinkedList<StyleContainer> styleContainers = new LinkedList<>();
        LinkedList<StyleContainer> existingSpans = new LinkedList<>();

        // remember the previous style spans
        for (ParcelableSpan span : editable.getSpans(0, editable.length(), ParcelableSpan.class)) {
            existingSpans.add(new StyleContainer(editable.getSpanStart(span), editable.getSpanEnd(span), span, editable.getSpanFlags(span)));
        }
        for (CharacterStyle span : editable.getSpans(0, editable.length(), CharacterStyle.class)) {
            existingSpans.add(new StyleContainer(editable.getSpanStart(span), editable.getSpanEnd(span), span, editable.getSpanFlags(span)));
        }
        try {
            editable.clearSpans();
        } catch (Exception ex) {
            //SpannableStringBuilder has an issue which causes this to crash
            //https://github.com/mikepenz/Android-Iconics/issues/155#issue-141629137
        }

        int iconStart = -1;
        for (int i = 0; i < editable.length(); i++) {
            Character c = editable.charAt(i);
            if (c == ICON_START) {
                iconStart = i;
            } else if (c == ICON_END) {
                if (iconStart > -1) {
                    StyleContainer styleContainer = placeFontIcon(editable, iconStart, i, fonts);

                    if (styleContainer != null) {
                        styleContainers.add(styleContainer);

                        //adjust existing spans to new position
                        for (StyleContainer existingStyleContainer : existingSpans) {
                            if (existingStyleContainer.startIndex > i) {
                                existingStyleContainer.startIndex = existingStyleContainer.startIndex - (i - iconStart);
                                existingStyleContainer.endIndex = existingStyleContainer.endIndex - (i - iconStart);
                            } else if (existingStyleContainer.endIndex > i) {
                                existingStyleContainer.endIndex = existingStyleContainer.endIndex - (i - iconStart);
                            }
                        }

                        //remember how many chars were removed already so we can remove the correct characters
                        i = i - iconStart;
                    }
                }

                iconStart = -1;
            }
        }

        //add the existing spans
        styleContainers.addAll(existingSpans);

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
     * finds the icons within a Spanned, and tries to map the the available (given via the fonts param) icons on it
     *
     * @param spannable
     * @param fonts
     * @return
     */
    public static TextStyleContainer findIcons(Spanned spannable, HashMap<String, ITypeface> fonts) {
        LinkedList<StyleContainer> styleContainers = new LinkedList<>();
        LinkedList<StyleContainer> existingSpans = new LinkedList<>();

        // remember the previous style spans
        for (ParcelableSpan span : spannable.getSpans(0, spannable.length(), ParcelableSpan.class)) {
            existingSpans.add(new StyleContainer(spannable.getSpanStart(span), spannable.getSpanEnd(span), span, spannable.getSpanFlags(span)));
        }
        for (CharacterStyle span : spannable.getSpans(0, spannable.length(), CharacterStyle.class)) {
            existingSpans.add(new StyleContainer(spannable.getSpanStart(span), spannable.getSpanEnd(span), span, spannable.getSpanFlags(span)));
        }

        //the new string built with the replaced icons
        SpannableStringBuilder spannedString = new SpannableStringBuilder();
        SpannableStringBuilder tempIconString = new SpannableStringBuilder();

        int removedChars = 0;
        for (int i = 0; i < spannable.length(); i++) {
            Character c = spannable.charAt(i);
            if (c == ICON_START) {
                //if something started with { but was no icon replacement
                spannedString.append(tempIconString);
                //start to remember the tempIconString again
                tempIconString = new SpannableStringBuilder();
                tempIconString.append(c);
            } else if (c == ICON_END) {
                tempIconString.append(c);
                //make sure there was a { before and enough chars for the font key
                if (tempIconString.length() > 5) {
                    StyleContainer styleContainer = placeFontIcon(spannedString, tempIconString, fonts);
                    if (styleContainer != null) {
                        styleContainers.add(styleContainer);

                        //adjust existing spans to new position
                        for (StyleContainer existingStyleContainer : existingSpans) {
                            if (existingStyleContainer.startIndex > i - removedChars) {
                                existingStyleContainer.startIndex = existingStyleContainer.startIndex - tempIconString.length() + 1;
                            }
                            if (existingStyleContainer.endIndex > i - removedChars) {
                                existingStyleContainer.endIndex = existingStyleContainer.endIndex - tempIconString.length() + 1;
                            }
                        }
                        removedChars += tempIconString.length() - 1;
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

        //add the existing spans
        styleContainers.addAll(existingSpans);

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
     * Applies all given styles on the given Spannable
     *
     * @param ctx
     * @param text            the text which will get the Styles applied
     * @param styleContainers all styles to apply
     * @param styles          additional CharacterStyles to apply
     * @param stylesFor       additional styles to apply for specific icons
     */
    public static void applyStyles(Context ctx, Spannable text, List<StyleContainer> styleContainers, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
        for (StyleContainer styleContainer : styleContainers) {
            if (styleContainer.style != null) {
                text.setSpan(styleContainer.style, styleContainer.startIndex, styleContainer.endIndex, styleContainer.flags);
            } else if (styleContainer.span != null) {
                text.setSpan(styleContainer.span, styleContainer.startIndex, styleContainer.endIndex, styleContainer.flags);
            } else {
                text.setSpan(new IconicsTypefaceSpan("sans-serif", styleContainer.font.getTypeface(ctx)), styleContainer.startIndex, styleContainer.endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            if (stylesFor != null && stylesFor.containsKey(styleContainer.icon)) {
                for (CharacterStyle style : stylesFor.get(styleContainer.icon)) {
                    text.setSpan(CharacterStyle.wrap(style), styleContainer.startIndex, styleContainer.endIndex, styleContainer.flags);
                }
            } else if (styles != null) {
                for (CharacterStyle style : styles) {
                    text.setSpan(CharacterStyle.wrap(style), styleContainer.startIndex, styleContainer.endIndex, styleContainer.flags);
                }
            }
        }
    }
}
