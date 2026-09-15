package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A standard button that sizes to its content.
 *
 * Distinct from [FTTPrimaryActionButton], which is always full-width and 56dp tall —
 * that one is the screen's single hero call to action. Use this for everything else,
 * including two buttons side by side.
 *
 * @param textResId Display copy. Always a string resource.
 */
@Composable
fun FTTButton(
    @StringRes textResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    contentColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    Button(
        onClick = onClick,
        modifier = modifier.heightIn(min = 48.dp),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        // The label takes LocalContentColor, which Button sets to [contentColor]. Mapping the
        // colour onto an FTTTextColor role instead discarded every custom contentColor except
        // onPrimary, so a label on a container fill rendered as onSurface — unreadable on a
        // dark container.
        Text(
            text = stringResource(id = textResId),
            style = FTTTextStyle.ButtonLabel.resolve(),
            color = LocalContentColor.current,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

/**
 * The lower-emphasis sibling of [FTTButton], for the secondary half of a button pair.
 *
 * @param textResId    Display copy.
 * @param onClick      Invoked when the button is tapped.
 * @param modifier     Layout modifier.
 * @param enabled      Whether the button accepts input.
 * @param height       Visual height of the button.
 * @param borderWidth  Thickness of the border.
 * @param cornerRadius Corner radius of the button.
 */
@Composable
fun FTTOutlinedButton(
    @StringRes textResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    /** Substituted into [textResId] when it carries a placeholder. */
    formatArg: String? = null,
    height: Dp = 48.dp,
    borderWidth: Dp = 1.dp,
    cornerRadius: Dp = 12.dp
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(height),
        enabled = enabled,
        shape = RoundedCornerShape(cornerRadius),
        border = BorderStroke(borderWidth, MaterialTheme.colorScheme.primary),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        if (formatArg == null) {
            FTTText(
                textResId = textResId,
                style = FTTTextStyle.ButtonLabel,
                color = FTTTextColor.Accent,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        } else {
            FTTText(
                textResId = textResId,
                style = FTTTextStyle.ButtonLabel,
                color = FTTTextColor.Accent,
                modifier = Modifier.padding(vertical = 4.dp),
                formatArgs = arrayOf<Any>(formatArg)
            )
        }
    }
}

/**
 * Low-emphasis filled button on the field track.
 */
@Composable
fun FTTTonalButton(
    @StringRes textResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    height: Dp = 40.dp,
    cornerRadius: Dp = 11.dp,
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    contentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(height),
        enabled = enabled,
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        FTTText(
            textResId = textResId,
            style = FTTTextStyle.ButtonLabel,
            color = FTTTextColor.Secondary,
            modifier = Modifier.padding(vertical = 2.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTButtonEnabledPreview() {
    FTTPreview { FTTButton(textResId = R.string.ftt_preview_primary_action, onClick = {}) }
}

@PreviewLightDark
@Composable
private fun FTTButtonDisabledPreview() {
    FTTPreview { FTTButton(textResId = R.string.ftt_preview_primary_action, onClick = {}, enabled = false) }
}

@PreviewLightDark
@Composable
private fun FTTOutlinedButtonEnabledPreview() {
    FTTPreview { FTTOutlinedButton(textResId = R.string.ftt_preview_primary_action, onClick = {}) }
}

@PreviewLightDark
@Composable
private fun FTTTonalButtonPreview() {
    FTTPreview { FTTTonalButton(textResId = R.string.ftt_preview_primary_action, onClick = {}) }
}
