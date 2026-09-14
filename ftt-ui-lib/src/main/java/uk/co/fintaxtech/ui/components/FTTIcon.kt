package uk.co.fintaxtech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * Semantic icon tints, mirroring [FTTTextColor].
 */
enum class FTTIconTint {
    Primary,
    Secondary,
    Accent,
    OnAccent,
    Success,
    Error
}

/**
 * A themed icon.
 *
 * @param iconResId Drawable resource to render.
 * @param contentDescriptionResId Accessibility description, as a string resource.
 *        Pass null **only** when the icon is decorative and its meaning is already
 *        carried by adjacent text.
 */
@Composable
fun FTTIcon(
    @DrawableRes iconResId: Int,
    @StringRes contentDescriptionResId: Int?,
    modifier: Modifier = Modifier,
    size: Dp = 20.dp,
    tint: FTTIconTint = FTTIconTint.Primary
) {
    Icon(
        painter = painterResource(id = iconResId),
        contentDescription = contentDescriptionResId?.let { resId -> stringResource(id = resId) },
        modifier = modifier.size(size),
        tint = tint.resolve()
    )
}

/**
 * An icon inside a rounded, tinted container — the design's treatment for a badge such
 * as the streak flame.
 *
 * @param containerColor Background tint. Defaults to the success tint, which is the
 *        only usage in the current design; pass another token as new badges appear.
 */
@Composable
fun FTTIconBadge(
    @DrawableRes iconResId: Int,
    @StringRes contentDescriptionResId: Int?,
    modifier: Modifier = Modifier,
    containerSize: Dp = 34.dp,
    iconSize: Dp = 17.dp,
    cornerRadius: Dp = 12.dp,
    tint: FTTIconTint = FTTIconTint.Success,
    containerColor: Color = LocalFTTColors.current.successTint
) {
    Box(
        modifier = modifier
            .size(containerSize)
            .background(
                color = containerColor,
                shape = RoundedCornerShape(cornerRadius)
            ),
        contentAlignment = Alignment.Center
    ) {
        FTTIcon(
            iconResId = iconResId,
            contentDescriptionResId = contentDescriptionResId,
            size = iconSize,
            tint = tint
        )
    }
}

@Composable
@ReadOnlyComposable
private fun FTTIconTint.resolve(): Color = when (this) {
    FTTIconTint.Primary -> MaterialTheme.colorScheme.onSurface
    FTTIconTint.Secondary -> MaterialTheme.colorScheme.onSurfaceVariant
    FTTIconTint.Accent -> MaterialTheme.colorScheme.primary
    FTTIconTint.OnAccent -> MaterialTheme.colorScheme.onPrimary
    FTTIconTint.Success -> LocalFTTColors.current.success
    FTTIconTint.Error -> MaterialTheme.colorScheme.error
}

@PreviewLightDark
@Composable
private fun FTTIconDefaultPreview() {
    FTTPreview {
        FTTIcon(
            iconResId = R.drawable.ic_ftt_placeholder,
            contentDescriptionResId = R.string.ftt_preview_icon_description
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTIconBadgePreview() {
    FTTPreview {
        FTTIconBadge(
            iconResId = R.drawable.ic_ftt_placeholder,
            contentDescriptionResId = R.string.ftt_preview_icon_description
        )
    }
}
