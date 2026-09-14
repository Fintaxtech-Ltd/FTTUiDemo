package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A table for logging workout sets, sharing a column specification between header and rows.
 *
 * Column labels are plain resolved strings rather than `@StringRes` ids — [primaryColumnLabel]
 * always was ("kg"/"lbs"), because it names a unit rather than fixed chrome, and
 * [secondaryColumnLabel] follows the same shape now that it is no longer always "Reps": a
 * duration exercise heads its second column "Level", a distance one heads its first "km".
 * The caller resolves whichever resource applies and passes the result in.
 *
 * @param primaryColumnLabel   The first value column's header (e.g. "kg", "km", "sec").
 * @param secondaryColumnLabel The second value column's header, or null when the tracking
 *        type has only one field — see [FTTSetRow].
 * @param content              Rows of the table.
 */
@Composable
fun FTTSetTable(
    primaryColumnLabel: String,
    modifier: Modifier = Modifier,
    secondaryColumnLabel: String? = null,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Table Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FTTText(
                textResId = R.string.ftt_set_table_set,
                style = FTTTextStyle.Caption,
                color = FTTTextColor.Secondary,
                modifier = Modifier.width(30.dp),
                textAlign = TextAlign.Center
            )
            // One line, always. This column takes whatever the fixed ones leave, and on a
            // larger display size or font scale that is narrow enough for "Previous" to
            // wrap — which pushed the header to two lines and misaligned the whole table.
            FTTText(
                textResId = R.string.ftt_set_table_previous,
                style = FTTTextStyle.Caption,
                color = FTTTextColor.Secondary,
                modifier = Modifier.weight(1f),
                maxLines = 1
            )
            FTTDataText(
                text = primaryColumnLabel,
                style = FTTTextStyle.Caption,
                color = FTTTextColor.Secondary,
                modifier = Modifier.width(74.dp),
                textAlign = TextAlign.Center,
                maxLines = 1
            )
            if (secondaryColumnLabel != null) {
                FTTDataText(
                    text = secondaryColumnLabel,
                    style = FTTTextStyle.Caption,
                    color = FTTTextColor.Secondary,
                    modifier = Modifier.width(62.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }
            // Empty space for the check button column (48dp)
            Spacer(modifier = Modifier.width(48.dp))
        }

        // Table Rows
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            content()
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTSetTablePreview() {
    FTTPreview {
        FTTSetTable(primaryColumnLabel = "kg", secondaryColumnLabel = "Reps") {
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
            FTTSetRow(
                ordinal = 2,
                previousSummary = "50\u00d712",
                primaryValue = "52.5",
                secondaryValue = "10",
                isComplete = false,
                onPrimaryChange = {},
                onSecondaryChange = {},
                onToggleComplete = {}
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTSetTableSingleColumnPreview() {
    FTTPreview {
        FTTSetTable(primaryColumnLabel = "sec") {
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
}
