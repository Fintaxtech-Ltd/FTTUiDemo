package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * Small, all-caps header for a group of settings or a list section.
 *
 * @param textResId Display copy.
 */
@Composable
fun FTTSectionHeader(
    @StringRes textResId: Int,
    modifier: Modifier = Modifier
) {
    FTTText(
        textResId = textResId,
        style = FTTTextStyle.SectionHeader,
        color = FTTTextColor.Secondary,
        modifier = modifier
            .padding(top = 22.dp, bottom = 9.dp)
            .padding(horizontal = 4.dp)
    )
}

@PreviewLightDark
@Composable
private fun FTTSectionHeaderPreview() {
    FTTPreview {
        FTTSectionHeader(textResId = R.string.ftt_preview_section_header)
    }
}
