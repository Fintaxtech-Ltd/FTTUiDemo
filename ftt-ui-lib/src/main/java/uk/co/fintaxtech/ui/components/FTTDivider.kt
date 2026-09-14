package uk.co.fintaxtech.ui.components

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A standard hairline divider.
 */
@Composable
fun FTTDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = modifier,
        thickness = 1.dp,
        color = LocalFTTColors.current.hairline
    )
}
