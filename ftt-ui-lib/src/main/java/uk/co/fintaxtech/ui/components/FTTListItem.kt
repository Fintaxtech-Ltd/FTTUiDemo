package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * The one row primitive.
 *
 * Nearly every row in this app is the same shape — an optional leading element, a headline
 * with optional supporting text, and an optional trailing element:
 *
 * ```
 * [ leading ]  headline            [ trailing ]
 *              supporting
 * ```
 *
 * A settings row, a session row, a plan card, an exercise row and a feature bullet all fit
 * that shape; only their slot contents differ. Before this existed the design system carried
 * seven near-identical components, several of them named after domain concepts — an
 * `FTTExerciseRow` in a *generic* design system is a category error, because the design
 * system must not know what an exercise is.
 *
 * Slots take composables rather than strings so the [FTTText] / [FTTDataText] distinction
 * survives: the caller decides whether each piece of text is display copy or data, and this
 * component never has to guess.
 *
 * Wrap in [FTTListGroup] for the card-with-dividers treatment.
 *
 * @param headline The row's primary text. Required — a row without one is not a list item.
 * @param supporting Secondary text beneath the headline.
 * @param leading Icon, badge, avatar, radio or accent bar at the start.
 * @param trailing Value, chevron, switch, segmented control or check at the end.
 * @param onClick Makes the whole row tappable. Null leaves it inert.
 * @param minHeight Enforces the 48dp minimum touch target when the row is clickable.
 */
@Composable
fun FTTListItem(
    headline: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    supporting: (@Composable () -> Unit)? = null,
    leading: (@Composable () -> Unit)? = null,
    trailing: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
    containerColor: Color = Color.Transparent,
    horizontalSpacing: Dp = 12.dp,
    minHeight: Dp = 48.dp
) {
    val content: @Composable () -> Unit = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = minHeight)
                .padding(contentPadding),
            horizontalArrangement = Arrangement.spacedBy(horizontalSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leading?.invoke()

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                headline()
                supporting?.invoke()
            }

            trailing?.invoke()
        }
    }

    if (onClick != null) {
        Surface(onClick = onClick, modifier = modifier, color = containerColor, content = content)
    } else {
        Surface(modifier = modifier, color = containerColor, content = content)
    }
}

/**
 * Convenience trailing slot: a value followed by a disclosure chevron. The most common
 * trailing arrangement in the app, and the reason `FTTNavigationRow` used to exist.
 */
@Composable
fun FTTListItemChevron(value: String? = null) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (value != null) {
            FTTDataText(text = value, style = FTTTextStyle.ListItemValue, color = FTTTextColor.Secondary)
        }
        FTTIcon(
            iconResId = R.drawable.ic_chevron_right,
            contentDescriptionResId = null,
            size = 15.dp,
            tint = FTTIconTint.Secondary
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTListItemHeadlineOnlyPreview() {
    FTTPreview {
        FTTListItem(
            headline = { FTTText(R.string.ftt_preview_restore, style = FTTTextStyle.ListItemTitle) },
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTListItemWithChevronPreview() {
    FTTPreview {
        FTTListItem(
            headline = { FTTText(R.string.ftt_preview_manage_subscription, style = FTTTextStyle.ListItemTitle) },
            trailing = { FTTListItemChevron(value = "Annual") },
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTListItemFullPreview() {
    FTTPreview {
        FTTListItem(
            leading = { FTTIconBadge(iconResId = R.drawable.ic_chevron_right, contentDescriptionResId = null) },
            headline = { FTTText(R.string.ftt_preview_backup, style = FTTTextStyle.ListItemTitle) },
            supporting = {
                FTTDataText("Last backup 2 days ago", style = FTTTextStyle.Meta, color = FTTTextColor.Secondary)
            },
            trailing = { FTTListItemChevron() },
            onClick = {}
        )
    }
}
