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

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author pa.gulko zTrap (28.11.2018)
 */
public class IconicsBrush<T extends Paint> implements Cloneable {
    private @Nullable ColorStateList mColors;
    private @NonNull final T mPaint;
    private @Nullable int[] mState;
    private int mAlpha;

    public IconicsBrush(@NonNull T paint) {
        mPaint = paint;
    }

    public void setColors(@Nullable ColorStateList colors) {
        mColors = colors;
    }

    public @Nullable ColorStateList getColorsList() {
        return mColors;
    }

    public @NonNull T getPaint() {
        return mPaint;
    }

    public void setAlpha(int alpha) {
        mAlpha = alpha;
        mPaint.setAlpha(alpha);
    }

    boolean isStateful() {
        return mColors != null && mColors.isStateful();
    }

    int getColorForCurrentState(int defaultColor) {
        if (mColors != null) {
            return mColors.getColorForState(mState, defaultColor);
        } else {
            return defaultColor;
        }
    }

    int getColorForCurrentState() {
        if (mColors != null) {
            return getColorForCurrentState(mColors.getDefaultColor());
        } else {
            return Color.TRANSPARENT;
        }
    }

    boolean applyState(@NonNull int[] state) {
        mState = state;

        boolean isInvalidate = false;

        int colorForState = getColorForCurrentState();
        int red = Color.red(colorForState);
        int green = Color.green(colorForState);
        int blue = Color.blue(colorForState);

        int colorRgb = Color.rgb(red, green, blue);
        if (colorRgb != mPaint.getColor()) {
            mPaint.setColor(colorRgb);
            isInvalidate = true;
        }

        int alpha = Color.alpha(colorForState);
        if (alpha != 255 && alpha != mAlpha) {
            setAlpha(alpha);
            isInvalidate = true;
        }
        return isInvalidate;
    }
}
