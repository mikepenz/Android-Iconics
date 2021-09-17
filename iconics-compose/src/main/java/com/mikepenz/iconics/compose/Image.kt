package com.mikepenz.iconics.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.mikepenz.iconics.typeface.IIcon

/**
 * A composable that lays out and draws a given [IIcon]. This will attempt to
 * size the composable according to the [IIcon]'s given width and height. However, an
 * optional [Modifier] parameter can be provided to adjust sizing or draw additional content (ex.
 * background). Any unspecified dimension will leverage the default 24dp size as a minimum
 * constraint.
 *
 * @param asset The [IIcon] to draw.
 * @param modifier Modifier used to adjust the layout algorithm or draw decoration content (ex.
 * background)
 * @param alignment Optional alignment parameter used to place the [ImageAsset] in the given
 * bounds defined by the width and height.
 * @param contentScale Optional scale parameter used to determine the aspect ratio scaling to be used
 * if the bounds are a different size from the intrinsic size of the [ImageAsset].
 * @param alpha Optional opacity to be applied to the [ImageAsset] when it is rendered onscreen
 * @param colorFilter Optional ColorFilter to apply for the [ImageAsset] when it is rendered
 * onscreen
 */
@Suppress("NOTHING_TO_INLINE")
@Composable
@SuppressLint("ModifierParameter")
inline fun Image(
    asset: IIcon,
    contentDescription: String? = asset.name,
    modifier: Modifier = Modifier.size(24.dp),
    iconicsConfig: IconicsConfig = IconicsConfig(),
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null
) {
    val imagePainter = remember(asset, iconicsConfig) { IconicsPainter(asset, iconicsConfig) }
    Image(
        painter = imagePainter,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )
}