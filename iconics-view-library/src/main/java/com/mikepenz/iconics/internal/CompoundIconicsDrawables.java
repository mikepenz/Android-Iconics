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

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

import com.mikepenz.iconics.IconicsDrawable;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public interface CompoundIconicsDrawables {

    IconicsDrawable getIconicsDrawableStart();

    IconicsDrawable getIconicsDrawableTop();

    IconicsDrawable getIconicsDrawableEnd();

    IconicsDrawable getIconicsDrawableBottom();

    void setDrawableStart(@Nullable IconicsDrawable drawable);

    void setDrawableTop(@Nullable IconicsDrawable drawable);

    void setDrawableEnd(@Nullable IconicsDrawable drawable);

    void setDrawableBottom(@Nullable IconicsDrawable drawable);

    void setDrawableForAll(@Nullable IconicsDrawable drawable);
}
