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
