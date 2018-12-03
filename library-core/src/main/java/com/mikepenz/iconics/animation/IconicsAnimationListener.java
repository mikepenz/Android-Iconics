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

/**
 * @author pa.gulko zTrap (01.12.2018)
 */
public interface IconicsAnimationListener {

    /**
     * Notifies the start of the animation as well as the animation's overall play direction.
     * This method's default behavior is to call 
     * {@link #onAnimationStart(IconicsAnimationProcessor)}. This method can be overridden, 
     * though not required, to get the additional play direction info when an animation starts. 
     * Skipping calling super when overriding this method results in
     * {@link #onAnimationStart(IconicsAnimationProcessor)} not getting called.
     *
     * @param processor The started processor.
     * @param isReverse Whether the processor is playing in reverse.
     */
    default void onAnimationStart(IconicsAnimationProcessor processor, boolean isReverse) {
        onAnimationStart(processor);
    }

    /**
     * Notifies the end of the animation. This callback is not invoked
     * for animations with repeat count set to INFINITE.
     *
     * This method's default behavior is to call {@link #onAnimationEnd(IconicsAnimationProcessor)}.
     * This method can be overridden, though not required, to get the additional play direction info
     * when an animation ends. Skipping calling super when overriding this method results in
     * {@link #onAnimationEnd(IconicsAnimationProcessor)} not getting called.
     *
     * @param processor The processor which reached its end.
     * @param isReverse Whether the processor is playing in reverse.
     */
    default void onAnimationEnd(IconicsAnimationProcessor processor, boolean isReverse) {
        onAnimationEnd(processor);
    }

    /**
     * Notifies the start of the animation.
     *
     * @param processor The started processor.
     */
    default void onAnimationStart(IconicsAnimationProcessor processor) {
    }

    /**
     * Notifies the end of the animation. This callback is not invoked
     * for processors with repeat count set to INFINITE.
     *
     * @param processor The processor which reached its end.
     */
    default void onAnimationEnd(IconicsAnimationProcessor processor) {
    }

    /**
     * Notifies the cancellation of the animation. This callback is not invoked
     * for animations with repeat count set to INFINITE.
     *
     * @param processor The processor which was canceled.
     */
    default void onAnimationCancel(IconicsAnimationProcessor processor) {
    }

    /**
     * Notifies the repetition of the animation.
     *
     * @param processor The processor which was repeated.
     */
    default void onAnimationRepeat(IconicsAnimationProcessor processor) {
    }
}