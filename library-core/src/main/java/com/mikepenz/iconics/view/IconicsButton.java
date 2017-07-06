/*
 * Copyright 2014 Mike Penz
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
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;

public class IconicsButton extends AppCompatButton implements SideIconicsDrawables {
    private CompoundDrawablesHelper mApplier;

    public IconicsButton(Context context) {
        super(context);
    }

    public IconicsButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconicsButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            mApplier = new CompoundDrawablesHelper();
            mApplier.applyAttr(context, attrs, defStyle, new Runnable() {
                @Override
                public void run() {
                    //setting created icons
                    setIcons();
                }
            });
        }
    }
    
    private void setIcons(){
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this,
                mApplier.mStartIconBundle.mIcon,
                mApplier.mTopIconBundle.mIcon,
                mApplier.mEndIconBundle.mIcon,
                mApplier.mBottomIconBundle.mIcon
        );
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableStart(){
        return mApplier.mStartIconBundle.mIcon;
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableTop(){
        return mApplier.mTopIconBundle.mIcon;
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableEnd(){
        return mApplier.mEndIconBundle.mIcon;
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableBottom(){
        return mApplier.mBottomIconBundle.mIcon;
    }
    
    @Override
    public void setIconicsDrawableStart(@Nullable IconicsDrawable drawable){
        mApplier.mStartIconBundle.mIcon = drawable;
        setIcons();
    }
    
    @Override
    public void setIconicsDrawableTop(@Nullable IconicsDrawable drawable){
        mApplier.mTopIconBundle.mIcon = drawable;
        setIcons();
    }
    
    @Override
    public void setIconicsDrawableEnd(@Nullable IconicsDrawable drawable){
        mApplier.mEndIconBundle.mIcon = drawable;
        setIcons();
    }
    
    @Override
    public void setIconicsDrawableBottom(@Nullable IconicsDrawable drawable){
        mApplier.mBottomIconBundle.mIcon = drawable;
        setIcons();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        // NOTES:
        // 1. Need to disable the All Caps option to make Spannable work properly!
        // 2. This method will be called from the constructor of the super class
        setAllCaps(false);

        if (!isInEditMode()) {
            super.setText(new Iconics.IconicsBuilder().ctx(getContext()).on(text).build(), type);
        } else {
            super.setText(text, type);
        }
    }
}
