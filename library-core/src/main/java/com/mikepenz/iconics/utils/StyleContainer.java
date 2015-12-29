package com.mikepenz.iconics.utils;

import android.text.style.StyleSpan;

import com.mikepenz.iconics.typeface.ITypeface;

public class StyleContainer {
    public int startIndex;
    public int endIndex;
    public String icon;
    public ITypeface font;
    public StyleSpan styleSpan;

    public StyleContainer(int startIndex, int endIndex, String icon, ITypeface font) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.icon = icon;
        this.font = font;
    }

    public StyleContainer(int startIndex, int endIndex, StyleSpan styleSpan) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.styleSpan = styleSpan;
    }
}
