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
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.GenericsUtil;
import com.mikepenz.iconics.utils.IconicsUtils;
import com.mikepenz.iconics.utils.StyleContainer;
import com.mikepenz.iconics.utils.TextStyleContainer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class Iconics {
    public static final String TAG = Iconics.class.getSimpleName();

    private static boolean INIT_DONE = false;
    private static HashMap<String, ITypeface> FONTS = new HashMap<>();

    /**
     * initializes the FONTS. This also tries to find all founds automatically via their font file
     *
     * @param ctx
     */
    public static void init(Context ctx) {
        if (!INIT_DONE) {
            String[] fonts = GenericsUtil.getFields(ctx);
            for (String fontsClassPath : fonts) {
                try {
                    ITypeface typeface = (ITypeface) Class.forName(fontsClassPath).newInstance();
                    FONTS.put(typeface.getMappingPrefix(), typeface);
                } catch (Exception e) {
                    Log.e("Android-Iconics", "Can't init: " + fontsClassPath);
                }
            }
            INIT_DONE = true;
        }
    }

    /**
     * this makes sure the FONTS are initialized. If the given fonts Map is empty we set the initialized FONTS on it
     *
     * @param ctx
     * @param fonts
     * @return
     */
    private static HashMap<String, ITypeface> init(Context ctx, HashMap<String, ITypeface> fonts) {
        init(ctx);
        if (fonts == null || fonts.size() == 0) {
            fonts = FONTS;
        }
        return fonts;
    }

    /**
     * registeres a fonts into the FONTS array for performance
     *
     * @param font
     * @return
     */
    public static boolean registerFont(ITypeface font) {
        FONTS.put(font.getMappingPrefix(), font);
        return true;
    }

    /**
     * return all registered FONTS
     *
     * @param ctx
     * @return
     */
    public static Collection<ITypeface> getRegisteredFonts(Context ctx) {
        init(ctx);
        return FONTS.values();
    }

    /**
     * tries to find a font by its key in all registered FONTS
     *
     * @param ctx
     * @param key
     * @return
     */
    public static ITypeface findFont(Context ctx, String key) {
        init(ctx);
        return FONTS.get(key);
    }

    /**
     * fetches the font from the Typeface of an IIcon
     *
     * @param icon
     * @return
     */
    public static ITypeface findFont(IIcon icon) {
        return icon.getTypeface();
    }

    private Iconics() {
        // Prevent instantiation
    }

    /**
     * Creates a new SpannableStringBuilder and will iterate over the textSpanned once and copy over
     * all characters, it will also directly replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     *
     * @param ctx
     * @param textSpanned
     * @return
     */
    public static Spanned style(Context ctx, Spanned textSpanned) {
        return style(ctx, null, textSpanned, null, null);
    }

    /**
     * Creates a new SpannableStringBuilder and will iterate over the textSpanned once and copy over
     * all characters, it will also directly replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     *
     * @param ctx
     * @param fonts
     * @param textSpanned
     * @param styles
     * @param stylesFor
     * @return
     */
    public static Spanned style(Context ctx, HashMap<String, ITypeface> fonts, Spanned textSpanned, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
        fonts = init(ctx, fonts);

        //find all icons which should be replaced with the iconFont
        TextStyleContainer textStyleContainer = IconicsUtils.findIcons(textSpanned, fonts);

        //create spannableString to set the spans on
        SpannableString sb = SpannableString.valueOf(textStyleContainer.spannableStringBuilder);

        //set all the icons and styles
        IconicsUtils.applyStyles(ctx, sb, textStyleContainer.styleContainers, styles, stylesFor);

        return sb;
    }

    /**
     * Iterates over the editable once and replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     *
     * @param ctx
     * @param editable
     */
    public static void styleEditable(Context ctx, Editable editable) {
        styleEditable(ctx, null, editable, null, null);
    }

    /**
     * Iterates over the editable once and replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     *
     * @param ctx
     * @param fonts
     * @param textSpanned
     * @param styles
     * @param stylesFor
     */
    public static void styleEditable(Context ctx, HashMap<String, ITypeface> fonts, Editable textSpanned, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
        fonts = init(ctx, fonts);

        //find all icons which should be replaced with the iconFont
        List<StyleContainer> styleContainers = IconicsUtils.findIconsFromEditable(textSpanned, fonts);

        //set all the icons and styles
        IconicsUtils.applyStyles(ctx, textSpanned, styleContainers, styles, stylesFor);
    }

    public static class IconicsBuilderString {
        private Context ctx;
        private Spanned text;
        private List<CharacterStyle> withStyles;
        private HashMap<String, List<CharacterStyle>> withStylesFor;
        private List<ITypeface> fonts;

        public IconicsBuilderString(Context ctx, List<ITypeface> fonts, Spanned text, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
            this.ctx = ctx;
            this.fonts = fonts;
            this.text = text;
            this.withStyles = styles;
            this.withStylesFor = stylesFor;
        }

        public Spanned build() {
            HashMap<String, ITypeface> mappedFonts = new HashMap<>();
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
            HashMap<String, ITypeface> mappedFonts = new HashMap<>();
            for (ITypeface font : fonts) {
                mappedFonts.put(font.getMappingPrefix(), font);
            }

            //DO NOT STYLE EDITABLE (comes from EditText) as this causes bad issues with the cursor!
            /*
            if (view.getText() instanceof Editable) {
                Iconics.styleEditable(ctx, mappedFonts, (Editable) view.getText(), withStyles, withStylesFor);
            } else
            */
            if (view.getText() instanceof Spanned) {
                view.setText(Iconics.style(ctx, mappedFonts, (Spanned) view.getText(), withStyles, withStylesFor));
            } else {
                view.setText(Iconics.style(ctx, mappedFonts, new SpannableString(view.getText()), withStyles, withStylesFor));
            }

            if (view instanceof Button) {
                view.setAllCaps(false);
            }
        }
    }

    public static class IconicsBuilder {
        private List<CharacterStyle> styles = new LinkedList<>();
        private HashMap<String, List<CharacterStyle>> stylesFor = new HashMap<>();
        private List<ITypeface> fonts = new LinkedList<>();
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

        /**
         * this method allows you to apply additional styles on icons , just provide all CharacterStyles you want to apply on the given IIcon
         *
         * @param styleFor
         * @param styles
         * @return
         */
        public IconicsBuilder styleFor(IIcon styleFor, CharacterStyle... styles) {
            return styleFor(styleFor.getName(), styles);
        }

        /**
         * this method allows you to apply additional styles on icons , just provide all CharacterStyles you want to apply on the given icon (by it's name faw-android)
         *
         * @param styleFor
         * @param styles
         * @return
         */
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

        /**
         * adds additional fonts which should be used to apply the icons
         *
         * @param font
         * @return
         */
        public IconicsBuilder font(ITypeface font) {
            this.fonts.add(font);
            return this;
        }

        /**
         * defines where the icons should be applied to
         *
         * @param on
         * @return
         */
        public IconicsBuilderString on(Spanned on) {
            return new IconicsBuilderString(ctx, fonts, on, styles, stylesFor);
        }

        /**
         * defines where the icons should be applied to
         *
         * @param on
         * @return
         */
        public IconicsBuilderString on(String on) {
            return on(new SpannableString(on));
        }

        /**
         * defines where the icons should be applied to
         *
         * @param on
         * @return
         */
        public IconicsBuilderString on(CharSequence on) {
            return on(on.toString());
        }

        /**
         * defines where the icons should be applied to
         *
         * @param on
         * @return
         */
        public IconicsBuilderString on(StringBuilder on) {
            return on(on.toString());
        }

        /**
         * defines where the icons should be applied to
         *
         * @param on
         * @return
         */
        public IconicsBuilderView on(TextView on) {
            return new IconicsBuilderView(ctx, fonts, on, styles, stylesFor);
        }

        /**
         * defines where the icons should be applied to
         *
         * @param on
         * @return
         */
        public IconicsBuilderView on(Button on) {
            return new IconicsBuilderView(ctx, fonts, on, styles, stylesFor);
        }
    }
}
