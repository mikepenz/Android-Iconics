package com.mikepenz.iconics.utils;

import android.text.ParcelableSpan;
import android.text.style.CharacterStyle;

import com.mikepenz.iconics.typeface.ITypeface;

public class StyleContainer {
    public int startIndex;
    public int endIndex;
    public String icon;
    public ITypeface font;
    public ParcelableSpan span;
    public CharacterStyle style;

    public StyleContainer(int startIndex, int endIndex, String icon, ITypeface font) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.icon = icon;
        this.font = font;
    }

    public StyleContainer(int startIndex, int endIndex, ParcelableSpan span) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.span = span;
    }

    public StyleContainer(int startIndex, int endIndex, CharacterStyle style) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.style = style;
    }
}
