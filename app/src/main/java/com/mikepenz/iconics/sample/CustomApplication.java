package com.mikepenz.iconics.sample;


import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.sample.typeface.CustomFont;
import com.mikepenz.iconics.typeface.GenericFont;

import androidx.multidex.MultiDexApplication;

public class CustomApplication extends MultiDexApplication {

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

        //Enable the below line to not allow the automatic font detection via the included string fields. This helps to increase performance by a tiny bit.
        //Iconics.markInitDone();
    }

}
