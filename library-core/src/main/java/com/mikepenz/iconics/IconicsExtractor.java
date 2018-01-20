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

import android.support.annotation.RestrictTo;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (20.01.2018)
 */
@RestrictTo(LIBRARY_GROUP)
public interface IconicsExtractor {
    int DEF_COLOR = Integer.MIN_VALUE;
    int DEF_SIZE = -1;
    int DEF_RESOURCE = -1;
}
