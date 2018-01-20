/*
 * Copyright 2017 Mike Penz
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

package com.mikepenz.iconics.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.internal.IconicsView;
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

public class IconicsImageView extends AppCompatImageView implements IconicsView {

    public IconicsImageView(Context context) {
        this(context, null);
    }

    public IconicsImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconicsImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize(context, attrs, defStyle);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void initialize(Context context, AttributeSet attrs, int defStyle) {
        //set the scale type for this view
        setScaleType(ScaleType.CENTER_INSIDE);

        applyAttr(context, attrs, defStyle);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        setIcon(IconicsViewsAttrsApplier.getIconicsImageViewDrawable(context, attrs));
    }

    public void setIcon(@Nullable IconicsDrawable icon) {
        setImageDrawable(icon);
    }

    public IconicsDrawable getIcon() {
        if (getDrawable() instanceof IconicsDrawable) {
            return ((IconicsDrawable) getDrawable());
        } else {
            return null;
        }
    }
}
