package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

enum class FTTSegmentedRowLayout { Inline, Stacked }

/**
 * A list row that presents a segmented control.
 *
 * @param labelResId       Main row text.
 * @param optionsResIds    Display copy for each option.
 * @param selectedIndex    The currently active option.
 * @param onOptionSelected Invoked when an option is tapped.
 * @param leadingIcon      Optional icon or badge at the start.
 * @param layout           Whether the control is inline with the label or stacked below it.
 */
@Composable
fun FTTSegmentedRow(
    @StringRes labelResId: Int,
    optionsResIds: List<Int>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    layout: FTTSegmentedRowLayout = FTTSegmentedRowLayout.Inline
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                leadingIcon()
                Spacer(modifier = Modifier.width(13.dp))
            }

            FTTText(
                textResId = labelResId,
                style = FTTTextStyle.ListItemTitle,
                color = FTTTextColor.Primary,
                modifier = Modifier.weight(1f)
            )

            if (layout == FTTSegmentedRowLayout.Inline) {
                Spacer(modifier = Modifier.width(12.dp))
                FTTSegmentedControl(
                    optionsResIds = optionsResIds,
                    selectedIndex = selectedIndex,
                    onOptionSelected = onOptionSelected
                )
            }
        }

        if (layout == FTTSegmentedRowLayout.Stacked) {
            Spacer(modifier = Modifier.height(12.dp))
            FTTSegmentedControl(
                optionsResIds = optionsResIds,
                selectedIndex = selectedIndex,
                onOptionSelected = onOptionSelected,
                fillMaxWidth = true
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTSegmentedRowInlinePreview() {
    FTTPreview {
        FTTSegmentedRow(
            labelResId = R.string.ftt_preview_weight_units,
            optionsResIds = listOf(R.string.ftt_preview_tab_home, R.string.ftt_preview_tab_history),
            selectedIndex = 0,
            onOptionSelected = {},
            leadingIcon = {
                FTTIconBadge(
                    iconResId = R.drawable.ic_ftt_placeholder,
                    contentDescriptionResId = null
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTSegmentedRowStackedPreview() {
    FTTPreview {
        FTTSegmentedRow(
            labelResId = R.string.ftt_preview_theme_mode,
            optionsResIds = listOf(
                R.string.ftt_preview_tab_home,
                R.string.ftt_preview_tab_history,
                R.string.ftt_preview_tab_settings
            ),
            selectedIndex = 1,
            onOptionSelected = {},
            layout = FTTSegmentedRowLayout.Stacked,
            leadingIcon = {
                FTTIconBadge(
                    iconResId = R.drawable.ic_ftt_placeholder,
                    contentDescriptionResId = null
                )
            }
        )
    }
}
