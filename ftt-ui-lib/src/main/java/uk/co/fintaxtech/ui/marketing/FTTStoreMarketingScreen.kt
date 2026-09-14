package uk.co.fintaxtech.ui.marketing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * How much of [FTTStoreMarketingScreen]'s device mockup is visible.
 *
 * [BottomPartial] and [BottomMorePartial] crop the phone off the bottom edge, trading device
 * visibility for headline space — useful when the feature the screenshot sells is at the top
 * of the screen.
 */
enum class FTTPhonePosition {
    CenterFull,
    BottomPartial,
    BottomMorePartial
}

private val FTTPhonePosition.alignment: Alignment
    get() = when (this) {
        FTTPhonePosition.CenterFull -> Alignment.Center
        FTTPhonePosition.BottomPartial, FTTPhonePosition.BottomMorePartial -> Alignment.BottomCenter
    }

private val FTTPhonePosition.widthFraction: Float
    get() = when (this) {
        FTTPhonePosition.CenterFull -> 0.78f
        FTTPhonePosition.BottomPartial -> 0.88f
        FTTPhonePosition.BottomMorePartial -> 0.98f
    }

/** Fraction of the screen's own height the phone is pushed down by, cropping it at the bottom edge. */
private val FTTPhonePosition.bottomCropFraction: Float
    get() = when (this) {
        FTTPhonePosition.CenterFull -> 0f
        FTTPhonePosition.BottomPartial -> 0.12f
        FTTPhonePosition.BottomMorePartial -> 0.28f
    }

/**
 * True while composing inside [FTTStoreMarketingScreen].
 *
 * Some UI doesn't render well in a static export — a Lottie animation, a video player, an
 * interactive control with nothing to react to it. Check this instead of hand-rolling an
 * `isPreview` parameter on every screen: `if (LocalFTTIsMarketingScreenshot.current) { /*
 * static drawable */ } else { /* real animation */ }`.
 */
val LocalFTTIsMarketingScreenshot = staticCompositionLocalOf { false }

/**
 * The marketing-screenshot template: a gradient background, a headline, and [content] —
 * real app UI, not a mockup — inside an [FTTPhoneFrame].
 *
 * Pair this with [FTTMarketingPreview] so `headlineLines`/`subheadline`, sourced from
 * `stringResource()` at the call site, render once per locale automatically. See
 * https://medium.com/@benlue/generate-app-store-screenshots-directly-from-jetpack-compose-previews-b2e30e4569a7
 *
 * @param headlineLines Already-resolved display copy, one string per line. Resolve the
 *                       string resource at the call site so the active preview's `locale`
 *                       is honoured.
 * @param subheadline    Optional supporting line, rendered uppercase below the headline.
 * @param phonePosition  How much of the device mockup is visible; see [FTTPhonePosition].
 */
@Composable
fun FTTStoreMarketingScreen(
    headlineLines: List<String>,
    modifier: Modifier = Modifier,
    subheadline: String? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    phonePosition: FTTPhonePosition = FTTPhonePosition.CenterFull,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalFTTIsMarketingScreenshot provides true) {
        BoxWithConstraints(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(backgroundColor, backgroundColor.copy(alpha = 0.75f))
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 64.dp, start = 32.dp, end = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                headlineLines.forEach { line ->
                    Text(
                        text = line,
                        style = MaterialTheme.typography.displayLarge,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }

                if (subheadline != null) {
                    Text(
                        text = subheadline.uppercase(),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White.copy(alpha = 0.9f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            FTTPhoneFrame(
                modifier = Modifier
                    .align(phonePosition.alignment)
                    .fillMaxWidth(phonePosition.widthFraction)
                    .offset(y = maxHeight * phonePosition.bottomCropFraction)
            ) {
                content()
            }
        }
    }
}
