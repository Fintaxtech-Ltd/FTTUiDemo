package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A single row in the workout logging table.
 *
 * Two numeric fields at most — weight+reps, distance+duration, duration+level — covers
 * every shape a set has needed so far, which is why this takes generic primary/secondary
 * values rather than being named after any one of them. Pass null for [secondaryValue]
 * (and [onSecondaryChange]) when the exercise's tracking type has only one field, such as
 * a plain duration hold: the row then renders a single input, not an empty second one.
 *
 * @param ordinal           The set number.
 * @param label             Shown in place of [ordinal] when set — "W" for a warmup. Warmups
 *                          are not numbered alongside working sets, because "3 sets" would
 *                          then mean two different things depending on where you counted.
 * @param previousSummary   Short text of previous performance (e.g. "50\u00d712" or "3:00").
 * @param primaryValue      The row's first value — weight, distance, or a duration.
 * @param secondaryValue    The row's second value, or null when there is only one.
 * @param isComplete        Whether this set is marked finished.
 * @param onPrimaryChange   Invoked when [primaryValue] is edited.
 * @param onSecondaryChange Invoked when [secondaryValue] is edited. Required unless
 *                          [secondaryValue] is null.
 * @param onToggleComplete  Invoked when the finish button is tapped.
 * @param onRemove          Deletes this set. Null hides the affordance entirely — no caller
 *                          currently does that, but the row should not assume one always
 *                          will. Reached by long-pressing the set number or the previous-
 *                          performance text, deliberately not a visible icon: the row has
 *                          no fixed-width column to spare for one without squeezing
 *                          [previousSummary] to nothing on a narrow phone.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FTTSetRow(
    ordinal: Int,
    previousSummary: String,
    primaryValue: String,
    secondaryValue: String?,
    isComplete: Boolean,
    onPrimaryChange: (String) -> Unit,
    onSecondaryChange: ((String) -> Unit)?,
    onToggleComplete: () -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    onRemove: (() -> Unit)? = null
) {
    val extendedColors = LocalFTTColors.current
    var isMenuOpen by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = if (isComplete) extendedColors.successRowTint else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 4.dp, horizontal = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Set number and previous performance share the long-press target below — grouped
        // here so the two flex together exactly as they did as separate siblings, with the
        // group taking whatever the fixed-width columns to their right leave.
        val longPressHint = stringResource(R.string.ftt_set_row_long_press_hint)
        Row(
            modifier = Modifier
                .weight(1f)
                .then(
                    if (onRemove != null) {
                        Modifier.combinedClickable(
                            onLongClickLabel = longPressHint,
                            onLongClick = { isMenuOpen = true },
                            onClick = {}
                        )
                    } else {
                        Modifier
                    }
                ),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Set Number (30dp)
            FTTDataText(
                text = label ?: ordinal.toString(),
                style = FTTTextStyle.MonoSetNumber,
                color = when {
                    isComplete -> FTTTextColor.Success
                    label != null -> FTTTextColor.Accent
                    // Quiet while pending, for the same reason the values are — see
                    // FTTNumericField. A row of bold numbers for work not yet done makes the
                    // card unreadable as a checklist.
                    else -> FTTTextColor.Secondary
                },
                modifier = Modifier.width(30.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            // Previous Performance (fill)
            FTTDataText(
                text = previousSummary,
                style = FTTTextStyle.MonoMeta,
                color = FTTTextColor.Secondary,
                modifier = Modifier.weight(1f),
                maxLines = 1
            )
        }

        if (onRemove != null) {
            DropdownMenu(expanded = isMenuOpen, onDismissRequest = { isMenuOpen = false }) {
                DropdownMenuItem(
                    text = {
                        FTTText(
                            textResId = R.string.ftt_set_row_delete,
                            style = FTTTextStyle.ListItemTitle,
                            color = FTTTextColor.Error
                        )
                    },
                    onClick = {
                        isMenuOpen = false
                        onRemove()
                    }
                )
            }
        }

        // Primary value — weight, distance, or a duration (74dp)
        FTTNumericField(
            value = primaryValue,
            onValueChange = onPrimaryChange,
            isComplete = isComplete,
            modifier = Modifier.width(74.dp)
        )

        // Secondary value — reps, a duration, or a level. Omitted entirely for a tracking
        // type with only one field, such as a plain duration hold.
        if (secondaryValue != null && onSecondaryChange != null) {
            FTTNumericField(
                value = secondaryValue,
                onValueChange = onSecondaryChange,
                isComplete = isComplete,
                modifier = Modifier.width(62.dp)
            )
        }

        // Complete Toggle (48dp)
        FTTCheckButton(
            isComplete = isComplete,
            onToggle = onToggleComplete,
            modifier = Modifier.width(48.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTSetRowPendingPreview() {
    FTTPreview {
        FTTSetRow(
            ordinal = 1,
            previousSummary = "50\u00d712",
            primaryValue = "50",
            secondaryValue = "12",
            isComplete = false,
            onPrimaryChange = {},
            onSecondaryChange = {},
            onToggleComplete = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTSetRowCompletePreview() {
    FTTPreview {
        FTTSetRow(
            ordinal = 1,
            previousSummary = "50\u00d712",
            primaryValue = "50",
            secondaryValue = "12",
            isComplete = true,
            onPrimaryChange = {},
            onSecondaryChange = {},
            onToggleComplete = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTSetRowSingleFieldPreview() {
    FTTPreview {
        FTTSetRow(
            ordinal = 1,
            previousSummary = "3:00",
            primaryValue = "45",
            secondaryValue = null,
            isComplete = false,
            onPrimaryChange = {},
            onSecondaryChange = null,
            onToggleComplete = {}
        )
    }
}
