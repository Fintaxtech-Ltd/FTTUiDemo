package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A card that is one option in a mutually exclusive set.
 *
 * Selection is shown two ways at once — an accent border and a tinted container — so the
 * state does not rely on colour alone.
 *
 * Pair with [FTTListItem] for the contents and [FTTRadioButton] in its leading slot. This
 * component owns only the container; it deliberately knows nothing about what is inside,
 * which is why a subscription plan and any future choice can both use it.
 */
@Composable
fun FTTSelectableCard(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val extendedColors = LocalFTTColors.current
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                extendedColors.accentContainer
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        border = BorderStroke(
            width = 2.dp,
            color = if (isSelected) MaterialTheme.colorScheme.primary else extendedColors.hairline
        ),
        content = content
    )
}

@PreviewLightDark
@Composable
private fun FTTSelectableCardSelectedPreview() {
    FTTPreview {
        FTTSelectableCard(isSelected = true, onClick = {}) {
            FTTListItem(
                leading = { FTTRadioButton(selected = true) },
                headline = { FTTText(R.string.ftt_preview_card_title, style = FTTTextStyle.ListItemTitle) }
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTSelectableCardUnselectedPreview() {
    FTTPreview {
        FTTSelectableCard(isSelected = false, onClick = {}) {
            FTTListItem(
                leading = { FTTRadioButton(selected = false) },
                headline = { FTTText(R.string.ftt_preview_card_title, style = FTTTextStyle.ListItemTitle) }
            )
        }
    }
}
