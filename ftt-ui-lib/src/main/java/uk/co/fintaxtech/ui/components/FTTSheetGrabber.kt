package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A purely decorative grabber for modal bottom sheets.
 */
@Composable
fun FTTSheetGrabber(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(top = 10.dp)
            .size(width = 38.dp, height = 4.dp)
            .background(
                color = LocalFTTColors.current.controlIdle,
                shape = RoundedCornerShape(2.dp)
            )
    )
}

@PreviewLightDark
@Composable
private fun FTTSheetGrabberPreview() {
    FTTPreview {
        FTTSheetGrabber()
    }
}
