package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A low-emphasis inline action, such as the "See all" affordance beside a section title.
 *
 * The touch target is expanded to the 48dp minimum through padding, so the control meets
 * the accessibility rule without growing the visual size the design specifies.
 *
 * @param textResId Display copy. Always a string resource.
 */
@Composable
fun FTTTextButton(
    @StringRes textResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: FTTTextStyle = FTTTextStyle.Link,
    color: FTTTextColor = FTTTextColor.Accent,
    enabled: Boolean = true
) {
    Box(
        modifier = modifier
            .defaultMinSize(minWidth = 48.dp, minHeight = 48.dp)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 4.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        FTTText(
            textResId = textResId,
            style = style,
            color = color
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTTextButtonDefaultPreview() {
    FTTPreview {
        FTTTextButton(
            textResId = R.string.ftt_preview_see_all,
            onClick = {}
        )
    }
}
