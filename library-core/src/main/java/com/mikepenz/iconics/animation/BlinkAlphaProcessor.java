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

package com.mikepenz.iconics.animation;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

import com.mikepenz.iconics.IconicsBrush;

/**
 * @author pa.gulko zTrap (30.11.2018)
 */
public class BlinkAlphaProcessor extends IconicsAnimationProcessor {
    /**
     * Duration used for all instances of this processor by default. 500 ms by default.
     */
    public static int defaultDuration = 500;

    private @IntRange(from = 0, to = 255)
    int mMinimumAlpha = 0;
    private @IntRange(from = 0, to = 255)
    int mMaximumAlpha = 255;

    {
        mRepeatMode = REVERSE;
        mDuration = defaultDuration;
    }

    /**
     * @param minimumAlpha The alpha which will be used as minimal available value.
     */
    public @NonNull
    BlinkAlphaProcessor minimumAlpha(@IntRange(from = 0, to = 255) int minimumAlpha) {
        mMinimumAlpha = minimumAlpha;
        return this;
    }

    /**
     * @param maximumAlpha The alpha which will be used as maximal available value.
     */
    public @NonNull
    BlinkAlphaProcessor maximumAlpha(@IntRange(from = 0, to = 255) int maximumAlpha) {
        mMaximumAlpha = maximumAlpha;
        return this;
    }

    /**
     * @return The minimal available alpha.
     */
    public @IntRange(from = 0, to = 255)
    int getMinimumAlpha() {
        return mMinimumAlpha;
    }

    /**
     * @return The maximal available alpha.
     */
    public @IntRange(from = 0, to = 255)
    int getMaximumAlpha() {
        return mMaximumAlpha;
    }

    @Override
    public @NonNull
    String animationTag() {
        return "blink_alpha";
    }

    @Override
    protected void processPreDraw(
            @NonNull Canvas canvas,
            @NonNull IconicsBrush<TextPaint> iconBrush,
            @NonNull IconicsBrush<Paint> iconContourBrush,
            @NonNull IconicsBrush<Paint> backgroundBrush,
            @NonNull IconicsBrush<Paint> backgroundContourBrush) {

        int alphaByPercent = (mMaximumAlpha - mMinimumAlpha) / 100;

        int alpha = (int) (getAnimatedPercent() * alphaByPercent);

        iconBrush.setAlpha(alpha);
        iconContourBrush.setAlpha(alpha);
        backgroundBrush.setAlpha(alpha);
        backgroundContourBrush.setAlpha(alpha);
    }
}
