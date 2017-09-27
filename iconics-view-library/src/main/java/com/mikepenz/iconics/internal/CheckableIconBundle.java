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

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.utils.Utils;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class CheckableIconBundle {
    public boolean mAnimateChanges;
    public IconicsDrawable mCheckedIconBundle;
    public IconicsDrawable mUncheckedIconBundle;

    public void createIcons(Context ctx) {
        mCheckedIconBundle = new IconicsDrawable(ctx);
        mUncheckedIconBundle = new IconicsDrawable(ctx);
    }

    public StateListDrawable createStates(Context ctx) {
        return Utils.getCheckableIconStateList(ctx, mUncheckedIconBundle,
                mCheckedIconBundle, mAnimateChanges);
    }
}
