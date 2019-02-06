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

package com.mikepenz.iconics.animation

import android.os.Build

import androidx.annotation.RequiresApi

/**
 * @author pa.gulko zTrap (01.12.2018)
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
interface IconicsAnimationPauseListener {
    /**
     * Notifies that the processor was paused.
     *
     * @param processor The processor being paused.
     * @see IconicsAnimationProcessor.pause
     */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun onAnimationPause(processor: IconicsAnimationProcessor) {
    }

    /**
     * Notifies that the processor was resumed, after being
     * previously paused.
     *
     * @param processor The processor being resumed.
     * @see IconicsAnimationProcessor.resume
     */
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun onAnimationResume(processor: IconicsAnimationProcessor) {
    }
}