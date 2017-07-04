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
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.utils.Utils;

public class IconicsTextView extends AppCompatTextView {
    private IconBundle mStartIconBundle = new IconBundle();
    private IconBundle mTopIconBundle = new IconBundle();
    private IconBundle mEndIconBundle = new IconBundle();
    private IconBundle mBottomIconBundle = new IconBundle();
    
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
    
    
    /**
     * Attributes priority:
     * <p>
     * Attributes with mark 'all' < attributes with some else mark ('start', 'top' etc)<br>
     * Working like as 'style' xml-attribute - local overrides global
     * <p>
     * <b>IMPORTANT TRICK</b>
     * <p>
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    private void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsTextView, defStyle, 0);
        
        //obtaining attributes for all icons
        IconBundle allIconsBundle = new IconBundle();
        allIconsBundle.mIconString = a.getString(R.styleable.IconicsTextView_iiv_all_icon);
        allIconsBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_all_color, 0);
        allIconsBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_size, -1);
        allIconsBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_padding, -1);
        allIconsBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_all_contour_color, 0);
        allIconsBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_contour_width, -1);
        allIconsBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_all_background_color, 0);
        allIconsBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_corner_radius, -1);
        
        //obtaining attributes for all icons
        mStartIconBundle = new IconBundle();
        mStartIconBundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_start_icon, R.styleable.IconicsTextView_iiv_all_icon);
        
        mStartIconBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_start_color, allIconsBundle.mColor);
        mStartIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_size, allIconsBundle.mSize);
        mStartIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_padding, allIconsBundle.mPadding);
        mStartIconBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_start_contour_color, allIconsBundle.mContourColor);
        mStartIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_contour_width, allIconsBundle.mContourWidth);
        mStartIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_start_background_color, allIconsBundle.mBackgroundColor);
        mStartIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_corner_radius, allIconsBundle.mCornerRadius);
        
        //obtaining attributes for all icons
        mTopIconBundle = new IconBundle();
        mTopIconBundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_top_icon, R.styleable.IconicsTextView_iiv_all_icon);
        
        mTopIconBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_top_color, allIconsBundle.mColor);
        mTopIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_size, allIconsBundle.mSize);
        mTopIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_padding, allIconsBundle.mPadding);
        mTopIconBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_top_contour_color, allIconsBundle.mContourColor);
        mTopIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_contour_width, allIconsBundle.mContourWidth);
        mTopIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_top_background_color, allIconsBundle.mBackgroundColor);
        mTopIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_corner_radius, allIconsBundle.mCornerRadius);
        
        //obtaining attributes for all icons
        mEndIconBundle = new IconBundle();
        mEndIconBundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_end_icon, R.styleable.IconicsTextView_iiv_all_icon);
        
        mEndIconBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_end_color, allIconsBundle.mColor);
        mEndIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_size, allIconsBundle.mSize);
        mEndIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_padding, allIconsBundle.mPadding);
        mEndIconBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_end_contour_color, allIconsBundle.mContourColor);
        mEndIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_contour_width, allIconsBundle.mContourWidth);
        mEndIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_end_background_color, allIconsBundle.mBackgroundColor);
        mEndIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_corner_radius, allIconsBundle.mCornerRadius);
        
        //obtaining attributes for all icons
        mBottomIconBundle = new IconBundle();
        mBottomIconBundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_bottom_icon, R.styleable.IconicsTextView_iiv_all_icon);
        
        mBottomIconBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_color, allIconsBundle.mColor);
        mBottomIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_size, allIconsBundle.mSize);
        mBottomIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_padding, allIconsBundle.mPadding);
        mBottomIconBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_contour_color, allIconsBundle.mContourColor);
        mBottomIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_contour_width, allIconsBundle.mContourWidth);
        mBottomIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_background_color, allIconsBundle.mBackgroundColor);
        mBottomIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_corner_radius, allIconsBundle.mCornerRadius);
        
        //recycle the typedArray
        a.recycle();
        
        //setting obtained attributes :D
        setAttributes();
        
        //setting created icons
        setIcons();
    }
    
    private void setAttributes(){
        setAttributesFromBundle(mStartIconBundle);
        setAttributesFromBundle(mTopIconBundle);
        setAttributesFromBundle(mEndIconBundle);
        setAttributesFromBundle(mBottomIconBundle);
    }
    
    private void setIcons(){
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this,
                mStartIconBundle.mIcon,
                mTopIconBundle.mIcon,
                mEndIconBundle.mIcon,
                mBottomIconBundle.mIcon
        );
    }
    
    private void setAttributesFromBundle(IconBundle bundle) {
        if (bundle.mIconString != null && !TextUtils.isEmpty(bundle.mIconString.trim())) {
            bundle.mIcon = new IconicsDrawable(getContext(), bundle.mIconString);
        } else {
            return;
        }
        if (bundle.mColor != 0) {
            bundle.mIcon.color(bundle.mColor);
        }
        if (bundle.mSize != -1) {
            bundle.mIcon.sizePx(bundle.mSize);
        }
        if (bundle.mPadding != -1) {
            bundle.mIcon.paddingPx(bundle.mPadding);
        }
        if (bundle.mContourColor != 0) {
            bundle.mIcon.contourColor(bundle.mContourColor);
        }
        if (bundle.mContourWidth != -1) {
            bundle.mIcon.contourWidthPx(bundle.mContourWidth);
        }
        if (bundle.mBackgroundColor != 0) {
            bundle.mIcon.backgroundColor(bundle.mBackgroundColor);
        }
        if (bundle.mCornerRadius != -1) {
            bundle.mIcon.roundedCornersPx(bundle.mCornerRadius);
        }
    }
    
    @Nullable
    public IconicsDrawable getIconicsDrawableStart(){
        return mStartIconBundle.mIcon;
    }
    
    @Nullable
    public IconicsDrawable getIconicsDrawableTop(){
        return mTopIconBundle.mIcon;
    }
    
    @Nullable
    public IconicsDrawable getIconicsDrawableEnd(){
        return mEndIconBundle.mIcon;
    }
    
    @Nullable
    public IconicsDrawable getIconicsDrawableBottom(){
        return mBottomIconBundle.mIcon;
    }
    
    public void setIconicsDrawableStart(@Nullable IconicsDrawable drawable){
        mStartIconBundle.mIcon = drawable;
        setIcons();
    }
    
    public void setIconicsDrawableTop(@Nullable IconicsDrawable drawable){
        mTopIconBundle.mIcon = drawable;
        setIcons();
    }
    
    public void setIconicsDrawableEnd(@Nullable IconicsDrawable drawable){
        mEndIconBundle.mIcon = drawable;
        setIcons();
    }
    
    public void setIconicsDrawableBottom(@Nullable IconicsDrawable drawable){
        mBottomIconBundle.mIcon = drawable;
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
    
    private class IconBundle {
        private String mIconString = null;
        private IconicsDrawable mIcon = null;
        @ColorInt
        private int mColor = 0;
        private int mSize = -1;
        private int mPadding = -1;
        @ColorInt
        private int mContourColor = 0;
        private int mContourWidth = -1;
        @ColorInt
        private int mBackgroundColor = 0;
        private int mCornerRadius = -1;
    }
}
