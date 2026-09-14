package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A list row with a toggle switch.
 *
 * @param labelResId          Main row text.
 * @param checked             Whether the switch is on.
 * @param onCheckedChange     Invoked when the user toggles the switch or taps the row.
 * @param leadingIcon         Optional icon or badge at the start.
 * @param supportingText      Optional smaller text below the label.
 * @param enabled             Whether the control accepts input.
 */
/**
 * A row whose trailing element is a switch. An arrangement of [FTTListItem]; the whole row
 * is tappable so the target is the row, not just the 52dp control.
 */
@Composable
fun FTTSwitchRow(
    @StringRes labelResId: Int,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    supportingText: String? = null,
    enabled: Boolean = true
) {
    FTTListItem(
        modifier = modifier,
        leading = leadingIcon,
        headline = { FTTText(textResId = labelResId, style = FTTTextStyle.ListItemTitle) },
        supporting = supportingText?.let { text ->
            { FTTDataText(text = text, style = FTTTextStyle.Meta, color = FTTTextColor.Secondary) }
        },
        trailing = {
            FTTSwitch(checked = checked, onCheckedChange = onCheckedChange, enabled = enabled)
        },
        onClick = if (enabled) {
            { onCheckedChange(!checked) }
        } else {
            null
        }
    )
}

@PreviewLightDark
@Composable
private fun FTTSwitchRowPreview() {
    FTTPreview {
        FTTSwitchRow(
            labelResId = R.string.ftt_preview_rest_timer_sound,
            checked = true,
            onCheckedChange = {},
            leadingIcon = {
                FTTIconBadge(
                    iconResId = R.drawable.ic_ftt_placeholder,
                    contentDescriptionResId = null
                )
            },
            supportingText = "Supporting text"
        )
    }
}
