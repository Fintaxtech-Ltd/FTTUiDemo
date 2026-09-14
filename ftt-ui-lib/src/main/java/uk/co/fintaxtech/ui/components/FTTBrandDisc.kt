package uk.co.fintaxtech.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTBrandGradientEnd
import uk.co.fintaxtech.ui.theme.FTTBrandGradientMid
import uk.co.fintaxtech.ui.theme.FTTBrandGradientStart
import uk.co.fintaxtech.ui.theme.FTTPreview

private const val FLARE_DURATION_MILLIS = 3400
private const val FLARE_SCALE_FROM = 1.0f
private const val FLARE_SCALE_TO = 1.09f
private const val FLARE_ALPHA_FROM = 0.55f
private const val FLARE_ALPHA_TO = 0.85f

/** The flare is a soft halo, so it needs room to breathe: 116dp disc inside a 170dp box. */
private const val FLARE_SIZE_RATIO = 170f / 116f

/**
 * A gradient disc used as a branding element or a background for an icon.
 *
 * With [hasAnimatedFlare] the disc sits inside a slowly pulsing radial halo and the
 * composable claims `size * 1.47` of layout space rather than [size]. Without it, the
 * disc occupies exactly [size]. Callers that need a fixed footprint should account for
 * this rather than assuming the halo is free.
 *
 * @param size Edge length of the disc itself, not of the halo.
 * @param cornerRadius Corner radius of the disc.
 * @param hasAnimatedFlare Whether to draw the pulsing halo behind the disc (Onboarding).
 */
@Composable
fun FTTBrandDisc(
    size: Dp,
    cornerRadius: Dp,
    modifier: Modifier = Modifier,
    hasAnimatedFlare: Boolean = false,
    content: @Composable () -> Unit
) {
    if (!hasAnimatedFlare) {
        FTTBrandDiscSurface(size = size, cornerRadius = cornerRadius, modifier = modifier, content = content)
        return
    }

    val transition = rememberInfiniteTransition(label = "brandFlare")
    val pulseSpec = infiniteRepeatable<Float>(
        animation = tween(durationMillis = FLARE_DURATION_MILLIS, easing = FastOutSlowInEasing),
        repeatMode = RepeatMode.Reverse
    )
    val scale by transition.animateFloat(
        initialValue = FLARE_SCALE_FROM,
        targetValue = FLARE_SCALE_TO,
        animationSpec = pulseSpec,
        label = "flareScale"
    )
    val alpha by transition.animateFloat(
        initialValue = FLARE_ALPHA_FROM,
        targetValue = FLARE_ALPHA_TO,
        animationSpec = pulseSpec,
        label = "flareAlpha"
    )

    Box(
        modifier = modifier.size(size * FLARE_SIZE_RATIO),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    this.alpha = alpha
                }
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            FTTBrandGradientMid.copy(alpha = 0.42f),
                            Color.Transparent
                        )
                    ),
                    shape = CircleShape
                )
        )
        FTTBrandDiscSurface(size = size, cornerRadius = cornerRadius, content = content)
    }
}

@Composable
private fun FTTBrandDiscSurface(
    size: Dp,
    cornerRadius: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .size(size)
            .shadow(
                elevation = 30.dp,
                shape = RoundedCornerShape(cornerRadius),
                ambientColor = FTTBrandGradientMid.copy(alpha = 0.45f),
                spotColor = FTTBrandGradientMid.copy(alpha = 0.45f)
            )
            .clip(RoundedCornerShape(cornerRadius))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(FTTBrandGradientStart, FTTBrandGradientMid, FTTBrandGradientEnd)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@PreviewLightDark
@Composable
private fun FTTBrandDiscPlainPreview() {
    FTTPreview {
        FTTBrandDisc(size = 66.dp, cornerRadius = 22.dp) {
            FTTIcon(
                iconResId = R.drawable.ic_rocket,
                contentDescriptionResId = null,
                size = 34.dp,
                tint = FTTIconTint.OnAccent
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTBrandDiscWithFlarePreview() {
    FTTPreview {
        FTTBrandDisc(size = 116.dp, cornerRadius = 38.dp, hasAnimatedFlare = true) {
            FTTIcon(
                iconResId = R.drawable.ic_rocket,
                contentDescriptionResId = null,
                size = 62.dp,
                tint = FTTIconTint.OnAccent
            )
        }
    }
}
