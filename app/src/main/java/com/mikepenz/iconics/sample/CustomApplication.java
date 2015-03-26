package com.mikepenz.iconics.sample;


import android.app.Application;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.sample.typeface.CustomFont;
import com.mikepenz.meteocons_typeface_library.Meteoconcs;
import com.mikepenz.octicons_typeface_library.Octicons;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconics.registerFont(new Meteoconcs());
        Iconics.registerFont(new Octicons());
        Iconics.registerFont(new CustomFont());
    }

}
