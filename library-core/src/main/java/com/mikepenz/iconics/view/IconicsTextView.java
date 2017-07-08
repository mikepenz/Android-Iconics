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
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.internal.AttributeSetReader;
import com.mikepenz.iconics.internal.CompoundIconicsDrawables;
import com.mikepenz.iconics.internal.CompoundIconsBundle;

public class IconicsTextView extends AppCompatTextView implements CompoundIconicsDrawables {
    private CompoundIconsBundle mIconsBundle = new CompoundIconsBundle();
    
    public IconicsTextView(Context context) {
        this(context, null);
    }
    
    public IconicsTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }
    
    public IconicsTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            applyAttr(context, attrs, defStyle);
        }
    }
    
    private void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsTextView, defStyle, 0);
        
        AttributeSetReader.readIconicsTextView(a, mIconsBundle);
        
        //recycle the typedArray
        a.recycle();
        
        //creating icons from obtained attributes
        mIconsBundle.createIcons(context);
        
        //setting created icons
        setIcons();
    }
    
    private void setIcons(){
        mIconsBundle.setIcons(this);
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableStart(){
        return mIconsBundle.mStartIconBundle.mIcon;
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableTop(){
        return mIconsBundle.mTopIconBundle.mIcon;
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableEnd(){
        return mIconsBundle.mEndIconBundle.mIcon;
    }
    
    @Nullable
    @Override
    public IconicsDrawable getIconicsDrawableBottom(){
        return mIconsBundle.mBottomIconBundle.mIcon;
    }
    
    @Override
    public void setIconicsDrawableStart(@Nullable IconicsDrawable drawable){
        mIconsBundle.mStartIconBundle.mIcon = drawable;
        setIcons();
    }
    
    @Override
    public void setIconicsDrawableTop(@Nullable IconicsDrawable drawable){
        mIconsBundle.mTopIconBundle.mIcon = drawable;
        setIcons();
    }
    
    @Override
    public void setIconicsDrawableEnd(@Nullable IconicsDrawable drawable){
        mIconsBundle.mEndIconBundle.mIcon = drawable;
        setIcons();
    }
    
    @Override
    public void setIconicsDrawableBottom(@Nullable IconicsDrawable drawable){
        mIconsBundle.mBottomIconBundle.mIcon = drawable;
        setIcons();
    }
    
    
    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!isInEditMode()) {
            super.setText(new Iconics.IconicsBuilder().ctx(getContext()).on(text).build(), type);
        } else {
            super.setText(text, type);
        }
    }
}
