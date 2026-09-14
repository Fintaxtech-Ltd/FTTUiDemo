package uk.co.fintaxtech.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.components.FTTDataText
import uk.co.fintaxtech.ui.components.FTTText
import uk.co.fintaxtech.ui.components.FTTTextColor
import uk.co.fintaxtech.ui.components.FTTTextStyle
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * Whole-region "nothing here yet" state.
 *
 * @param titleResId Display copy. Always a string resource.
 * @param bodyResId  Optional supporting copy. Always a string resource.
 * @param detail     Server- or user-originated text. Genuine data, so a plain [String],
 *                   and never translated by this view. Pass null when absent.
 */
@Composable
fun FTTEmptyView(
    @StringRes titleResId: Int,
    modifier: Modifier = Modifier,
    @StringRes bodyResId: Int? = null,
    detail: String? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FTTText(
            textResId = titleResId,
            style = FTTTextStyle.SectionTitle,
            textAlign = TextAlign.Center
        )

        if (bodyResId != null) {
            Spacer(modifier = Modifier.height(6.dp))
            FTTText(
                textResId = bodyResId,
                style = FTTTextStyle.Body,
                color = FTTTextColor.Secondary,
                textAlign = TextAlign.Center
            )
        }

        if (detail != null) {
            Spacer(modifier = Modifier.height(6.dp))
            FTTDataText(
                text = detail,
                style = FTTTextStyle.Meta,
                color = FTTTextColor.Secondary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTEmptyViewDefaultPreview() {
    FTTPreview {
        FTTEmptyView(titleResId = R.string.ftt_preview_empty_title)
    }
}

@PreviewLightDark
@Composable
private fun FTTEmptyViewWithBodyPreview() {
    FTTPreview {
        FTTEmptyView(
            titleResId = R.string.ftt_preview_empty_title,
            bodyResId = R.string.ftt_preview_empty_body
        )
    }
}
