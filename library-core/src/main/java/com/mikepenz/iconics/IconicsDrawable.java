/*
 * Copyright 2017 Mike Penz
 *
 *
 * I improved the previous version of the IconicsDrawable which
 * was written by Joan Zapata for the Android-Iconify project
 * which you can find here: http://joanzapata.com/android-iconify/
 * and added some functionality written by Artur Termenji used
 * in the https://github.com/theDazzler/droidicon project.
 *
 * The droidicon project is under the (MIT LICENSE http://opensource.org/licenses/MIT)
 * The android-iconify project under the (Apache License)
 *
 * This version of the IconicsDrawable uses functions from both
 * projects.
 *
 * In addition i added some more stuff like the toBitmap function.
 *
 *
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

package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

import static android.support.annotation.Dimension.DP;
import static android.support.annotation.Dimension.PX;

/**
 * A custom {@link Drawable} which can display icons from icon fonts.
 */
@SuppressWarnings("JavaDoc, UnusedReturnValue, WeakerAccess, unused, MethodDoesntCallSuperMethod, SameParameterValue")
public class IconicsDrawable extends Drawable {
    private Context mContext;

    private int mSizeX = -1;
    private int mSizeY = -1;

    private boolean mRespectFontBounds = false;

    private ColorStateList mIconColor;
    private Paint mIconPaint;
    private ColorStateList mBackgroundContourColor;
    private ColorStateList mIconContourColor;
    private Paint mIconContourPaint;
    private ColorStateList mBackgroundColor;
    private Paint mBackgroundPaint;

    private Paint mBackgroundContourPaint;

    private int mRoundedCornerRx = -1;
    private int mRoundedCornerRy = -1;

    private Rect mPaddingBounds;
    private RectF mPathBounds;

    private Path mPath;

    private int mIconPadding;
    private int mContourWidth;
    private int mBackgroundContourWidth;

    private int mIconOffsetX = 0;
    private int mIconOffsetY = 0;

    private int mAlpha = 255;

    private boolean mDrawContour;
    private boolean mDrawBackgroundContour;

    private boolean mDrawShadowInternal;
    private boolean mDrawShadow;
    private float mShadowRadius = 0F;
    private float mShadowDx = 0F;
    private float mShadowDy = 0F;
    private int mShadowColor = Color.TRANSPARENT;

    private IIcon mIcon;
    private String mPlainIcon;

    private ColorStateList mTint;
    private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
    private ColorFilter mTintFilter;
    private ColorFilter mColorFilter;

    public IconicsDrawable(Context context) {
        mContext = context.getApplicationContext();
        prepare();

        icon(' ');
    }

    public IconicsDrawable(Context context, Character icon) {
        mContext = context.getApplicationContext();
        prepare();

        icon(icon);
    }

    public IconicsDrawable(Context context, String icon) {
        mContext = context.getApplicationContext();
        prepare();

        try {
            ITypeface font = Iconics.findFont(context, icon.substring(0, 3));
            icon = icon.replace("-", "_");
            icon(font.getIcon(icon));
        } catch (Exception ex) {
            Log.e(Iconics.TAG, "Wrong icon name: " + icon);
        }
    }

    public IconicsDrawable(Context context, final IIcon icon) {
        mContext = context.getApplicationContext();
        prepare();
        icon(icon);
    }

    protected IconicsDrawable(Context context, final ITypeface typeface, final IIcon icon) {
        mContext = context.getApplicationContext();
        prepare();
        icon(typeface, icon);
    }

    //region getters

    /**
     * @return the icon default color
     */
    public int getColor() {
        return mIconColor.getDefaultColor();
    }

    /**
     * @return the icon colors
     */
    public ColorStateList getColorList() {
        return mIconColor;
    }

    /**
     * @return the icon contour default color
     */
    public int getContourColor() {
        return mIconContourColor.getDefaultColor();
    }

    /**
     * @return the icon contour colors
     */
    public ColorStateList getContourColorList() {
        return mIconContourColor;
    }

    /**
     * @return the icon background default color
     */
    public int getBackgroundColor() {
        return mBackgroundColor.getDefaultColor();
    }

    /**
     * @return the icon background colors
     */
    public ColorStateList getBackgroundColorList() {
        return mBackgroundColor;
    }

    /**
     * @return the icon background contour default color
     */
    public int getBackgroundContourColor() {
        return mBackgroundContourColor.getDefaultColor();
    }

    /**
     * @return the icon background contour colors
     */
    public ColorStateList getBackgroundContourColorList() {
        return mBackgroundContourColor;
    }

    /**
     * @return the IIcon which is used inside this IconicsDrawable
     */
    public IIcon getIcon() {
        return mIcon;
    }

    /**
     * @return the PlainIcon which is used inside this IconicsDrawable
     */
    public String getPlainIcon() {
        return mPlainIcon;
    }

    /**
     * just a helper method to get the alpha value
     *
     * @return current alpha
     */
    public int getCompatAlpha() {
        return mAlpha;
    }

    /**
     * Creates a BitMap to use in Widgets or anywhere else
     *
     * @return bitmap to set
     */
    public Bitmap toBitmap() {
        if (mSizeX == -1 || mSizeY == -1) {
            actionBar();
        }

        final Bitmap bitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        style(Paint.Style.FILL);

        final Canvas canvas = new Canvas(bitmap);
        setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        draw(canvas);

        return bitmap;
    }

    /**
     * clones the icon
     *
     * @return new IconicsDrawable with the same values.
     */
    @Override
    public IconicsDrawable clone() {
        IconicsDrawable iconicsDrawable = new IconicsDrawable(mContext)
                .color(IconicsColor.colorList(mIconColor))
                .sizeX(IconicsSize.px(mSizeX))
                .sizeY(IconicsSize.px(mSizeY))
                .iconOffsetX(IconicsSize.px(mIconOffsetX))
                .iconOffsetY(IconicsSize.px(mIconOffsetY))
                .padding(IconicsSize.px(mIconPadding))
                .backgroundContourColor(IconicsColor.colorList(mBackgroundContourColor))
                .backgroundColor(IconicsColor.colorList(mBackgroundColor))
                .contourColor(IconicsColor.colorList(mIconContourColor))
                .roundedCornersRx(IconicsSize.px(mRoundedCornerRx))
                .roundedCornersRy(IconicsSize.px(mRoundedCornerRy))
                .contourWidth(IconicsSize.px(mContourWidth))
                .shadowRadius(IconicsSize.px(mShadowRadius))
                .shadowDx(IconicsSize.px(mShadowDx))
                .shadowDy(IconicsSize.px(mShadowDy))
                .shadowColor(IconicsColor.colorInt(mShadowColor))
                .backgroundContourWidth(IconicsSize.px(mBackgroundContourWidth))
                .alpha(mAlpha)
                .drawShadow(mDrawShadow)
                .drawContour(mDrawContour)
                .drawBackgroundContour(mDrawBackgroundContour)
                .typeface(mIconPaint.getTypeface());

        if (mIcon != null) {
            iconicsDrawable.icon(mIcon);
        } else if (mPlainIcon != null) {
            iconicsDrawable.iconText(mPlainIcon);
        }
        return iconicsDrawable;
    }
    //endregion

    //region deprecated api

    /**
     * Size of {@link android.support.v7.widget.Toolbar} icon in dp
     * @deprecated Use {@link IconicsSize#TOOLBAR_ICON_SIZE} instead
     */
    @Deprecated
    @Dimension(unit = DP)
    public static final int TOOLBAR_ICON_SIZE = 24;

    /**
     * Size of {@link android.support.v7.widget.Toolbar} icon padding in dp
     * @deprecated Use {@link IconicsSize#TOOLBAR_ICON_PADDING} instead
     */
    @Deprecated
    @Dimension(unit = DP)
    public static final int TOOLBAR_ICON_PADDING = 1;

    //region color
    
    /**
     * Set the color of the drawable.
     *
     * @param color The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #color(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable color(@ColorInt int color) {
        return color(IconicsColor.colorInt(color));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #color(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable colorRes(@ColorRes int colorRes) {
        return color(IconicsColor.colorRes(colorRes));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #color(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable colorListRes(@ColorRes int colorRes) {
        return color(IconicsColor.colorListRes(colorRes));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colors The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #color(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable color(ColorStateList colors) {
        return color(IconicsColor.colorList(colors));
    }
    //endregion
    
    //region offsets

    /**
     * set the icon offset for X from resource
     *
     * @param iconOffsetXRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #iconOffsetX(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable iconOffsetXRes(@DimenRes int iconOffsetXRes) {
        return iconOffsetX(IconicsSize.res(iconOffsetXRes));
    }

    /**
     * set the icon offset for X as dp
     *
     * @param iconOffsetXDp
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #iconOffsetX(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable iconOffsetXDp(@Dimension(unit = DP) int iconOffsetXDp) {
        return iconOffsetX(IconicsSize.dp(iconOffsetXDp));
    }

    /**
     * set the icon offset for X
     *
     * @param iconOffsetX
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #iconOffsetX(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable iconOffsetXPx(@Dimension(unit = PX) int iconOffsetX) {
        return iconOffsetX(IconicsSize.px(iconOffsetX));
    }

    /**
     * set the icon offset for Y from resource
     *
     * @param iconOffsetYRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #iconOffsetY(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable iconOffsetYRes(@DimenRes int iconOffsetYRes) {
        return iconOffsetY(IconicsSize.res(iconOffsetYRes));
    }

    /**
     * set the icon offset for Y as dp
     *
     * @param iconOffsetYDp
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #iconOffsetY(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable iconOffsetYDp(@Dimension(unit = DP) int iconOffsetYDp) {
        return iconOffsetY(IconicsSize.dp(iconOffsetYDp));
    }

    /**
     * set the icon offset for Y
     *
     * @param iconOffsetY
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #iconOffsetY(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable iconOffsetYPx(@Dimension(unit = PX) int iconOffsetY) {
        return iconOffsetY(IconicsSize.px(iconOffsetY));
    }
    //endregion

    //region padding

    /**
     * Set the padding of the drawable from res
     *
     * @param dimenRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #padding(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable paddingRes(@DimenRes int dimenRes) {
        return padding(IconicsSize.res(dimenRes));
    }

    /**
     * Set the padding in dp for the drawable
     *
     * @param iconPadding
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #padding(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable paddingDp(@Dimension(unit = DP) int iconPadding) {
        return padding(IconicsSize.dp(iconPadding));
    }

    /**
     * Set a padding for the.
     *
     * @param iconPadding
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #padding(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable paddingPx(@Dimension(unit = PX) int iconPadding) {
        return padding(IconicsSize.px(iconPadding));
    }
    //endregion

    //region size

    /**
     * Set the size of the drawable.
     *
     * @param dimenRes The dimension resource.
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #size(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizeRes(@DimenRes int dimenRes) {
        return size(IconicsSize.res(dimenRes));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #size(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizeDp(@Dimension(unit = DP) int size) {
        return size(IconicsSize.dp(size));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #size(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizePx(@Dimension(unit = PX) int size) {
        return size(IconicsSize.px(size));
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenResX The dimension resource.
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #sizeX(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizeResX(@DimenRes int dimenResX) {
        return sizeX(IconicsSize.res(dimenResX));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeX The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #sizeX(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizeDpX(@Dimension(unit = DP) int sizeX) {
        return sizeX(IconicsSize.dp(sizeX));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeX The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #sizeX(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizePxX(@Dimension(unit = PX) int sizeX) {
        return sizeX(IconicsSize.px(sizeX));
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenResY The dimension resource.
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #sizeY(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizeResY(@DimenRes int dimenResY) {
        return sizeY(IconicsSize.res(dimenResY));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeY The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #sizeY(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizeDpY(@Dimension(unit = DP) int sizeY) {
        return sizeY(IconicsSize.dp(sizeY));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeY The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #sizeY(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable sizePxY(@Dimension(unit = PX) int sizeY) {
        return sizeY(IconicsSize.px(sizeY));
    }
    //endregion
    
    //region background contour

    /**
     * Set background contour color from color res.
     *
     * @param backgroundContourColorRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated Use {@link #backgroundContourColor(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable backgroundContourColorRes(@ColorRes int backgroundContourColorRes) {
        return backgroundContourColor(IconicsColor.colorRes(backgroundContourColorRes));
    }

    /**
     * Set background contour color for the.
     *
     * @param backgroundContourColor
     * @return The current IconicsDrawable for chaining.
     * @deprecated Use {@link #backgroundContourColor(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable backgroundContourColor(@ColorInt int backgroundContourColor) {
        return backgroundContourColor(IconicsColor.colorInt(backgroundContourColor));
    }
    //endregion
    
    //region icon contour color

    /**
     * Set contour color from color res.
     *
     * @param contourColorRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #contourColor(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable contourColorRes(@ColorRes int contourColorRes) {
        return contourColor(IconicsColor.colorRes(contourColorRes));
    }

    /**
     * Set contour color for the.
     *
     * @param contourColor
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #contourColor(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable contourColor(@ColorInt int contourColor) {
        return contourColor(IconicsColor.colorInt(contourColor));
    }
    //endregion
    
    //region background color

    /**
     * set background color from res
     *
     * @param backgroundColorRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #contourColor(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable backgroundColorRes(@ColorRes int backgroundColorRes) {
        return backgroundColor(IconicsColor.colorRes(backgroundColorRes));
    }

    /**
     * set background color
     *
     * @param backgroundColor
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #contourColor(IconicsColor)} instead
     */
    @Deprecated
    public IconicsDrawable backgroundColor(@ColorInt int backgroundColor) {
        return backgroundColor(IconicsColor.colorInt(backgroundColor));
    }
    //endregion

    //region rounded corners

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRxRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCornersRx(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersRxRes(@DimenRes int roundedCornerRxRes) {
        return roundedCornersRx(IconicsSize.res(roundedCornerRxRes));
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerRxDp
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCornersRx(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersRxDp(@Dimension(unit = DP) int roundedCornerRxDp) {
        return roundedCornersRx(IconicsSize.dp(roundedCornerRxDp));
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerRxPx
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCornersRx(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersRxPx(@Dimension(unit = PX) int roundedCornerRxPx) {
        return roundedCornersRx(IconicsSize.px(roundedCornerRxPx));
    }

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRyRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCornersRy(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersRyRes(@DimenRes int roundedCornerRyRes) {
        return roundedCornersRy(IconicsSize.res(roundedCornerRyRes));
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerRyDp
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCornersRy(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersRyDp(@Dimension(unit = DP) int roundedCornerRyDp) {
        return roundedCornersRy(IconicsSize.dp(roundedCornerRyDp));
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerRyPx
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCornersRy(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersRyPx(@Dimension(unit = PX) int roundedCornerRyPx) {
        return roundedCornersRy(IconicsSize.px(roundedCornerRyPx));
    }

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCorners(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersRes(@DimenRes int roundedCornerRes) {
        return roundedCorners(IconicsSize.res(roundedCornerRes));
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerDp
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCorners(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersDp(@Dimension(unit = DP) int roundedCornerDp) {
        return roundedCorners(IconicsSize.dp(roundedCornerDp));
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerPx
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #roundedCorners(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable roundedCornersPx(@Dimension(unit = PX) int roundedCornerPx) {
        return roundedCorners(IconicsSize.px(roundedCornerPx));
    }
    //endregion

    //region contour width

    /**
     * Set contour width from an dimen res for the icon
     *
     * @param contourWidthRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #contourWidth(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable contourWidthRes(@DimenRes int contourWidthRes) {
        return contourWidth(IconicsSize.res(contourWidthRes));
    }

    /**
     * Set contour width from dp for the icon
     *
     * @param contourWidthDp
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #contourWidth(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable contourWidthDp(@Dimension(unit = DP) int contourWidthDp) {
        return contourWidth(IconicsSize.dp(contourWidthDp));
    }

    /**
     * Set contour width for the icon.
     *
     * @param contourWidth
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #contourWidth(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable contourWidthPx(@Dimension(unit = PX) int contourWidth) {
        return contourWidth(IconicsSize.px(contourWidth));
    }
    //endregion

    //region background contour width

    /**
     * Set background contour width from an dimen res for the icon
     *
     * @param backgroundContourWidthRes
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #backgroundContourWidth(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable backgroundContourWidthRes(@DimenRes int backgroundContourWidthRes) {
        return backgroundContourWidth(IconicsSize.res(backgroundContourWidthRes));
    }

    /**
     * Set background contour width from dp for the icon
     *
     * @param backgroundContourWidthDp
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #backgroundContourWidth(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable backgroundContourWidthDp(@Dimension(unit = DP) int backgroundContourWidthDp) {
        return backgroundContourWidth(IconicsSize.dp(backgroundContourWidthDp));
    }

    /**
     * Set background contour width for the icon.
     *
     * @param backgroundContourWidth
     * @return The current IconicsDrawable for chaining.
     * @deprecated use {@link #backgroundContourWidth(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable backgroundContourWidthPx(@Dimension(unit = PX) int backgroundContourWidth) {
        return backgroundContourWidth(IconicsSize.px(backgroundContourWidth));
    }
    //endregion

    //region shadow

    /**
     * Sets the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     * @deprecated use {@link #shadowColor(IconicsColor)}, {@link #shadowDelta(IconicsSize)},
     * {@link #shadowRadius(IconicsSize)}, {@link #shadowDx(IconicsSize)},
     * {@link #shadowDy(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable shadowRes(@DimenRes int radiusRes, @DimenRes int dxRes, @DimenRes int dyRes, @ColorRes int colorRes) {
        return shadowColor(IconicsColor.colorRes(colorRes))
                .shadowRadius(IconicsSize.res(radiusRes))
                .shadowDy(IconicsSize.res(dyRes))
                .shadowDx(IconicsSize.res(dxRes));
    }

    /**
     * Sets the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     * @deprecated use {@link #shadowColor(IconicsColor)}, {@link #shadowDelta(IconicsSize)},
     * {@link #shadowRadius(IconicsSize)}, {@link #shadowDx(IconicsSize)},
     * {@link #shadowDy(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable shadowDp(@Dimension(unit = DP) float radiusDp, @Dimension(unit = DP) float dxDp, @Dimension(unit = DP) float dyDp, @ColorInt int color) {
        return shadowColor(IconicsColor.colorInt(color))
                .shadowRadius(IconicsSize.dp(radiusDp))
                .shadowDy(IconicsSize.dp(dyDp))
                .shadowDx(IconicsSize.dp(dxDp));
    }

    /**
     * Sets the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     * @deprecated use {@link #shadowColor(IconicsColor)}, {@link #shadowDelta(IconicsSize)},
     * {@link #shadowRadius(IconicsSize)}, {@link #shadowDx(IconicsSize)},
     * {@link #shadowDy(IconicsSize)} instead
     */
    @Deprecated
    public IconicsDrawable shadowPx(@Dimension(unit = PX) float radius, @Dimension(unit = PX) float dx, @Dimension(unit = PX) float dy, @ColorInt int color) {
        return shadowColor(IconicsColor.colorInt(color))
                .shadowRadius(IconicsSize.px(radius))
                .shadowDy(IconicsSize.px(dy))
                .shadowDx(IconicsSize.px(dx));
    }
    //endregion

    //endregion

    //region chain setters

    //region icon

    /**
     * Loads and draws given text
     *
     * @param icon
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable icon(String icon) {
        try {
            ITypeface font = Iconics.findFont(mContext, icon.substring(0, 3));
            icon = icon.replace("-", "_");
            icon(font.getIcon(icon));
        } catch (Exception ex) {
            Log.e(Iconics.TAG, "Wrong icon name: " + icon);
        }
        return this;
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable icon(Character icon) {
        return iconText(icon.toString(), null);
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @param typeface
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable icon(Character icon, @Nullable Typeface typeface) {
        return iconText(icon.toString(), typeface);
    }

    /**
     * Loads and draws given text
     *
     * @param icon
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconText(String icon) {
        return iconText(icon, null);
    }

    /**
     * Loads and draws given text
     *
     * @param icon
     * @param typeface
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconText(String icon, @Nullable Typeface typeface) {
        mPlainIcon = icon;
        mIcon = null;
        mIconPaint.setTypeface(typeface == null ? Typeface.DEFAULT : typeface);

        invalidateSelf();
        return this;
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable icon(IIcon icon) {
        mIcon = icon;
        mPlainIcon = null;
        ITypeface typeface = icon.getTypeface();
        mIconPaint.setTypeface(typeface.getTypeface(mContext));

        invalidateSelf();
        return this;
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @param typeface
     * @return The current IconicsDrawable for chaining.
     */
    protected IconicsDrawable icon(ITypeface typeface, IIcon icon) {
        mIcon = icon;
        mIconPaint.setTypeface(typeface.getTypeface(mContext));

        invalidateSelf();
        return this;
    }
    //endregion

    //region icon size

    /**
     * Sets the size and the Padding to the correct values to be used for the actionBar / toolBar
     *
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable actionBar() {
        size(IconicsSize.TOOLBAR_ICON_SIZE);
        padding(IconicsSize.TOOLBAR_ICON_PADDING);
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The extractor of size.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable size(IconicsSize size) {
        mSizeX = mSizeY = size.extract(mContext);
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The extractor of size of Y.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeY(IconicsSize size) {
        mSizeY = size.extract(mContext);
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The extractor of size of X.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeX(IconicsSize size) {
        mSizeX = size.extract(mContext);
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }
    //endregion

    //region icon color

    /**
     * Set the color of the drawable.
     *
     * @param color The extractor of color.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable color(IconicsColor color) {
        mIconColor = color.extract(mContext);

        updateIconColor();
        return this;
    }
    //endregion

    //region icon contour

    /**
     * Set contour color for the drawable.
     *
     * @param color The extractor of color.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable contourColor(IconicsColor color) {
        mIconContourColor = color.extract(mContext);

        updateIconContourColor();
        return this;
    }

    /**
     * Set contour width for the icon.
     *
     * @param size The extractor of size.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable contourWidth(IconicsSize size) {
        mContourWidth = size.extract(mContext);
        mIconContourPaint.setStrokeWidth(mContourWidth);
        drawContour(true);

        invalidateSelf();
        return this;
    }

    /**
     * Enable/disable contour drawing.
     *
     * @param drawContour
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable drawContour(boolean drawContour) {
        if (mDrawContour != drawContour) {
            mDrawContour = drawContour;

            mIconPadding += (mDrawContour ? 1 : -1) * mContourWidth;

            invalidateSelf();
        }
        return this;
    }
    //endregion

    //region offsets

    /**
     * Set the icon offset
     *
     * @param size The extractor of size.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffset(IconicsSize size) {
        mIconOffsetX = mIconOffsetY = size.extract(mContext);

        invalidateSelf();
        return this;
    }

    /**
     * Set the icon offset for X
     *
     * @param size The extractor of size of X.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetY(IconicsSize size) {
        mIconOffsetY = size.extract(mContext);

        invalidateSelf();
        return this;
    }

    /**
     * Set the icon offset for Y
     *
     * @param size The extractor of size of Y.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetX(IconicsSize size) {
        mIconOffsetX = size.extract(mContext);

        invalidateSelf();
        return this;
    }
    //endregion

    //region padding

    /**
     * Set a padding for the drawable.
     *
     * @param size The extractor of size.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable padding(IconicsSize size) {
        int iconPadding = size.extract(mContext);
        if (mIconPadding != iconPadding) {
            mIconPadding = iconPadding;
            if (mDrawContour) {
                mIconPadding += mContourWidth;
            }
            if (mDrawBackgroundContour) {
                mIconPadding += mBackgroundContourWidth;
            }

            invalidateSelf();
        }
        return this;
    }
    //endregion

    //region background color

    /**
     * Set background color
     *
     * @param color The extractor of color.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundColor(IconicsColor color) {
        mBackgroundColor = color.extract(mContext);
        if (mRoundedCornerRx == -1) {
            mRoundedCornerRx = 0;
        }
        if (mRoundedCornerRy == -1) {
            mRoundedCornerRy = 0;
        }
        updateBackgroundContourColor();

        invalidateSelf();
        return this;
    }
    //endregion

    //region background contour

    /**
     * Set background contour width for the icon.
     *
     * @param size The extractor of size.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundContourWidth(IconicsSize size) {
        mBackgroundContourWidth = size.extract(mContext);
        mBackgroundContourPaint.setStrokeWidth(mBackgroundContourWidth);
        drawBackgroundContour(true);

        invalidateSelf();
        return this;
    }

    /**
     * Set background contour color for the.
     *
     * @param color The extractor of color.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundContourColor(IconicsColor color) {
        mBackgroundContourColor = color.extract(mContext);

        updateBackgroundContourColor();
        return this;
    }

    /**
     * Enable/disable background contour drawing.
     *
     * @param drawBackgroundContour
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable drawBackgroundContour(boolean drawBackgroundContour) {
        if (mDrawBackgroundContour != drawBackgroundContour) {
            mDrawBackgroundContour = drawBackgroundContour;

            mIconPadding += (mDrawBackgroundContour ? 1 : -1) * mBackgroundContourWidth * 2;

            invalidateSelf();
        }
        return this;
    }
    //endregion

    //region rounded corner

    /**
     * Set rounded corner
     *
     * @param size The extractor of size.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable roundedCorners(IconicsSize size) {
        mRoundedCornerRy = mRoundedCornerRx = size.extract(mContext);

        invalidateSelf();
        return this;
    }

    /**
     * Set rx size for rounded corner
     *
     * @param size The extractor of size of rx.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable roundedCornersRx(IconicsSize size) {
        mRoundedCornerRx = size.extract(mContext);

        invalidateSelf();
        return this;
    }

    /**
     * Set ry size for rounded corner
     *
     * @param size The extractor of size of ry.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable roundedCornersRy(IconicsSize size) {
        mRoundedCornerRy = size.extract(mContext);

        invalidateSelf();
        return this;
    }
    //endregion

    //region shadow

    //region shadow radius

    /**
     * Sets the shadow radius for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowRadius(IconicsSize size) {
        mShadowRadius = size.extractFloat(mContext);

        drawShadow(true);

        invalidateSelf();
        return this;
    }
    //endregion

    //region shadow delta

    /**
     * Sets the shadow delta for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDelta(IconicsSize size) {
        mShadowDx = mShadowDy = size.extractFloat(mContext);

        invalidateSelf();
        return this;
    }

    /**
     * Sets the shadow delta Y for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDy(IconicsSize size) {
        mShadowDy = size.extractFloat(mContext);

        invalidateSelf();
        return this;
    }

    /**
     * Sets the shadow delta X for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDx(IconicsSize size) {
        mShadowDx = size.extractFloat(mContext);

        invalidateSelf();
        return this;
    }
    //endregion

    //region shadow color

    /**
     * Sets the shadow color for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowColor(IconicsColor color) {
        ColorStateList colorStateList = color.extract(mContext);
        if (colorStateList != null) {
            mShadowColor = colorStateList.getDefaultColor();

            invalidateSelf();
        }
        return this;
    }
    //endregion

    /**
     * Enables the `LAYER_TYPE_SOFTWARE` for the view holding this icon,
     * to enable correct shadowLayer drawing
     *
     * @param view the view holding this `IconicsDrawable`
     * @return The current IconicsDrawable for chaining.
     * @see View#setLayerType(int, Paint)
     */
    public IconicsDrawable enableShadowSupport(View view) {
        view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        return this;
    }

    /**
     * Enable / disable the shadow drawing for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable drawShadow(boolean drawShadow) {
        if (mDrawShadow != drawShadow) {
            mDrawShadow = drawShadow;
            mDrawShadowInternal = mDrawShadow && mShadowRadius > 0;

            invalidateSelf();
        }
        return this;
    }
    //endregion

    //region common features methods

    /**
     * Set if it should respect the original bounds of the icon. (DEFAULT is false)
     * This will break the "padding" functionality, but keep the padding defined by the font itself
     * Check it out with the oct_arrow_down and oct_arrow_small_down of the Octicons font
     *
     * @param respectBounds set to true if it should respect the original bounds
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable respectFontBounds(boolean respectBounds) {
        mRespectFontBounds = respectBounds;

        invalidateSelf();
        return this;
    }

    /**
     * Set the colorFilter
     *
     * @param cf
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable colorFilter(ColorFilter cf) {
        setColorFilter(cf);
        return this;
    }

    /**
     * Sets the opacity
     * **NOTE** if you define a color (or as part of a colorStateList) with alpha
     * the alpha value of that color will ALWAYS WIN!
     *
     * @param alpha
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable alpha(int alpha) {
        setAlpha(alpha);
        return this;
    }

    /**
     * Sets the style
     *
     * @param style
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable style(Paint.Style style) {
        mIconPaint.setStyle(style);

        invalidateSelf();
        return this;
    }

    /**
     * sets the typeface of the drawable
     * NOTE THIS WILL OVERWRITE THE ICONFONT!
     *
     * @param typeface
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable typeface(Typeface typeface) {
        mIconPaint.setTypeface(typeface);

        invalidateSelf();
        return this;
    }
    //endregion
    //endregion

    //region overridden methods from android.graphics.drawable.Drawable class
    @Override
    public void draw(@NonNull Canvas canvas) {
        if (mIcon != null || mPlainIcon != null) {
            final Rect viewBounds = getBounds();

            updatePaddingBounds(viewBounds);
            updateTextSize(viewBounds);
            offsetIcon(viewBounds);

            if (mBackgroundPaint != null && mRoundedCornerRy > -1 && mRoundedCornerRx > -1) {
                if (mDrawBackgroundContour && mBackgroundContourPaint != null) {
                    float halfContourSize = mBackgroundContourWidth / 2;
                    RectF rectF = new RectF(halfContourSize, halfContourSize,
                            viewBounds.width() - halfContourSize,
                            viewBounds.height() - halfContourSize);
                    canvas.drawRoundRect(rectF, mRoundedCornerRx, mRoundedCornerRy, mBackgroundPaint);
                    canvas.drawRoundRect(rectF, mRoundedCornerRx, mRoundedCornerRy, mBackgroundContourPaint);
                } else {
                    RectF rectF = new RectF(0, 0, viewBounds.width(), viewBounds.height());
                    canvas.drawRoundRect(rectF, mRoundedCornerRx, mRoundedCornerRy, mBackgroundPaint);
                }
            }

            if (!mPath.isEmpty()) {
                mPath.close();
            }

            if (mDrawContour) {
                canvas.drawPath(mPath, mIconContourPaint);
            }

            if (mDrawShadowInternal) {
                mIconPaint.setShadowLayer(mShadowRadius, mShadowDx, mShadowDy, mShadowColor);
            } else {
                mIconPaint.setShadowLayer(0, 0, 0, 0);
            }

            mIconPaint.setColorFilter(mColorFilter == null ? mTintFilter : mColorFilter);

            canvas.drawPath(mPath, mIconPaint);
        }
    }

    @Override
    public void setTint(int tintColor) {
        setTintList(ColorStateList.valueOf(tintColor));
    }

    @Override
    public void setTintList(ColorStateList tint) {
        mTint = tint;
        mTintFilter = updateTintFilter(tint, mTintMode);

        invalidateSelf();
    }

    @Override
    public void setTintMode(@NonNull PorterDuff.Mode tintMode) {
        mTintMode = tintMode;
        mTintFilter = updateTintFilter(mTint, tintMode);

        invalidateSelf();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        offsetIcon(bounds);
        if (!mPath.isEmpty()) {
            mPath.close();
        }
        super.onBoundsChange(bounds);
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public boolean setState(@NonNull int[] stateSet) {
        boolean b = super.setState(stateSet);
        return b || (mIconColor != null && mIconColor.isStateful() || mColorFilter != null || mTintFilter != null);
    }

    @Override
    public int getOpacity() {
        if (mTintFilter != null || mIconPaint.getColorFilter() != null) {
            return PixelFormat.TRANSLUCENT;
        }
        switch (getAlpha()) {
            case 255:
                return PixelFormat.OPAQUE;
            case 0:
                return PixelFormat.TRANSPARENT;
        }
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    protected boolean onStateChange(int[] stateSet) {
        boolean ret = false;
        if (mIconColor != null && mIconColor.isStateful()) {
            updateIconColor();
            ret = true;
        }
        if (mIconContourColor != null && mIconContourColor.isStateful()) {
            updateIconContourColor();
            ret = true;
        }
        if (mBackgroundColor != null && mBackgroundColor.isStateful()) {
            updateBackgroundColor();
            ret = true;
        }
        if (mBackgroundContourColor != null && mBackgroundContourColor.isStateful()) {
            updateBackgroundContourColor();
            ret = true;
        }
        if (mTint != null && mTintMode != null) {
            mTintFilter = updateTintFilter(mTint, mTintMode);
            invalidateSelf();
            ret = true;
        }
        return ret;
    }

    @Override
    public int getIntrinsicWidth() {
        return mSizeX;
    }

    @Override
    public int getIntrinsicHeight() {
        return mSizeY;
    }

    @Override
    public void setAlpha(int alpha) {
        mIconPaint.setAlpha(alpha);
        mIconContourPaint.setAlpha(alpha);
        mBackgroundPaint.setAlpha(alpha);
        mBackgroundContourPaint.setAlpha(alpha);
        mAlpha = alpha;

        invalidateSelf();
    }

    @Override
    public int getAlpha() {
        return mAlpha;
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mColorFilter = cf;

        invalidateSelf();
    }

    @Override
    public void clearColorFilter() {
        mColorFilter = null;

        invalidateSelf();
    }
    //endregion

    //region PRIVATE HELPER METHODS
    private void prepare() {
        mIconPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mIconPaint.setStyle(Paint.Style.FILL);
        mIconPaint.setTextAlign(Paint.Align.CENTER);
        mIconPaint.setUnderlineText(false);
        mIconPaint.setAntiAlias(true);

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mIconContourPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mIconContourPaint.setStyle(Paint.Style.STROKE);

        mBackgroundContourPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundContourPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();

        mPathBounds = new RectF();
        mPaddingBounds = new Rect();
    }

    /**
     * Update the Padding Bounds
     *
     * @param viewBounds
     */
    private void updatePaddingBounds(Rect viewBounds) {
        if (mIconPadding >= 0
                && !(mIconPadding * 2 > viewBounds.width())
                && !(mIconPadding * 2 > viewBounds.height())) {
            mPaddingBounds.set(
                    viewBounds.left + mIconPadding,
                    viewBounds.top + mIconPadding,
                    viewBounds.right - mIconPadding,
                    viewBounds.bottom - mIconPadding);
        }
    }

    /**
     * Update the TextSize
     *
     * @param viewBounds
     */
    private void updateTextSize(Rect viewBounds) {
        float textSize = (float) viewBounds.height() * (mRespectFontBounds ? 1 : 2);
        mIconPaint.setTextSize(textSize);

        String textValue = mIcon != null ? String.valueOf(mIcon.getCharacter()) : String.valueOf(mPlainIcon);
        mIconPaint.getTextPath(textValue, 0, textValue.length(), 0, viewBounds.height(), mPath);
        mPath.computeBounds(mPathBounds, true);

        if (!mRespectFontBounds) {
            float deltaWidth = ((float) mPaddingBounds.width() / mPathBounds.width());
            float deltaHeight = ((float) mPaddingBounds.height() / mPathBounds.height());
            float delta = (deltaWidth < deltaHeight) ? deltaWidth : deltaHeight;
            textSize *= delta;

            mIconPaint.setTextSize(textSize);

            mIconPaint.getTextPath(textValue, 0, textValue.length(), 0, viewBounds.height(), mPath);
            mPath.computeBounds(mPathBounds, true);
        }
    }

    /**
     * Set the icon offset
     *
     * @param viewBounds
     */
    private void offsetIcon(Rect viewBounds) {
        float startX = viewBounds.centerX() - (mPathBounds.width() / 2);
        float offsetX = startX - mPathBounds.left;

        float startY = viewBounds.centerY() - (mPathBounds.height() / 2);
        float offsetY = startY - (mPathBounds.top);

        mPath.offset(offsetX + mIconOffsetX, offsetY + mIconOffsetY);
    }

    /**
     * Ensures that the icon paint and alpha is consistent with icon state, invalidates icon if
     * any changes were made
     */
    private void updateIconColor() {
        updateColor(mIconPaint, mIconColor);
    }

    /**
     * Ensures that the background paint and alpha is consistent with icon state,
     * invalidates icon if any changes were made
     */
    private void updateBackgroundColor() {
        updateColor(mBackgroundPaint, mBackgroundColor);
    }

    /**
     * Ensures that the icon contour paint and alpha is consistent with icon state,
     * invalidates icon if any changes were made
     */
    private void updateIconContourColor() {
        updateColor(mIconContourPaint, mIconContourColor);
    }

    /**
     * Ensures that the background contour paint and alpha is consistent with icon state,
     * invalidates icon if any changes were made
     */
    private void updateBackgroundContourColor() {
        updateColor(mBackgroundContourPaint, mBackgroundContourColor);
    }

    private void updateColor(@NonNull Paint paint, @NonNull ColorStateList colorStateList) {
        boolean invalidate = false;

        int currentColor = colorStateList.getColorForState(getState(), colorStateList.getDefaultColor());
        int red = Color.red(currentColor);
        int green = Color.green(currentColor);
        int blue = Color.blue(currentColor);

        int color = Color.rgb(red, green, blue);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidate = true;
        }

        int alpha = Color.alpha(color);
        if (alpha != 255 && alpha != paint.getAlpha()) {
            paint.setAlpha(alpha);
            invalidate = true;
        }
        if (invalidate) {
            invalidateSelf();
        }
    }

    /**
     * Ensures the tint filter is consistent with the current tint color and
     * mode.
     */
    private PorterDuffColorFilter updateTintFilter(ColorStateList tint, PorterDuff.Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        // setMode, setColor of PorterDuffColorFilter are not public method in SDK v7. (Thanks @Google still not accessible in API v24)
        // Therefore we create a new one all the time here. Don't expect this is called often.
        final int color = tint.getColorForState(getState(), Color.TRANSPARENT);
        return new PorterDuffColorFilter(color, tintMode);
    }
    //endregion
}