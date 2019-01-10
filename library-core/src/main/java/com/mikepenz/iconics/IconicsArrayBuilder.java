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

import android.graphics.Typeface;
import android.util.Pair;

import com.mikepenz.iconics.typeface.IIcon;

import java.util.ArrayList;

/**
 * Created by mikepenz on 30.06.15.
 */
public class IconicsArrayBuilder {
    private IconicsDrawable mIconBase;
    private ArrayList<Pair<Object, Typeface>> mIcons = new ArrayList<>();

    public IconicsArrayBuilder(IconicsDrawable iconicsDrawable) {
        this.mIconBase = iconicsDrawable;
    }

    public IconicsArrayBuilder add(IIcon icon) {
        mIcons.add(Pair.create(icon, null));
        return this;
    }

    public IconicsArrayBuilder add(String icon) {
        return add(icon, Typeface.DEFAULT);
    }

    public IconicsArrayBuilder add(Character icon) {
        return add(icon, Typeface.DEFAULT);
    }

    public IconicsArrayBuilder add(String icon, Typeface typeface) {
        mIcons.add(Pair.create(icon, typeface));
        return this;
    }

    public IconicsArrayBuilder add(Character icon, Typeface typeface) {
        mIcons.add(Pair.create(icon, typeface));
        return this;
    }

    public IconicsDrawable[] build() {
        IconicsDrawable[] iconicsDrawables = new IconicsDrawable[mIcons.size()];

        for (int i = 0; i < mIcons.size(); i++) {
            Pair<Object, Typeface> pair = mIcons.get(i);
            if (pair.first instanceof IIcon) {
                iconicsDrawables[i] = mIconBase.clone().icon((IIcon) pair.first);
            } else if (pair.first instanceof Character) {
                iconicsDrawables[i] = mIconBase.clone().icon((Character) pair.first, pair.second);
            } else if (pair.first instanceof String) {
                iconicsDrawables[i] = mIconBase.clone().iconText((String) pair.first, pair.second);
            }
        }

        return iconicsDrawables;
    }
}
