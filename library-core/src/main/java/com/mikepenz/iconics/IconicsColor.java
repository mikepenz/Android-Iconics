/*
 * Copyright 2018 Mike Penz
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
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

/**
 * @author pa.gulko zTrap (20.01.2018)
 */
public final class IconicsColor implements IconicsExtractor {
    private ColorStateList mColorStateList;
    @ColorRes private int mColorStateListRes = DEF_RESOURCE;
    @ColorInt private int mColorInt = DEF_COLOR;
    @ColorRes private int mColorRes = DEF_RESOURCE;

    private IconicsColor() {
    }

    /**
     * @param colorInt The color, usually from android.graphics.Color or 0xFF012345.
     * */
    public static IconicsColor colorInt(@ColorInt int colorInt) {
        IconicsColor iconicsColor = new IconicsColor();
        iconicsColor.mColorInt = colorInt;
        return iconicsColor;
    }

    /**
     * @param colorRes The color resource, from your R file.
     * */
    public static IconicsColor colorRes(@ColorRes int colorRes) {
        IconicsColor iconicsColor = new IconicsColor();
        iconicsColor.mColorRes = colorRes;
        return iconicsColor;
    }

    /**
     * @param colorList The color state list.
     * */
    public static IconicsColor colorList(ColorStateList colorList) {
        IconicsColor iconicsColor = new IconicsColor();
        iconicsColor.mColorStateList = colorList;
        return iconicsColor;
    }

    /**
     * @param colorListRes The color state list resource, from your R file.
     * */
    public static IconicsColor colorListRes(@ColorRes int colorListRes) {
        IconicsColor iconicsColor = new IconicsColor();
        iconicsColor.mColorStateListRes = colorListRes;
        return iconicsColor;
    }

    /**
     * Parse the color string, and return the corresponding color-int. If the string cannot be
     * parsed, throws an IllegalArgumentException exception. Supported formats are: #RRGGBB
     * #AARRGGBB or one of the following names: 'red', 'blue', 'green', 'black', 'white', 'gray',
     * 'cyan', 'magenta', 'yellow', 'lightgray', 'darkgray', 'grey', 'lightgrey', 'darkgrey',
     * 'aqua', 'fuchsia', 'lime', 'maroon', 'navy', 'olive', 'purple', 'silver', 'teal'.
     * */
    public static IconicsColor parse(String colorString) {
        return colorInt(Color.parseColor(colorString));
    }

    @Nullable
    ColorStateList extract(Context context) {
        ColorStateList colorStateList = mColorStateList;
        if (mColorStateListRes != DEF_RESOURCE) {
            colorStateList = ContextCompat.getColorStateList(context, mColorStateListRes);
        }
        if (mColorRes != DEF_RESOURCE) {
            colorStateList = ColorStateList.valueOf(ContextCompat.getColor(context, mColorRes));
        }
        if (mColorInt != DEF_COLOR) {
            colorStateList = ColorStateList.valueOf(mColorInt);
        }
        return colorStateList;
    }
}
