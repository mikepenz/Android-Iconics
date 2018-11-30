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
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.Utils;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import static android.view.View.LAYER_TYPE_SOFTWARE;
import static androidx.annotation.Dimension.DP;
import static androidx.annotation.Dimension.PX;

/**
 * A custom {@link Drawable} which can display icons from icon fonts.
 */
@SuppressWarnings("JavaDoc, UnusedReturnValue, WeakerAccess, unused, MethodDoesntCallSuperMethod, SameParameterValue")
public class IconicsDrawable extends Drawable {
    /**
     * Size of {@link androidx.appcompat.widget.Toolbar} icon in dp
     */
    @Dimension(unit = DP)
    public static final int TOOLBAR_ICON_SIZE = 24;

    /**
     * Size of {@link androidx.appcompat.widget.Toolbar} icon padding in dp
     */
    @Dimension(unit = DP)
    public static final int TOOLBAR_ICON_PADDING = 1;

    protected Context mContext;

    private int mSizeX = -1;
    private int mSizeY = -1;

    private boolean mRespectFontBounds = false;

    // icon
    private final IconicsBrush<TextPaint> mIconBrush = new IconicsBrush<>(new TextPaint(Paint.ANTI_ALIAS_FLAG));

    // background
    private final IconicsBrush<Paint> mBackgroundBrush = new IconicsBrush<>(new Paint(Paint.ANTI_ALIAS_FLAG));

    // contour
    private final IconicsBrush<Paint> mContourBrush = new IconicsBrush<>(new Paint(Paint.ANTI_ALIAS_FLAG));
    private boolean mDrawContour;

    // background contour
    private final IconicsBrush<Paint> mBackgroundContourBrush = new IconicsBrush<>(new Paint(Paint.ANTI_ALIAS_FLAG));
    private boolean mDrawBackgroundContour;

    private int mRoundedCornerRx = -1;
    private int mRoundedCornerRy = -1;

    private Rect mPaddingBounds = new Rect();
    private RectF mPathBounds = new RectF();

    private Path mPath = new Path();

    private int mIconPadding;
    private int mContourWidth;
    private int mBackgroundContourWidth;

    private int mIconOffsetX = 0;
    private int mIconOffsetY = 0;

    private int mAlpha = 255;

    private float mShadowRadius = 0F;
    private float mShadowDx = 0F;
    private float mShadowDy = 0F;
    private int mShadowColor = Color.TRANSPARENT;

    private @Nullable IIcon mIcon;
    private @Nullable String mPlainIcon;

    private @Nullable ColorStateList mTint;
    private @NonNull PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
    private @Nullable ColorFilter mTintFilter;
    private @Nullable ColorFilter mColorFilter;

    public IconicsDrawable(@NonNull Context context) {
        mContext = context.getApplicationContext();

        icon(' ');
    }

    public IconicsDrawable(@NonNull Context context, @NonNull Character icon) {
        this(context);

        icon(icon);
    }

    public IconicsDrawable(@NonNull Context context, @NonNull String icon) {
        this(context);

        icon(icon);
    }

    public IconicsDrawable(@NonNull Context context, @NonNull IIcon icon) {
        this(context);

        icon(icon);
    }

    protected IconicsDrawable(@NonNull Context context, @NonNull ITypeface typeface, @NonNull IIcon icon) {
        this(context);

        icon(typeface, icon);
    }

    {
        mIconBrush.getPaint().setStyle(Paint.Style.FILL);
        mIconBrush.getPaint().setTextAlign(Paint.Align.CENTER);
        mIconBrush.getPaint().setUnderlineText(false);

        mContourBrush.getPaint().setStyle(Paint.Style.STROKE);

        mBackgroundContourBrush.getPaint().setStyle(Paint.Style.STROKE);
    }

    //region getters

    /**
     * @return the icon color
     */
    public int getColor() {
        return mIconBrush.getColorForCurrentState();
    }

    /**
     * @return the icon colors
     */
    public @Nullable ColorStateList getColorList() {
        return mIconBrush.getColorsList();
    }

    /**
     * @return the icon contour color
     */
    public int getContourColor() {
        return mContourBrush.getColorForCurrentState();
    }

    /**
     * @return the contour colors
     */
    public @Nullable ColorStateList getContourColorList() {
        return mContourBrush.getColorsList();
    }

    /**
     * @return the icon background color
     */
    public int getBackgroundColor() {
        return mBackgroundBrush.getColorForCurrentState();
    }

    /**
     * @return the background colors
     */
    public @Nullable ColorStateList getBackgroundColorList() {
        return mBackgroundBrush.getColorsList();
    }

    /**
     * @return the icon background contour color
     */
    public int getBackgroundContourColor() {
        return mBackgroundContourBrush.getColorForCurrentState();
    }

    /**
     * @return the background contour colors
     */
    public @Nullable ColorStateList getBackgroundContourColorList() {
        return mBackgroundContourBrush.getColorsList();
    }

    /**
     * @return the IIcon which is used inside this IconicsDrawable
     */
    public @Nullable IIcon getIcon() {
        return mIcon;
    }

    /**
     * @return the PlainIcon which is used inside this IconicsDrawable
     */
    public @Nullable String getPlainIcon() {
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
    public @NonNull Bitmap toBitmap() {
        if (mSizeX == -1 || mSizeY == -1) {
            actionBar();
        }

        Bitmap bitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        style(Paint.Style.FILL);

        Canvas canvas = new Canvas(bitmap);
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
    public @NonNull IconicsDrawable clone() {
        IconicsDrawable iconicsDrawable = new IconicsDrawable(mContext)
                // icon
                .color(mIconBrush.getColorsList())
                .sizePxX(mSizeX)
                .sizePxY(mSizeY)
                .iconOffsetXPx(mIconOffsetX)
                .iconOffsetYPx(mIconOffsetY)
                .paddingPx(mIconPadding)
                .typeface(mIconBrush.getPaint().getTypeface())
                // background
                .backgroundColor(mBackgroundBrush.getColorsList())
                .roundedCornersRxPx(mRoundedCornerRx)
                .roundedCornersRyPx(mRoundedCornerRy)
                // icon contour
                .drawContour(mDrawContour)
                .contourColor(mContourBrush.getColorsList())
                .contourWidthPx(mContourWidth)
                // background contour
                .drawBackgroundContour(mDrawBackgroundContour)
                .backgroundContourColor(mBackgroundContourBrush.getColorsList())
                .backgroundContourWidthPx(mBackgroundContourWidth)
                // shadow
                .shadowPx(mShadowRadius, mShadowDx, mShadowDy, mShadowColor)
                // common
                .alpha(mAlpha);

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
    public @NonNull IconicsDrawable icon(@NonNull String icon) {
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
    public @NonNull IconicsDrawable icon(@NonNull Character icon) {
        return iconText(icon.toString(), null);
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @param typeface
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable icon(@NonNull Character icon, @Nullable Typeface typeface) {
        return iconText(icon.toString(), typeface);
    }

    /**
     * Loads and draws given text
     *
     * @param icon
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconText(@NonNull String icon) {
        return iconText(icon, null);
    }

    /**
     * Loads and draws given text
     *
     * @param icon
     * @param typeface
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconText(@NonNull String icon, @Nullable Typeface typeface) {
        mPlainIcon = icon;
        mIcon = null;
        mIconBrush.getPaint().setTypeface(typeface == null ? Typeface.DEFAULT : typeface);

        invalidateSelf();
        return this;
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable icon(@NonNull IIcon icon) {
        mIcon = icon;
        mPlainIcon = null;
        ITypeface typeface = icon.getTypeface();
        mIconBrush.getPaint().setTypeface(typeface.getTypeface(mContext));

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
    protected @NonNull IconicsDrawable icon(@NonNull ITypeface typeface, @NonNull IIcon icon) {
        mIcon = icon;
        mIconBrush.getPaint().setTypeface(typeface.getTypeface(mContext));

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
    public @NonNull IconicsDrawable respectFontBounds(boolean respectBounds) {
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
    public @NonNull IconicsDrawable color(@ColorInt int color) {
        return color(ColorStateList.valueOf(color));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorResId The color resource, from your R file.
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable colorRes(@ColorRes int colorResId) {
        return color(ContextCompat.getColor(mContext, colorResId));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorResId The color resource, from your R file.
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable colorListRes(@ColorRes int colorResId) {
        return color(ContextCompat.getColorStateList(mContext, colorResId));
    }

    /**
     * Set the color of the drawable.
     *
     * @param colors The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable color(@NonNull ColorStateList colors) {
        if (colors != null) {
            mIconBrush.setColors(colors);
            if (mIconBrush.applyState(getState())) {
                invalidateSelf();
            }
        }
        return this;
    }

    /**
     * set the icon offset for X from resource
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconOffsetXRes(@DimenRes int sizeResId) {
        return iconOffsetXPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * set the icon offset for X as dp
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconOffsetXDp(@Dimension(unit = DP) int sizeDp) {
        return iconOffsetXPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * set the icon offset for X
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconOffsetXPx(@Dimension(unit = PX) int sizePx) {
        mIconOffsetX = sizePx;

        invalidateSelf();
        return this;
    }

    /**
     * set the icon offset for Y from resource
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconOffsetYRes(@DimenRes int sizeResId) {
        return iconOffsetYPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * set the icon offset for Y as dp
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconOffsetYDp(@Dimension(unit = DP) int sizeDp) {
        return iconOffsetYPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * set the icon offset for Y
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable iconOffsetYPx(@Dimension(unit = PX) int sizePx) {
        mIconOffsetY = sizePx;

        invalidateSelf();
        return this;
    }

    /**
     * Set the padding of the drawable from res
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable paddingRes(@DimenRes int sizeResId) {
        return paddingPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set the padding in dp for the drawable
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable paddingDp(@Dimension(unit = DP) int sizeDp) {
        return paddingPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set a padding for the.
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable paddingPx(@Dimension(unit = PX) int sizePx) {
        if (mIconPadding != sizePx) {
            mIconPadding = sizePx;
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
    public @NonNull IconicsDrawable actionBar() {
        sizeDp(TOOLBAR_ICON_SIZE);
        paddingDp(TOOLBAR_ICON_PADDING);
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeResId The dimension resource.
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizeRes(@DimenRes int sizeResId) {
        return sizePx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeDp The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizeDp(@Dimension(unit = DP) int sizeDp) {
        return sizePx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizePx The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizePx(@Dimension(unit = PX) int sizePx) {
        mSizeX = mSizeY = sizePx;
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeResId The dimension resource.
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizeResX(@DimenRes int sizeResId) {
        return sizePxX(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeDp The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizeDpX(@Dimension(unit = DP) int sizeDp) {
        return sizePxX(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizePx The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizePxX(@Dimension(unit = PX) int sizePx) {
        mSizeX = sizePx;
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeResId The dimension resource.
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizeResY(@DimenRes int sizeResId) {
        return sizePxY(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeDp The size in density-independent pixels (dp).
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizeDpY(@Dimension(unit = DP) int sizeDp) {
        return sizePxY(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizePx The size in pixels (px).
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable sizePxY(@Dimension(unit = PX) int sizePx) {
        mSizeY = sizePx;
        setBounds(0, 0, mSizeX, mSizeY);

        invalidateSelf();
        return this;
    }

    /**
     * Set background contour color from color res.
     *
     * @param colorResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundContourColorRes(@ColorRes int colorResId) {
        return backgroundContourColor(ContextCompat.getColor(mContext, colorResId));
    }

    /**
     * Set background contour color.
     *
     * @param color
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundContourColor(@ColorInt int color) {
        return backgroundContourColor(ColorStateList.valueOf(color));
    }


    /**
     * Set background contour colors from color res.
     *
     * @param colorResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundContourColorListRes(@ColorRes int colorResId) {
        return backgroundContourColor(ContextCompat.getColorStateList(mContext, colorResId));
    }


    /**
     * Set background contour colors.
     *
     * @param colors
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundContourColor(@NonNull ColorStateList colors) {
        if (colors != null) {
            mBackgroundContourBrush.setColors(colors);
            if (mBackgroundContourBrush.applyState(getState())) {
                invalidateSelf();
            }
        }
        return this;
    }

    /**
     * Set contour color from color res.
     *
     * @param colorResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable contourColorRes(@ColorRes int colorResId) {
        return contourColor(ContextCompat.getColor(mContext, colorResId));
    }

    /**
     * Set contour color.
     *
     * @param color
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable contourColor(@ColorInt int color) {
        return contourColor(ColorStateList.valueOf(color));
    }


    /**
     * Set contour colors from color res.
     *
     * @param colorResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable contourColorListRes(@ColorRes int colorResId) {
        return contourColor(ContextCompat.getColorStateList(mContext, colorResId));
    }


    /**
     * Set contour colors.
     *
     * @param colors
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable contourColor(@NonNull ColorStateList colors) {
        if (colors != null) {
            mContourBrush.setColors(colors);
            if (mContourBrush.applyState(getState())) {
                invalidateSelf();
            }
        }
        return this;
    }

    /**
     * Set background color from res.
     *
     * @param colorResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundColorRes(@ColorRes int colorResId) {
        return backgroundColor(ContextCompat.getColor(mContext, colorResId));
    }

    /**
     * Set background color.
     *
     * @param color
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundColor(@ColorInt int color) {
        return backgroundColor(ColorStateList.valueOf(color));
    }


    /**
     * Set background contour colors from color res.
     *
     * @param colorResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundColorListRes(@ColorRes int colorResId) {
        return backgroundColor(ContextCompat.getColorStateList(mContext, colorResId));
    }


    /**
     * Set background contour colors.
     *
     * @param colors
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundColor(@NonNull ColorStateList colors) {
        if (colors != null) {
            boolean isInvalidate = false;

            if (mRoundedCornerRx == -1) {
                mRoundedCornerRx = 0;
                isInvalidate = true;
            }
            if (mRoundedCornerRy == -1) {
                mRoundedCornerRy = 0;
                isInvalidate = true;
            }

            mBackgroundBrush.setColors(colors);
            if (mBackgroundBrush.applyState(getState())) {
                isInvalidate = true;
            }

            if (isInvalidate) {
                invalidateSelf();
            }
        }
        return this;
    }

    /**
     * Set rounded corner from res
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersRxRes(@DimenRes int sizeResId) {
        return roundedCornersRxPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set rounded corner from dp
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersRxDp(@Dimension(unit = DP) int sizeDp) {
        return roundedCornersRxPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set rounded corner from px
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersRxPx(@Dimension(unit = PX) int sizePx) {
        mRoundedCornerRx = sizePx;

        invalidateSelf();
        return this;
    }

    /**
     * Set rounded corner from res
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersRyRes(@DimenRes int sizeResId) {
        return roundedCornersRyPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set rounded corner from dp
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersRyDp(@Dimension(unit = DP) int sizeDp) {
        return roundedCornersRyPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set rounded corner from px
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersRyPx(@Dimension(unit = PX) int sizePx) {
        mRoundedCornerRy = sizePx;

        invalidateSelf();
        return this;
    }

    /**
     * Set rounded corner from res
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersRes(@DimenRes int sizeResId) {
        return roundedCornersPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set rounded corner from dp
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersDp(@Dimension(unit = DP) int sizeDp) {
        return roundedCornersPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set rounded corner from px
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable roundedCornersPx(@Dimension(unit = PX) int sizePx) {
        mRoundedCornerRx = mRoundedCornerRy = sizePx;

        invalidateSelf();
        return this;
    }

    /**
     * Set contour width from an dimen res for the icon
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable contourWidthRes(@DimenRes int sizeResId) {
        return contourWidthPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set contour width from dp for the icon
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable contourWidthDp(@Dimension(unit = DP) int sizeDp) {
        return contourWidthPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set contour width for the icon.
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable contourWidthPx(@Dimension(unit = PX) int sizePx) {
        mContourWidth = sizePx;
        mContourBrush.getPaint().setStrokeWidth(sizePx);
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
    public @NonNull IconicsDrawable enableShadowSupport(@NonNull View view) {
        view.setLayerType(LAYER_TYPE_SOFTWARE, null);
        return this;
    }

    /**
     * Sets the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public @NonNull IconicsDrawable shadowRes(
            @DimenRes int radiusRes,
            @DimenRes int dxRes,
            @DimenRes int dyRes,
            @ColorRes int colorResId) {
        return shadowPx(
                mContext.getResources().getDimensionPixelSize(radiusRes),
                mContext.getResources().getDimensionPixelSize(dxRes),
                mContext.getResources().getDimensionPixelSize(dyRes),
                ContextCompat.getColor(mContext, colorResId));
    }

    /**
     * Sets the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public @NonNull IconicsDrawable shadowDp(
            @Dimension(unit = DP) float radiusDp,
            @Dimension(unit = DP) float dxDp,
            @Dimension(unit = DP) float dyDp,
            @ColorInt int color) {
        return shadowPx(
                Utils.convertDpToPx(mContext, radiusDp),
                Utils.convertDpToPx(mContext, dxDp),
                Utils.convertDpToPx(mContext, dyDp),
                color);
    }

    /**
     * Sets the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint#setShadowLayer(float, float, float, int)
     * @see #enableShadowSupport(View)
     */
    public @NonNull IconicsDrawable shadowPx(
            @Dimension(unit = PX) float radius,
            @Dimension(unit = PX) float dx,
            @Dimension(unit = PX) float dy,
            @ColorInt int color) {
        mShadowRadius = radius;
        mShadowDx = dx;
        mShadowDy = dy;
        mShadowColor = color;

        mIconBrush.getPaint().setShadowLayer(radius, dx, dy, color);
        invalidateSelf();
        return this;
    }

    /**
     * Set background contour width from an dimen res for the icon
     *
     * @param sizeResId
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundContourWidthRes(@DimenRes int sizeResId) {
        return backgroundContourWidthPx(mContext.getResources().getDimensionPixelSize(sizeResId));
    }

    /**
     * Set background contour width from dp for the icon
     *
     * @param sizeDp
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundContourWidthDp(@Dimension(unit = DP) int sizeDp) {
        return backgroundContourWidthPx(Utils.convertDpToPx(mContext, sizeDp));
    }

    /**
     * Set background contour width for the icon.
     *
     * @param sizePx
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable backgroundContourWidthPx(@Dimension(unit = PX) int sizePx) {
        mBackgroundContourWidth = sizePx;
        mBackgroundContourBrush.getPaint().setStrokeWidth(sizePx);
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
    public @NonNull IconicsDrawable drawContour(boolean drawContour) {
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
    public @NonNull IconicsDrawable drawBackgroundContour(boolean drawBackgroundContour) {
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
    public @NonNull IconicsDrawable colorFilter(@Nullable ColorFilter cf) {
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
    public @NonNull IconicsDrawable alpha(int alpha) {
        setAlpha(alpha);
        return this;
    }

    /**
     * Sets the style
     *
     * @param style
     * @return The current IconicsDrawable for chaining.
     */
    public @NonNull IconicsDrawable style(@NonNull Paint.Style style) {
        mIconBrush.getPaint().setStyle(style);

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
    public @NonNull IconicsDrawable typeface(@Nullable Typeface typeface) {
        mIconBrush.getPaint().setTypeface(typeface);

        invalidateSelf();
        return this;
    }
    //endregion

    //region overridden methods from android.graphics.drawable.Drawable class
    @Override public void draw(@NonNull Canvas canvas) {
        if (mIcon == null && mPlainIcon == null) return;

        Rect viewBounds = getBounds();

        updatePaddingBounds(viewBounds);
        updateTextSize(viewBounds);
        offsetIcon(viewBounds);

        if (mRoundedCornerRy > -1 && mRoundedCornerRx > -1) {
            if (mDrawBackgroundContour) {
                float halfContourSize = mBackgroundContourWidth / 2;
                RectF rectF = new RectF(
                        halfContourSize,
                        halfContourSize,
                        viewBounds.width() - halfContourSize,
                        viewBounds.height() - halfContourSize);
                canvas.drawRoundRect(
                        rectF,
                        mRoundedCornerRx,
                        mRoundedCornerRy,
                        mBackgroundBrush.getPaint());
                canvas.drawRoundRect(
                        rectF,
                        mRoundedCornerRx,
                        mRoundedCornerRy,
                        mBackgroundContourBrush.getPaint());
            } else {
                RectF rectF = new RectF(0, 0, viewBounds.width(), viewBounds.height());
                canvas.drawRoundRect(
                        rectF,
                        mRoundedCornerRx,
                        mRoundedCornerRy,
                        mBackgroundBrush.getPaint());
            }
        }

        try {
            mPath.close();
        } catch (Exception ignored) {
        }

        if (mDrawContour) {
            canvas.drawPath(mPath, mContourBrush.getPaint());
        }

        mIconBrush.getPaint().setColorFilter(mColorFilter == null ? mTintFilter : mColorFilter);

        canvas.drawPath(mPath, mIconBrush.getPaint());
    }

    @Override public void setTint(int tintColor) {
        setTintList(ColorStateList.valueOf(tintColor));
    }

    @Override public void setTintList(@Nullable ColorStateList tint) {
        mTint = tint;
        mTintFilter = updateTintFilter(tint, mTintMode);

        invalidateSelf();
    }

    @Override public void setTintMode(@NonNull PorterDuff.Mode tintMode) {
        mTintMode = tintMode;
        mTintFilter = updateTintFilter(mTint, tintMode);

        invalidateSelf();
    }

    @Override protected void onBoundsChange(@Nullable Rect bounds) {
        offsetIcon(bounds);
        try {
            mPath.close();
        } catch (Exception ignored) {
        }
        super.onBoundsChange(bounds);
    }

    @Override public boolean isStateful() {
        return mIconBrush.isStateful()
                || mContourBrush.isStateful()
                || mBackgroundBrush.isStateful()
                || mBackgroundContourBrush.isStateful();
    }

    @Override public boolean setState(@NonNull int[] stateSet) {
        boolean b = super.setState(stateSet);
        return b || mIconBrush.isStateful()
                || mContourBrush.isStateful()
                || mBackgroundBrush.isStateful()
                || mBackgroundContourBrush.isStateful()
                || mColorFilter != null
                || mTintFilter != null;
    }

    @Override public int getOpacity() {
        if (mTintFilter != null || mIconBrush.getPaint().getColorFilter() != null) {
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

    @Override protected boolean onStateChange(@NonNull int[] stateSet) {
        boolean isNeedsRedraw = mIconBrush.applyState(stateSet);
        isNeedsRedraw |= mContourBrush.applyState(stateSet);
        isNeedsRedraw |= mBackgroundBrush.applyState(stateSet);
        isNeedsRedraw |= mBackgroundContourBrush.applyState(stateSet);

        if (mTint != null && mTintMode != null) {
            mTintFilter = updateTintFilter(mTint, mTintMode);
            isNeedsRedraw = true;
        }

        return isNeedsRedraw;
    }

    @Override public int getIntrinsicWidth() {
        return mSizeX;
    }

    @Override public int getIntrinsicHeight() {
        return mSizeY;
    }

    @Override public void setAlpha(int alpha) {
        mIconBrush.setAlpha(alpha);
        mContourBrush.setAlpha(alpha);
        mBackgroundBrush.setAlpha(alpha);
        mBackgroundContourBrush.setAlpha(alpha);

        mAlpha = alpha;

        invalidateSelf();
    }

    @Override public int getAlpha() {
        return mAlpha;
    }

    @Override public void setColorFilter(@Nullable ColorFilter cf) {
        mColorFilter = cf;

        invalidateSelf();
    }

    @Override public void clearColorFilter() {
        mColorFilter = null;

        invalidateSelf();
    }
    //endregion

    //region PRIVATE HELPER METHODS

    /**
     * Update the Padding Bounds
     *
     * @param viewBounds
     */
    private void updatePaddingBounds(@NonNull Rect viewBounds) {
        if (mIconPadding >= 0
                && mIconPadding * 2 <= viewBounds.width()
                && mIconPadding * 2 <= viewBounds.height()) {
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
    private void updateTextSize(@NonNull Rect viewBounds) {
        float textSize = (float) viewBounds.height() * (mRespectFontBounds ? 1 : 2);
        mIconBrush.getPaint().setTextSize(textSize);

        String textValue = mIcon != null ? String.valueOf(mIcon.getCharacter()) : String.valueOf(mPlainIcon);
        mIconBrush.getPaint().getTextPath(textValue, 0, textValue.length(), 0, viewBounds.height(), mPath);
        mPath.computeBounds(mPathBounds, true);

        if (!mRespectFontBounds) {
            float deltaWidth = ((float) mPaddingBounds.width() / mPathBounds.width());
            float deltaHeight = ((float) mPaddingBounds.height() / mPathBounds.height());
            float delta = (deltaWidth < deltaHeight) ? deltaWidth : deltaHeight;
            textSize *= delta;

            mIconBrush.getPaint().setTextSize(textSize);

            mIconBrush.getPaint().getTextPath(textValue, 0, textValue.length(), 0, viewBounds.height(), mPath);
            mPath.computeBounds(mPathBounds, true);
        }
    }

    /**
     * Set the icon offset
     *
     * @param viewBounds
     */
    private void offsetIcon(@NonNull Rect viewBounds) {
        float startX = viewBounds.centerX() - (mPathBounds.width() / 2);
        float offsetX = startX - mPathBounds.left;

        float startY = viewBounds.centerY() - (mPathBounds.height() / 2);
        float offsetY = startY - (mPathBounds.top);

        mPath.offset(offsetX + mIconOffsetX, offsetY + mIconOffsetY);
    }

    /**
     * Ensures the tint filter is consistent with the current tint color and
     * mode.
     */
    private PorterDuffColorFilter updateTintFilter(@Nullable ColorStateList tint, @Nullable PorterDuff.Mode tintMode) {
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