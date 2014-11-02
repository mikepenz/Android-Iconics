package com.mikpenz.iconics.sample;


import android.app.Application;

import com.mikpenz.iconics.Iconics;
import com.mikpenz.iconics.sample.typeface.CustomFont;
import com.mikpenz.meteocons_typeface_library.Meteoconcs;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconics.registerFont(new Meteoconcs());
        Iconics.registerFont(new CustomFont());
    }

}
