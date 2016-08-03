/*
 * Copyright 2014 Mike Penz
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
import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.util.Log;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.Utils;

import static android.support.annotation.Dimension.DP;
import static android.support.annotation.Dimension.PX;

/**
 * A custom {@link Drawable} which can display icons from icon fonts.
 */
public class IconicsDrawable extends Drawable {
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_PADDING_DP = 1;

    private Context mContext;

    private int mSizeX = -1;
    private int mSizeY = -1;

    private boolean mRespectFontBounds = false;

    private int mIconColor;
    private Paint mIconPaint;
    private int mContourColor;
    private Paint mContourPaint;
    private int mBackgroundColor;
    private Paint mBackgroundPaint;

    private int mRoundedCornerRx = -1;
    private int mRoundedCornerRy = -1;

    private Rect mPaddingBounds;
    private RectF mPathBounds;

    private Path mPath;

    private int mIconPadding;
    private int mContourWidth;

    private int mIconOffsetX = 0;
    private int mIconOffsetY = 0;

    private int mAlpha = 255;

    private boolean mDrawContour;

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

    private void prepare() {
        mIconPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mIconPaint.setStyle(Paint.Style.FILL);
        mIconPaint.setTextAlign(Paint.Align.CENTER);
        mIconPaint.setUnderlineText(false);
        mIconPaint.setAntiAlias(true);

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mContourPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mContourPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();

        mPathBounds = new RectF();
        mPaddingBounds = new Rect();
    }

    /**
     * Loads and draws given text
     *
     * @param icon
     * @return The current IconExtDrawable for chaining.
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
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable icon(Character icon) {
        return iconText(icon.toString());
    }

    /**
     * Loads and draws given text
     *
     * @param icon
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable iconText(String icon) {
        mPlainIcon = icon;
        mIcon = null;
        mIconPaint.setTypeface(Typeface.DEFAULT);
        invalidateSelf();
        return this;
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @return The current IconExtDrawable for chaining.
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
     * @param typeface
     * @param icon
     * @return The current IconExtDrawable for chaining.
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
     */
    public IconicsDrawable respectFontBounds(boolean respectBounds) {
        this.mRespectFontBounds = respectBounds;
        invalidateSelf();
        return this;
    }

    /**
     * Set the color of the drawable.
     *
     * @param color The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable color(@ColorInt int color) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        mIconPaint.setColor(Color.rgb(red, green, blue));
        mIconColor = color;
        setAlpha(Color.alpha(color));
        invalidateSelf();
        return this;
    }

    /*
    public int adjustAlpha(int color, float factor) {
        int alpha = Math.round(Color.alpha(color));
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }
    */

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable colorRes(@ColorRes int colorRes) {
        return color(ContextCompat.getColor(mContext, colorRes));
    }


    /**
     * Returns the icon color
     */
    public int getColor() {
        return mIconColor;
    }

    /**
     * Returns the icon contour color
     */
    public int getContourColor() {
        return mContourColor;
    }

    /**
     * Returns the icon background color
     */
    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    /**
     * set the icon offset for X from resource
     *
     * @param iconOffsetXRes
     * @return
     */
    public IconicsDrawable iconOffsetXRes(@DimenRes int iconOffsetXRes) {
        return iconOffsetXPx(mContext.getResources().getDimensionPixelSize(iconOffsetXRes));
    }

    /**
     * set the icon offset for X as dp
     *
     * @param iconOffsetXDp
     * @return
     */
    public IconicsDrawable iconOffsetXDp(@Dimension(unit = DP) int iconOffsetXDp) {
        return iconOffsetXPx(Utils.convertDpToPx(mContext, iconOffsetXDp));
    }

    /**
     * set the icon offset for X
     *
     * @param iconOffsetX
     * @return
     */
    public IconicsDrawable iconOffsetXPx(@Dimension(unit = PX) int iconOffsetX) {
        this.mIconOffsetX = iconOffsetX;
        return this;
    }

    /**
     * set the icon offset for Y from resource
     *
     * @param iconOffsetYRes
     * @return
     */
    public IconicsDrawable iconOffsetYRes(@DimenRes int iconOffsetYRes) {
        return iconOffsetYPx(mContext.getResources().getDimensionPixelSize(iconOffsetYRes));
    }

    /**
     * set the icon offset for Y as dp
     *
     * @param iconOffsetYDp
     * @return
     */
    public IconicsDrawable iconOffsetYDp(@Dimension(unit = DP) int iconOffsetYDp) {
        return iconOffsetYPx(Utils.convertDpToPx(mContext, iconOffsetYDp));
    }

    /**
     * set the icon offset for Y
     *
     * @param iconOffsetY
     * @return
     */
    public IconicsDrawable iconOffsetYPx(@Dimension(unit = PX) int iconOffsetY) {
        this.mIconOffsetY = iconOffsetY;
        return this;
    }

    /**
     * Set the padding of the drawable from res
     *
     * @param dimenRes
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable paddingRes(@DimenRes int dimenRes) {
        return paddingPx(mContext.getResources().getDimensionPixelSize(dimenRes));
    }


    /**
     * Set the padding in dp for the drawable
     *
     * @param iconPadding
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable paddingDp(@Dimension(unit = DP) int iconPadding) {
        return paddingPx(Utils.convertDpToPx(mContext, iconPadding));
    }

    /**
     * Set a padding for the.
     *
     * @param iconPadding
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable paddingPx(@Dimension(unit = PX) int iconPadding) {
        if (mIconPadding != iconPadding) {
            mIconPadding = iconPadding;
            if (mDrawContour) {
                mIconPadding += mContourWidth;
            }

            invalidateSelf();
        }
        return this;
    }

    /**
     * Set the size of this icon to the standard Android ActionBar.
     *
     * @return The current IconExtDrawable for chaining.
     * @deprecated use actionBar() instead
     */
    @Deprecated
    public IconicsDrawable actionBarSize() {
        return sizeDp(ANDROID_ACTIONBAR_ICON_SIZE_DP);
    }

    /**
     * Sets the size and the Padding to the correct values to be used for the actionBar / toolBar
     *
     * @return
     */
    public IconicsDrawable actionBar() {
        sizeDp(ANDROID_ACTIONBAR_ICON_SIZE_DP);
        paddingDp(ANDROID_ACTIONBAR_ICON_SIZE_PADDING_DP);
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenRes The dimension resource.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeRes(@DimenRes int dimenRes) {
        return sizePx(mContext.getResources().getDimensionPixelSize(dimenRes));
    }


    /**
     * Set the size of the drawable.
     *
     * @param size The size in density-independent pixels (dp).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeDp(@Dimension(unit = DP) int size) {
        return sizePx(Utils.convertDpToPx(mContext, size));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in pixels (px).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizePx(@Dimension(unit = PX) int size) {
        this.mSizeX = size;
        this.mSizeY = size;
        setBounds(0, 0, size, size);
        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenResX The dimension resource.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeResX(@DimenRes int dimenResX) {
        return sizePxX(mContext.getResources().getDimensionPixelSize(dimenResX));
    }


    /**
     * Set the size of the drawable.
     *
     * @param sizeX The size in density-independent pixels (dp).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeDpX(@Dimension(unit = DP) int sizeX) {
        return sizePxX(Utils.convertDpToPx(mContext, sizeX));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeX The size in pixels (px).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizePxX(@Dimension(unit = PX) int sizeX) {
        this.mSizeX = sizeX;
        setBounds(0, 0, mSizeX, mSizeY);
        invalidateSelf();
        return this;
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenResY The dimension resource.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeResY(@DimenRes int dimenResY) {
        return sizePxY(mContext.getResources().getDimensionPixelSize(dimenResY));
    }


    /**
     * Set the size of the drawable.
     *
     * @param sizeY The size in density-independent pixels (dp).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeDpY(@Dimension(unit = DP) int sizeY) {
        return sizePxY(Utils.convertDpToPx(mContext, sizeY));
    }

    /**
     * Set the size of the drawable.
     *
     * @param sizeY The size in pixels (px).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizePxY(@Dimension(unit = PX) int sizeY) {
        this.mSizeY = sizeY;
        setBounds(0, 0, mSizeX, mSizeY);
        invalidateSelf();
        return this;
    }


    /**
     * Set contour color for the.
     *
     * @param contourColor
     * @return The current IconExtDrawable for chaining.
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
     * Set contour color from color res.
     *
     * @param contourColorRes
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourColorRes(@ColorRes int contourColorRes) {
        return contourColor(ContextCompat.getColor(mContext, contourColorRes));
    }

    /**
     * set background color
     *
     * @param backgroundColor
     * @return
     */
    public IconicsDrawable backgroundColor(@ColorInt int backgroundColor) {
        this.mBackgroundPaint.setColor(backgroundColor);
        this.mBackgroundColor = backgroundColor;
        this.mRoundedCornerRx = 0;
        this.mRoundedCornerRy = 0;
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
     * set rounded corner from res
     *
     * @param roundedCornerRxRes
     * @return
     */
    public IconicsDrawable roundedCornersRxRes(@DimenRes int roundedCornerRxRes) {
        this.mRoundedCornerRx = mContext.getResources().getDimensionPixelSize(roundedCornerRxRes);
        return this;
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerRxDp
     * @return
     */
    public IconicsDrawable roundedCornersRxDp(@Dimension(unit = DP) int roundedCornerRxDp) {
        this.mRoundedCornerRx = Utils.convertDpToPx(mContext, roundedCornerRxDp);
        return this;
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerRxPx
     * @return
     */
    public IconicsDrawable roundedCornersRxPx(@Dimension(unit = PX) int roundedCornerRxPx) {
        this.mRoundedCornerRx = roundedCornerRxPx;
        return this;
    }

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRyRes
     * @return
     */
    public IconicsDrawable roundedCornersRyRes(@DimenRes int roundedCornerRyRes) {
        this.mRoundedCornerRy = mContext.getResources().getDimensionPixelSize(roundedCornerRyRes);
        return this;
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerRyDp
     * @return
     */
    public IconicsDrawable roundedCornersRyDp(@Dimension(unit = DP) int roundedCornerRyDp) {
        this.mRoundedCornerRy = Utils.convertDpToPx(mContext, roundedCornerRyDp);
        return this;
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerRyPx
     * @return
     */
    public IconicsDrawable roundedCornersRyPx(@Dimension(unit = PX) int roundedCornerRyPx) {
        this.mRoundedCornerRy = roundedCornerRyPx;
        return this;
    }

    /**
     * set rounded corner from res
     *
     * @param roundedCornerRes
     * @return
     */
    public IconicsDrawable roundedCornersRes(@DimenRes int roundedCornerRes) {
        this.mRoundedCornerRx = mContext.getResources().getDimensionPixelSize(roundedCornerRes);
        this.mRoundedCornerRy = this.mRoundedCornerRx;
        return this;
    }

    /**
     * set rounded corner from dp
     *
     * @param roundedCornerDp
     * @return
     */
    public IconicsDrawable roundedCornersDp(@Dimension(unit = DP) int roundedCornerDp) {
        this.mRoundedCornerRx = Utils.convertDpToPx(mContext, roundedCornerDp);
        this.mRoundedCornerRy = this.mRoundedCornerRx;
        return this;
    }

    /**
     * set rounded corner from px
     *
     * @param roundedCornerPx
     * @return
     */
    public IconicsDrawable roundedCornersPx(@Dimension(unit = PX) int roundedCornerPx) {
        this.mRoundedCornerRx = roundedCornerPx;
        this.mRoundedCornerRy = this.mRoundedCornerRx;
        return this;
    }

    /**
     * Set contour width from an dimen res for the icon
     *
     * @param contourWidthRes
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourWidthRes(@DimenRes int contourWidthRes) {
        return contourWidthPx(mContext.getResources().getDimensionPixelSize(contourWidthRes));
    }

    /**
     * Set contour width from dp for the icon
     *
     * @param contourWidthDp
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourWidthDp(@Dimension(unit = DP) int contourWidthDp) {
        return contourWidthPx(Utils.convertDpToPx(mContext, contourWidthDp));
    }

    /**
     * Set contour width for the icon.
     *
     * @param contourWidth
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourWidthPx(@Dimension(unit = PX) int contourWidth) {
        mContourWidth = contourWidth;
        mContourPaint.setStrokeWidth(mContourWidth);
        drawContour(true);
        invalidateSelf();
        return this;
    }

    /**
     * Enable/disable contour drawing.
     *
     * @param drawContour
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable drawContour(boolean drawContour) {
        if (mDrawContour != drawContour) {
            mDrawContour = drawContour;

            if (mDrawContour) {
                mIconPadding += mContourWidth;
            } else {
                mIconPadding -= mContourWidth;
            }

            invalidateSelf();
        }
        return this;
    }

    /**
     * Set the colorFilter
     *
     * @param cf
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable colorFilter(ColorFilter cf) {
        setColorFilter(cf);
        return this;
    }

    /**
     * Sets the opacity
     *
     * @param alpha
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable alpha(int alpha) {
        setAlpha(alpha);
        return this;
    }

    /**
     * Sets the style
     *
     * @param style
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable style(Paint.Style style) {
        mIconPaint.setStyle(style);
        return this;
    }

    /**
     * sets the typeface of the drawable
     * NOTE THIS WILL OVERWRITE THE ICONFONT!
     *
     * @param typeface
     * @return
     */
    public IconicsDrawable typeface(Typeface typeface) {
        mIconPaint.setTypeface(typeface);
        return this;
    }

    @Override
    public void draw(Canvas canvas) {
        if (mIcon != null || mPlainIcon != null) {
            final Rect viewBounds = getBounds();

            updatePaddingBounds(viewBounds);
            updateTextSize(viewBounds);
            offsetIcon(viewBounds);

            if (mBackgroundPaint != null && mRoundedCornerRy > -1 && mRoundedCornerRx > -1) {
                canvas.drawRoundRect(new RectF(0, 0, viewBounds.width(), viewBounds.height()), mRoundedCornerRx, mRoundedCornerRy, mBackgroundPaint);
            }

            mPath.close();

            if (mDrawContour) {
                canvas.drawPath(mPath, mContourPaint);
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
    public boolean setState(int[] stateSet) {
        setAlpha(mAlpha);
        return super.setState(stateSet);
    }

    @Override
    protected boolean onStateChange(int[] stateSet) {
        if (mTint != null && mTintMode != null) {
            mTintFilter = updateTintFilter(mTint, mTintMode);
            invalidateSelf();
            return true;
        }
        return false;
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
    public int getOpacity() {
        return this.mAlpha;
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
     * @return
     */
    public int getCompatAlpha() {
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

    /**
     * Creates a BitMap to use in Widgets or anywhere else
     *
     * @return bitmap to set
     */
    public Bitmap toBitmap() {
        if (mSizeX == -1 || mSizeY == -1) {
            this.actionBar();
        }

        final Bitmap bitmap = Bitmap.createBitmap(this.getIntrinsicWidth(), this.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        this.style(Paint.Style.FILL);

        final Canvas canvas = new Canvas(bitmap);
        this.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        this.draw(canvas);

        return bitmap;
    }

    //------------------------------------------
    // PRIVATE HELPER METHODS
    //------------------------------------------

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


    /**
     * clones the icon
     *
     * @return
     */
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
                .backgroundColor(mBackgroundColor)
                .color(mIconColor)
                .alpha(mAlpha)
                .drawContour(mDrawContour)
                .typeface(mIconPaint.getTypeface());

        if (mIcon != null) {
            iconicsDrawable.icon(mIcon);
        } else if (mPlainIcon != null) {
            iconicsDrawable.iconText(mPlainIcon);
        }
        return iconicsDrawable;
    }
}