package uk.co.fintaxtech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A themed icon button.
 *
 * @param iconResId Drawable resource for the icon.
 * @param onClick Invoked when the button is tapped.
 * @param contentDescriptionResId Accessibility description.
 * @param modifier Layout modifier.
 * @param size Visual size of the button container. Defaults to 48dp.
 * @param iconSize Size of the icon inside. Defaults to 20dp.
 * @param cornerRadius Corner radius for the container. Defaults to 12dp.
 * @param containerColor Background color. Defaults to transparent.
 * @param border Optional border.
 * @param tint Icon tint.
 */
@Composable
fun FTTIconButton(
    @DrawableRes iconResId: Int,
    onClick: () -> Unit,
    @StringRes contentDescriptionResId: Int,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    iconSize: Dp = 20.dp,
    cornerRadius: Dp = 12.dp,
    containerColor: Color = Color.Transparent,
    border: BorderStroke? = null,
    tint: FTTIconTint = FTTIconTint.Primary
) {
    IconButton(
        onClick = onClick,
        modifier = modifier.size(48.dp) // Enforce minimum touch target
    ) {
        Surface(
            modifier = Modifier.size(size),
            shape = RoundedCornerShape(cornerRadius),
            color = containerColor,
            border = border
        ) {
            Box(contentAlignment = Alignment.Center) {
                FTTIcon(
                    iconResId = iconResId,
                    contentDescriptionResId = contentDescriptionResId,
                    size = iconSize,
                    tint = tint
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTIconButtonPreview() {
    FTTPreview {
        FTTIconButton(
            iconResId = R.drawable.ic_ftt_placeholder,
            onClick = {},
            contentDescriptionResId = R.string.ftt_preview_icon_description
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTIconButtonOverflowPreview() {
    FTTPreview {
        FTTIconButton(
            iconResId = R.drawable.ic_ftt_placeholder,
            onClick = {},
            contentDescriptionResId = R.string.ftt_preview_icon_description,
            size = 34.dp,
            iconSize = 17.dp,
            cornerRadius = 10.dp,
            border = BorderStroke(1.dp, LocalFTTColors.current.hairline),
            tint = FTTIconTint.Secondary
        )
    }
}
