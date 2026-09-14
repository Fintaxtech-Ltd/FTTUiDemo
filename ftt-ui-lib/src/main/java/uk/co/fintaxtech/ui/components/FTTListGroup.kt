package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A rounded container that groups related list items.
 *
 * It draws a hairline border and clips its content to the container's corners.
 * Callers should use [FTTDivider] between items.
 */
@Composable
fun FTTListGroup(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, LocalFTTColors.current.hairline)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.large),
            content = content
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTListGroupPreview() {
    FTTPreview {
        FTTListGroup {
            FTTText(
                textResId = R.string.ftt_preview_body,
                modifier = Modifier.padding(16.dp)
            )
            FTTDivider()
            FTTText(
                textResId = R.string.ftt_preview_body,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
