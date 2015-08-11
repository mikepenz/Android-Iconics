/*
 * Copyright 2014 Mike Penz
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
package com.mikepenz.iconics;

import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.GenericsUtil;
import com.mikepenz.iconics.utils.IconicsTypefaceSpan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class Iconics {
    public static final String TAG = Iconics.class.getSimpleName();

    private static HashMap<String, ITypeface> FONTS;

    public static void init(Context ctx) {
        String[] fonts = GenericsUtil.getFields(ctx);

        FONTS = new HashMap<>();
        for (String fontsClassPath : fonts) {
            try {
                ITypeface typeface = (ITypeface) Class.forName(fontsClassPath).newInstance();
                FONTS.put(typeface.getMappingPrefix(), typeface);
            } catch (Exception e) {
                Log.e("Android-Iconics", "Can't init: " + fontsClassPath);
            }
        }
    }

    public static boolean registerFont(ITypeface font) {
        FONTS.put(font.getMappingPrefix(), font);
        return true;
    }

    public static ITypeface getDefault(Context ctx) {
        if (FONTS == null) {
            init(ctx);
        }

        if (FONTS != null && FONTS.size() > 0) {
            return FONTS.entrySet().iterator().next().getValue();
        } else {
            throw new RuntimeException("You have to provide at least one Typeface to use this functionality");
        }
    }

    public static Collection<ITypeface> getRegisteredFonts(Context ctx) {
        if (FONTS == null) {
            init(ctx);
        }

        return FONTS.values();
    }

    public static ITypeface findFont(Context ctx, String key) {
        if (FONTS == null) {
            init(ctx);
        }

        return FONTS.get(key);
    }

    public static ITypeface findFont(IIcon icon) {
        return icon.getTypeface();
    }

    private Iconics() {
        // Prevent instantiation
    }

    private static SpannableString style(Context ctx, HashMap<String, ITypeface> fonts, SpannableString textSpanned, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
        if (FONTS == null) {
            init(ctx);
        }

        if (fonts == null || fonts.size() == 0) {
            fonts = FONTS;
        }

        int startIndex = -1;
        String fontKey = "";

        //remember the position of removed chars
        ArrayList<RemoveInfo> removed = new ArrayList<RemoveInfo>();

        //StringBuilder text = new StringBuilder(textSpanned.toString());
        StringBuilder text = new StringBuilder(textSpanned);

        //find the first "{"
        while ((startIndex = text.indexOf("{", startIndex + 1)) != -1) {
            //make sure we are still within the bounds of the text
            if (text.length() < startIndex + 5) {
                startIndex = -1;
                break;
            }
            //make sure the found text is a real fontKey
            if (!text.substring(startIndex + 4, startIndex + 5).equals("-")) {
                break;
            }
            //get the fontKey
            fontKey = text.substring(startIndex + 1, startIndex + 4).toLowerCase();
            //check if the fontKey is a registeredFont
            if (fonts.containsKey(fontKey)) {
                break;
            }
        }
        if (startIndex == -1) {
            return new SpannableString(text);
        }

        //remember total removed chars
        int removedChars = 0;

        LinkedList<StyleContainer> styleContainers = new LinkedList<StyleContainer>();
        do {
            //get the information from the iconString
            int endIndex = text.substring(startIndex).indexOf("}") + startIndex + 1;
            String iconString = text.substring(startIndex + 1, endIndex - 1);
            iconString = iconString.replaceAll("-", "_").toLowerCase();
            try {
                //get the correct character for this Font and Icon
                ITypeface typeface = fonts.get(fontKey);

                if (typeface != null) {
                    IIcon icon = typeface.getIcon(iconString);
                    //we can only add an icon which is a font
                    if (icon != null) {
                        char fontChar = icon.getCharacter();
                        String iconValue = String.valueOf(fontChar);

                        //get just the icon identifier
                        text = text.replace(startIndex, endIndex, iconValue);

                        //store some info about the removed chars
                        removedChars = removedChars + (endIndex - startIndex);
                        removed.add(new RemoveInfo(startIndex, (endIndex - startIndex - 1), removedChars));

                        //add the current icon to the container
                        styleContainers.add(new StyleContainer(startIndex, startIndex + 1, iconString, fonts.get(fontKey)));
                    } else {
                        Log.e(Iconics.TAG, "Wrong icon name: " + iconString);
                    }
                } else {
                    Log.e(Iconics.TAG, "Wrong fontId: " + iconString);
                }
            } catch (IllegalArgumentException e) {
                Log.e(Iconics.TAG, "Wrong icon name: " + iconString);
            }

            //reset fontKey so we can react if we are at the end but haven't found any more matches
            fontKey = null;

            //check the rest of the text for matches
            while ((startIndex = text.indexOf("{", startIndex + 1)) != -1) {
                //make sure we are still within the bounds
                if (text.length() < startIndex + 5) {
                    startIndex = -1;
                    break;
                }
                //check if the 5. char is a "-"
                if (text.substring(startIndex + 4, startIndex + 5).equals("-")) {
                    //get the fontKey
                    fontKey = text.substring(startIndex + 1, startIndex + 4);
                    //check if the fontKey is registered
                    if (fonts.containsKey(fontKey)) {
                        break;
                    }
                }
            }
        } while (startIndex != -1 && fontKey != null);

        SpannableString sb = new SpannableString(text);

        //reapply all previous styles
        for (StyleSpan span : textSpanned.getSpans(0, textSpanned.length(), StyleSpan.class)) {
            int spanStart = newSpanPoint(textSpanned.getSpanStart(span), removed);
            int spanEnd = newSpanPoint(textSpanned.getSpanEnd(span), removed);
            if (spanStart >= 0 && spanEnd > 0) {
                sb.setSpan(span, spanStart, spanEnd, textSpanned.getSpanFlags(span));
            }
        }

        //set all the icons and styles
        for (StyleContainer styleContainer : styleContainers) {
            sb.setSpan(new IconicsTypefaceSpan("sans-serif", styleContainer.getFont().getTypeface(ctx)), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            if (stylesFor.containsKey(styleContainer.getIcon())) {
                for (CharacterStyle style : stylesFor.get(styleContainer.getIcon())) {
                    sb.setSpan(CharacterStyle.wrap(style), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            } else if (styles != null) {
                for (CharacterStyle style : styles) {
                    sb.setSpan(CharacterStyle.wrap(style), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }

        //sb = applyKerning(sb, 1);

        return sb;
    }

    private static int newSpanPoint(int pos, ArrayList<RemoveInfo> removed) {
        for (RemoveInfo removeInfo : removed) {
            if (pos < removeInfo.getStart()) {
                return pos;
            }

            pos = pos - removeInfo.getCount();
        }
        return pos;
    }

    private static int determineNewSpanPoint(int pos, ArrayList<RemoveInfo> removed) {
        for (RemoveInfo removeInfo : removed) {
            if (pos > removeInfo.getStart()) {
                continue;
            }

            if (pos > removeInfo.getStart() && pos < removeInfo.getStart() + removeInfo.getCount()) {
                return -1;
            }

            if (pos < removeInfo.getStart()) {
                return pos;
            } else {
                return pos - removeInfo.getTotal();
            }
        }

        return -1;
    }

    /*
    KEEP THIS HERE perhaps we are able to implement proper spacing for the icons

    public static SpannableString applyKerning(CharSequence src, float kerning) {
        if (src == null) return null;
        final int srcLength = src.length();
        if (srcLength < 2) return src instanceof SpannableString
                ? (SpannableString) src
                : new SpannableString(src);

        final String nonBreakingSpace = "\u00A0";
        final SpannableStringBuilder builder = src instanceof SpannableStringBuilder
                ? (SpannableStringBuilder) src
                : new SpannableStringBuilder(src);
        for (int i = src.length() - 1; i >= 1; i--) {
            builder.insert(i, nonBreakingSpace);
            builder.setSpan(new ScaleXSpan(kerning), i, i + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return new SpannableString(builder);
    }
    */

    public static class IconicsBuilderString {
        private Context ctx;
        private SpannableString text;
        private List<CharacterStyle> withStyles;
        private HashMap<String, List<CharacterStyle>> withStylesFor;
        private List<ITypeface> fonts;

        public IconicsBuilderString(Context ctx, List<ITypeface> fonts, SpannableString text, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
            this.ctx = ctx;
            this.fonts = fonts;
            this.text = text;
            this.withStyles = styles;
            this.withStylesFor = stylesFor;
        }

        public SpannableString build() {
            HashMap<String, ITypeface> mappedFonts = new HashMap<String, ITypeface>();
            for (ITypeface font : fonts) {
                mappedFonts.put(font.getMappingPrefix(), font);
            }
            return Iconics.style(ctx, mappedFonts, text, withStyles, withStylesFor);
        }
    }

    public static class IconicsBuilderView {
        private Context ctx;
        private TextView view;
        private List<CharacterStyle> withStyles;
        private HashMap<String, List<CharacterStyle>> withStylesFor;
        private List<ITypeface> fonts;

        public IconicsBuilderView(Context ctx, List<ITypeface> fonts, TextView view, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
            this.ctx = ctx;
            this.fonts = fonts;
            this.view = view;
            this.withStyles = styles;
            this.withStylesFor = stylesFor;
        }


        public void build() {
            HashMap<String, ITypeface> mappedFonts = new HashMap<String, ITypeface>();
            for (ITypeface font : fonts) {
                mappedFonts.put(font.getMappingPrefix(), font);
            }

            if (view.getText() instanceof SpannableString) {
                view.setText(Iconics.style(ctx, mappedFonts, (SpannableString) view.getText(), withStyles, withStylesFor));
            } else {
                view.setText(Iconics.style(ctx, mappedFonts, new SpannableString(view.getText()), withStyles, withStylesFor));
            }

            if (Build.VERSION.SDK_INT >= 14) {
                if (view instanceof Button) {
                    view.setAllCaps(false);
                }
            }
        }
    }

    public static class IconicsBuilder {
        private List<CharacterStyle> styles = new LinkedList<CharacterStyle>();
        private HashMap<String, List<CharacterStyle>> stylesFor = new HashMap<String, List<CharacterStyle>>();
        private List<ITypeface> fonts = new LinkedList<ITypeface>();
        private Context ctx;

        public IconicsBuilder() {
        }

        public IconicsBuilder ctx(Context ctx) {
            this.ctx = ctx;
            return this;
        }

        public IconicsBuilder style(CharacterStyle... styles) {
            if (styles != null && styles.length > 0) {
                Collections.addAll(this.styles, styles);
            }
            return this;
        }

        public IconicsBuilder styleFor(IIcon styleFor, CharacterStyle... styles) {
            return styleFor(styleFor.getName(), styles);
        }

        public IconicsBuilder styleFor(String styleFor, CharacterStyle... styles) {
            styleFor = styleFor.replace("-", "_");

            if (!stylesFor.containsKey(styleFor)) {
                this.stylesFor.put(styleFor, new LinkedList<CharacterStyle>());
            }

            if (styles != null && styles.length > 0) {
                for (CharacterStyle style : styles) {
                    this.stylesFor.get(styleFor).add(style);
                }
            }
            return this;
        }

        public IconicsBuilder font(ITypeface font) {
            this.fonts.add(font);
            return this;
        }


        public IconicsBuilderString on(SpannableString on) {
            return new IconicsBuilderString(ctx, fonts, on, styles, stylesFor);
        }

        public IconicsBuilderString on(String on) {
            return on(new SpannableString(on));
        }

        public IconicsBuilderString on(CharSequence on) {
            return on(on.toString());
        }

        public IconicsBuilderString on(StringBuilder on) {
            return on(on.toString());
        }

        public IconicsBuilderView on(TextView on) {
            return new IconicsBuilderView(ctx, fonts, on, styles, stylesFor);
        }

        public IconicsBuilderView on(Button on) {
            return new IconicsBuilderView(ctx, fonts, on, styles, stylesFor);
        }
    }

    private static class StyleContainer {
        private int startIndex;
        private int endIndex;
        private String icon;
        private ITypeface font;

        private StyleContainer(int startIndex, int endIndex, String icon, ITypeface font) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.icon = icon;
            this.font = font;
        }

        public int getStartIndex() {
            return startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public String getIcon() {
            return icon;
        }

        public ITypeface getFont() {
            return font;
        }
    }

    private static class RemoveInfo {
        private int start;
        private int count;
        private int total;

        public RemoveInfo(int start, int count) {
            this.start = start;
            this.count = count;
        }

        public RemoveInfo(int start, int count, int total) {
            this.start = start;
            this.count = count;
            this.total = total;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
