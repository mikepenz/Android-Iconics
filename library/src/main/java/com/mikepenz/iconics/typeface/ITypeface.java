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

package com.mikepenz.iconics.typeface;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by mikepenz on 01.11.14.
 */
public interface ITypeface {

    public IIcon getIcon(String key);

    public HashMap<String, Character> getCharacters();

    /**
     * The Mapping Prefix to identify this font
     * must have a length of 3
     *
     * @return mappingPrefix (length = 3)
     */
    public String getMappingPrefix();

    public String getFontName();

    public String getVersion();

    public int getIconCount();

    public Collection<String> getIcons();

    public String getAuthor();

    public String getUrl();

    public String getDescription();

    public String getLicense();

    public String getLicenseUrl();

    public Typeface getTypeface(Context ctx);

}
