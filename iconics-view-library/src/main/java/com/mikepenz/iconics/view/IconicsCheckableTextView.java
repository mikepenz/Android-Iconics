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
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.SoundEffectConstants;
import android.widget.Checkable;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.animation.IconicsAnimatedDrawable;
import com.mikepenz.iconics.internal.CheckedCompoundIconicsDrawables;
import com.mikepenz.iconics.internal.CompoundIconsBundle;
import com.mikepenz.iconics.internal.IconicsViewsAttrsApplier;
import com.mikepenz.iconics.utils.Utils;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.widget.TextViewCompat;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
public class IconicsCheckableTextView extends IconicsTextView implements Checkable, CheckedCompoundIconicsDrawables {
    protected CompoundIconsBundle mCheckedIconsBundle;
    private boolean mAnimateChanges;

    private boolean mChecked;
    private boolean mBroadcasting;

    private OnCheckedChangeListener mOnCheckedChangeListener;

    private static final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked
    };

    public IconicsCheckableTextView(Context context) {
        this(context, null);
    }

    public IconicsCheckableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public IconicsCheckableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void initialize(Context context, AttributeSet attrs, int defStyle) {
        mCheckedIconsBundle = new CompoundIconsBundle();
        setFocusable(true);
        setClickable(true);
        //taking normal state attrs
        super.applyAttr(context, attrs, defStyle);
        checkAnimation(mIconsBundle.mBottomIcon);
        checkAnimation(mIconsBundle.mTopIcon);
        checkAnimation(mIconsBundle.mEndIcon);
        checkAnimation(mIconsBundle.mStartIcon);

        //taking checked state attrs
        applyAttr(context, attrs, defStyle);

        checkAnimation(mCheckedIconsBundle.mBottomIcon);
        checkAnimation(mCheckedIconsBundle.mTopIcon);
        checkAnimation(mCheckedIconsBundle.mEndIcon);
        checkAnimation(mCheckedIconsBundle.mStartIcon);
        //setting created icons
        setIcons();
    }

    @Override
    @RestrictTo(LIBRARY_GROUP)
    public void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        IconicsViewsAttrsApplier.readIconicsCheckableTextView(context, attrs, mCheckedIconsBundle);
        mAnimateChanges = IconicsViewsAttrsApplier.isIconicsAnimateChanges(context, attrs);
    }

    private void setIcons() {
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this,
                createStatesStart(),
                createStatesTop(),
                createStatesEnd(),
                createStatesBottom()
        );
    }

    private StateListDrawable createStatesStart() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mStartIcon,
                mCheckedIconsBundle.mStartIcon, mAnimateChanges);
    }

    private StateListDrawable createStatesTop() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mTopIcon,
                mCheckedIconsBundle.mTopIcon, mAnimateChanges);
    }

    private StateListDrawable createStatesEnd() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mEndIcon,
                mCheckedIconsBundle.mEndIcon, mAnimateChanges);
    }

    private StateListDrawable createStatesBottom() {
        return Utils.getCheckableIconStateList(getContext(), mIconsBundle.mBottomIcon,
                mCheckedIconsBundle.mBottomIcon, mAnimateChanges);
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return IconicsCheckableTextView.class.getName();
    }

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            refreshDrawableState();

            // Avoid infinite recursions if setChecked() is called from a listener
            if (mBroadcasting) {
                return;
            }

            mBroadcasting = true;
            if (mOnCheckedChangeListener != null) {
                mOnCheckedChangeListener.onCheckedChanged(this, mChecked);
            }
            mBroadcasting = false;
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public boolean performClick() {
        toggle();

        final boolean handled = super.performClick();
        if (!handled) {
            playSoundEffect(SoundEffectConstants.CLICK);
        }

        return handled;
    }

    //region CheckedCompoundIconicsDrawablesImpl
    @Override
    public IconicsDrawable getCheckedIconicsDrawableStart() {
        if (mCheckedIconsBundle.mStartIcon != null) {
            return mCheckedIconsBundle.mStartIcon;
        } else {
            return null;
        }
    }

    @Override
    public IconicsDrawable getCheckedIconicsDrawableTop() {
        if (mCheckedIconsBundle.mTopIcon != null) {
            return mCheckedIconsBundle.mTopIcon;
        } else {
            return null;
        }
    }

    @Override
    public IconicsDrawable getCheckedIconicsDrawableEnd() {
        if (mCheckedIconsBundle.mEndIcon != null) {
            return mCheckedIconsBundle.mEndIcon;
        } else {
            return null;
        }
    }

    @Override
    public IconicsDrawable getCheckedIconicsDrawableBottom() {
        if (mCheckedIconsBundle.mBottomIcon != null) {
            return mCheckedIconsBundle.mBottomIcon;
        } else {
            return null;
        }
    }

    @Override
    public void setCheckedDrawableStart(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mStartIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setCheckedDrawableTop(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mTopIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setCheckedDrawableEnd(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mEndIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setCheckedDrawableBottom(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mBottomIcon = checkAnimation(drawable);
        setIcons();
    }

    @Override
    public void setCheckedDrawableForAll(@Nullable IconicsDrawable drawable) {
        mCheckedIconsBundle.mStartIcon = checkAnimation(drawable);
        mCheckedIconsBundle.mTopIcon = checkAnimation(drawable);
        mCheckedIconsBundle.mEndIcon = checkAnimation(drawable);
        mCheckedIconsBundle.mBottomIcon = checkAnimation(drawable);
        setIcons();
    }

    private @Nullable IconicsDrawable checkAnimation(@Nullable IconicsDrawable drawable) {
        if (drawable == null) return null;
        if (drawable instanceof IconicsAnimatedDrawable) {
            ((IconicsAnimatedDrawable) drawable).animateIn(this);
        }
        return drawable;
    }
    //endregion

    public interface OnCheckedChangeListener {
        void onCheckedChanged(IconicsCheckableTextView buttonView, boolean isChecked);
    }
}
