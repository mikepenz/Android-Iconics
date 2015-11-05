package com.mikepenz.iconics.utils;

import com.mikepenz.iconics.typeface.ITypeface;

public class StyleContainer {
    private int startIndex;
    private int endIndex;
    private String icon;
    private ITypeface font;

    public StyleContainer(int startIndex, int endIndex, String icon, ITypeface font) {
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
