package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A labelled single-line text field.
 *
 * The label sits above the field as a caption rather than floating inside it: these forms
 * are read top-to-bottom at a glance, and a Material floating label hides the question the
 * moment the user starts answering it.
 *
 * @param errorResId when non-null the border and the helper line turn red. Errors here are
 *        ordinary outcomes — a name already taken — so they render inline rather than as
 *        a dialog.
 * @param counter optional trailing text under the field, e.g. "12/24".
 * @param hidesKeyboardOnImeAction whether the done key dismisses the keyboard. Pass false
 *        only for a field built for repeated entry, where the next value follows the last.
 */
@Composable
fun FTTTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes labelResId: Int,
    @StringRes placeholderResId: Int,
    modifier: Modifier = Modifier,
    @StringRes trailingLabelResId: Int? = null,
    @StringRes errorResId: Int? = null,
    counter: String? = null,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: () -> Unit = {},
    hidesKeyboardOnImeAction: Boolean = true
) {
    val focusManager = LocalFocusManager.current

    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FTTText(
                textResId = labelResId,
                style = FTTTextStyle.Caption,
                color = FTTTextColor.Secondary
            )
            if (trailingLabelResId != null) {
                FTTText(
                    textResId = trailingLabelResId,
                    style = FTTTextStyle.Caption,
                    color = FTTTextColor.Secondary
                )
            }
        }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 52.dp),
            placeholder = {
                FTTText(
                    textResId = placeholderResId,
                    style = FTTTextStyle.Body,
                    color = FTTTextColor.Secondary
                )
            },
            singleLine = true,
            isError = errorResId != null,
            shape = MaterialTheme.shapes.medium,
            textStyle = MaterialTheme.typography.bodyLarge,
            keyboardOptions = KeyboardOptions(imeAction = imeAction),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Supplying onDone replaces Compose's default action, and that default
                    // is what dismisses the keyboard — so dismissing has to happen here, or
                    // the tick key does nothing at all.
                    if (hidesKeyboardOnImeAction) focusManager.clearFocus()
                    onImeAction()
                },
                onNext = {
                    focusManager.moveFocus(FocusDirection.Next)
                    onImeAction()
                }
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = LocalFTTColors.current.hairline,
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                errorContainerColor = MaterialTheme.colorScheme.surface
            )
        )

        if (errorResId != null || counter != null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp),
                horizontalArrangement = if (errorResId != null) {
                    Arrangement.SpaceBetween
                } else {
                    Arrangement.End
                }
            ) {
                if (errorResId != null) {
                    FTTText(
                        textResId = errorResId,
                        style = FTTTextStyle.Meta,
                        color = FTTTextColor.Error
                    )
                }
                if (counter != null) {
                    FTTDataText(
                        text = counter,
                        style = FTTTextStyle.Caption,
                        color = FTTTextColor.Secondary
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTTextFieldPreview() {
    FTTPreview {
        FTTTextField(
            value = "",
            onValueChange = {},
            labelResId = R.string.ftt_preview_field_label,
            placeholderResId = R.string.ftt_preview_field_placeholder
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTTextFieldErrorPreview() {
    FTTPreview {
        FTTTextField(
            value = "Rope Pushdown",
            onValueChange = {},
            labelResId = R.string.ftt_preview_field_label,
            placeholderResId = R.string.ftt_preview_field_placeholder,
            errorResId = R.string.ftt_preview_field_error,
            counter = "13/24"
        )
    }
}
