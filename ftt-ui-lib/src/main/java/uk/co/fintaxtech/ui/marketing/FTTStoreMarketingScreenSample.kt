package uk.co.fintaxtech.ui.marketing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.components.FTTText
import uk.co.fintaxtech.ui.components.FTTTextStyle
import uk.co.fintaxtech.ui.theme.FTTTheme

/**
 * End-to-end example wiring [FTTMarketingPreview], [FTTStoreMarketingScreen] and
 * [FTTPhoneFrame] together over a real design-system component — mirroring the pattern from
 * https://medium.com/@benlue/generate-app-store-screenshots-directly-from-jetpack-compose-previews-b2e30e4569a7
 *
 * Not part of the public API. Copy this shape into your app module: swap [content] for a
 * real app screen, and `headlineLines`/`subheadline` will localize themselves for every
 * locale [FTTMarketingPreview] renders, because `stringResource()` reads the active
 * preview's locale.
 *
 * Export the result from Android Studio's Preview panel — right-click a rendered preview
 * and choose "Copy Image", or use the panel's export action — and it renders at the full
 * pixel resolution the annotation targets.
 */
@FTTMarketingPreviewEn
@Composable
private fun FTTStoreMarketingScreenSample() {
    val headline = stringResource(R.string.ftt_preview_wordmark)
    val subheadline = stringResource(R.string.ftt_preview_body)

    FTTTheme {
        FTTStoreMarketingScreen(
            headlineLines = listOf(headline),
            subheadline = subheadline,
            backgroundColor = Color(0xFFFF5722),
            phonePosition = FTTPhonePosition.BottomPartial
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                FTTText(
                    textResId = R.string.ftt_preview_card_title,
                    style = FTTTextStyle.CardTitle,
                    modifier = Modifier.padding(24.dp)
                )
            }
        }
    }
}
