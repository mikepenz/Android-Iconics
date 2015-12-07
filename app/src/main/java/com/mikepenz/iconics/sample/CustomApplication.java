package com.mikepenz.iconics.sample;


import android.app.Application;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.sample.typeface.CustomFont;
import com.mikepenz.iconics.typeface.GenericFont;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //register custom fonts like this (or also provide a font definition file)
        Iconics.registerFont(new CustomFont());

        //Generic font creation process
        GenericFont gf2 = new GenericFont("GenericFont", "SampleGenericFont", "gmf", "fonts/materialdrawerfont.ttf");
        gf2.registerIcon("person", '\ue800');
        gf2.registerIcon("up", '\ue801');
        gf2.registerIcon("down", '\ue802');
        Iconics.registerFont(gf2);
    }

}
