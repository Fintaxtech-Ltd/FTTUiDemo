package uk.co.fintaxtech.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A themed toggle switch.
 *
 * @param checked         Whether the switch is in the 'on' position.
 * @param onCheckedChange Invoked when the user toggles the switch.
 * @param enabled         Whether the switch accepts input.
 */
@Composable
fun FTTSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.onPrimary,
            checkedTrackColor = MaterialTheme.colorScheme.primary,
            uncheckedThumbColor = MaterialTheme.colorScheme.onSurfaceVariant,
            uncheckedTrackColor = LocalFTTColors.current.controlIdle,
            uncheckedBorderColor = Color.Transparent
        )
    )
}

@PreviewLightDark
@Composable
private fun FTTSwitchOnPreview() {
    FTTPreview {
        FTTSwitch(checked = true, onCheckedChange = {})
    }
}

@PreviewLightDark
@Composable
private fun FTTSwitchOffPreview() {
    FTTPreview {
        FTTSwitch(checked = false, onCheckedChange = {})
    }
}
