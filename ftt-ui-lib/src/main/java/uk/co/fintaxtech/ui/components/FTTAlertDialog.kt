package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A themed confirmation dialog.
 *
 * Named after the interaction, not any one caller. Text arrives as `@StringRes` for the
 * same reason [FTTText] takes one — a `String` parameter here would be an unlocalizable
 * hole in the design system.
 *
 * @param isDestructive colours the confirm action as a destruction rather than a
 *        continuation. Use it when confirming means losing something.
 * @param content optional extra content below the body — a field the dialog collects
 *        before confirming. A slot rather than a `String` parameter, so the caller keeps
 *        the display-copy versus data distinction it already owns.
 */
@Composable
fun FTTAlertDialog(
    @StringRes titleResId: Int,
    @StringRes bodyResId: Int,
    @StringRes confirmTextResId: Int,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    @StringRes dismissTextResId: Int = R.string.ftt_dialog_cancel,
    /** Substituted into [bodyResId] when it carries placeholders. */
    bodyFormatArgs: Array<Any> = emptyArray(),
    isDestructive: Boolean = false,
    content: (@Composable () -> Unit)? = null
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp,
        title = { FTTText(textResId = titleResId, style = FTTTextStyle.CardTitle) },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                FTTText(
                    textResId = bodyResId,
                    style = FTTTextStyle.Body,
                    color = FTTTextColor.Secondary,
                    formatArgs = *bodyFormatArgs
                )
                content?.invoke()
            }
        },
        confirmButton = {
            FTTTextButton(
                textResId = confirmTextResId,
                onClick = onConfirm,
                color = if (isDestructive) FTTTextColor.Error else FTTTextColor.Accent
            )
        },
        dismissButton = {
            FTTTextButton(
                textResId = dismissTextResId,
                onClick = onDismiss,
                color = FTTTextColor.Secondary
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun FTTAlertDialogDestructivePreview() {
    FTTPreview {
        FTTAlertDialog(
            titleResId = R.string.ftt_preview_dialog_title,
            bodyResId = R.string.ftt_preview_dialog_body,
            confirmTextResId = R.string.ftt_preview_dialog_confirm,
            onConfirm = {},
            onDismiss = {},
            isDestructive = true
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTAlertDialogNeutralPreview() {
    FTTPreview {
        FTTAlertDialog(
            titleResId = R.string.ftt_preview_dialog_title,
            bodyResId = R.string.ftt_preview_dialog_body,
            confirmTextResId = R.string.ftt_preview_dialog_confirm,
            onConfirm = {},
            onDismiss = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTAlertDialogWithContentPreview() {
    FTTPreview {
        FTTAlertDialog(
            titleResId = R.string.ftt_preview_dialog_title,
            bodyResId = R.string.ftt_preview_dialog_body,
            confirmTextResId = R.string.ftt_preview_dialog_confirm,
            onConfirm = {},
            onDismiss = {}
        ) {
            FTTTextField(
                value = "",
                onValueChange = {},
                labelResId = R.string.ftt_preview_dialog_field_label,
                placeholderResId = R.string.ftt_preview_dialog_field_placeholder
            )
        }
    }
}
