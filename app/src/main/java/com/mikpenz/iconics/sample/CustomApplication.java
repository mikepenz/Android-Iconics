package com.mikpenz.iconics.sample;


import android.app.Application;

import com.mikpenz.iconics.Iconics;
import com.mikpenz.iconics.sample.typeface.CustomFont;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconics.registerFont(new CustomFont());
    }

}
