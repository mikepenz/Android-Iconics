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
package com.mikpenz.iconics;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.mikpenz.iconics.typeface.FontAwesome;
import com.mikpenz.iconics.typeface.IIcon;
import com.mikpenz.iconics.typeface.ITypeface;
import com.mikpenz.iconics.utils.IconicsTypefaceSpan;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class Iconics {
    public static final String TAG = Iconics.class.getSimpleName();

    private static HashMap<String, ITypeface> FONTS = new HashMap<String, ITypeface>();

    //ADD DEFAULT to fontList
    static {
        FontAwesome fa = new FontAwesome();
        FONTS.put(fa.getMappingPrefix(), fa);
    }

    public static void registerFont(ITypeface font) {
        FONTS.put(font.getMappingPrefix(), font);
    }

    public static Collection<ITypeface> getRegisteredFonts() {
        return FONTS.values();
    }

    public static ITypeface findFont(String key) {
        return FONTS.get(key);
    }


    private Iconics() {
        // Prevent instantiation
    }

    private static SpannableString style(Context ctx, HashMap<String, ITypeface> fonts, StringBuilder text, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
        if (fonts == null || fonts.size() == 0) {
            fonts = FONTS;
        }

        int startIndex = -1;
        String fontKey = "";
        while ((startIndex = text.indexOf("{icon-", startIndex + 1)) != -1) {
            fontKey = text.substring(startIndex + 6, startIndex + 9);

            if (fonts.containsKey(fontKey)) {
                break;
            }
        }
        if (startIndex == -1) {
            return new SpannableString(text);
        }

        LinkedList<StyleContainer> styleContainers = new LinkedList<StyleContainer>();
        do {
            int endIndex = text.substring(startIndex).indexOf("}") + startIndex + 1;
            String iconString = text.substring(startIndex + 1, endIndex - 1);
            iconString = iconString.replaceAll("-", "_");
            iconString = iconString.substring(5);
            try {
                char fontChar = fonts.get(fontKey).getIcon(iconString).getCharacter();
                String iconValue = String.valueOf(fontChar);

                text = text.replace(startIndex, endIndex, iconValue);

                styleContainers.add(new StyleContainer(startIndex, startIndex + 1, iconString, fonts.get(fontKey)));

            } catch (IllegalArgumentException e) {
                Log.w(Iconics.TAG, "Wrong icon name: " + iconString);
            }

            while ((startIndex = text.indexOf("{icon-", startIndex + 1)) != -1) {
                fontKey = text.substring(startIndex + 6, startIndex + 9);

                if (fonts.containsKey(fontKey)) {
                    break;
                }
            }
        } while (startIndex != -1);


        SpannableString sb = new SpannableString(text);

        for (StyleContainer styleContainer : styleContainers) {
            sb.setSpan(new IconicsTypefaceSpan("sans-serif", styleContainer.getFont().getTypeface(ctx)), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

            if (stylesFor.containsKey(styleContainer.getIcon())) {
                for (CharacterStyle style : stylesFor.get(styleContainer.getIcon())) {
                    sb.setSpan(CharacterStyle.wrap(style), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                }
            } else if (styles != null) {
                for (CharacterStyle style : styles) {
                    sb.setSpan(CharacterStyle.wrap(style), styleContainer.getStartIndex(), styleContainer.getEndIndex(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                }
            }
        }
        return sb;
    }

    public static class IconicsBuilderString {
        private Context ctx;
        private StringBuilder text;
        private List<CharacterStyle> withStyles;
        private HashMap<String, List<CharacterStyle>> withStylesFor;
        private List<ITypeface> fonts;

        public IconicsBuilderString(Context ctx, List<ITypeface> fonts, StringBuilder text, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
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
        private TextView onTextView;
        private Button onButton;
        private List<CharacterStyle> withStyles;
        private HashMap<String, List<CharacterStyle>> withStylesFor;
        private List<ITypeface> fonts;

        public IconicsBuilderView(Context ctx, List<ITypeface> fonts, TextView textView, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
            this.ctx = ctx;
            this.fonts = fonts;
            this.onTextView = textView;
            this.withStyles = styles;
            this.withStylesFor = stylesFor;
        }

        public IconicsBuilderView(Context ctx, List<ITypeface> fonts, Button button, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
            this.ctx = ctx;
            this.fonts = fonts;
            this.onButton = button;
            this.withStyles = styles;
            this.withStylesFor = stylesFor;
        }

        public void build() {
            HashMap<String, ITypeface> mappedFonts = new HashMap<String, ITypeface>();
            for (ITypeface font : fonts) {
                mappedFonts.put(font.getMappingPrefix(), font);
            }

            if (onTextView != null) {
                onTextView.setText(Iconics.style(ctx, mappedFonts, new StringBuilder(onTextView.getText()), withStyles, withStylesFor));
            } else if (onButton != null) {
                onButton.setText(Iconics.style(ctx, mappedFonts, new StringBuilder(onButton.getText()), withStyles, withStylesFor));
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


        public IconicsBuilderString on(String on) {
            return new IconicsBuilderString(ctx, fonts, new StringBuilder(on), styles, stylesFor);
        }

        public IconicsBuilderString on(CharSequence on) {
            return new IconicsBuilderString(ctx, fonts, new StringBuilder(on), styles, stylesFor);
        }

        public IconicsBuilderString on(StringBuilder on) {
            return new IconicsBuilderString(ctx, fonts, on, styles, stylesFor);
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
}
