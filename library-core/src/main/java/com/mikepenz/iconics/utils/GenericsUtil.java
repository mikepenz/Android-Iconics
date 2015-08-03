package com.mikepenz.iconics.utils;

import android.content.Context;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by mikepenz on 03.08.15.
 */
public class GenericsUtil {

    public static String[] getFields(Context ctx) {
        Class rClass = resolveRClass(ctx.getPackageName());

        if (rClass != null) {
            for (Class c : rClass.getClasses()) {
                if (c.getName().endsWith("string")) {
                    return getDefinedFonts(ctx, c.getFields());
                }
            }
        }
        return new String[0];
    }

    /**
     * a helper class to resolve the correct R Class for the package
     *
     * @param packageName
     * @return
     */
    private static Class resolveRClass(String packageName) {
        try {
            return Class.forName(packageName + ".R");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return Class.forName(packageName.replace(".debug", "") + ".R");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return Class.forName(packageName.replace(".release", "") + ".R");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * A helper method to get a String[] out of a fieldArray
     *
     * @param fields R.strings.class.getFields()
     * @return a String[] with the string ids we need
     */
    private static String[] getDefinedFonts(Context ctx, Field[] fields) {
        ArrayList<String> fieldArray = new ArrayList<String>();
        for (Field field : fields) {
            if (field.getName().contains("define_font_")) {
                fieldArray.add(getStringResourceByName(ctx, field.getName()));
            }
        }
        return fieldArray.toArray(new String[fieldArray.size()]);
    }

    /**
     * helper class to retrieve a string by it's resource name
     *
     * @param ctx
     * @param resourceName
     * @return
     */
    private static String getStringResourceByName(Context ctx, String resourceName) {
        String packageName = ctx.getPackageName();
        int resId = ctx.getResources().getIdentifier(resourceName, "string", packageName);
        if (resId == 0) {
            return "";
        } else {
            return ctx.getString(resId);
        }
    }
}
