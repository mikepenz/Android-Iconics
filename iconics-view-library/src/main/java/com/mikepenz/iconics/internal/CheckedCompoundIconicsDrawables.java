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

import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (09.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public interface CheckedCompoundIconicsDrawables {

    IconicsDrawable getCheckedIconicsDrawableStart();

    IconicsDrawable getCheckedIconicsDrawableTop();

    IconicsDrawable getCheckedIconicsDrawableEnd();

    IconicsDrawable getCheckedIconicsDrawableBottom();

    void setCheckedDrawableStart(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableTop(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableEnd(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableBottom(@Nullable IconicsDrawable drawable);

    void setCheckedDrawableForAll(@Nullable IconicsDrawable drawable);
}
