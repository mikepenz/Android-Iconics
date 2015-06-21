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
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.IconicsTypefaceSpan;
import com.mikepenz.iconics.utils.Utils;

import java.util.ArrayList;
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
        GoogleMaterial gm = new GoogleMaterial();
        FONTS.put(gm.getMappingPrefix(), gm);
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

    public static ITypeface findFont(IIcon icon) {
        return icon.getTypeface();
    }

    private Iconics() {
        // Prevent instantiation
    }

    private static SpannableString style(Context ctx, HashMap<String, ITypeface> fonts, SpannableString textSpanned, List<CharacterStyle> styles, HashMap<String, List<CharacterStyle>> stylesFor) {
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
            fontKey = text.substring(startIndex + 1, startIndex + 4);
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
            iconString = iconString.replaceAll("-", "_");
            try {
                //get the correct character for this Font and Icon
                IIcon icon = fonts.get(fontKey).getIcon(iconString);
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
                }
            } catch (IllegalArgumentException e) {
                Log.w(Iconics.TAG, "Wrong icon name: " + iconString);
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

    public static class IconicsArrayBuilder {

        private Context ctx;
        private List<IIcon> iIcons;
        private int color;
        private Paint.Style style;
        private int mIconOffsetX;
        private int mIconOffsetY;
        private int mIconPadding;
        private int mSize;
        private SIZE sizeType;
        private int contourColor;
        private int mBackgroundColor;
        private int mContourWidth;
        private boolean drawContour;
        private ColorFilter colorFilter;
        private int alpha;

        private enum SIZE {
            ACTION_BAR,
            ACTION_BAR_SIZE,
            CUSTOM_RES,
            CUSTOM_DP,
            CUSTOM_PX;
        }

        public IconicsArrayBuilder() {
            iIcons = new ArrayList<>();
        }

        public IconicsArrayBuilder ctx(Context ctx) {
            this.ctx = ctx;
            return this;
        }

        public IconicsArrayBuilder add(IIcon iIcon) {
            iIcons.add(iIcon);
            return this;
        }

        /**
         * Set the color of the drawable.
         *
         * @param color The color, usually from android.graphics.Color or 0xFF012345.
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder color(int color) {
            this.color = color;
            return this;
        }

        /**
         * Set the color of the drawable.
         *
         * @param colorRes The color resource, from your R file.
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder colorRes(int colorRes) {
            return color(ctx.getResources().getColor(colorRes));
        }


        /**
         * set the icon offset for X from resource
         *
         * @param iconOffsetXRes
         * @return
         */
        public IconicsArrayBuilder iconOffsetXRes(int iconOffsetXRes) {
            return iconOffsetXPx(ctx.getResources().getDimensionPixelSize(iconOffsetXRes));
        }

        /**
         * set the icon offset for X as dp
         *
         * @param iconOffsetXDp
         * @return
         */
        public IconicsArrayBuilder iconOffsetXDp(int iconOffsetXDp) {
            return iconOffsetXPx(Utils.convertDpToPx(ctx, iconOffsetXDp));
        }

        /**
         * set the icon offset for X
         *
         * @param iconOffsetX
         * @return
         */
        public IconicsArrayBuilder iconOffsetXPx(int iconOffsetX) {
            this.mIconOffsetX = iconOffsetX;
            return this;
        }

        /**
         * set the icon offset for Y from resource
         *
         * @param iconOffsetYRes
         * @return
         */
        public IconicsArrayBuilder iconOffsetYRes(int iconOffsetYRes) {
            return iconOffsetYPx(ctx.getResources().getDimensionPixelSize(iconOffsetYRes));
        }

        /**
         * set the icon offset for Y as dp
         *
         * @param iconOffsetYDp
         * @return
         */
        public IconicsArrayBuilder iconOffsetYDp(int iconOffsetYDp) {
            return iconOffsetYPx(Utils.convertDpToPx(ctx, iconOffsetYDp));
        }

        /**
         * set the icon offset for Y
         *
         * @param iconOffsetY
         * @return
         */
        public IconicsArrayBuilder iconOffsetYPx(int iconOffsetY) {
            this.mIconOffsetY = iconOffsetY;
            return this;
        }

        /**
         * Set the padding of the drawable from res
         *
         * @param dimenRes
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder paddingRes(int dimenRes) {
            return paddingPx(ctx.getResources().getDimensionPixelSize(dimenRes));
        }


        /**
         * Set the padding in dp for the drawable
         *
         * @param iconPadding
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder paddingDp(int iconPadding) {
            return paddingPx(Utils.convertDpToPx(ctx, iconPadding));
        }

        /**
         * Set a padding for the.
         *
         * @param iconPadding
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder paddingPx(int iconPadding) {
            mIconPadding = iconPadding;
            return this;
        }

        /**
         * Set the size of this icon to the standard Android ActionBar.
         *
         * @return The current IconExtDrawable for chaining.
         * @deprecated use actionBar() instead
         */
        @Deprecated
        public IconicsArrayBuilder actionBarSize() {
            this.sizeType = SIZE.ACTION_BAR_SIZE;
            return this;
        }

        /**
         * Sets the size and the Padding to the correct values to be used for the actionBar / toolBar
         *
         * @return
         */
        public IconicsArrayBuilder actionBar() {
            this.sizeType = SIZE.ACTION_BAR;
            return this;
        }

        /**
         * Set the size of the drawable.
         *
         * @param dimenRes The dimension resource.
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder sizeRes(int dimenRes) {
            this.sizeType = SIZE.CUSTOM_RES;
            return sizePx(ctx.getResources().getDimensionPixelSize(dimenRes));
        }


        /**
         * Set the size of the drawable.
         *
         * @param size The size in density-independent pixels (dp).
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder sizeDp(int size) {
            this.sizeType = SIZE.CUSTOM_DP;
            return sizePx(Utils.convertDpToPx(ctx, size));
        }

        /**
         * Set the size of the drawable.
         *
         * @param size The size in pixels (px).
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder sizePx(int size) {
            this.sizeType = SIZE.CUSTOM_PX;
            this.mSize = size;
            return this;
        }


        /**
         * Set contour color for the.
         *
         * @param contourColor
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder contourColor(int contourColor) {
            this.contourColor = contourColor;
            return this;
        }

        /**
         * Set contour color from color res.
         *
         * @param contourColorRes
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder contourColorRes(int contourColorRes) {
            contourColor(ctx.getResources().getColor(contourColorRes));
            return this;
        }

        /**
         * set background color
         *
         * @param backgroundColor
         * @return
         */
        public IconicsArrayBuilder backgroundColor(int backgroundColor) {
            this.mBackgroundColor = backgroundColor;
            return this;
        }

        /**
         * set background color from res
         *
         * @param backgroundColorRes
         * @return
         */
        public IconicsArrayBuilder backgroundColorRes(int backgroundColorRes) {
            this.mBackgroundColor = ctx.getResources().getColor(backgroundColorRes);
            return this;
        }


        /**
         * Set contour width from an dimen res for the icon
         *
         * @param contourWidthRes
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder contourWidthRes(int contourWidthRes) {
            return contourWidthPx(ctx.getResources().getDimensionPixelSize(contourWidthRes));
        }

        /**
         * Set contour width from dp for the icon
         *
         * @param contourWidthDp
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder contourWidthDp(int contourWidthDp) {
            return contourWidthPx(Utils.convertDpToPx(ctx, contourWidthDp));
        }

        /**
         * Set contour width for the icon.
         *
         * @param contourWidth
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder contourWidthPx(int contourWidth) {
            this.mContourWidth = contourWidth;
            return this;
        }

        /**
         * Enable/disable contour drawing.
         *
         * @param drawContour
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder drawContour(boolean drawContour) {
            this.drawContour = drawContour;
            return this;
        }

        /**
         * Set the colorFilter
         *
         * @param cf
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder colorFilter(ColorFilter cf) {
            this.colorFilter = cf;
            return this;
        }

        /**
         * Sets the opacity
         *
         * @param alpha
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder alpha(int alpha) {
            this.alpha = alpha;
            return this;
        }

        /**
         * Sets the style
         *
         * @param style
         * @return The current IconExtDrawable for chaining.
         */
        public IconicsArrayBuilder style(Paint.Style style) {
            this.style = style;
            return this;
        }


        public IconicsDrawable[] build() {
            IconicsDrawable[] array = new IconicsDrawable[iIcons.size()];

            for (int i = 0; i < iIcons.size(); i++) {
                array[i] = createDrawable(iIcons.get(i));
            }

            return array;
        }

        private IconicsDrawable createDrawable(IIcon iIcon) {
            IconicsDrawable drawable =  new IconicsDrawable(ctx, iIcon).color(color)
                    .contourColor(contourColor)
                    .drawContour(drawContour)
                    .color(color)
                    .backgroundColor(mBackgroundColor)
                    .colorFilter(this.colorFilter)
                    .paddingPx(mIconPadding)
                    .iconOffsetXPx(mIconOffsetX)
                    .iconOffsetYPx(mIconOffsetY);

            if (sizeType != null) {
                switch (sizeType) {
                    case CUSTOM_RES:
                        drawable.sizeRes(mSize);
                        break;
                    case CUSTOM_DP:
                        drawable.sizeDp(mSize);
                        break;
                    case CUSTOM_PX:
                        drawable.sizePx(mSize);
                        break;
                }
            }

            return drawable;
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
