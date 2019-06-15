/*
 * Copyright 2019 Mike Penz
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

@file:Suppress("NOTHING_TO_INLINE", "LargeClass")

package com.mikepenz.iconics

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PixelFormat
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.Log
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.annotation.Dimension.DP
import androidx.annotation.Dimension.PX
import androidx.annotation.IntRange
import com.mikepenz.iconics.animation.IconicsAnimatedDrawable
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.utils.clearedIconName
import com.mikepenz.iconics.utils.iconPrefix
import com.mikepenz.iconics.utils.toIconicsColor
import com.mikepenz.iconics.utils.toIconicsColorRes
import com.mikepenz.iconics.utils.toIconicsSizeDp
import com.mikepenz.iconics.utils.toIconicsSizePx
import com.mikepenz.iconics.utils.toIconicsSizeRes

/** A custom [Drawable] which can display icons from icon fonts. */
open class IconicsDrawable(protected val context: Context) : Drawable() {
    protected val iconBrush = IconicsBrush(TextPaint(Paint.ANTI_ALIAS_FLAG))
    protected val backgroundContourBrush = IconicsBrush(Paint(Paint.ANTI_ALIAS_FLAG))
    protected val backgroundBrush = IconicsBrush(Paint(Paint.ANTI_ALIAS_FLAG))
    protected val contourBrush = IconicsBrush(Paint(Paint.ANTI_ALIAS_FLAG))

    private val paddingBounds = Rect()
    private val pathBounds = RectF()

    private val path = Path()

    private var sizeX: Int = -1
    private var sizeY: Int = -1

    private var isRespectFontBounds: Boolean = false

    private var isDrawContour: Boolean = false

    private var isDrawBackgroundContour: Boolean = false

    private var roundedCornerRx: Float = -1f
    private var roundedCornerRy: Float = -1f

    private var iconPadding: Int = 0
    private var contourWidth: Int = 0
    private var backgroundContourWidth: Int = 0

    private var iconOffsetX: Int = 0
    private var iconOffsetY: Int = 0

    private var shadowRadius: Float = 0f
    private var shadowDx: Float = 0f
    private var shadowDy: Float = 0f
    private var shadowColor = Color.TRANSPARENT

    private var tint: ColorStateList? = null
    private var tintMode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN
    private var tintFilter: ColorFilter? = null
    private var iconColorFilter: ColorFilter? = null

    init {
        Iconics.init(context)
        iconBrush.also {
            it.colorsList = ColorStateList.valueOf(Color.BLACK)
            it.paint.apply {
                style = Paint.Style.FILL
                textAlign = Paint.Align.CENTER
                isUnderlineText = false
            }
        }

        contourBrush.paint.style = Paint.Style.STROKE

        backgroundContourBrush.paint.style = Paint.Style.STROKE

        icon(' ')
    }

    constructor(context: Context, icon: Char) : this(context) {
        icon(icon)
    }

    constructor(context: Context, icon: String) : this(context) {
        icon(icon)
    }

    constructor(context: Context, icon: IIcon) : this(context) {
        icon(icon)
    }

    protected constructor(context: Context, typeface: ITypeface, icon: IIcon) : this(context) {
        icon(typeface, icon)
    }

    /**
     * just a helper to get the alpha value
     *
     * @return current alpha
     */
    @IntRange(from = 0, to = 255)
    open var compatAlpha = 255
        protected set

    /** @return the IIcon which is used inside this IconicsDrawable */
    var icon: IIcon? = null
        private set

    /** @return the PlainIcon which is used inside this IconicsDrawable */
    var plainIcon: String? = null
        private set

    /** @return the icon color */
    val color: Int
        @ColorInt get() = iconBrush.colorForCurrentState

    /** @return the icon colors */
    val colorList: ColorStateList?
        get() = iconBrush.colorsList

    /** @return the icon contour color */
    val contourColor: Int
        @ColorInt get() = contourBrush.colorForCurrentState

    /** @return the contour colors */
    val contourColorList: ColorStateList?
        get() = contourBrush.colorsList

    /** @return the icon background color */
    val backgroundColor: Int
        @ColorInt get() = backgroundBrush.colorForCurrentState

    /** @return the background colors */
    val backgroundColorList: ColorStateList?
        get() = backgroundBrush.colorsList

    /** @return the icon background contour color */
    val backgroundContourColor: Int
        @ColorInt get() = backgroundContourBrush.colorForCurrentState

    /** @return the background contour colors */
    val backgroundContourColorList: ColorStateList?
        get() = backgroundContourBrush.colorsList

    /**
     * Creates a BitMap to use in Widgets or anywhere else
     *
     * @return bitmap to set
     */
    fun toBitmap(): Bitmap {
        if (sizeX == -1 || sizeY == -1) {
            actionBar()
        }

        val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)

        style(Paint.Style.FILL)

        val canvas = Canvas(bitmap)
        setBounds(0, 0, canvas.width, canvas.height)
        draw(canvas)

        return bitmap
    }

    /**
     * clones the icon
     *
     * @return new IconicsDrawable with the same values.
     */
    fun clone(): IconicsDrawable {
        return copyTo(IconicsDrawable(context))
    }

    /**
     * Transform the icon to an animated icon
     *
     * @return new IconicsDrawable with the same values.
     */
    fun toAnimatedDrawable(): IconicsAnimatedDrawable {
        return copyTo(IconicsAnimatedDrawable(context))
    }

    private fun <T : IconicsDrawable> copyTo(other: T): T {
        // icon
        colorList?.also { other.color(IconicsColor.colorList(it)) }
        // background
        backgroundColorList?.also { other.backgroundColor(IconicsColor.colorList(it)) }
        // icon contour
        contourColorList?.also { other.contourColor(IconicsColor.colorList(it)) }
        // background contour
        backgroundContourColorList?.also { other.backgroundContourColor(IconicsColor.colorList(it)) }

        // icon
        other.sizeX(IconicsSize.px(sizeX))
                .sizeY(IconicsSize.px(sizeY))
                .iconOffsetX(IconicsSize.px(iconOffsetX))
                .iconOffsetY(IconicsSize.px(iconOffsetY))
                .padding(IconicsSize.px(iconPadding))
                .typeface(iconBrush.paint.typeface)
                .respectFontBounds(isRespectFontBounds)
                // background
                .roundedCornersRx(IconicsSize.px(roundedCornerRx))
                .roundedCornersRy(IconicsSize.px(roundedCornerRy))
                // icon contour
                .contourWidth(IconicsSize.px(contourWidth))
                .drawContour(isDrawContour)
                // background contour
                .backgroundContourWidth(IconicsSize.px(backgroundContourWidth))
                .drawBackgroundContour(isDrawBackgroundContour)
                // shadow
                .shadow(
                    IconicsSize.px(shadowRadius),
                    IconicsSize.px(shadowDx),
                    IconicsSize.px(shadowDy),
                    IconicsColor.colorInt(shadowColor)
                )
                // common
                .alpha(compatAlpha)

        icon?.let(other::icon) ?: plainIcon?.let { other.iconText(it) }

        return other
    }

    /**
     * Loads and draws given text
     *
     * @return The current IconicsDrawable for chaining.
     */
    @JvmName("iconFromString")
    fun icon(iconProducer: () -> String?): IconicsDrawable {
        iconProducer()?.let { icon(it) }
        return this
    }

    /**
     * Loads and draws given text
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun icon(icon: String): IconicsDrawable {
        try {
            Iconics.findFont(icon.iconPrefix)?.let { icon(it.getIcon(icon.clearedIconName)) }
        } catch (ex: Exception) {
            Iconics.logger.log(Log.ERROR, Iconics.TAG, "Wrong icon name: $icon")
        }

        return this
    }

    /**
     * Loads and draws given char
     *
     * @return The current IconicsDrawable for chaining.
     */
    @JvmName("iconFromChar")
    fun icon(iconProducer: () -> Char?): IconicsDrawable {
        iconProducer()?.let { icon(it) }
        return this
    }

    /**
     * Loads and draws given char
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun icon(icon: Char): IconicsDrawable {
        return iconText(icon.toString(), null)
    }

    /**
     * Loads and draws given char
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun icon(icon: Char, typeface: Typeface?): IconicsDrawable {
        return iconText(icon.toString(), typeface)
    }

    /**
     * Loads and draws given text
     *
     * @return The current IconicsDrawable for chaining.
     */
    @JvmName("iconTextFromString")
    fun iconText(iconTextProducer: () -> String?): IconicsDrawable {
        iconTextProducer()?.let { iconText(it) }
        return this
    }

    /**
     * Loads and draws given text
     *
     * @return The current IconicsDrawable for chaining.
     */
    @JvmOverloads
    fun iconText(icon: String, typeface: Typeface? = null): IconicsDrawable {
        plainIcon = icon
        this.icon = null
        iconBrush.paint.typeface = typeface ?: Typeface.DEFAULT

        invalidateSelf()
        return this
    }

    /**
     * Loads and draws given icon
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun icon(iconProducer: () -> IIcon?): IconicsDrawable {
        iconProducer()?.let { icon(it) }
        return this
    }

    /**
     * Loads and draws given icon
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun icon(icon: IIcon): IconicsDrawable {
        plainIcon = null
        this.icon = icon
        iconBrush.paint.typeface = icon.typeface.rawTypeface

        invalidateSelf()
        return this
    }

    /**
     * Loads and draws given icon
     *
     * @return The current IconicsDrawable for chaining.
     */
    protected fun icon(typeface: ITypeface, icon: IIcon): IconicsDrawable {
        this.icon = icon
        iconBrush.paint.typeface = typeface.rawTypeface

        invalidateSelf()
        return this
    }

    /**
     * Set if it should respect the original bounds of the icon. (DEFAULT is false)
     * This will break the "padding" functionality, but keep the padding defined by the font itself
     * Check it out with the oct_arrow_down and oct_arrow_small_down of the Octicons font
     *
     * @param respectFontBoundsProducer set to true if it should respect the original bounds
     * @return The current IconicsDrawable for chaining.
     */
    fun respectFontBounds(respectFontBoundsProducer: () -> Boolean?): IconicsDrawable {
        respectFontBoundsProducer()?.let { respectFontBounds(it) }
        return this
    }

    /**
     * Set if it should respect the original bounds of the icon. (DEFAULT is false)
     * This will break the "padding" functionality, but keep the padding defined by the font itself
     * Check it out with the oct_arrow_down and oct_arrow_small_down of the Octicons font
     *
     * @param isRespectFontBounds set to true if it should respect the original bounds
     * @return The current IconicsDrawable for chaining.
     */
    fun respectFontBounds(isRespectFontBounds: Boolean): IconicsDrawable {
        this.isRespectFontBounds = isRespectFontBounds

        invalidateSelf()
        return this
    }

    /**
     * Set the color of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun color(colorProducer: () -> IconicsColor?): IconicsDrawable {
        colorProducer()?.let { color(it) }
        return this
    }

    /**
     * Set the color of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun color(colors: IconicsColor): IconicsDrawable {
        iconBrush.colorsList = colors.extractList(context)
        if (iconBrush.applyState(state)) {
            invalidateSelf()
        }
        return this
    }

    /**
     * Set the icon offset for X axis
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun iconOffsetX(iconOffsetXProducer: () -> IconicsSize?): IconicsDrawable {
        iconOffsetXProducer()?.let { iconOffsetX(it) }
        return this
    }

    /**
     * Set the icon offset for X axis
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun iconOffsetX(size: IconicsSize): IconicsDrawable {
        iconOffsetX = size.extract(context)

        invalidateSelf()
        return this
    }

    /**
     * Set the icon offset for Y axis
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun iconOffsetY(iconOffsetYProducer: () -> IconicsSize?): IconicsDrawable {
        iconOffsetYProducer()?.let { iconOffsetY(it) }
        return this
    }

    /**
     * Set the icon offset for Y axis
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun iconOffsetY(size: IconicsSize): IconicsDrawable {
        iconOffsetY = size.extract(context)

        invalidateSelf()
        return this
    }

    /**
     * Set the padding for the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun padding(paddingProducer: () -> IconicsSize?): IconicsDrawable {
        paddingProducer()?.let { padding(it) }
        return this
    }

    /**
     * Set the padding for the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun padding(size: IconicsSize): IconicsDrawable {
        val sizePx = size.extract(context)
        if (iconPadding != sizePx) {
            iconPadding = sizePx
            if (isDrawContour) {
                iconPadding += contourWidth
            }
            if (isDrawBackgroundContour) {
                iconPadding += backgroundContourWidth
            }

            invalidateSelf()
        }
        return this
    }

    /**
     * Set the size and the padding to the correct values to be used for the actionBar / toolBar
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun actionBar(): IconicsDrawable {
        return size(IconicsSize.TOOLBAR_ICON_SIZE).padding(IconicsSize.TOOLBAR_ICON_PADDING)
    }

    /**
     * Set the size by X and Y axis of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun size(sizeProducer: () -> IconicsSize?): IconicsDrawable {
        sizeProducer()?.let { size(it) }
        return this
    }

    /**
     * Set the size by X and Y axis of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun size(size: IconicsSize): IconicsDrawable {
        sizeY = size.extract(context)
        sizeX = sizeY
        setBounds(0, 0, sizeX, sizeY)

        invalidateSelf()
        return this
    }

    /**
     * Set the size by X axis of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun sizeX(sizeXProducer: () -> IconicsSize?): IconicsDrawable {
        sizeXProducer()?.let { sizeX(it) }
        return this
    }

    /**
     * Set the size by X axis of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun sizeX(size: IconicsSize): IconicsDrawable {
        sizeX = size.extract(context)
        setBounds(0, 0, sizeX, sizeY)

        invalidateSelf()
        return this
    }

    /**
     * Set the size by Y axis of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun sizeY(sizeYProducer: () -> IconicsSize?): IconicsDrawable {
        sizeYProducer()?.let { sizeY(it) }
        return this
    }

    /**
     * Set the size by Y axis of the drawable.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun sizeY(size: IconicsSize): IconicsDrawable {
        sizeY = size.extract(context)
        setBounds(0, 0, sizeX, sizeY)

        invalidateSelf()
        return this
    }

    /**
     * Set background contour colors.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun backgroundContourColor(
        backgroundContourColorProducer: () -> IconicsColor?
    ): IconicsDrawable {
        backgroundContourColorProducer()?.let { backgroundContourColor(it) }
        return this
    }

    /**
     * Set background contour colors.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun backgroundContourColor(colors: IconicsColor): IconicsDrawable {
        backgroundContourBrush.colorsList = colors.extractList(context)
        if (backgroundContourBrush.applyState(state)) {
            invalidateSelf()
        }
        return this
    }

    /**
     * Set contour colors.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun contourColor(contourColorProducer: () -> IconicsColor?): IconicsDrawable {
        contourColorProducer()?.let { contourColor(it) }
        return this
    }

    /**
     * Set contour colors.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun contourColor(colors: IconicsColor): IconicsDrawable {
        contourBrush.colorsList = colors.extractList(context)
        if (contourBrush.applyState(state)) {
            invalidateSelf()
        }
        return this
    }

    /**
     * Set background colors.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun backgroundColor(backgroundColorProducer: () -> IconicsColor?): IconicsDrawable {
        backgroundColorProducer()?.let { backgroundColor(it) }
        return this
    }

    /**
     * Set background colors.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun backgroundColor(colors: IconicsColor): IconicsDrawable {
        var isInvalidate = false

        if (roundedCornerRx == -1f) {
            roundedCornerRx = 0f
            isInvalidate = true
        }
        if (roundedCornerRy == -1f) {
            roundedCornerRy = 0f
            isInvalidate = true
        }

        backgroundBrush.colorsList = colors.extractList(context)
        if (backgroundBrush.applyState(state)) {
            isInvalidate = true
        }

        if (isInvalidate) {
            invalidateSelf()
        }
        return this
    }

    /**
     * Set rounded corners.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun roundedCornersRx(roundedCornersRxProducer: () -> IconicsSize?): IconicsDrawable {
        roundedCornersRxProducer()?.let { roundedCornersRx(it) }
        return this
    }

    /**
     * Set rounded corners.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun roundedCornersRx(size: IconicsSize): IconicsDrawable {
        roundedCornerRx = size.extractFloat(context)

        invalidateSelf()
        return this
    }

    /**
     * Set rounded corner from px
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun roundedCornersRy(roundedCornersRyProducer: () -> IconicsSize?): IconicsDrawable {
        roundedCornersRyProducer()?.let { roundedCornersRy(it) }
        return this
    }

    /**
     * Set rounded corner from px
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun roundedCornersRy(size: IconicsSize): IconicsDrawable {
        roundedCornerRy = size.extractFloat(context)

        invalidateSelf()
        return this
    }

    /**
     * Set rounded corner from px
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun roundedCorners(roundedCornersProducer: () -> IconicsSize?): IconicsDrawable {
        roundedCornersProducer()?.let { roundedCorners(it) }
        return this
    }

    /**
     * Set rounded corner from px
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun roundedCorners(size: IconicsSize): IconicsDrawable {
        roundedCornerRy = size.extractFloat(context)
        roundedCornerRx = roundedCornerRy

        invalidateSelf()
        return this
    }

    /**
     * Set contour width for the icon.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun contourWidth(contourWidthProducer: () -> IconicsSize?): IconicsDrawable {
        contourWidthProducer()?.let { contourWidth(it) }
        return this
    }

    /**
     * Set contour width for the icon.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun contourWidth(size: IconicsSize): IconicsDrawable {
        contourWidth = size.extract(context)
        contourBrush.paint.strokeWidth = contourWidth.toFloat()
        drawContour(true)

        invalidateSelf()
        return this
    }

    /**
     * Set the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint.setShadowLayer
     * @see com.mikepenz.iconics.utils.IconicsUtils.enableShadowSupport
     * @see clearShadow
     */
    fun shadow(
        radiusProducer: () -> IconicsSize? = { IconicsSize.px(shadowRadius) },
        dxProducer: () -> IconicsSize? = { IconicsSize.px(shadowDx) },
        dyProducer: () -> IconicsSize? = { IconicsSize.px(shadowDy) },
        colorProducer: () -> IconicsColor? = { IconicsColor.colorInt(shadowColor) }
    ): IconicsDrawable {
        val radius = radiusProducer()
        val dx = dxProducer()
        val dy = dyProducer()
        val color = colorProducer()

        @Suppress("ComplexCondition")
        if (radius != null && dx != null && dy != null && color != null) {
            shadow(radius, dx, dy, color)
        }

        return this
    }

    /**
     * Set the shadow for the icon
     * This requires shadow support to be enabled on the view holding this `IconicsDrawable`
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint.setShadowLayer
     * @see com.mikepenz.iconics.utils.IconicsUtils.enableShadowSupport
     * @see clearShadow
     */
    fun shadow(
        radius: IconicsSize = IconicsSize.px(shadowRadius),
        dx: IconicsSize = IconicsSize.px(shadowDx),
        dy: IconicsSize = IconicsSize.px(shadowDy),
        color: IconicsColor = IconicsColor.colorInt(shadowColor)
    ): IconicsDrawable {
        shadowRadius = radius.extractFloat(context)
        shadowDx = dx.extractFloat(context)
        shadowDy = dy.extractFloat(context)
        shadowColor = color.extract(context)

        iconBrush.paint.setShadowLayer(shadowRadius, shadowDx, shadowDy, shadowColor)
        invalidateSelf()
        return this
    }

    /**
     * Clear the shadow for the icon
     *
     * @return The current IconicsDrawable for chaining.
     * @see Paint.clearShadowLayer
     * @see com.mikepenz.iconics.utils.IconicsUtils.enableShadowSupport
     * @see shadow
     */
    fun clearShadow(): IconicsDrawable {
        iconBrush.paint.clearShadowLayer()

        invalidateSelf()
        return this
    }

    /**
     * Set background contour width for the icon.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun backgroundContourWidth(
        backgroundContourWidthProducer: () -> IconicsSize?
    ): IconicsDrawable {
        backgroundContourWidthProducer()?.let { backgroundContourWidth(it) }
        return this
    }

    /**
     * Set background contour width for the icon.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun backgroundContourWidth(size: IconicsSize): IconicsDrawable {
        backgroundContourWidth = size.extract(context)
        backgroundContourBrush.paint.strokeWidth = backgroundContourWidth.toFloat()
        drawBackgroundContour(true)

        invalidateSelf()
        return this
    }

    /**
     * Enable/disable contour drawing.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun drawContour(drawContourProducer: () -> Boolean?): IconicsDrawable {
        drawContourProducer()?.let { drawContour(it) }
        return this
    }

    /**
     * Enable/disable contour drawing.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun drawContour(drawContour: Boolean): IconicsDrawable {
        if (isDrawContour != drawContour) {
            isDrawContour = drawContour

            iconPadding += (if (isDrawContour) 1 else -1) * contourWidth

            invalidateSelf()
        }
        return this
    }

    /**
     * Enable/disable background contour drawing.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun drawBackgroundContour(
        drawBackgroundContourProducer: () -> Boolean?
    ): IconicsDrawable {
        drawBackgroundContourProducer()?.let { drawBackgroundContour(it) }
        return this
    }

    /**
     * Enable/disable background contour drawing.
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun drawBackgroundContour(isDrawBackgroundContour: Boolean): IconicsDrawable {
        if (this.isDrawBackgroundContour != isDrawBackgroundContour) {
            this.isDrawBackgroundContour = isDrawBackgroundContour

            iconPadding += (if (isDrawBackgroundContour) 1 else -1) * backgroundContourWidth * 2

            invalidateSelf()
        }
        return this
    }

    /**
     * Set the ColorFilter
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun colorFilter(colorFilterProducer: () -> ColorFilter?): IconicsDrawable {
        colorFilterProducer()?.let { colorFilter(it) }
        return this
    }

    /**
     * Set the ColorFilter
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun colorFilter(cf: ColorFilter?): IconicsDrawable {
        colorFilter = cf

        invalidateSelf()
        return this
    }

    /**
     * Set the opacity
     * **NOTE** if you define a color (or as part of a colorStateList) with alpha
     * the alpha value of that color will ALWAYS WIN!
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun alpha(alphaProducer: () -> Int?): IconicsDrawable {
        alphaProducer()?.let { alpha(it) }
        return this
    }

    /**
     * Set the opacity
     * **NOTE** if you define a color (or as part of a colorStateList) with alpha
     * the alpha value of that color will ALWAYS WIN!
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun alpha(@IntRange(from = 0, to = 255) alpha: Int): IconicsDrawable {
        setAlpha(alpha)
        return this
    }

    /**
     * Set the style
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun style(styleProducer: () -> Paint.Style?): IconicsDrawable {
        styleProducer()?.let { style(it) }
        return this
    }

    /**
     * Set the style
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun style(style: Paint.Style): IconicsDrawable {
        iconBrush.paint.style = style

        invalidateSelf()
        return this
    }

    /**
     * Set the typeface of the drawable
     * NOTE THIS WILL OVERWRITE THE ICONFONT!
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun typeface(typefaceProducer: () -> Typeface?): IconicsDrawable {
        typefaceProducer()?.let { typeface(it) }
        return this
    }

    /**
     * Set the typeface of the drawable
     * NOTE THIS WILL OVERWRITE THE ICONFONT!
     *
     * @return The current IconicsDrawable for chaining.
     */
    fun typeface(typeface: Typeface?): IconicsDrawable {
        iconBrush.paint.typeface = typeface

        invalidateSelf()
        return this
    }

    // magic happens here ;)
    override fun draw(canvas: Canvas) {
        if (icon == null && plainIcon == null) return

        val viewBounds = bounds

        updatePaddingBounds(viewBounds)
        updateTextSize(viewBounds)
        offsetIcon(viewBounds)

        if (roundedCornerRy > -1 && roundedCornerRx > -1) {
            if (isDrawBackgroundContour) {
                val halfContourSize = (backgroundContourWidth / 2).toFloat()
                val rectF = RectF(
                    halfContourSize,
                    halfContourSize,
                    viewBounds.width() - halfContourSize,
                    viewBounds.height() - halfContourSize
                )
                canvas.drawRoundRect(rectF, roundedCornerRx, roundedCornerRy, backgroundBrush.paint)
                canvas.drawRoundRect(
                    rectF,
                    roundedCornerRx,
                    roundedCornerRy,
                    backgroundContourBrush.paint
                )
            } else {
                val rectF = RectF(
                    0f,
                    0f,
                    viewBounds.width().toFloat(),
                    viewBounds.height().toFloat()
                )
                canvas.drawRoundRect(rectF, roundedCornerRx, roundedCornerRy, backgroundBrush.paint)
            }
        }

        runCatching { path.close() }

        if (isDrawContour) {
            canvas.drawPath(path, contourBrush.paint)
        }

        iconBrush.paint.colorFilter = iconColorFilter ?: tintFilter

        canvas.drawPath(path, iconBrush.paint)
    }

    override fun setTintList(tint: ColorStateList?) {
        this.tint = tint
        updateTintFilter()

        invalidateSelf()
    }

    override fun setTintMode(tintMode: PorterDuff.Mode?) {
        this.tintMode = tintMode ?: PorterDuff.Mode.SRC_IN
        updateTintFilter()

        invalidateSelf()
    }

    override fun onBoundsChange(bounds: Rect) {
        offsetIcon(bounds)
        runCatching { path.close() }
        super.onBoundsChange(bounds)
    }

    override fun isStateful(): Boolean {
        return iconBrush.isStateful
                || contourBrush.isStateful
                || backgroundBrush.isStateful
                || backgroundContourBrush.isStateful
                || tint?.isStateful == true
    }

    override fun setState(stateSet: IntArray): Boolean {
        return super.setState(stateSet)
                || iconBrush.isStateful
                || contourBrush.isStateful
                || backgroundBrush.isStateful
                || backgroundContourBrush.isStateful
                || tint?.isStateful == true
    }

    override fun getOpacity(): Int {
        if (tintFilter != null || iconColorFilter != null) {
            return PixelFormat.TRANSLUCENT
        }
        when (alpha) {
            255 -> return PixelFormat.OPAQUE
            0 -> return PixelFormat.TRANSPARENT
        }
        return PixelFormat.TRANSLUCENT
    }

    // in some cases (e.g. on API 16) stateSet might be null
    override fun onStateChange(stateSet: IntArray?): Boolean {
        var isNeedsRedraw = iconBrush.applyState(stateSet)
        isNeedsRedraw = contourBrush.applyState(stateSet) || isNeedsRedraw
        isNeedsRedraw = backgroundBrush.applyState(stateSet) || isNeedsRedraw
        isNeedsRedraw = backgroundContourBrush.applyState(stateSet) || isNeedsRedraw

        if (tint != null) {
            updateTintFilter()
            isNeedsRedraw = true
        }

        return isNeedsRedraw
    }

    override fun getIntrinsicWidth(): Int = sizeX

    override fun getIntrinsicHeight(): Int = sizeY

    override fun setAlpha(@IntRange(from = 0, to = 255) alpha: Int) {
        iconBrush.alpha = alpha
        contourBrush.alpha = alpha
        backgroundBrush.alpha = alpha
        backgroundContourBrush.alpha = alpha

        compatAlpha = alpha

        invalidateSelf()
    }

    @IntRange(from = 0, to = 255)
    override fun getAlpha(): Int = compatAlpha

    override fun setColorFilter(cf: ColorFilter?) {
        iconColorFilter = cf

        invalidateSelf()
    }

    override fun clearColorFilter() {
        iconColorFilter = null

        invalidateSelf()
    }

    /** Update the Padding Bounds */
    private fun updatePaddingBounds(viewBounds: Rect) {
        if (iconPadding >= 0
                && iconPadding * 2 <= viewBounds.width()
                && iconPadding * 2 <= viewBounds.height()) {
            paddingBounds.set(
                viewBounds.left + iconPadding,
                viewBounds.top + iconPadding,
                viewBounds.right - iconPadding,
                viewBounds.bottom - iconPadding
            )
        }
    }

    /** Update the TextSize */
    private fun updateTextSize(viewBounds: Rect) {
        var textSize = viewBounds.height().toFloat() * if (isRespectFontBounds) 1 else 2
        iconBrush.paint.textSize = textSize

        val textValue = icon?.character?.toString() ?: plainIcon.toString()
        iconBrush.paint.getTextPath(
            textValue,
            0,
            textValue.length,
            0f,
            viewBounds.height().toFloat(),
            path
        )
        path.computeBounds(pathBounds, true)

        if (!isRespectFontBounds) {
            val deltaWidth = paddingBounds.width().toFloat() / pathBounds.width()
            val deltaHeight = paddingBounds.height().toFloat() / pathBounds.height()
            val delta = if (deltaWidth < deltaHeight) deltaWidth else deltaHeight
            textSize *= delta

            iconBrush.paint.textSize = textSize

            iconBrush.paint.getTextPath(
                textValue,
                0,
                textValue.length,
                0f,
                viewBounds.height().toFloat(),
                path
            )
            path.computeBounds(pathBounds, true)
        }
    }

    /** Set the icon offset */
    private fun offsetIcon(viewBounds: Rect) {
        val startX = viewBounds.centerX() - pathBounds.width() / 2
        val offsetX = startX - pathBounds.left

        val startY = viewBounds.centerY() - pathBounds.height() / 2
        val offsetY = startY - pathBounds.top

        path.offset(offsetX + iconOffsetX, offsetY + iconOffsetY)
    }

    /** Ensures the tint filter is consistent with the current tint color and mode. */
    private fun updateTintFilter() {
        val tint = this.tint
        val tintMode = this.tintMode

        if (tint == null) {
            tintFilter = null
            return
        }
        // setMode, setColor of PorterDuffColorFilter are not public method in SDK v7.
        // (Thanks @Google still not accessible in API v24)
        // Therefore we create a new one all the time here. Don't expect this is called often.
        val color = tint.getColorForState(state, Color.TRANSPARENT)
        tintFilter = PorterDuffColorFilter(color, tintMode)
    }
}

// VARIOUS convenient extension functions for quick common setters
@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("colorString", "com.mikepenz.iconics.utils.colorString")
)
inline fun IconicsDrawable.colorString(colorString: String) =
        color(colorString.toIconicsColor())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("colorRes", "com.mikepenz.iconics.utils.colorRes")
)
inline fun IconicsDrawable.colorRes(@ColorRes colorRes: Int) =
        color(colorRes.toIconicsColorRes())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("colorInt", "com.mikepenz.iconics.utils.colorInt")
)
inline fun IconicsDrawable.colorInt(@ColorInt colorInt: Int) =
        color(colorInt.toIconicsColor())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("sizeDp", "com.mikepenz.iconics.utils.sizeDp")
)
inline fun IconicsDrawable.sizeDp(@Dimension(unit = DP) sizeDp: Int) =
        size(sizeDp.toIconicsSizeDp())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("sizePx", "com.mikepenz.iconics.utils.sizePx")
)
inline fun IconicsDrawable.sizePx(@Dimension(unit = PX) sizePx: Int) =
        size(sizePx.toIconicsSizePx())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("sizeRes", "com.mikepenz.iconics.utils.sizeRes")
)
inline fun IconicsDrawable.sizeRes(@DimenRes sizeRes: Int) =
        size(sizeRes.toIconicsSizeRes())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("paddingDp", "com.mikepenz.iconics.utils.paddingDp")
)
inline fun IconicsDrawable.paddingDp(@Dimension(unit = DP) sizeDp: Int) =
        padding(sizeDp.toIconicsSizeDp())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("paddingPx", "com.mikepenz.iconics.utils.paddingPx")
)
inline fun IconicsDrawable.paddingPx(@Dimension(unit = PX) sizePx: Int) =
        padding(sizePx.toIconicsSizePx())

@Deprecated(
    message = "Moved to new class",
    replaceWith = ReplaceWith("paddingRes", "com.mikepenz.iconics.utils.paddingRes")
)
inline fun IconicsDrawable.paddingRes(@DimenRes sizeRes: Int) =
        padding(sizeRes.toIconicsSizeRes())