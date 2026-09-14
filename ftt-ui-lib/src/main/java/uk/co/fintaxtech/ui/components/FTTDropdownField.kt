package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A labelled field that picks one option from a closed list via a dropdown menu.
 *
 * Mirrors [FTTTextField]'s layout — a caption label above an outlined field — so a form
 * mixing typed and picked fields reads as one system. Unlike [FTTSegmentedControl], which
 * suits two or three mutually exclusive options shown at once as pills, this is for a list
 * too long to lay out that way without crowding the row.
 *
 * Whether the menu is open is local, ephemeral UI state, not something a caller needs to
 * hoist — it never outlives this composable and carries no meaning once collapsed.
 *
 * @param optionsResIds    Display copy for every option, in the order presented. All copy
 *        here is chrome, never data, so every option is a resource id — see [FTTText].
 * @param selectedIndex    The currently chosen option.
 * @param onOptionSelected Invoked with the tapped option's index. The menu closes itself.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FTTDropdownField(
    @StringRes labelResId: Int,
    optionsResIds: List<Int>,
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = modifier.fillMaxWidth()) {
        FTTText(
            textResId = labelResId,
            style = FTTTextStyle.Caption,
            color = FTTTextColor.Secondary,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = it }
        ) {
            OutlinedTextField(
                value = optionsResIds.getOrNull(selectedIndex)
                    ?.let { resId -> stringResource(id = resId) }
                    .orEmpty(),
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 52.dp)
                    .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable),
                readOnly = true,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                textStyle = MaterialTheme.typography.bodyLarge,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = LocalFTTColors.current.hairline,
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                )
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                optionsResIds.forEachIndexed { index, optionResId ->
                    DropdownMenuItem(
                        text = { FTTText(textResId = optionResId, style = FTTTextStyle.Body) },
                        onClick = {
                            isExpanded = false
                            onOptionSelected(index)
                        }
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTDropdownFieldPreview() {
    FTTPreview {
        FTTDropdownField(
            labelResId = R.string.ftt_preview_field_label,
            optionsResIds = listOf(
                R.string.ftt_preview_dropdown_option_1,
                R.string.ftt_preview_dropdown_option_2,
                R.string.ftt_preview_dropdown_option_3
            ),
            selectedIndex = 0,
            onOptionSelected = {}
        )
    }
}
