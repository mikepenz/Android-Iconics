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
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
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

    public static void init(Context ctx) {
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

    public static boolean registerFont(ITypeface font) {
        FONTS.put(font.getMappingPrefix(), font);
        return true;
    }

    public static Collection<ITypeface> getRegisteredFonts(Context ctx) {
        if (!INIT_DONE) {
            init(ctx);
        }
        return FONTS.values();
    }

    public static ITypeface findFont(Context ctx, String key) {
        if (!INIT_DONE) {
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


    /**
     * Creates a new SpannableStringBuilder and will iterate over the textSpanned once and copy over
     * all characters, it will also directly replace icon font placeholders with the correct mapping.
     * Afterwards it will apply the styles
     *
     * @param ctx
     * @param textSpanned
     * @return
     */
    public static Spannable style(Context ctx, Spannable textSpanned) {
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
    public static Spannable style(Context ctx, HashMap<String, ITypeface> fonts, Spannable textSpanned, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
        if (!INIT_DONE) {
            init(ctx);
        }
        if (fonts == null || fonts.size() == 0) {
            fonts = FONTS;
        }

        //find all icons which should be replaced with the iconFont
        TextStyleContainer textStyleContainer = IconicsUtils.findIcons(textSpanned, fonts);

        //create spannableString to set the spans on
        SpannableString sb = SpannableString.valueOf(textStyleContainer.spannableStringBuilder);

        //TODO create logic to reapply previous applyed spans

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
        if (!INIT_DONE) {
            init(ctx);
        }
        if (fonts == null || fonts.size() == 0) {
            fonts = FONTS;
        }

        //find all icons which should be replaced with the iconFont
        List<StyleContainer> styleContainers = IconicsUtils.findIconsFromEditable(textSpanned, fonts);

        //TODO create logic to reapply previous applyed spans

        //set all the icons and styles
        IconicsUtils.applyStyles(ctx, textSpanned, styleContainers, styles, stylesFor);
    }

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

        public Spannable build() {
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
}
