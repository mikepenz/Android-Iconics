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

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/**
 * @author pa.gulko zTrap (28.11.2018)
 */
@SuppressWarnings("UnusedReturnValue, WeakerAccess, unused")
public class IconicsAnimatedDrawable extends IconicsDrawable {
    @NonNull
    private List<IconicsAnimationProcessor> mProcessors = new ArrayList<>();

    public IconicsAnimatedDrawable(Context context) {
        super(context);
    }

    public IconicsAnimatedDrawable(Context context, Character icon) {
        super(context, icon);
    }

    public IconicsAnimatedDrawable(Context context, String icon) {
        super(context, icon);
    }

    public IconicsAnimatedDrawable(Context context, IIcon icon) {
        super(context, icon);
    }

    protected IconicsAnimatedDrawable(Context context, ITypeface typeface, IIcon icon) {
        super(context, typeface, icon);
    }

    @Override
    public int getAlpha() {
        return mIconBrush.getAlpha();
    }

    @Override
    public int getCompatAlpha() {
        return mIconBrush.getAlpha();
    }

    // FI-LO
    @Override
    public void draw(@NonNull Canvas canvas) {
        for (int i = 0; i < mProcessors.size(); i++) {
            IconicsAnimationProcessor p = mProcessors.get(i);
            p.processPreDraw(
                    canvas,
                    mIconBrush,
                    mContourBrush,
                    mBackgroundBrush,
                    mBackgroundContourBrush);
        }

        super.draw(canvas);

        for (int i = mProcessors.size() - 1; i >= 0; i--) {
            IconicsAnimationProcessor p = mProcessors.get(i);
            p.processPostDraw(canvas);
        }
    }

    /**
     * Attach an {@link IconicsAnimationProcessor processor} to this drawable
     */
    @NonNull
    public IconicsAnimatedDrawable processor(@NonNull IconicsAnimationProcessor processor) {
        if (processor == null) return this;
        processor.setDrawable(this);
        mProcessors.add(processor);
        return this;
    }

    /**
     * Attach an {@link IconicsAnimationProcessor processors} to this drawable
     */
    @NonNull
    public IconicsAnimatedDrawable processors(@NonNull IconicsAnimationProcessor... processors) {
        if (processors == null || processors.length == 0) return this;
        for (IconicsAnimationProcessor processor : processors) {
            processor(processor);
        }
        return this;
    }

    /**
     * @return The runner which used for animations. Animations can be easily removed by calling
     * {@link Runner#unset()}
     */
    @NonNull
    public Runner animateIn(@Nullable View view) {
        Runner runner = new Runner();
        runner.setFor(view, this);
        return runner;
    }

    public static class Runner {
        private boolean mIsAttached = false;
        @Nullable
        private View mView;
        @Nullable
        private IconicsAnimatedDrawable mDrawable;

        private Runner() {
        }

        private View.OnAttachStateChangeListener mListener = new View.OnAttachStateChangeListener() {

            @Override
            public void onViewAttachedToWindow(@NonNull final View v) {
                mIsAttached = true;
                ViewCompat.postOnAnimation(v, new Runnable() {
                    @Override
                    public void run() {
                        if (mIsAttached && mDrawable != null) {
                            v.invalidateDrawable(mDrawable);
                            ViewCompat.postOnAnimation(v, this);
                        }
                    }
                });
            }

            @Override
            public void onViewDetachedFromWindow(@NonNull View v) {
                mIsAttached = false;
            }
        };

        /**
         * Setup all animations to provided drawable and view
         */
        public void setFor(@NonNull View view, @NonNull IconicsAnimatedDrawable drawable) {
            unset();
            if (view == null || drawable == null) return;
            mView = view;
            mDrawable = drawable;
            if (ViewCompat.isAttachedToWindow(view)) {
                mListener.onViewAttachedToWindow(view);
            }
            view.addOnAttachStateChangeListener(mListener);
        }

        /**
         * Clear all animations from previously provided drawable and view
         */
        public void unset() {
            mDrawable = null;
            if (mView != null) {
                mView.removeOnAttachStateChangeListener(mListener);
                mView = null;
            }
            mIsAttached = false;
        }
    }
}
