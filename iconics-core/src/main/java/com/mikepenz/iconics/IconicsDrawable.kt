/*
 * Copyright 2020 Mike Penz
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
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.content.res.TypedArray
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
import android.os.Build
import android.text.TextPaint
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.core.content.res.use
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import com.mikepenz.iconics.animation.IconicsAnimatedDrawable
import com.mikepenz.iconics.context.IconicsAttrsExtractor
import com.mikepenz.iconics.core.R
import com.mikepenz.iconics.typeface.IIcon
import com.mikepenz.iconics.typeface.ITypeface
import com.mikepenz.iconics.utils.actionBar
import com.mikepenz.iconics.utils.icon
import org.xmlpull.v1.XmlPullParser

/** A custom [Drawable] which can display icons from icon fonts. */
open class IconicsDrawable internal constructor() : WrappedDrawable() {

    internal lateinit var res: Resources
    internal var theme: Theme? = null

    internal var iconBrush = IconicsBrush(TextPaint(Paint.ANTI_ALIAS_FLAG))
        private set

    /** Set the color of the drawable. */
    var colorList: ColorStateList?
        get() = iconBrush.colorsList
        set(value) {
            iconBrush.colorsList = value
            if (iconBrush.applyState(state)) {
                invalidateThis()
            }
        }

    /** Set the style for the icon brush */
    var style: Paint.Style
        get() = iconBrush.paint.style
        set(value) {
            iconBrush.paint.style = value
            invalidateThis()
        }

    /** Set the typeface of the drawable NOTE THIS WILL OVERWRITE THE ICONFONT! */
    var typeface: Typeface?
        get() = iconBrush.paint.typeface
        set(value) {
            iconBrush.paint.typeface = value
            invalidateThis()
        }

    internal var backgroundContourBrush = IconicsBrush(Paint(Paint.ANTI_ALIAS_FLAG))
        private set

    /** Set the color of the drawable. */
    var backgroundContourColorList: ColorStateList?
        get() = backgroundContourBrush.colorsList
        set(value) {
            backgroundContourBrush.colorsList = value
            if (backgroundContourBrush.applyState(state)) {
                invalidateThis()
            }
        }

    internal var backgroundBrush = IconicsBrush(Paint(Paint.ANTI_ALIAS_FLAG))
        private set

    /** Set the color of the drawable. */
    var backgroundColorList: ColorStateList?
        get() = backgroundBrush.colorsList
        set(value) {
            backgroundBrush.colorsList = value

            // disable invalidation temporary
            val enabled = invalidationEnabled
            invalidationEnabled = false
            if (roundedCornerRxPx == -1f) {
                roundedCornerRxPx = 0f
            }
            if (roundedCornerRyPx == -1f) {
                roundedCornerRyPx = 0f
            }
            invalidationEnabled = enabled

            if (backgroundBrush.applyState(state)) {
                invalidateThis()
            }
        }

    internal var contourBrush = IconicsBrush(Paint(Paint.ANTI_ALIAS_FLAG))
        private set

    /** Set the color of the drawable. */
    var contourColorList: ColorStateList?
        get() = contourBrush.colorsList
        set(value) {
            contourBrush.colorsList = value
            if (contourBrush.applyState(state)) {
                invalidateThis()
            }
        }

    private val paddingBounds = Rect()
    private val pathBounds = RectF()
    private val path = Path()

    /**
     * Set the opacity
     * **NOTE** if you define a color (or as part of a colorStateList) with alpha
     * the alpha value of that color will ALWAYS WIN!
     */
    @IntRange(from = 0, to = 255)
    var compatAlpha = 255
        set(value) {
            field = value
            invalidateThis()
        }

    /** @return the IIcon which is used inside this IconicsDrawable */
    var icon: IIcon? = null
        set(value) {
            field = value
            typeface = value?.typeface?.rawTypeface
            if (field != null) {
                iconText = null
                invalidateThis()
            }
        }

    /** @return the PlainIcon which is used inside this IconicsDrawable */
    var iconText: String? = null
        set(value) {
            field = value
            if (field != null) {
                this.icon = null
                invalidateThis()
            }
        }

    /** @return if auto mirroring is enabled for this drawable */
    var autoMirroredCompat: Boolean = false
        set(value) {
            field = value
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                isAutoMirrored = value
            }
            invalidateThis()
        }

    /** defines if we want to instantly invalidate on changes */
    var invalidationEnabled = true
        set(value) {
            field = value
            invalidateSelf()
        }

    /** defines if we want to instantly invalidate changes of the shadow */
    internal var invalidateShadowEnabled = true

    /** Set the size by X axis of the drawable.*/
    var sizeXPx: Int = -1
        set(value) {
            field = value
            setBounds(0, 0, sizeXPx, sizeYPx)
        }

    /** Set the size by Y axis of the drawable.*/
    var sizeYPx: Int = -1
        set(value) {
            field = value
            setBounds(0, 0, sizeXPx, sizeYPx)
        }

    var respectFontBounds: Boolean = Iconics.respectFontBoundsDefault
        set(value) {
            field = value
            invalidateThis()
        }

    var drawContour: Boolean = false
        set(value) {
            if (value != drawContour) {
                field = value
                paddingPx += (if (drawContour) 1 else -1) * contourWidthPx
                invalidateThis()
            }
        }

    var drawBackgroundContour: Boolean = false
        set(value) {
            if (value != drawBackgroundContour) {
                field = value
                paddingPx += (if (drawBackgroundContour) 1 else -1) * backgroundContourWidthPx * 2
                invalidateThis()
            }
        }

    var roundedCornerRxPx: Float = -1f
        set(value) {
            field = value
            invalidateThis()
        }

    var roundedCornerRyPx: Float = -1f
        set(value) {
            field = value
            invalidateThis()
        }

    var paddingPx: Int = 0
        set(value) {
            if (field != value) {
                var adjustedPadding = value
                if (drawContour) {
                    adjustedPadding += contourWidthPx
                }
                if (drawBackgroundContour) {
                    adjustedPadding += backgroundContourWidthPx
                }
                field = adjustedPadding
                invalidateThis()
            }
        }

    var contourWidthPx: Int = 0
        set(value) {
            field = value
            contourBrush.paint.strokeWidth = contourWidthPx.toFloat()
            drawContour = true
            invalidateThis()
        }

    var backgroundContourWidthPx: Int = 0
        set(value) {
            field = value
            backgroundContourBrush.paint.strokeWidth = backgroundContourWidthPx.toFloat()
            drawBackgroundContour = true
            invalidateThis()
        }

    var iconOffsetXPx: Int = 0
        set(value) {
            field = value
            invalidateThis()
        }

    var iconOffsetYPx: Int = 0
        set(value) {
            field = value
            invalidateThis()
        }

    var shadowRadiusPx: Float = 0f
        set(value) {
            field = value
            updateShadow()
        }
    var shadowDxPx: Float = 0f
        set(value) {
            field = value
            updateShadow()
        }
    var shadowDyPx: Float = 0f
        set(value) {
            field = value
            updateShadow()
        }

    @ColorInt
    var shadowColorInt = Color.TRANSPARENT
        set(value) {
            field = value
            updateShadow()
            invalidateThis()
        }

    private fun updateShadow() {
        // will not update shadows if dinvalidation is disabled
        if (invalidateShadowEnabled) {
            iconBrush.paint.setShadowLayer(shadowRadiusPx, shadowDxPx, shadowDyPx, shadowColorInt)
            invalidateThis()
        }
    }

    var tint: ColorStateList? = null
        set(value) {
            field = value
            updateTintFilter()
            invalidateThis()
        }
    var tintPorterMode: PorterDuff.Mode = PorterDuff.Mode.SRC_IN
        set(value) {
            field = value
            updateTintFilter()
            invalidateThis()
        }
    private var tintFilter: ColorFilter? = null
    var iconColorFilter: ColorFilter? = null
        set(value) {
            field = value
            invalidateThis()
        }

    constructor(res: Resources, theme: Theme? = null) : this() {
        this.res = res
        this.theme = theme
    }

    constructor(res: Resources, theme: Theme? = null, icon: Char) : this(res, theme) {
        icon(icon)
    }

    constructor(res: Resources, theme: Theme? = null, icon: String) : this(res, theme) {
        icon(icon)
    }

    constructor(res: Resources, theme: Theme? = null, icon: IIcon) : this(res, theme) {
        icon(icon)
    }

    protected constructor(res: Resources, theme: Theme? = null, typeface: ITypeface, icon: IIcon) : this(res, theme) {
        icon(typeface, icon)
    }

    constructor(context: Context) : this(context.resources, context.theme) {
        Iconics.init(context)
    }

    constructor(context: Context, icon: Char) : this(context.resources, context.theme) {
        Iconics.init(context)
        icon(icon)
    }

    constructor(context: Context, icon: String) : this(context.resources, context.theme) {
        Iconics.init(context)
        icon(icon)
    }

    constructor(context: Context, icon: IIcon) : this(context.resources, context.theme) {
        Iconics.init(context)
        icon(icon)
    }

    protected constructor(context: Context, typeface: ITypeface, icon: IIcon) : this(context.resources, context.theme) {
        Iconics.init(context)
        icon(typeface, icon)
    }

    init {
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
    }

    // magic happens here ;)
    override fun draw(canvas: Canvas) {
        if (icon == null && iconText == null) return
        val viewBounds = bounds
        updatePaddingBounds(viewBounds)
        updatePathBounds(viewBounds)
        offsetIcon()

        if (needMirroring()) {
            // Mirror the drawable
            canvas.translate((bounds.right - bounds.left).toFloat(), 0f)
            canvas.scale(-1.0f, 1.0f)
        }

        if (roundedCornerRyPx > -1 && roundedCornerRxPx > -1) {
            if (drawBackgroundContour) {
                val halfContourSize = (backgroundContourWidthPx / 2).toFloat()
                val rectF = RectF(halfContourSize, halfContourSize, viewBounds.width() - halfContourSize, viewBounds.height() - halfContourSize)
                canvas.drawRoundRect(rectF, roundedCornerRxPx, roundedCornerRyPx, backgroundBrush.paint)
                canvas.drawRoundRect(rectF, roundedCornerRxPx, roundedCornerRyPx, backgroundContourBrush.paint)
            } else {
                val rectF = RectF(0f, 0f, viewBounds.width().toFloat(), viewBounds.height().toFloat())
                canvas.drawRoundRect(rectF, roundedCornerRxPx, roundedCornerRyPx, backgroundBrush.paint)
            }
        }
        runCatching { path.close() }
        if (drawContour) {
            canvas.drawPath(path, contourBrush.paint)
        }
        iconBrush.paint.colorFilter = iconColorFilter ?: tintFilter
        canvas.drawPath(path, iconBrush.paint)
    }

    override fun setTintList(tint: ColorStateList?) {
        this.tint = tint
    }

    override fun setTintMode(tintMode: PorterDuff.Mode?) {
        this.tintPorterMode = tintMode ?: PorterDuff.Mode.SRC_IN
    }

    override fun onBoundsChange(bounds: Rect) {
        updatePaddingBounds(bounds)
        updatePathBounds(bounds)
        offsetIcon()
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

    override fun setState(stateSet: IntArray?): Boolean {
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

    override fun getIntrinsicWidth(): Int = sizeXPx

    override fun getIntrinsicHeight(): Int = sizeYPx

    override fun setAlpha(@IntRange(from = 0, to = 255) alpha: Int) {
        iconBrush.alpha = alpha
        contourBrush.alpha = alpha
        backgroundBrush.alpha = alpha
        backgroundContourBrush.alpha = alpha
        compatAlpha = alpha
    }

    @IntRange(from = 0, to = 255)
    override fun getAlpha(): Int = compatAlpha

    override fun setColorFilter(cf: ColorFilter?) {
        iconColorFilter = cf
    }

    override fun clearColorFilter() {
        iconColorFilter = null
    }

    /** Update the Padding Bounds */
    private fun updatePaddingBounds(viewBounds: Rect) {
        if (paddingPx >= 0 && paddingPx * 2 <= viewBounds.width() && paddingPx * 2 <= viewBounds.height()) {
            paddingBounds.set(viewBounds.left + paddingPx, viewBounds.top + paddingPx, viewBounds.right - paddingPx, viewBounds.bottom - paddingPx)
        }
    }

    /** Update the TextSize */
    private fun updatePathBounds(viewBounds: Rect) {
        val textValue = icon?.character?.toString() ?: iconText.toString()

        var textSize = paddingBounds.height().toFloat()
        iconBrush.paint.textSize = textSize
        iconBrush.paint.getTextPath(textValue, 0, textValue.length, 0f, 0f, path)
        path.computeBounds(pathBounds, true)

        if (respectFontBounds) {
            path.offset(viewBounds.exactCenterX(), paddingBounds.top + textSize - iconBrush.paint.fontMetrics.descent)
        }
        else {
            val deltaWidth = paddingBounds.width().toFloat() / pathBounds.width()
            val deltaHeight = paddingBounds.height().toFloat() / pathBounds.height()
            val delta = if (deltaWidth < deltaHeight) deltaWidth else deltaHeight
            textSize *= delta
            iconBrush.paint.textSize = textSize
            iconBrush.paint.getTextPath(textValue, 0, textValue.length, 0f, 0f, path)
            path.computeBounds(pathBounds, true)
            path.offset(paddingBounds.left - pathBounds.left, paddingBounds.top - pathBounds.top)
        }
    }

    /** Set the icon offset */
    private fun offsetIcon() {
        if (respectFontBounds) {
            path.offset(iconOffsetXPx.toFloat(), iconOffsetYPx.toFloat())
        }
        else {
            val offsetX = (paddingBounds.width() - pathBounds.width()) / 2
            val offsetY = (paddingBounds.height() - pathBounds.height()) / 2
            path.offset(offsetX + iconOffsetXPx, offsetY + iconOffsetYPx)
        }
    }

    /** Ensures the tint filter is consistent with the current tint color and mode. */
    private fun updateTintFilter() {
        val tint = this.tint
        val tintMode = this.tintPorterMode

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

    private fun needMirroring(): Boolean {
        return autoMirroredCompat && DrawableCompat.getLayoutDirection(this) == ViewCompat.LAYOUT_DIRECTION_RTL
    }

    override fun inflate(r: Resources, parser: XmlPullParser, attrs: AttributeSet, theme: Theme?) {
        super.inflate(r, parser, attrs, theme)
        // set resource and theme to this icon
        this.res = r
        this.theme = theme
        obtainAttributes(r, theme, attrs, R.styleable.Iconics).use {
            IconicsAttrsExtractor(
                res = r,
                theme = theme,
                typedArray = it,
                iconId = R.styleable.Iconics_ico_icon,
                colorsId = R.styleable.Iconics_ico_color,
                sizeId = R.styleable.Iconics_ico_size,
                paddingId = R.styleable.Iconics_ico_padding,
                offsetXId = R.styleable.Iconics_ico_offset_x,
                offsetYId = R.styleable.Iconics_ico_offset_y,
                contourColorId = R.styleable.Iconics_ico_contour_color,
                contourWidthId = R.styleable.Iconics_ico_contour_width,
                backgroundColorId = R.styleable.Iconics_ico_background_color,
                cornerRadiusId = R.styleable.Iconics_ico_corner_radius,
                backgroundContourColorId = R.styleable.Iconics_ico_background_contour_color,
                backgroundContourWidthId = R.styleable.Iconics_ico_background_contour_width,
                shadowRadiusId = R.styleable.Iconics_ico_shadow_radius,
                shadowDxId = R.styleable.Iconics_ico_shadow_dx,
                shadowDyId = R.styleable.Iconics_ico_shadow_dy,
                shadowColorId = R.styleable.Iconics_ico_shadow_color,
                animationsId = R.styleable.Iconics_ico_animations,
                autoMirrorId = R.styleable.Iconics_ico_automirror
            ).extractInto(this)
        }
    }

    private fun obtainAttributes(res: Resources, theme: Theme?, set: AttributeSet, attrs: IntArray): TypedArray {
        return if (theme == null) {
            res.obtainAttributes(set, attrs)
        } else theme.obtainStyledAttributes(set, attrs, 0, 0)
    }

    /**
     * Invalidates the `IconicsDrawable` if invalidation is currently enabled
     */
    fun invalidateThis() {
        if (invalidationEnabled) {
            invalidateSelf()
        }
    }

    /**
     * Creates a BitMap to use in Widgets or anywhere else
     *
     * @return bitmap to set
     */
    fun toBitmap(): Bitmap {
        if (sizeXPx == -1 || sizeYPx == -1) {
            actionBar()
        }

        val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)

        style = Paint.Style.FILL

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
    @Deprecated("Use copy instead", ReplaceWith("copy()"))
    fun clone(): IconicsDrawable {
        return copy()
    }

    /**
     * Transform the icon to an animated icon
     *
     * @return new IconicsDrawable with the same values.
     */
    fun toAnimatedDrawable(): IconicsAnimatedDrawable {
        return copy(target = IconicsAnimatedDrawable(res, theme)) as IconicsAnimatedDrawable
    }

    /**
     * Copies this IconicsDrawable with the given modifications
     */
    @Suppress("LongParameterList")
    fun copy(
        target: IconicsDrawable? = null,
        res: Resources = this.res,
        theme: Theme? = this.theme,
        colorList: ColorStateList? = this.colorList,
        style: Paint.Style = this.style,
        typeface: Typeface? = this.typeface,
        backgroundContourColorList: ColorStateList? = this.backgroundContourColorList,
        backgroundColorList: ColorStateList? = this.backgroundColorList,
        contourColorList: ColorStateList? = this.contourColorList,
        compatAlpha: Int = this.compatAlpha,
        icon: IIcon? = this.icon,
        iconText: String? = this.iconText,
        autoMirroredCompat: Boolean = this.autoMirroredCompat,
        sizeXPx: Int = this.sizeXPx,
        sizeYPx: Int = this.sizeYPx,
        respectFontBounds: Boolean = this.respectFontBounds,
        drawContour: Boolean = this.drawContour,
        drawBackgroundContour: Boolean = this.drawBackgroundContour,
        roundedCornerRxPx: Float = this.roundedCornerRxPx,
        roundedCornerRyPx: Float = this.roundedCornerRyPx,
        paddingPx: Int = this.paddingPx,
        contourWidthPx: Int = this.contourWidthPx,
        backgroundContourWidthPx: Int = this.backgroundContourWidthPx,
        iconOffsetXPx: Int = this.iconOffsetXPx,
        iconOffsetYPx: Int = this.iconOffsetYPx,
        shadowRadiusPx: Float = this.shadowRadiusPx,
        shadowDxPx: Float = this.shadowDxPx,
        shadowDyPx: Float = this.shadowDyPx,
        shadowColorInt: Int = this.shadowColorInt,
        tint: ColorStateList? = this.tint,
        tintPorterMode: PorterDuff.Mode = this.tintPorterMode,
        iconColorFilter: ColorFilter? = this.iconColorFilter
    ): IconicsDrawable {
        return (target ?: IconicsDrawable(res, theme)).apply {
            this.colorList = colorList
            this.style = style
            this.typeface = typeface
            this.backgroundContourColorList = backgroundContourColorList
            this.backgroundColorList = backgroundColorList
            this.contourColorList = contourColorList
            this.compatAlpha = compatAlpha
            this.icon = icon
            this.iconText = iconText
            this.autoMirroredCompat = autoMirroredCompat
            this.sizeXPx = sizeXPx
            this.sizeYPx = sizeYPx
            this.respectFontBounds = respectFontBounds
            this.drawContour = drawContour
            this.drawBackgroundContour = drawBackgroundContour
            this.roundedCornerRxPx = roundedCornerRxPx
            this.roundedCornerRyPx = roundedCornerRyPx
            this.paddingPx = paddingPx
            this.contourWidthPx = contourWidthPx
            this.backgroundContourWidthPx = backgroundContourWidthPx
            this.iconOffsetXPx = iconOffsetXPx
            this.iconOffsetYPx = iconOffsetYPx
            this.shadowRadiusPx = shadowRadiusPx
            this.shadowDxPx = shadowDxPx
            this.shadowDyPx = shadowDyPx
            this.shadowColorInt = shadowColorInt
            this.tint = tint
            this.tintPorterMode = tintPorterMode
            this.iconColorFilter = iconColorFilter
        }
    }

    /** Applies the shadow in an optimized form. Will disable shadow invalidation for the inner shadow set operations */
    fun applyShadow(block: IconicsDrawable.() -> Unit): IconicsDrawable {
        invalidateShadowEnabled = false
        block()
        invalidateShadowEnabled = true
        updateShadow()
        return this
    }

    /** Applies properties in an optimized form. Will disable invalidation of the IconicsDrawable for the inner property set operations */
    fun apply(block: IconicsDrawable.() -> Unit): IconicsDrawable {
        invalidationEnabled = false
        block()
        invalidationEnabled = true
        invalidateSelf()
        return this
    }
}
