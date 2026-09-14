package uk.co.fintaxtech.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import uk.co.fintaxtech.ui.components.FTTPrimaryActionButton
import uk.co.fintaxtech.ui.components.FTTText
import uk.co.fintaxtech.ui.components.FTTTextColor
import uk.co.fintaxtech.ui.components.FTTTextStyle
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * Whole-region failure state.
 *
 * This is the component where the resource-versus-data split matters most.
 *
 * @param titleResId Display copy. Always a string resource.
 * @param detail     Server-supplied error text. Genuine data, so a plain [String], and
 *                   never translated by this view. Pass null when absent.
 * @param onRetry    Optional action. The affordance renders only when supplied.
 * @param retryLabelResId Display copy for the retry affordance. Always a string resource.
 */
@Composable
fun FTTErrorView(
    @StringRes titleResId: Int,
    modifier: Modifier = Modifier,
    detail: String? = null,
    onRetry: (() -> Unit)? = null,
    @StringRes retryLabelResId: Int = R.string.ftt_retry
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FTTText(
            textResId = titleResId,
            style = FTTTextStyle.CardTitle,
            textAlign = TextAlign.Center
        )

        if (detail != null) {
            Spacer(modifier = Modifier.height(8.dp))
            FTTDataText(
                text = detail,
                style = FTTTextStyle.Meta,
                color = FTTTextColor.Secondary,
                textAlign = TextAlign.Center
            )
        }

        if (onRetry != null) {
            Spacer(modifier = Modifier.height(24.dp))
            FTTPrimaryActionButton(
                textResId = retryLabelResId,
                onClick = onRetry
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTErrorViewDefaultPreview() {
    FTTPreview {
        FTTErrorView(titleResId = R.string.ftt_preview_error_title)
    }
}

@PreviewLightDark
@Composable
private fun FTTErrorViewRetryablePreview() {
    FTTPreview {
        FTTErrorView(
            titleResId = R.string.ftt_preview_error_title,
            detail = "Connection timed out after 30s",
            onRetry = {}
        )
    }
}
