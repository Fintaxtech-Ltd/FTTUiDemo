package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A full-screen themed background with optional centred content.
 *
 * The theme sets colours but paints nothing; every normal screen gets its background from
 * its own `Scaffold`. This covers the cases with no scaffold to speak of — a launch state
 * waiting on disk, a full-screen error — so hosts do not reach past the design system for
 * a raw `MaterialTheme.colorScheme` lookup.
 */
@Composable
fun FTTScreenSurface(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
            content = content
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTScreenSurfaceEmptyPreview() {
    FTTPreview(padded = false) { FTTScreenSurface() }
}
