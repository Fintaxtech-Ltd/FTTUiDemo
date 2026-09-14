package uk.co.fintaxtech.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Shared preview wrapper. Every `@PreviewLightDark` body in the design system and in
 * every feature module wraps its content in this, so theme and surface stay consistent.
 *
 * It takes no `darkTheme` parameter on purpose: `@PreviewLightDark` sets `uiMode`, which
 * drives `isSystemInDarkTheme()`, which [FTTTheme] already defaults to.
 */
@Composable
fun FTTPreview(
    padded: Boolean = true,
    content: @Composable () -> Unit
) {
    FTTTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Box(modifier = if (padded) Modifier.padding(16.dp) else Modifier) {
                content()
            }
        }
    }
}
