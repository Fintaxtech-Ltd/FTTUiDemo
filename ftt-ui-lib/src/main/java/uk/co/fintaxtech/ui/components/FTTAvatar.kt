package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTBrandGradientEnd
import uk.co.fintaxtech.ui.theme.FTTBrandGradientMid
import uk.co.fintaxtech.ui.theme.FTTBrandGradientStart
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A square-ish avatar with the brand gradient, displaying user initials.
 *
 * @param initials The user's initials (usually 1-2 characters).
 */
@Composable
fun FTTAvatar(
    initials: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(46.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        FTTBrandGradientStart,
                        FTTBrandGradientMid,
                        FTTBrandGradientEnd
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        FTTDataText(
            text = initials,
            style = FTTTextStyle.AvatarInitials,
            color = FTTTextColor.OnAccent
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTAvatarPreview() {
    FTTPreview {
        FTTAvatar(initials = "JS")
    }
}
