package uk.co.fintaxtech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A circular icon button on a filled accent background — the treatment for a card's own
 * action, where a text button would compete with the card's title for attention.
 *
 * A wrapper over [FTTIconButton] rather than a call site passing a corner radius, so the
 * container stays circular at any size instead of being a coincidence of two numbers that
 * have to be changed together.
 *
 * Icon-only, so [contentDescriptionResId] is required rather than nullable: there is no
 * adjacent label to carry the meaning for a screen reader.
 */
@Composable
fun FTTFilledIconButton(
    @DrawableRes iconResId: Int,
    onClick: () -> Unit,
    @StringRes contentDescriptionResId: Int,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    iconSize: Dp = 20.dp,
    containerColor: Color = MaterialTheme.colorScheme.primary
) {
    FTTIconButton(
        iconResId = iconResId,
        onClick = onClick,
        contentDescriptionResId = contentDescriptionResId,
        modifier = modifier,
        size = size,
        iconSize = iconSize,
        cornerRadius = size / 2,
        containerColor = containerColor,
        tint = FTTIconTint.OnAccent
    )
}

@PreviewLightDark
@Composable
private fun FTTFilledIconButtonPreview() {
    FTTPreview {
        FTTFilledIconButton(
            iconResId = R.drawable.ic_play,
            onClick = {},
            contentDescriptionResId = R.string.ftt_preview_icon_description
        )
    }
}
