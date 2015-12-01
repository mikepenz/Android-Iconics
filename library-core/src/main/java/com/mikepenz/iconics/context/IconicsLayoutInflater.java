package com.mikepenz.iconics.context;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mikepenz on 01.12.15.
 */
public class IconicsLayoutInflater implements LayoutInflaterFactory {
    private AppCompatDelegate appCompatDelegate;
    private final IconicsFactory mIconicsFactory;

    public IconicsLayoutInflater(AppCompatDelegate appCompatDelegate) {
        this.appCompatDelegate = appCompatDelegate;
        this.mIconicsFactory = new IconicsFactory();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View result = appCompatDelegate.createView(parent, name, context, attrs);
        return mIconicsFactory.onViewCreated(result, context, attrs);
    }
}
