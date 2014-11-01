/**
 * Copyright 2013 Joan Zapata
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mikpenz.iconics.utils;

import android.content.Context;
import android.util.Log;

import com.mikpenz.iconics.Iconics;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;

public class Utils {

    public static final String ICON_FONT_FOLDER = "icon_tmp";

    private Utils() {
        // Prevents instantiation
    }

    public static int convertDpToPx(Context context, float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

    public static boolean isEnabled(int[] stateSet) {
        for (int state : stateSet)
            if (state == android.R.attr.state_enabled)
                return true;
        return false;
    }

    public static File resourceToFile(Context context, String resourceName) throws IOException {
        File f = null;
        if (context.getFilesDir() == null)
            f = new File(context.getCacheDir(), ICON_FONT_FOLDER);
        else
            f = new File(context.getFilesDir(), ICON_FONT_FOLDER);
        if (!f.exists())
            if (!f.mkdirs()) {
                Log.e(Iconics.TAG, "Font folder creation failed");
                throw new IllegalStateException("Cannot create Iconify font destination folder");
            }
        File outPath = new File(f, resourceName);
        if (outPath.exists()) return outPath;

        BufferedOutputStream bos = null;
        InputStream inputStream = null;
        try {
            inputStream = Iconics.class.getClassLoader().getResourceAsStream(resourceName);
            byte[] buffer = new byte[inputStream.available()];
            bos = new BufferedOutputStream(new FileOutputStream(outPath));
            int l = 0;
            while ((l = inputStream.read(buffer)) > 0) {
                bos.write(buffer, 0, l);
            }
            return outPath;
        } finally {
            closeQuietly(bos);
            closeQuietly(inputStream);
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                // Don't care
            }
        }
    }
}
