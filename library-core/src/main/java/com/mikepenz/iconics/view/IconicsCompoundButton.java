package com.mikepenz.iconics.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import com.mikepenz.iconics.Iconics;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.internal.AttributeSetReader;
import com.mikepenz.iconics.internal.CheckableIconBundle;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
public class IconicsCompoundButton extends CompoundButton {
    private CheckableIconBundle mIconBundle = new CheckableIconBundle();
    
    public IconicsCompoundButton(Context context) {
        super(context);
    }
    
    public IconicsCompoundButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public IconicsCompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            applyAttr(context, attrs, defStyle);
        }
    }
    
    private void applyAttr(Context context, AttributeSet attrs, int defStyle) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconicsCompoundButton, defStyle, 0);
        
        AttributeSetReader.readIconicsCompoundButton(a, mIconBundle);
        
        a.recycle();
    
        if (mIconBundle.createIcons(context)) {
            setButtonDrawable(mIconBundle.createStates(context));
        }
    }
    
    public void setCheckedIcon(@Nullable IconicsDrawable icon) {
        mIconBundle.mCheckedIconBundle.mIcon = icon;
        setButtonDrawable(mIconBundle.createStates(getContext()));
    }
    
    public void setUncheckedIcon(@Nullable IconicsDrawable icon) {
        mIconBundle.mUncheckedIconBundle.mIcon = icon;
        setButtonDrawable(mIconBundle.createStates(getContext()));
    }
    
    @Nullable
    public IconicsDrawable getCheckedIcon() {
        return mIconBundle.mCheckedIconBundle.mIcon;
    }
    
    @Nullable
    public IconicsDrawable getUncheckedIcon() {
        return mIconBundle.mUncheckedIconBundle.mIcon;
    }
    
    @Override
    public void setText(CharSequence text, BufferType type) {
        if (!isInEditMode()) {
            super.setText(new Iconics.IconicsBuilder().ctx(getContext()).on(text).build(), type);
        } else {
            super.setText(text, type);
        }
    }
    
    @Override
    public CharSequence getAccessibilityClassName() {
        return IconicsCompoundButton.class.getName();
    }
}
