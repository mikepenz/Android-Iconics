package com.mikepenz.iconics.sample;


import android.app.Application;

import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.sample.typeface.CustomFont;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.iconics.typeface.GenericFont;
import com.mikepenz.meteocons_typeface_library.Meteoconcs;
import com.mikepenz.octicons_typeface_library.Octicons;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Iconics.registerFont(new GoogleMaterial());
        Iconics.registerFont(new FontAwesome());
        Iconics.registerFont(new Meteoconcs());
        Iconics.registerFont(new Octicons());
        Iconics.registerFont(new CommunityMaterial());
        Iconics.registerFont(new CustomFont());

        //Generic font creation process
        GenericFont gf2 = new GenericFont("gmf", "fonts/materialdrawerfont.ttf");
        gf2.registerIcon("person", '\ue800');
        gf2.registerIcon("up", '\ue801');
        gf2.registerIcon("down", '\ue802');
        Iconics.registerFont(gf2);
    }

}
