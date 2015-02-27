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
package com.mikepenz.meteocons_typeface_library;

import android.content.Context;
import android.graphics.Typeface;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Meteoconcs implements ITypeface {
    private static final String TTF_FILE = "meteocons.ttf";

    private static Typeface typeface = null;

    private static HashMap<String, Character> mChars;

    @Override
    public IIcon getIcon(String key) {
        return Icon.valueOf(key);
    }

    @Override
    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> aChars = new HashMap<String, Character>();
            for (Icon v : Icon.values()) {
                aChars.put(v.name(), v.character);
            }
            mChars = aChars;
        }

        return mChars;
    }

    @Override
    public String getMappingPrefix() {
        return "met";
    }

    @Override
    public String getFontName() {
        return "Meteocons";
    }

    @Override
    public String getVersion() {
        return "1.1.1";
    }

    @Override
    public int getIconCount() {
        return mChars.size();
    }

    @Override
    public Collection<String> getIcons() {
        Collection<String> icons = new LinkedList<String>();

        for (Icon value : Icon.values()) {
            icons.add(value.name());
        }

        return icons;
    }

    @Override
    public String getAuthor() {
        return "Alessio Atzeni";
    }

    @Override
    public String getUrl() {
        return "http://www.alessioatzeni.com/meteocons/";
    }

    @Override
    public String getDescription() {
        return "Meteocons is a set of weather icons, it containing 40+ icons available in PSD, CSH, EPS, SVG, Desktop font and Web font. All icon and updates are free and always will be.";
    }

    @Override
    public String getLicense() {
        return "";
    }

    @Override
    public String getLicenseUrl() {
        return "";
    }

    @Override
    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + TTF_FILE);
            } catch (Exception e) {
                return null;
            }
        }
        return typeface;
    }

    public static enum Icon implements IIcon {
        met_windy_rain_inv('\ue800'),
        met_snow_inv('\ue801'),
        met_snow_heavy_inv('\ue802'),
        met_hail_inv('\ue803'),
        met_clouds_inv('\ue804'),
        met_clouds_flash_inv('\ue805'),
        met_temperature('\ue806'),
        met_compass('\ue807'),
        met_na('\ue808'),
        met_celcius('\ue809'),
        met_fahrenheit('\ue80a'),
        met_clouds_flash_alt('\ue80b'),
        met_sun_inv('\ue80c'),
        met_moon_inv('\ue80d'),
        met_cloud_sun_inv('\ue80e'),
        met_cloud_moon_inv('\ue80f'),
        met_cloud_inv('\ue810'),
        met_cloud_flash_inv('\ue811'),
        met_drizzle_inv('\ue812'),
        met_rain_inv('\ue813'),
        met_windy_inv('\ue814'),
        met_sunrise('\ue815'),
        met_sun('\ue816'),
        met_moon('\ue817'),
        met_eclipse('\ue818'),
        met_mist('\ue819'),
        met_wind('\ue81a'),
        met_snowflake('\ue81b'),
        met_cloud_sun('\ue81c'),
        met_cloud_moon('\ue81d'),
        met_fog_sun('\ue81e'),
        met_fog_moon('\ue81f'),
        met_fog_cloud('\ue820'),
        met_fog('\ue821'),
        met_cloud('\ue822'),
        met_cloud_flash('\ue823'),
        met_cloud_flash_alt('\ue824'),
        met_drizzle('\ue825'),
        met_rain('\ue826'),
        met_windy('\ue827'),
        met_windy_rain('\ue828'),
        met_snow('\ue829'),
        met_snow_alt('\ue82a'),
        met_snow_heavy('\ue82b'),
        met_hail('\ue82c'),
        met_clouds('\ue82d'),
        met_clouds_flash('\ue82e');

        char character;

        Icon(char character) {
            this.character = character;
        }

        public String getFormattedName() {
            return "{" + name() + "}";
        }

        public char getCharacter() {
            return character;
        }

        public String getName() {
            return name();
        }

        // remember the typeface so we can use it later
        private static ITypeface typeface;

        public ITypeface getTypeface() {
            if (typeface == null) {
                typeface = new Meteoconcs();
            }
            return typeface;
        }
    }
}
