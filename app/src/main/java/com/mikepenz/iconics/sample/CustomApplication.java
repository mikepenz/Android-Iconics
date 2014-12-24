package com.mikepenz.iconics.sample;


import android.app.Application;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.sample.typeface.CustomFont;
import com.mikepenz.meteocons_typeface_library.Meteoconcs;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconics.registerFont(new Meteoconcs());
        Iconics.registerFont(new GoogleMaterial());
        Iconics.registerFont(new CustomFont());
    }

}
