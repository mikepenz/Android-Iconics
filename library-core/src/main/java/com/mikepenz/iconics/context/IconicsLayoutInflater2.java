package com.mikepenz.iconics.context;

import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bschnack on 07.18.17.
 */
public class IconicsLayoutInflater2 implements android.view.LayoutInflater.Factory2 {
    private AppCompatDelegate appCompatDelegate;
    private final IconicsFactory mIconicsFactory;

    public IconicsLayoutInflater2(AppCompatDelegate appCompatDelegate) {
        this.appCompatDelegate = appCompatDelegate;
        this.mIconicsFactory = new IconicsFactory();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View result = appCompatDelegate.createView(parent, name, context, attrs);
        return mIconicsFactory.onViewCreated(result, context, attrs);
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View result = appCompatDelegate.createView(null, name, context, attrs);
        return mIconicsFactory.onViewCreated(result, context, attrs);
    }
}
