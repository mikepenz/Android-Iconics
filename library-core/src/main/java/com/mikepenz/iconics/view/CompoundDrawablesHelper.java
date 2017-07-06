package com.mikepenz.iconics.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.core.R;
import com.mikepenz.iconics.utils.Utils;

/**
 * @author pa.gulko zTrap (06.07.2017)
 */
class CompoundDrawablesHelper {
    IconBundle mStartIconBundle = new IconBundle();
    IconBundle mTopIconBundle = new IconBundle();
    IconBundle mEndIconBundle = new IconBundle();
    IconBundle mBottomIconBundle = new IconBundle();
    
    
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
    void applyAttr(Context context, AttributeSet attrs, int defStyle, @NonNull Runnable postApplyRunnable) {
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
        mStartIconBundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_start_icon, R.styleable.IconicsTextView_iiv_all_icon);
        
        mStartIconBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_start_color, allIconsBundle.mColor);
        mStartIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_size, allIconsBundle.mSize);
        mStartIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_padding, allIconsBundle.mPadding);
        mStartIconBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_start_contour_color, allIconsBundle.mContourColor);
        mStartIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_contour_width, allIconsBundle.mContourWidth);
        mStartIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_start_background_color, allIconsBundle.mBackgroundColor);
        mStartIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_corner_radius, allIconsBundle.mCornerRadius);
        
        //obtaining attributes for all icons
        mTopIconBundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_top_icon, R.styleable.IconicsTextView_iiv_all_icon);
        
        mTopIconBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_top_color, allIconsBundle.mColor);
        mTopIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_size, allIconsBundle.mSize);
        mTopIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_padding, allIconsBundle.mPadding);
        mTopIconBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_top_contour_color, allIconsBundle.mContourColor);
        mTopIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_contour_width, allIconsBundle.mContourWidth);
        mTopIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_top_background_color, allIconsBundle.mBackgroundColor);
        mTopIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_corner_radius, allIconsBundle.mCornerRadius);
        
        //obtaining attributes for all icons
        mEndIconBundle.mIconString = Utils.getString(a, R.styleable.IconicsTextView_iiv_end_icon, R.styleable.IconicsTextView_iiv_all_icon);
        
        mEndIconBundle.mColor = a.getColor(R.styleable.IconicsTextView_iiv_end_color, allIconsBundle.mColor);
        mEndIconBundle.mSize = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_size, allIconsBundle.mSize);
        mEndIconBundle.mPadding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_padding, allIconsBundle.mPadding);
        mEndIconBundle.mContourColor = a.getColor(R.styleable.IconicsTextView_iiv_end_contour_color, allIconsBundle.mContourColor);
        mEndIconBundle.mContourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_contour_width, allIconsBundle.mContourWidth);
        mEndIconBundle.mBackgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_end_background_color, allIconsBundle.mBackgroundColor);
        mEndIconBundle.mCornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_corner_radius, allIconsBundle.mCornerRadius);
        
        //obtaining attributes for all icons
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
    
        //creating icons from obtained attributes
        createIcons(context);
        
        //run post-apply runnable
        postApplyRunnable.run();
    }
    
    private void createIcons(Context ctx){
        createIconFromBundle(mStartIconBundle, ctx);
        createIconFromBundle(mTopIconBundle, ctx);
        createIconFromBundle(mEndIconBundle, ctx);
        createIconFromBundle(mBottomIconBundle, ctx);
    }
    
    static void createIconFromBundle(IconBundle bundle, Context ctx) {
        if (bundle.mIconString != null && !TextUtils.isEmpty(bundle.mIconString.trim())) {
            bundle.mIcon = new IconicsDrawable(ctx, bundle.mIconString);
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
}
