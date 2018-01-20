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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;

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