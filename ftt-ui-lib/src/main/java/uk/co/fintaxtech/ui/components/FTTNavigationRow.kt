package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A row that navigates somewhere or performs an action, ending in a disclosure chevron.
 *
 * A thin arrangement of [FTTListItem] rather than a component in its own right. It exists
 * because this exact shape recurs constantly and spelling out four slots at every call site
 * is noise — not because a navigation row is structurally different from any other row.
 *
 * The name describes an **interaction**, not a domain concept, which is the line this design
 * system draws: `FTTNavigationRow` is legitimate, `FTTExerciseRow` was not.
 */
@Composable
fun FTTNavigationRow(
    @StringRes labelResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    supportingText: String? = null,
    value: String? = null,
    showChevron: Boolean = true
) {
    FTTListItem(
        modifier = modifier,
        leading = leadingIcon,
        headline = { FTTText(textResId = labelResId, style = FTTTextStyle.ListItemTitle) },
        supporting = supportingText?.let { text ->
            { FTTDataText(text = text, style = FTTTextStyle.Meta, color = FTTTextColor.Secondary) }
        },
        trailing = when {
            showChevron -> {
                { FTTListItemChevron(value = value) }
            }
            value != null -> {
                { FTTDataText(text = value, style = FTTTextStyle.ListItemValue, color = FTTTextColor.Secondary) }
            }
            else -> null
        },
        onClick = onClick
    )
}

@PreviewLightDark
@Composable
private fun FTTNavigationRowDefaultPreview() {
    FTTPreview {
        FTTNavigationRow(labelResId = R.string.ftt_preview_manage_subscription, onClick = {}, value = "Annual")
    }
}

@PreviewLightDark
@Composable
private fun FTTNavigationRowWithLeadingPreview() {
    FTTPreview {
        FTTNavigationRow(
            labelResId = R.string.ftt_preview_backup,
            onClick = {},
            leadingIcon = { FTTIconBadge(iconResId = R.drawable.ic_barbell, contentDescriptionResId = null) },
            supportingText = "Last backup 2 days ago"
        )
    }
}
