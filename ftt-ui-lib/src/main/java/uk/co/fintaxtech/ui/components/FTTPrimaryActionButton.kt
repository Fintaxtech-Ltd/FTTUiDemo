package uk.co.fintaxtech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * The screen's single highest-priority call to action.
 *
 * @param textResId Display copy. Always a string resource — a raw [String] is never
 *                  accepted, so an unlocalized literal cannot reach the UI.
 * @param formatArg Optional dynamic value substituted into [textResId]. Genuine data
 *                  (an elapsed timer, a count), so a plain [String]; it is never
 *                  translated. Pass null when the copy takes no argument.
 * @param onClick   Invoked when the user activates the button.
 * @param iconResId Optional leading graphic.
 * @param iconContentDescriptionResId Description for the icon. Required whenever the
 *                  icon carries meaning not already stated by [textResId]; pass null
 *                  when it is decorative alongside the label.
 */
@Composable
fun FTTPrimaryActionButton(
    @StringRes textResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    formatArg: String? = null,
    enabled: Boolean = true,
    @DrawableRes iconResId: Int? = null,
    @StringRes iconContentDescriptionResId: Int? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (iconResId != null) {
                FTTIcon(
                    iconResId = iconResId,
                    contentDescriptionResId = iconContentDescriptionResId,
                    size = 22.dp,
                    tint = FTTIconTint.OnAccent
                )
            }
            if (formatArg != null) {
                FTTText(
                    textResId = textResId,
                    style = FTTTextStyle.ButtonLabel,
                    color = FTTTextColor.OnAccent,
                    formatArgs = arrayOf(formatArg)
                )
            } else {
                FTTText(
                    textResId = textResId,
                    style = FTTTextStyle.ButtonLabel,
                    color = FTTTextColor.OnAccent
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTPrimaryActionButtonEnabledPreview() {
    FTTPreview {
        FTTPrimaryActionButton(
            textResId = R.string.ftt_preview_primary_action,
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTPrimaryActionButtonWithIconPreview() {
    FTTPreview {
        FTTPrimaryActionButton(
            textResId = R.string.ftt_preview_primary_action,
            onClick = {},
            iconResId = R.drawable.ic_ftt_placeholder,
            iconContentDescriptionResId = null
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTPrimaryActionButtonDisabledPreview() {
    FTTPreview {
        FTTPrimaryActionButton(
            textResId = R.string.ftt_preview_primary_action,
            onClick = {},
            enabled = false
        )
    }
}
