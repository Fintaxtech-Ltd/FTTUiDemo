package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A selectable chip for filtering lists.
 *
 * @param label The text to display. Data originating from domain, so a plain String.
 * @param isSelected Whether the chip is in the active state.
 * @param onClick Invoked when the chip is tapped.
 */
@Composable
fun FTTFilterChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = if (isSelected) {
            MaterialTheme.colorScheme.primary
        } else {
            LocalFTTColors.current.fieldTrack
        },
        contentColor = if (isSelected) {
            MaterialTheme.colorScheme.onPrimary
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant
        },
        border = if (isSelected) null else BorderStroke(1.dp, Color.Transparent)
    ) {
        FTTDataText(
            text = label,
            // TODO: The design specifies weight 700 when selected and 600 otherwise. Both
            //  currently map to ListItemValue, so the chip does not change weight on
            //  selection. Needs a second type role before this can branch meaningfully.
            style = FTTTextStyle.ListItemValue,
            modifier = Modifier.padding(vertical = 9.dp, horizontal = 15.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTFilterChipSelectedPreview() {
    FTTPreview {
        FTTFilterChip(label = "Chest", isSelected = true, onClick = {})
    }
}

@PreviewLightDark
@Composable
private fun FTTFilterChipUnselectedPreview() {
    FTTPreview {
        FTTFilterChip(label = "Back", isSelected = false, onClick = {})
    }
}
