package com.mikepenz.iconics.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.utils.Utils;
import com.mikepenz.iconics.view.R;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconicsViewsAttrsReader {

    //region IconicsImageView
    public static void readIconicsImageView(TypedArray a, IconicsDrawable icon) {
        icon.icon(a.getString(R.styleable.IconicsImageView_iiv_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsImageView_iiv_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsImageView_iiv_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsImageView_iiv_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }
    //endregion

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
    public static void readIconicsTextView(Context ctx, TypedArray a, CompoundIconsBundle bundle) {
        IconicsDrawable allIconBundle = new IconicsDrawable(ctx);

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

    public static void readIconicsTextViewAll(TypedArray a, IconicsDrawable icon) {
        icon.icon(a.getString(R.styleable.IconicsTextView_iiv_all_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsTextView_iiv_all_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_all_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_all_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsTextViewStart(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(a.getString(R.styleable.IconicsTextView_iiv_start_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsTextView_iiv_start_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_start_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_start_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsTextViewTop(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(a.getString(R.styleable.IconicsTextView_iiv_top_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsTextView_iiv_top_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_top_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_top_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsTextViewEnd(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(a.getString(R.styleable.IconicsTextView_iiv_end_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsTextView_iiv_end_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_end_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_end_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsTextViewBottom(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(a.getString(R.styleable.IconicsTextView_iiv_bottom_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsTextView_iiv_bottom_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }
    //endregion

    //region IconicsCompoundButton
    public static void readIconicsCompoundButton(TypedArray a, CheckableIconBundle icon) {
        //obtaining attributes for Checked icon state
        readIconicsCompoundButtonChecked(a, icon.mCheckedIconBundle);

        //obtaining attributes for Unchecked icon state
        readIconicsCompoundButtonUnchecked(a, icon.mUncheckedIconBundle);
    }

    public static void readIconicsCompoundButtonChecked(TypedArray a, IconicsDrawable icon) {
        icon.icon(a.getString(R.styleable.IconicsCompoundButton_iiv_checked_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsCompoundButtonUnchecked(TypedArray a, IconicsDrawable icon) {
        icon.icon(a.getString(R.styleable.IconicsCompoundButton_iiv_unchecked_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
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
    public static void readIconicsCheckableTextView(Context ctx, TypedArray a, CompoundIconsBundle bundle) {
        IconicsDrawable allIconBundle = new IconicsDrawable(ctx);

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

    public static void readIconicsCheckableTextViewAll(TypedArray a, IconicsDrawable icon) {
        icon.icon(a.getString(R.styleable.IconicsCheckableTextView_iiv_all_checked_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsCheckableTextViewStart(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_start_checked_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsCheckableTextViewTop(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_top_checked_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsCheckableTextViewEnd(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_end_checked_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_color, defIcon.getColor());
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }

    public static void readIconicsCheckableTextViewBottom(TypedArray a, IconicsDrawable icon, IconicsDrawable defIcon) {
        icon.icon(Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_bottom_checked_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }
    //endregion
}
