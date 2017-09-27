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
import android.support.annotation.RestrictTo;
import android.util.AttributeSet;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author zTrap (09.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public interface IconicsView {

    @RestrictTo(LIBRARY_GROUP)
    void initialize(Context context, AttributeSet attrs, int defStyle);

    @RestrictTo(LIBRARY_GROUP)
    void applyAttr(Context context, AttributeSet attrs, int defStyle);
}
