package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * An inline banner showing an AI progressive-overload suggestion.
 *
 * @param copy          The suggestion text (e.g. "Strong work! Try 52.5 kg...").
 * @param actionResId   Display copy for the action button.
 * @param onApply       Invoked when the user taps the action button.
 * @param modifier      Layout modifier.
 * @param isApplied     Whether the suggestion has already been applied.
 */
@Composable
fun FTTSuggestionBanner(
    copy: String,
    @StringRes actionResId: Int,
    onApply: () -> Unit,
    modifier: Modifier = Modifier,
    isApplied: Boolean = false
) {
    val extendedColors = LocalFTTColors.current

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        color = extendedColors.accentContainer
    ) {
        Column(
            modifier = Modifier.padding(vertical = 13.dp, horizontal = 14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                FTTIcon(
                    iconResId = R.drawable.ic_star, // Should be ic_sparkle
                    contentDescriptionResId = null,
                    size = 19.dp,
                    tint = FTTIconTint.Accent
                )
                FTTDataText(
                    text = copy,
                    style = FTTTextStyle.Body,
                    color = FTTTextColor.Primary,
                    modifier = Modifier.weight(1f)
                )
            }

            FTTButton(
                textResId = actionResId,
                onClick = onApply,
                enabled = !isApplied,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTSuggestionBannerPreview() {
    FTTPreview {
        FTTSuggestionBanner(
            copy = "Strong work! Try 52.5 kg (+2.5 kg) on your next set based on your 12-rep max.",
            actionResId = R.string.ftt_preview_primary_action,
            onApply = {}
        )
    }
}
