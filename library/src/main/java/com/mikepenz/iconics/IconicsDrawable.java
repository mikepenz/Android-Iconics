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
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.Utils;

/**
 * A custom {@link Drawable} which can display icons from icon fonts.
 */
public class IconicsDrawable extends Drawable {
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;

    private Context mContext;

    private int mSize = -1;

    private Paint mIconPaint;
    private Paint mContourPaint;

    private Rect mPaddingBounds;
    private RectF mPathBounds;

    private Path mPath;

    private int mIconPadding;
    private int mContourWidth;

    private int mAlpha = 255;

    private boolean mDrawContour;

    private IIcon mIcon;

    public IconicsDrawable(Context context, String icon) {
        mContext = context.getApplicationContext();
        prepare();

        ITypeface font = Iconics.findFont(icon.substring(0, 3));
        icon = icon.replace("-", "_");
        icon(font.getIcon(icon));
    }

    public IconicsDrawable(Context context, final IIcon icon) {
        mContext = context.getApplicationContext();
        prepare();
        icon(icon);
    }

    public IconicsDrawable(Context context, final ITypeface typeface, final IIcon icon) {
        mContext = context.getApplicationContext();
        prepare();
        icon(typeface, icon);
    }

    private void prepare() {
        mIconPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mContourPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mContourPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();

        mPathBounds = new RectF();
        mPaddingBounds = new Rect();
    }

    /**
     * Loads and draws given.
     *
     * @param icon
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable icon(IIcon icon) {
        mIcon = icon;

        ITypeface typeface = Iconics.findFont(icon.getName().substring(0, 3));
        if (typeface == null) {
            throw new RuntimeException("The font for the given icon isn't registered!");
        }
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
    public IconicsDrawable icon(ITypeface typeface, IIcon icon) {
        mIcon = icon;
        mIconPaint.setTypeface(typeface.getTypeface(mContext));
        invalidateSelf();
        return this;
    }

    /**
     * Set the color of the drawable.
     *
     * @param color The color, usually from android.graphics.Color or 0xFF012345.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable color(int color) {
        mIconPaint.setColor(color);
        invalidateSelf();
        return this;
    }

    /**
     * Set the color of the drawable.
     *
     * @param colorRes The color resource, from your R file.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable colorRes(int colorRes) {
        mIconPaint.setColor(mContext.getResources().getColor(colorRes));
        invalidateSelf();
        return this;
    }


    /**
     * Set the padding of the drawable from res
     *
     * @param dimenRes
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable paddingRes(int dimenRes) {
        return paddingPx(mContext.getResources().getDimensionPixelSize(dimenRes));
    }


    /**
     * Set the padding in dp for the drawable
     *
     * @param iconPadding
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable paddingDp(int iconPadding) {
        return paddingPx(Utils.convertDpToPx(mContext, iconPadding));
    }

    /**
     * Set a padding for the.
     *
     * @param iconPadding
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable paddingPx(int iconPadding) {
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
     */
    public IconicsDrawable actionBarSize() {
        return sizeDp(ANDROID_ACTIONBAR_ICON_SIZE_DP);
    }

    /**
     * Set the size of the drawable.
     *
     * @param dimenRes The dimension resource.
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeRes(int dimenRes) {
        return sizePx(mContext.getResources().getDimensionPixelSize(dimenRes));
    }


    /**
     * Set the size of the drawable.
     *
     * @param size The size in density-independent pixels (dp).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizeDp(int size) {
        return sizePx(Utils.convertDpToPx(mContext, size));
    }

    /**
     * Set the size of the drawable.
     *
     * @param size The size in pixels (px).
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable sizePx(int size) {
        this.mSize = size;
        setBounds(0, 0, size, size);
        invalidateSelf();
        return this;
    }


    /**
     * Set contour color for the.
     *
     * @param contourColor
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourColor(int contourColor) {
        mContourPaint.setColor(contourColor);
        drawContour(true);
        invalidateSelf();
        return this;
    }

    /**
     * Set contour color from color res.
     *
     * @param contourColorRes
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourColorRes(int contourColorRes) {
        mContourPaint.setColor(mContext.getResources().getColor(contourColorRes));
        drawContour(true);
        invalidateSelf();
        return this;
    }

    /**
     * Set contour width from an dimen res for the icon
     *
     * @param contourWidthRes
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourWidthRes(int contourWidthRes) {
        return contourWidthPx(mContext.getResources().getDimensionPixelSize(contourWidthRes));
    }

    /**
     * Set contour width from dp for the icon
     *
     * @param contourWidthDp
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourWidthDp(int contourWidthDp) {
        return contourWidthPx(Utils.convertDpToPx(mContext, contourWidthDp));
    }

    /**
     * Set contour width for the icon.
     *
     * @param contourWidth
     * @return The current IconExtDrawable for chaining.
     */
    public IconicsDrawable contourWidthPx(int contourWidth) {
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
        mAlpha = alpha;
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

    @Override
    public void draw(Canvas canvas) {
        if (mIcon != null) {
            final Rect viewBounds = getBounds();

            updatePaddingBounds(viewBounds);
            updateTextSize(viewBounds);
            offsetIcon(viewBounds);

            mPath.close();

            if (mDrawContour) {
                canvas.drawPath(mPath, mContourPaint);
            }

            canvas.drawPath(mPath, mIconPaint);
        }
    }

    @Override
    public boolean isStateful() {
        return true;
    }

    @Override
    public boolean setState(int[] stateSet) {
        int oldValue = mIconPaint.getAlpha();
        int newValue = Utils.isEnabled(stateSet) ? mAlpha : mAlpha / 2;
        mIconPaint.setAlpha(newValue);
        return oldValue != newValue;
    }

    @Override
    public int getIntrinsicWidth() {
        return mSize;
    }

    @Override
    public int getIntrinsicHeight() {
        return mSize;
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }

    @Override
    public void setAlpha(int alpha) {
        mIconPaint.setAlpha(alpha);
        mAlpha = alpha;
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mIconPaint.setColorFilter(cf);
    }

    /**
     * Creates a BitMap to use in Widgets or anywhere else
     *
     * @return bitmap to set
     */
    public Bitmap toBitmap() {
        if (mSize == -1) {
            this.actionBarSize();
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
        float textSize = (float) viewBounds.height() * 2;
        mIconPaint.setTextSize(textSize);

        String textValue = String.valueOf(mIcon.getCharacter());
        mIconPaint.getTextPath(textValue, 0, 1,
                0, viewBounds.height(), mPath);
        mPath.computeBounds(mPathBounds, true);

        float deltaWidth = ((float) mPaddingBounds.width() / mPathBounds.width());
        float deltaHeight = ((float) mPaddingBounds.height() / mPathBounds.height());
        float delta = (deltaWidth < deltaHeight) ? deltaWidth : deltaHeight;
        textSize *= delta;

        mIconPaint.setTextSize(textSize);

        mIconPaint.getTextPath(textValue, 0, 1,
                0, viewBounds.height(), mPath);
        mPath.computeBounds(mPathBounds, true);
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

        mPath.offset(offsetX, offsetY);
    }
}