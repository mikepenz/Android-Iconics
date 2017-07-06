package com.mikepenz.iconics.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.utils.Utils;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
public class IconicsCompoundButton extends CompoundButton {
    private IconBundle mCheckedIconBundle = new IconBundle();
    private IconBundle mUncheckedIconBundle = new IconBundle();
    private boolean mAnimateChanges;
    
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
        
        mAnimateChanges = a.getBoolean(R.styleable.IconicsCompoundButton_iiv_animate_icon_changes, true);
        
        //obtaining attributes for Checked icon state
        mCheckedIconBundle.mIconString = a.getString(R.styleable.IconicsCompoundButton_iiv_checked_icon);
        mCheckedIconBundle.mColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_color, 0);
        mCheckedIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_size, -1);
        mCheckedIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_padding, -1);
        mCheckedIconBundle.mContourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_contour_color, 0);
        mCheckedIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_contour_width, -1);
        mCheckedIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_background_color, 0);
        mCheckedIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_corner_radius, -1);
        
        //obtaining attributes for Normal icon state
        mUncheckedIconBundle.mIconString = a.getString(R.styleable.IconicsCompoundButton_iiv_unchecked_icon);
        mUncheckedIconBundle.mColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_color, 0);
        mUncheckedIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_size, -1);
        mUncheckedIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_padding, -1);
        mUncheckedIconBundle.mContourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_color, 0);
        mUncheckedIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_width, -1);
        mUncheckedIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_background_color, 0);
        mUncheckedIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_corner_radius, -1);
        
        a.recycle();
        
        CompoundDrawablesHelper.createIconFromBundle(mCheckedIconBundle, context);
        CompoundDrawablesHelper.createIconFromBundle(mUncheckedIconBundle, context);
    
        setButtonDrawable(createStates());
    }
    
    public void setCheckedIcon(@Nullable IconicsDrawable icon) {
        mCheckedIconBundle.mIcon = icon;
        setButtonDrawable(createStates());
    }
    
    public void setUncheckedIcon(@Nullable IconicsDrawable icon) {
        mUncheckedIconBundle.mIcon = icon;
        setButtonDrawable(createStates());
    }
    
    @Nullable
    public IconicsDrawable getCheckedIcon() {
        return mCheckedIconBundle.mIcon;
    }
    
    @Nullable
    public IconicsDrawable getUncheckedIcon() {
        return mUncheckedIconBundle.mIcon;
    }
    
    private StateListDrawable createStates() {
        return Utils.getCheckableIconStateList(getContext(), mUncheckedIconBundle.mIcon,
                mCheckedIconBundle.mIcon, mAnimateChanges);
    }
    
    @Override
    public CharSequence getAccessibilityClassName() {
        return IconicsCompoundButton.class.getName();
    }
}
