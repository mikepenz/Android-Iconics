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
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.Utils;

import static android.support.annotation.Dimension.DP;
import static android.support.annotation.Dimension.PX;
import static android.view.View.LAYER_TYPE_SOFTWARE;

/**
 * A custom {@link Drawable} which can display icons from icon fonts.
 */
@SuppressWarnings("JavaDoc, UnusedReturnValue, WeakerAccess, unused, MethodDoesntCallSuperMethod, SameParameterValue")
public class IconicsDrawable extends Drawable {
    /**
     * Size of {@link android.support.v7.widget.Toolbar} icon in dp
     */
    @Dimension(unit = DP)
    public static final int TOOLBAR_ICON_SIZE = 24;

    /**
     * Size of {@link android.support.v7.widget.Toolbar} icon padding in dp
     */
    @Dimension(unit = DP)
    public static final int TOOLBAR_ICON_PADDING = 1;

    private Context mContext;

    private int mSizeX = -1;
    private int mSizeY = -1;

    private boolean mRespectFontBounds = false;

    private ColorStateList mIconColor;
    private Paint mIconPaint;
    private int mBackgroundContourColor;
    private int mContourColor;
    private Paint mContourPaint;
    private int mBackgroundColor;
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
     * @return the icon contour color
     */
    public int getContourColor() {
        return mContourColor;
    }

    /**
     * @return the icon background color
     */
    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    /**
     * @return the icon background contour color
     */
    public int getBackgroundContourColor() {
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
                .paddingPx(mIconPadding)
                .roundedCornersRxPx(mRoundedCornerRx)
                .roundedCornersRyPx(mRoundedCornerRy)
                .sizePxX(mSizeX)
                .sizePxY(mSizeY)
                .iconOffsetXPx(mIconOffsetX)
                .iconOffsetYPx(mIconOffsetY)
                .contourColor(mContourColor)
                .contourWidthPx(mContourWidth)
                .shadowRadiusPx(mShadowRadius)
                .shadowDxPx(mShadowDx)
                .shadowDyPx(mShadowDy)
                .shadowColor(mShadowColor)
                .backgroundColor(mBackgroundColor)
                .backgroundContourColor(mBackgroundContourColor)
                .backgroundContourWidthPx(mBackgroundContourWidth)
                .color(mIconColor)
                .alpha(mAlpha)
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

    //region chain setters

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
     * Set the color of the drawable.
     *
     * @param color The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable color(@ColorInt int color) {
        mIconColor = ColorStateList.valueOf(color);

        updateIconColor();
        return this;
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable colorRes(@ColorRes int colorRes) {
        return color(ContextCompat.getColor(mContext, colorRes));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable colorListRes(@ColorRes int colorRes) {
        return color(ContextCompat.getColorStateList(mContext, colorRes));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colors The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable color(ColorStateList colors) {
        if (colors != null) {
            mIconColor = colors;
            updateIconColor();
        }
        return this;
    }

    /**
     * set the icon offset for X from resource
     *
     * @param iconOffsetXRes
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetXRes(@DimenRes int iconOffsetXRes) {
        return iconOffsetXPx(mContext.getResources().getDimensionPixelSize(iconOffsetXRes));
    }

    /**
     * set the icon offset for X as dp
     *
     * @param iconOffsetXDp
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetXDp(@Dimension(unit = DP) int iconOffsetXDp) {
        return iconOffsetXPx(Utils.convertDpToPx(mContext, iconOffsetXDp));
    }

    /**
     * set the icon offset for X
     *
     * @param iconOffsetX
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetXPx(@Dimension(unit = PX) int iconOffsetX) {
        mIconOffsetX = iconOffsetX;

        invalidateSelf();
        return this;
    }

    /**
     * set the icon offset for Y from resource
     *
     * @param iconOffsetYRes
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetYRes(@DimenRes int iconOffsetYRes) {
        return iconOffsetYPx(mContext.getResources().getDimensionPixelSize(iconOffsetYRes));
    }

    /**
     * set the icon offset for Y as dp
     *
     * @param iconOffsetYDp
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetYDp(@Dimension(unit = DP) int iconOffsetYDp) {
        return iconOffsetYPx(Utils.convertDpToPx(mContext, iconOffsetYDp));
    }

    /**
     * set the icon offset for Y
     *
     * @param iconOffsetY
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable iconOffsetYPx(@Dimension(unit = PX) int iconOffsetY) {
        mIconOffsetY = iconOffsetY;

        invalidateSelf();
        return this;
    }

    /**
     * Set the padding of the drawable from res
     *
     * @param dimenRes
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable paddingRes(@DimenRes int dimenRes) {
        return paddingPx(mContext.getResources().getDimensionPixelSize(dimenRes));
    }

    /**
     * Set the padding in dp for the drawable
     *
     * @param iconPadding
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable paddingDp(@Dimension(unit = DP) int iconPadding) {
        return paddingPx(Utils.convertDpToPx(mContext, iconPadding));
    }

    /**
     * Set a padding for the.
     *
     * @param iconPadding
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable paddingPx(@Dimension(unit = PX) int iconPadding) {
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

    /**
     * Sets the size and the Padding to the correct values to be used for the actionBar / toolBar
     *
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable actionBar() {
        sizeDp(TOOLBAR_ICON_SIZE);
        paddingDp(TOOLBAR_ICON_PADDING);
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenRes The dimension resource.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeRes(@DimenRes int dimenRes) {
        return sizePx(mContext.getResources().getDimensionPixelSize(dimenRes));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeDp(@Dimension(unit = DP) int size) {
        return sizePx(Utils.convertDpToPx(mContext, size));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizePx(@Dimension(unit = PX) int size) {
        mSizeX = mSizeY = size;
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenResX The dimension resource.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeResX(@DimenRes int dimenResX) {
        return sizePxX(mContext.getResources().getDimensionPixelSize(dimenResX));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeX The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeDpX(@Dimension(unit = DP) int sizeX) {
        return sizePxX(Utils.convertDpToPx(mContext, sizeX));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeX The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizePxX(@Dimension(unit = PX) int sizeX) {
        mSizeX = sizeX;
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenResY The dimension resource.
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeResY(@DimenRes int dimenResY) {
        return sizePxY(mContext.getResources().getDimensionPixelSize(dimenResY));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeY The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizeDpY(@Dimension(unit = DP) int sizeY) {
        return sizePxY(Utils.convertDpToPx(mContext, sizeY));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeY The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable sizePxY(@Dimension(unit = PX) int sizeY) {
        mSizeY = sizeY;
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set background contour color from color res.
     *
     * @param backgroundContourColorRes
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundContourColorRes(@ColorRes int backgroundContourColorRes) {
        return backgroundContourColor(ContextCompat.getColor(mContext, backgroundContourColorRes));
    }

    /**
     * Set background contour color for the.
     *
     * @param backgroundContourColor
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundContourColor(@ColorInt int backgroundContourColor) {
        int red = Color.red(backgroundContourColor);
        int green = Color.green(backgroundContourColor);
        int blue = Color.blue(backgroundContourColor);
        mBackgroundContourPaint.setColor(Color.rgb(red, green, blue));
        mBackgroundContourPaint.setAlpha(Color.alpha(backgroundContourColor));
        mBackgroundContourColor = backgroundContourColor;

        invalidateSelf();
        return this;
    }

    /**
     * Set contour color from color res.
     *
     * @param contourColorRes
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable contourColorRes(@ColorRes int contourColorRes) {
        return contourColor(ContextCompat.getColor(mContext, contourColorRes));
    }

    /**
     * Set contour color for the.
     *
     * @param contourColor
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable contourColor(@ColorInt int contourColor) {
        int red = Color.red(contourColor);
        int green = Color.green(contourColor);
        int blue = Color.blue(contourColor);
        mContourPaint.setColor(Color.rgb(red, green, blue));
        mContourPaint.setAlpha(Color.alpha(contourColor));
        mContourColor = contourColor;

        invalidateSelf();
        return this;
    }

    /**
     * set background color from res
     *
     * @param backgroundColorRes
     * @return
     */
    public IconicsDrawable backgroundColorRes(@ColorRes int backgroundColorRes) {
        return backgroundColor(ContextCompat.getColor(mContext, backgroundColorRes));
    }

    /**
     * set background color
     *
     * @param backgroundColor
     * @return
     */
    public IconicsDrawable backgroundColor(@ColorInt int backgroundColor) {
        mBackgroundPaint.setColor(backgroundColor);
        mBackgroundColor = backgroundColor;
        if (mRoundedCornerRx == -1) {
            mRoundedCornerRx = 0;
        }
        if (mRoundedCornerRy == -1) {
            mRoundedCornerRy = 0;
        }

        invalidateSelf();
        return this;
    }

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRxRes
     * @return
     */
    public IconicsDrawable roundedCornersRxRes(@DimenRes int roundedCornerRxRes) {
        return roundedCornersRxPx(mContext.getResources().getDimensionPixelSize(roundedCornerRxRes));
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerRxDp
     * @return
     */
    public IconicsDrawable roundedCornersRxDp(@Dimension(unit = DP) int roundedCornerRxDp) {
        return roundedCornersRxPx(Utils.convertDpToPx(mContext, roundedCornerRxDp));
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerRxPx
     * @return
     */
    public IconicsDrawable roundedCornersRxPx(@Dimension(unit = PX) int roundedCornerRxPx) {
        mRoundedCornerRx = roundedCornerRxPx;

        invalidateSelf();
        return this;
    }

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRyRes
     * @return
     */
    public IconicsDrawable roundedCornersRyRes(@DimenRes int roundedCornerRyRes) {
        return roundedCornersRyPx(mContext.getResources().getDimensionPixelSize(roundedCornerRyRes));
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerRyDp
     * @return
     */
    public IconicsDrawable roundedCornersRyDp(@Dimension(unit = DP) int roundedCornerRyDp) {
        return roundedCornersRyPx(Utils.convertDpToPx(mContext, roundedCornerRyDp));
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerRyPx
     * @return
     */
    public IconicsDrawable roundedCornersRyPx(@Dimension(unit = PX) int roundedCornerRyPx) {
        mRoundedCornerRy = roundedCornerRyPx;

        invalidateSelf();
        return this;
    }

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRes
     * @return
     */
    public IconicsDrawable roundedCornersRes(@DimenRes int roundedCornerRes) {
        return roundedCornersPx(mContext.getResources().getDimensionPixelSize(roundedCornerRes));
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerDp
     * @return
     */
    public IconicsDrawable roundedCornersDp(@Dimension(unit = DP) int roundedCornerDp) {
        return roundedCornersPx(Utils.convertDpToPx(mContext, roundedCornerDp));
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerPx
     * @return
     */
    public IconicsDrawable roundedCornersPx(@Dimension(unit = PX) int roundedCornerPx) {
        mRoundedCornerRx = mRoundedCornerRy = roundedCornerPx;

        invalidateSelf();
        return this;
    }

    /**
     * Set contour width from an dimen res for the icon
     *
     * @param contourWidthRes
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable contourWidthRes(@DimenRes int contourWidthRes) {
        return contourWidthPx(mContext.getResources().getDimensionPixelSize(contourWidthRes));
    }

    /**
     * Set contour width from dp for the icon
     *
     * @param contourWidthDp
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable contourWidthDp(@Dimension(unit = DP) int contourWidthDp) {
        return contourWidthPx(Utils.convertDpToPx(mContext, contourWidthDp));
    }

    /**
     * Set contour width for the icon.
     *
     * @param contourWidth
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable contourWidthPx(@Dimension(unit = PX) int contourWidth) {
        mContourWidth = contourWidth;
        mContourPaint.setStrokeWidth(mContourWidth);
        drawContour(true);

        invalidateSelf();
        return this;
    }

    /**
     * Enables the `LAYER_TYPE_SOFTWARE` for the view holding this icon,
     * to enable correct shadowLayer drawing
     *
     * @param view the view holding this `IconicsDrawable`
     * @return The current IconicsDrawable for chaining.
     * @see View#setLayerType(int, Paint)
     */
    public IconicsDrawable enableShadowSupport(View view) {
        view.setLayerType(LAYER_TYPE_SOFTWARE, null);
        return this;
    }

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
    public IconicsDrawable shadowRadiusRes(@DimenRes int radiusRes){
        return shadowRadiusPx(mContext.getResources().getDimensionPixelSize(radiusRes));
    }

    /**
     * Sets the shadow radius for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowRadiusDp(@Dimension(unit = DP) int radiusDp){
        return shadowRadiusPx(Utils.convertDpToPx(mContext, radiusDp));
    }

    /**
     * Sets the shadow radius for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowRadiusPx(@Dimension(unit = PX) float radiusPx){
        mShadowRadius = radiusPx;

        mDrawShadow = radiusPx > 0;

        invalidateSelf();
        return this;
    }
    //endregion

    //region shadow delta X

    /**
     * Sets the shadow delta X for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDxRes(@DimenRes int dxRes){
        return shadowDxPx(mContext.getResources().getDimensionPixelSize(dxRes));
    }

    /**
     * Sets the shadow delta X for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDxDp(@Dimension(unit = DP) int dxDp) {
        return shadowDxPx(Utils.convertDpToPx(mContext, dxDp));
    }

    /**
     * Sets the shadow delta X for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDxPx(@Dimension(unit = PX) float dxPx){
        mShadowDx = dxPx;

        invalidateSelf();
        return this;
    }
    //endregion

    //region shadow delta Y

    /**
     * Sets the shadow delta Y for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDyRes(@DimenRes int dyRes){
        return shadowDyPx(mContext.getResources().getDimensionPixelSize(dyRes));
    }

    /**
     * Sets the shadow delta Y for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDyDp(@Dimension(unit = DP) int dyDp) {
        return shadowDyPx(Utils.convertDpToPx(mContext, dyDp));
    }

    /**
     * Sets the shadow delta Y for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDyPx(@Dimension(unit = PX) float dyPx){
        mShadowDy = dyPx;

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
    public IconicsDrawable shadowDeltaRes(@DimenRes int deltaRes){
        return shadowDeltaPx(mContext.getResources().getDimensionPixelSize(deltaRes));
    }

    /**
     * Sets the shadow delta for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDeltaDp(@Dimension(unit = DP) int deltaDp) {
        return shadowDeltaPx(Utils.convertDpToPx(mContext, deltaDp));
    }

    /**
     * Sets the shadow delta for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowDeltaPx(@Dimension(unit = PX) float deltaPx){
        mShadowDx = mShadowDy = deltaPx;

        invalidateSelf();
        return this;
    }
    //endregion

    //region shadow color

    /**
     * Sets the shadow color from resources for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowColorRes(@ColorRes int shadowColorRes){
        return shadowColor(ContextCompat.getColor(mContext, shadowColorRes));
    }


    /**
     * Sets the shadow color for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable shadowColor(@ColorInt int shadowColor){
        mShadowColor = shadowColor;

        invalidateSelf();
        return this;
    }
    //endregion

    /**
     * Enable / disable the shadow drawing for the icon
     * This requires {@link #enableShadowSupport(View) shadow support} to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public IconicsDrawable drawShadow(boolean drawShadow){
        mDrawShadow = drawShadow && mShadowRadius > 0;

        invalidateSelf();
        return this;
    }
    //endregion



    /**
     * Set background contour width from an dimen res for the icon
     *
     * @param backgroundContourWidthRes
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundContourWidthRes(@DimenRes int backgroundContourWidthRes) {
        return backgroundContourWidthPx(mContext.getResources().getDimensionPixelSize(backgroundContourWidthRes));
    }

    /**
     * Set background contour width from dp for the icon
     *
     * @param backgroundContourWidthDp
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundContourWidthDp(@Dimension(unit = DP) int backgroundContourWidthDp) {
        return backgroundContourWidthPx(Utils.convertDpToPx(mContext, backgroundContourWidthDp));
    }

    /**
     * Set background contour width for the icon.
     *
     * @param backgroundContourWidth
     * @return The current IconicsDrawable for chaining.
     */
    public IconicsDrawable backgroundContourWidthPx(@Dimension(unit = PX) int backgroundContourWidth) {
        mBackgroundContourWidth = backgroundContourWidth;
        mBackgroundContourPaint.setStrokeWidth(mBackgroundContourWidth);
        drawBackgroundContour(true);

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

            mPath.close();

            if (mDrawContour) {
                canvas.drawPath(mPath, mContourPaint);
            }

            if (mDrawShadow) {
                mIconPaint.setShadowLayer(mShadowRadius, mShadowDx, mShadowDy, mShadowColor);
            } else {
                mIconPaint.setShadowLayer(0, 0, 0, 0);
            }

            mIconPaint.setAlpha(mAlpha);
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
        mPath.close();
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

        mContourPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mContourPaint.setStyle(Paint.Style.STROKE);

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
        boolean invalidate = false;

        int color = mIconColor.getColorForState(getState(), mIconColor.getDefaultColor());
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        int iconColor = Color.rgb(red, green, blue);
        if (iconColor != mIconPaint.getColor()) {
            mIconPaint.setColor(iconColor);
            invalidate = true;
        }

        int alpha = Color.alpha(color);
        if (alpha != 255 && alpha != mAlpha) {
            setAlpha(alpha);
        } else if (invalidate) {
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