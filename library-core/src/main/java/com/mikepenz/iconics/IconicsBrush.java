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
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mikepenz.iconics.animation.IconicsAnimationProcessor;

/**
 * Helper class to control applying state changes to colors and paint. Also for compact providing
 * into {@link IconicsAnimationProcessor AnimationProcessor}
 *
 * @author pa.gulko zTrap (28.11.2018)
 */
public class IconicsBrush<T extends Paint> {
    @Nullable
    private ColorStateList mColors;
    @NonNull
    private final T mPaint;
    @Nullable
    private int[] mState;
    private int mAlpha = 255;

    public IconicsBrush(@NonNull T paint) {
        mPaint = paint;
        mPaint.setAlpha(mAlpha);
    }

    /**
     * @param colors which will be applied on {@link #getPaint()} for drawing current state
     */
    public void setColors(@Nullable ColorStateList colors) {
        mColors = colors;
    }

    /**
     * @return colors which applied on {@link #getPaint()} for drawing current state
     */
    @Nullable
    public ColorStateList getColorsList() {
        return mColors;
    }

    /**
     * @return paint. Will be used for drawing something (icon, background etc.)
     */
    @NonNull
    public T getPaint() {
        return mPaint;
    }

    /**
     * @param alpha channel for colors
     */
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        mAlpha = alpha;
        mPaint.setAlpha(alpha);
    }

    /**
     * @return alpha channel for colors
     */
    @IntRange(from = 0, to = 255)
    public int getAlpha() {
        return mAlpha;
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
        if (alpha != mAlpha) {
            setAlpha(alpha);
            isInvalidate = true;
        }
        return isInvalidate;
    }
}
