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

package com.mikepenz.iconics.internal;

import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.TextViewCompat;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class CompoundIconsBundle {
    public IconicsDrawable mStartIcon;
    public IconicsDrawable mTopIcon;
    public IconicsDrawable mEndIcon;
    public IconicsDrawable mBottomIcon;

    public void setIcons(TextView textView) {
        Drawable[] drawables = TextViewCompat.getCompoundDrawablesRelative(textView);

        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(textView,
                mStartIcon != null ? mStartIcon : drawables[0],
                mTopIcon != null ? mTopIcon : drawables[1],
                mEndIcon != null ? mEndIcon : drawables[2],
                mBottomIcon != null ? mBottomIcon : drawables[3]
        );
    }
}
