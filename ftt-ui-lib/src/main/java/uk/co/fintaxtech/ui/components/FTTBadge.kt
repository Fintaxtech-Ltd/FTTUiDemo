package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A small label for a status or membership tier.
 *
 * @param textResId      Display copy.
 * @param containerColor Background color. Defaults to the primary accent.
 * @param contentColor   Color for the text. Defaults to onPrimary.
 * @param cornerRadius   Corner radius for the badge. Defaults to 7dp.
 */
@Composable
fun FTTBadge(
    @StringRes textResId: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    cornerRadius: Dp = 7.dp
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        color = containerColor,
        contentColor = contentColor
    ) {
        FTTText(
            textResId = textResId,
            style = FTTTextStyle.Badge,
            color = if (contentColor ==
                MaterialTheme.colorScheme.primary
            ) {
                FTTTextColor.Accent
            } else {
                FTTTextColor.OnAccent
            },
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 9.dp)
        )
    }
}

/**
 * Text whose content is **data**, not copy.
 */
@Composable
fun FTTDataBadge(
    text: String,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary,
    cornerRadius: Dp = 7.dp
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(cornerRadius),
        color = containerColor,
        contentColor = contentColor
    ) {
        FTTDataText(
            text = text,
            style = FTTTextStyle.Badge,
            color = if (contentColor ==
                MaterialTheme.colorScheme.primary
            ) {
                FTTTextColor.Accent
            } else {
                FTTTextColor.OnAccent
            },
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 9.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTBadgePreview() {
    FTTPreview {
        FTTBadge(textResId = R.string.ftt_preview_badge)
    }
}

@PreviewLightDark
@Composable
private fun FTTBadgeTintedPreview() {
    FTTPreview {
        FTTBadge(
            textResId = R.string.ftt_preview_badge,
            containerColor = Color(0xFFFF5722).copy(alpha = 0.13f),
            contentColor = Color(0xFFFF5722),
            cornerRadius = 8.dp
        )
    }
}
