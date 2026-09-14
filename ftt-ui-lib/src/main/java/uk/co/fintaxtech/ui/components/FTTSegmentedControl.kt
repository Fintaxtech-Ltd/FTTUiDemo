package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A selector for mutually exclusive options, rendered as a track containing pills.
 *
 * @param optionsResIds    Display copy for each option.
 * @param selectedIndex    The currently active option.
 * @param onOptionSelected Invoked when an option is tapped.
 * @param fillMaxWidth     Whether to stretch to fill horizontal space (e.g. for 3+ options).
 */
@Composable
fun FTTSegmentedControl(
    optionsResIds: List<Int>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    fillMaxWidth: Boolean = false
) {
    Surface(
        modifier = if (fillMaxWidth) modifier.fillMaxWidth() else modifier,
        shape = MaterialTheme.shapes.medium,
        color = LocalFTTColors.current.fieldTrack
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            optionsResIds.forEachIndexed { index, resId ->
                val isSelected = index == selectedIndex
                Surface(
                    onClick = { onOptionSelected(index) },
                    modifier = if (fillMaxWidth) Modifier.weight(1f) else Modifier,
                    shape = MaterialTheme.shapes.medium,
                    color = if (isSelected) MaterialTheme.colorScheme.surface else Color.Transparent,
                    border = if (isSelected) BorderStroke(1.dp, LocalFTTColors.current.hairline) else null
                ) {
                    Box(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        FTTText(
                            textResId = resId,
                            style = FTTTextStyle.ListItemValue,
                            color = if (isSelected) FTTTextColor.Primary else FTTTextColor.Secondary
                        )
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTSegmentedControlWrapPreview() {
    FTTPreview {
        FTTSegmentedControl(
            optionsResIds = listOf(R.string.ftt_preview_tab_home, R.string.ftt_preview_tab_history),
            selectedIndex = 0,
            onOptionSelected = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTSegmentedControlFillPreview() {
    FTTPreview {
        FTTSegmentedControl(
            optionsResIds = listOf(
                R.string.ftt_preview_tab_home,
                R.string.ftt_preview_tab_history,
                R.string.ftt_preview_tab_settings
            ),
            selectedIndex = 1,
            onOptionSelected = {},
            fillMaxWidth = true
        )
    }
}
