package uk.co.fintaxtech.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.components.FTTText
import uk.co.fintaxtech.ui.components.FTTTextColor
import uk.co.fintaxtech.ui.components.FTTTextStyle
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * Whole-region busy state.
 *
 * @param messageResId Optional display copy. Always a string resource. Pass null for a
 *                     bare indicator.
 */
@Composable
fun FTTLoadingView(
    modifier: Modifier = Modifier,
    @StringRes messageResId: Int? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(40.dp),
            color = MaterialTheme.colorScheme.primary
        )

        if (messageResId != null) {
            Spacer(modifier = Modifier.height(16.dp))
            FTTText(
                textResId = messageResId,
                style = FTTTextStyle.Body,
                color = FTTTextColor.Secondary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTLoadingViewDefaultPreview() {
    FTTPreview {
        FTTLoadingView()
    }
}

@PreviewLightDark
@Composable
private fun FTTLoadingViewWithMessagePreview() {
    FTTPreview {
        FTTLoadingView(messageResId = R.string.ftt_preview_loading)
    }
}
