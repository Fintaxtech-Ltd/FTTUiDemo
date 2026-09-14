package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * The slate marker running down the leading edge of a list row.
 *
 * Purely decorative — it carries no information a screen reader needs, so it exposes no
 * content description and takes no text.
 */
@Composable
fun FTTListAccentBar(
    modifier: Modifier = Modifier,
    width: Dp = 6.dp,
    height: Dp = 38.dp,
    color: Color = LocalFTTColors.current.slate
) {
    Box(
        modifier = modifier
            .width(width)
            .height(height)
            .background(color = color, shape = MaterialTheme.shapes.extraSmall)
    )
}

@PreviewLightDark
@Composable
private fun FTTListAccentBarDefaultPreview() {
    FTTPreview {
        FTTListAccentBar()
    }
}
