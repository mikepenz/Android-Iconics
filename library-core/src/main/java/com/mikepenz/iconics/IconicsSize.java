/*
 * Copyright 2018 Mike Penz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mikepenz.iconics;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;

import com.mikepenz.iconics.utils.Utils;

/**
 * @author pa.gulko zTrap (20.01.2018)
 */
public final class IconicsSize implements IconicsExtractor {
    @Dimension(unit = Dimension.DP) private float mDp = DEF_SIZE;
    @Dimension(unit = Dimension.PX) private float mPx = DEF_SIZE;
    @DimenRes private int mRes = DEF_RESOURCE;

    /**
     * Size of {@link android.support.v7.widget.Toolbar} icon in dp
     */
    public static final IconicsSize TOOLBAR_ICON_SIZE = IconicsSize.dp(24);

    /**
     * Size of {@link android.support.v7.widget.Toolbar} icon padding in dp
     */
    public static final IconicsSize TOOLBAR_ICON_PADDING = IconicsSize.dp(1);

    private IconicsSize() {
    }

    /**
     * @param dp The size in density-independent pixels (dp).
     * */
    public static IconicsSize dp(@Dimension(unit = Dimension.DP) float dp) {
        IconicsSize iconicsSize = new IconicsSize();
        iconicsSize.mDp = dp;
        return iconicsSize;
    }

    /**
     * @param px The size in pixels (px).
     * */
    public static IconicsSize px(@Dimension(unit = Dimension.PX) float px) {
        IconicsSize iconicsSize = new IconicsSize();
        iconicsSize.mPx = px;
        return iconicsSize;
    }

    /**
     * @param res The dimension resource.
     * */
    public static IconicsSize res(@DimenRes int res) {
        IconicsSize iconicsSize = new IconicsSize();
        iconicsSize.mRes = res;
        return iconicsSize;
    }

    float extractFloat(Context context) {
        if (mPx == DEF_SIZE) {
            if (mDp != DEF_SIZE) {
                mPx = Utils.convertDpToPx(context, mDp);
                return mPx;
            }
            if (mRes != DEF_RESOURCE) {
                mPx = context.getResources().getDimensionPixelSize(mRes);
                return mPx;
            }
        }
        return mPx;
    }

    int extract(Context context) {
        return (int) extractFloat(context);
    }
}
