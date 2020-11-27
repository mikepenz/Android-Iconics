package com.mikepenz.iconics.compose

import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.text.TextPaint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import com.mikepenz.iconics.typeface.IIcon

data class IconicsConfig(
    val respectFontBounds: Boolean = true,
    val iconPaint: Paint = TextPaint(Paint.ANTI_ALIAS_FLAG),
    val iconBrush: Brush = SolidColor(Color.Black),
    val contourPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG),
    val contourBrush: Brush? = null,
    val paddingDp: Int? = null,
    val iconOffsetXPx: Int = 0,
    val iconOffsetYPx: Int = 0
)

@ExperimentalIconics
data class IconicsPainter(
    private val image: IIcon,
    private val config: IconicsConfig = IconicsConfig()
) : Painter() {
    private var isDirty by mutableStateOf(true)

    private val textValue = image.character.toString()

    private val paddingBounds = Rect()
    private val pathBounds = RectF()
    private val path = android.graphics.Path()

    private var iconPaint: Paint = config.iconPaint.apply {
        typeface = image.typeface.rawTypeface
    }

    private var alpha: Float = 1.0f
    private var colorFilter: ColorFilter? = null

    /** Update the Padding Bounds */
    private fun updatePaddingBounds(viewBounds: Rect) {
        val padding = config.paddingDp
        if (padding != null && padding * 2 <= viewBounds.width() && padding * 2 <= viewBounds.height()) {
            paddingBounds.set(
                viewBounds.left + padding,
                viewBounds.top + padding,
                viewBounds.right - padding,
                viewBounds.bottom - padding
            )
        }
    }

    /** Update the TextSize */
    private fun updateTextSize(viewBounds: Rect) {
        var textSize = viewBounds.height().toFloat() * if (config.respectFontBounds) 1 else 2
        iconPaint.textSize = textSize
        iconPaint.getTextPath(
            textValue,
            0,
            textValue.length,
            0f,
            viewBounds.height().toFloat(),
            path
        )
        path.computeBounds(pathBounds, true)

        if (!config.respectFontBounds) {
            val deltaWidth = paddingBounds.width().toFloat() / pathBounds.width()
            val deltaHeight = paddingBounds.height().toFloat() / pathBounds.height()
            val delta = if (deltaWidth < deltaHeight) deltaWidth else deltaHeight
            textSize *= delta
            iconPaint.textSize = textSize
            iconPaint.getTextPath(
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

        path.offset(offsetX + config.iconOffsetXPx, offsetY + config.iconOffsetYPx)
    }

    override fun DrawScope.onDraw() {
        val bounds = Rect(0, 0, this@onDraw.size.width.toInt(), this@onDraw.size.height.toInt())
        updatePaddingBounds(bounds)
        updateTextSize(bounds)
        offsetIcon(bounds)

        if (config.contourBrush != null) {
            drawPath(path.asComposePath(), config.contourBrush)
        }

        drawPath(
            path.asComposePath(),
            config.iconBrush,
            alpha = alpha,
            colorFilter = colorFilter
        )

        // This conditional is necessary to obtain invalidation callbacks as the state is
        // being read here which adds this callback to the snapshot observation
        if (isDirty) {
            isDirty = false
        }
    }

    /**
     * Icon fonts don't have a specific intrinsics size and will just scale
     */
    override val intrinsicSize: Size get() = Size.Unspecified

    override fun applyAlpha(alpha: Float): Boolean {
        this.alpha = alpha
        return true
    }

    override fun applyColorFilter(colorFilter: ColorFilter?): Boolean {
        this.colorFilter = colorFilter
        return true
    }
}