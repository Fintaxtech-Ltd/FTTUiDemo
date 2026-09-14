package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A custom radio button matching the design spec.
 *
 * @param selected Whether the radio button is selected.
 */
@Composable
fun FTTRadioButton(
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    val extendedColors = LocalFTTColors.current
    val borderColor = if (selected) MaterialTheme.colorScheme.primary else extendedColors.controlIdle

    Box(
        modifier = modifier
            .size(20.dp)
            .border(width = 2.dp, color = borderColor, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            Surface(
                modifier = Modifier.size(10.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.primary
            ) {}
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTRadioButtonSelectedPreview() {
    FTTPreview {
        FTTRadioButton(selected = true)
    }
}

@PreviewLightDark
@Composable
private fun FTTRadioButtonUnselectedPreview() {
    FTTPreview {
        FTTRadioButton(selected = false)
    }
}
