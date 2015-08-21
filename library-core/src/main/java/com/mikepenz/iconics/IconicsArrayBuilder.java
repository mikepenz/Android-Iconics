package com.mikepenz.iconics;

import com.mikepenz.iconics.typeface.IIcon;

import java.util.ArrayList;

/**
 * Created by mikepenz on 30.06.15.
 */
public class IconicsArrayBuilder {
    private IconicsDrawable mIconBase;
    private ArrayList<Object> mIcons = new ArrayList<>();

    public IconicsArrayBuilder(IconicsDrawable iconicsDrawable) {
        this.mIconBase = iconicsDrawable;
    }

    public IconicsArrayBuilder add(IIcon icon) {
        mIcons.add(icon);
        return this;
    }

    public IconicsArrayBuilder add(String icon) {
        mIcons.add(icon);
        return this;
    }

    public IconicsArrayBuilder add(Character icon) {
        mIcons.add(icon);
        return this;
    }

    public IconicsDrawable[] build() {
        IconicsDrawable[] iconicsDrawables = new IconicsDrawable[mIcons.size()];

        for (int i = 0; i < mIcons.size(); i++) {
            if (mIcons.get(i) instanceof IIcon) {
                iconicsDrawables[i] = mIconBase.clone().icon((IIcon) mIcons.get(i));
            } else if (mIcons.get(i) instanceof Character) {
                iconicsDrawables[i] = mIconBase.clone().icon((Character) mIcons.get(i));
            } else if (mIcons.get(i) instanceof String) {
                iconicsDrawables[i] = mIconBase.clone().iconText((String) mIcons.get(i));
            }
        }

        return iconicsDrawables;
    }
}
