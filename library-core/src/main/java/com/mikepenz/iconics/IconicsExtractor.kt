/*
 * Copyright 2019 Mike Penz
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

package com.mikepenz.iconics

/**
 * @author pa.gulko zTrap (20.01.2018)
 */
internal interface IconicsExtractor {
    companion object {
        const val DEF_COLOR: Int = Int.MIN_VALUE
        const val DEF_RESOURCE: Int = -1
        val DEF_SIZE: Number = -1
    }
}