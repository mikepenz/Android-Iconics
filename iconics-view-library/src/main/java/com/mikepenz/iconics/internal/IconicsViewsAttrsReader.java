package com.mikepenz.iconics.internal;

import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;

import com.mikepenz.iconics.utils.Utils;
import com.mikepenz.iconics.view.R;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconicsViewsAttrsReader {
    
    //region IconicsTextView
    
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
    public static void readIconicsTextView(TypedArray a, CompoundIconsBundle bundle) {
        IconBundle allIconBundle = new IconBundle();
        
        //obtaining attributes for all icons
        readIconicsTextViewAll(a, allIconBundle);
        
        //obtaining attributes for start icons
        readIconicsTextViewStart(a, bundle.mStartIconBundle, allIconBundle);
        
        //obtaining attributes for top icons
        readIconicsTextViewTop(a, bundle.mTopIconBundle, allIconBundle);
        
        //obtaining attributes for end icons
        readIconicsTextViewEnd(a, bundle.mEndIconBundle, allIconBundle);
        
        //obtaining attributes for bottom icons
        readIconicsTextViewBottom(a, bundle.mBottomIconBundle, allIconBundle);
        
    }
    
    public static void readIconicsTextViewAll(TypedArray a, IconBundle bundle) {
        bundle.mIconString = a.getString(R.styleable.IconicsTextView_iiv_all_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_all_color, 0);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_size, -1);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_padding, -1);
            bundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_all_contour_color, 0);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_contour_width, -1);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_all_background_color, 0);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_corner_radius, -1);
        }
    }
    
    public static void readIconicsTextViewStart(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_start_icon, R.styleable.IconicsTextView_iiv_all_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_start_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_start_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_start_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_corner_radius, defBundle.mCornerRadius);
        }
    }
    
    public static void readIconicsTextViewTop(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_top_icon, R.styleable.IconicsTextView_iiv_all_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_top_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_top_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_top_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_corner_radius, defBundle.mCornerRadius);
        }
    }
    
    public static void readIconicsTextViewEnd(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_end_icon, R.styleable.IconicsTextView_iiv_all_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_end_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_end_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_end_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_corner_radius, defBundle.mCornerRadius);
        }
    }
    
    public static void readIconicsTextViewBottom(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_bottom_icon, R.styleable.IconicsTextView_iiv_all_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_corner_radius, defBundle.mCornerRadius);
        }
    }
    //endregion
    
    //region IconicsCompoundButton
    public static void readIconicsCompoundButton(TypedArray a, CheckableIconBundle bundle) {
        //obtaining attributes for Checked icon state
        readIconicsCompoundButtonChecked(a, bundle.mCheckedIconBundle);
        
        //obtaining attributes for Unchecked icon state
        readIconicsCompoundButtonUnchecked(a, bundle.mUncheckedIconBundle);
    }
    
    public static void readIconicsCompoundButtonChecked(TypedArray a, IconBundle bundle) {
        bundle.mIconString = a.getString(R.styleable.IconicsCompoundButton_iiv_checked_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_color, 0);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_size, -1);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_padding, -1);
            bundle.mContourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_contour_color, 0);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_contour_width, -1);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_background_color, 0);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_corner_radius, -1);
        }
    }
    
    public static void readIconicsCompoundButtonUnchecked(TypedArray a, IconBundle bundle) {
        bundle.mIconString = a.getString(R.styleable.IconicsCompoundButton_iiv_unchecked_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_color, 0);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_size, -1);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_padding, -1);
            bundle.mContourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_color, 0);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_width, -1);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_background_color, 0);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_corner_radius, -1);
        }
    }
    //endregion
    
    //region IconicsCheckableTextView
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
    public static void readIconicsCheckableTextView(TypedArray a, CompoundIconsBundle bundle) {
        IconBundle allIconBundle = new IconBundle();
        
        //obtaining attributes for all icons
        readIconicsCheckableTextViewAll(a, allIconBundle);
        
        //obtaining attributes for start icons
        readIconicsCheckableTextViewStart(a, bundle.mStartIconBundle, allIconBundle);
        
        //obtaining attributes for top icons
        readIconicsCheckableTextViewTop(a, bundle.mTopIconBundle, allIconBundle);
        
        //obtaining attributes for end icons
        readIconicsCheckableTextViewEnd(a, bundle.mEndIconBundle, allIconBundle);
        
        //obtaining attributes for bottom icons
        readIconicsCheckableTextViewBottom(a, bundle.mBottomIconBundle, allIconBundle);
        
    }
    
    public static void readIconicsCheckableTextViewAll(TypedArray a, IconBundle bundle) {
        bundle.mIconString = a.getString(R.styleable.IconicsTextView_iiv_all_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_all_color, 0);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_size, -1);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_padding, -1);
            bundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_all_contour_color, 0);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_contour_width, -1);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_all_background_color, 0);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_corner_radius, -1);
        }
    }
    
    public static void readIconicsCheckableTextViewStart(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a,
                R.styleable.IconicsCheckableTextView_iiv_start_checked_icon,
                R.styleable.IconicsCheckableTextView_iiv_all_checked_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_corner_radius, defBundle.mCornerRadius);
        }
    }
    
    public static void readIconicsCheckableTextViewTop(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a,
                R.styleable.IconicsCheckableTextView_iiv_top_checked_icon,
                R.styleable.IconicsCheckableTextView_iiv_all_checked_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_corner_radius, defBundle.mCornerRadius);
        }
    }
    
    public static void readIconicsCheckableTextViewEnd(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a,
                R.styleable.IconicsCheckableTextView_iiv_end_checked_icon,
                R.styleable.IconicsCheckableTextView_iiv_all_checked_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_corner_radius, defBundle.mCornerRadius);
        }
    }
    
    public static void readIconicsCheckableTextViewBottom(TypedArray a, IconBundle bundle, IconBundle defBundle) {
        bundle.mIconString = Utils.getString(a,
                R.styleable.IconicsCheckableTextView_iiv_bottom_checked_icon,
                R.styleable.IconicsCheckableTextView_iiv_all_checked_icon);
        if (!TextUtils.isEmpty(bundle.mIconString)) {
            bundle.mColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_color, defBundle.mColor);
            bundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_size, defBundle.mSize);
            bundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_padding, defBundle.mPadding);
            bundle.mContourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_color, defBundle.mContourColor);
            bundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_width, defBundle.mContourWidth);
            bundle.mBackgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_color, defBundle.mBackgroundColor);
            bundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_corner_radius, defBundle.mCornerRadius);
        }
    }
    //endregion
}
