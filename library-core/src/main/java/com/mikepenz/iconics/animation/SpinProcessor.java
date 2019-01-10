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
import android.graphics.Rect;
import android.text.TextPaint;

import com.mikepenz.iconics.IconicsBrush;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

/**
 * @author pa.gulko zTrap (30.11.2018)
 */
public class SpinProcessor extends IconicsAnimationProcessor {
    /**
     * Duration used for all instances of this processor by default. 2000 ms by default.
     */
    public static int defaultDuration = 2000;

    public final static int DIRECTION_CLOCKWISE = +1;
    public final static int DIRECTION_COUNTER_CLOCKWISE = -1;

    @IntDef({DIRECTION_CLOCKWISE, DIRECTION_COUNTER_CLOCKWISE})
    @Retention(RetentionPolicy.SOURCE)
    private @interface Direction {
    }

    @Direction
    private int mDirection = DIRECTION_CLOCKWISE;
    private boolean mIsDrawableShadowCleared = false;

    {
        mDuration = defaultDuration;
    }

    /**
     * @param direction The direction of the spin, {@link #DIRECTION_CLOCKWISE clockwise (+1)}
     *                  or {@link #DIRECTION_COUNTER_CLOCKWISE counter clockwise (-1)}
     */
    @NonNull
    public SpinProcessor direction(@Direction int direction) {
        mDirection = direction;
        return this;
    }

    /**
     * @return the direction of the spin, clockwise (+1) or counter clockwise (-1)
     */
    @Direction
    public int getDirection() {
        return (int) Math.signum(mDirection);
    }

    @Override
    @NonNull
    public String animationTag() {
        return "spin";
    }

    @Override
    protected void processPreDraw(
            @NonNull Canvas canvas,
            @NonNull IconicsBrush<TextPaint> iconBrush,
            @NonNull IconicsBrush<Paint> iconContourBrush,
            @NonNull IconicsBrush<Paint> backgroundBrush,
            @NonNull IconicsBrush<Paint> backgroundContourBrush) {

        // Shadow are not recalculate while spin (it spin with drawable). It looks ugly!
        // Turn off ugly shadow!
        if (!mIsDrawableShadowCleared) {
            iconBrush.getPaint().clearShadowLayer();
            mIsDrawableShadowCleared = true;
        }

        canvas.save();

        Rect bounds = getDrawableBounds();
        float degrees = getAnimatedPercent() * 3.6f * getDirection();

        canvas.rotate(degrees, bounds.width() / 2, bounds.height() / 2);
    }

    @Override
    protected void processPostDraw(@NonNull Canvas canvas) {
        canvas.restore();
    }

    @Override
    protected void onDrawableDetached() {
        mIsDrawableShadowCleared = false;
    }
}
