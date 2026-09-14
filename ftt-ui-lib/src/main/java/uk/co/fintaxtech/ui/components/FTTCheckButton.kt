package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A square completion toggle.
 *
 * @param isComplete Whether the action is finished.
 * @param onToggle   Invoked when the user taps the control.
 */
@Composable
fun FTTCheckButton(
    isComplete: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val extendedColors = LocalFTTColors.current

    Surface(
        onClick = onToggle,
        modifier = modifier.size(48.dp),
        shape = RoundedCornerShape(8.dp), // Android-specific radius
        color = if (isComplete) extendedColors.success else Color.Transparent,
        border = if (isComplete) null else BorderStroke(2.dp, extendedColors.hairline)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            FTTIcon(
                iconResId = R.drawable.ic_check, // Should be ic_check
                contentDescriptionResId = null,
                size = 22.dp,
                tint = if (isComplete) FTTIconTint.OnAccent else FTTIconTint.Secondary
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTCheckButtonPendingPreview() {
    FTTPreview {
        FTTCheckButton(isComplete = false, onToggle = {})
    }
}

@PreviewLightDark
@Composable
private fun FTTCheckButtonCompletePreview() {
    FTTPreview {
        FTTCheckButton(isComplete = true, onToggle = {})
    }
}
