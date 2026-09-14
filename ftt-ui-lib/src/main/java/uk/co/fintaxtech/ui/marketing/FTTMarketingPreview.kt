package uk.co.fintaxtech.ui.marketing

import androidx.compose.ui.tooling.preview.Preview

/**
 * Renders an annotated composable as a set of localized App Store marketing screenshots.
 *
 * Based on: https://medium.com/@benlue/generate-app-store-screenshots-directly-from-jetpack-compose-previews-b2e30e4569a7
 *
 * The size is Apple's 6.9" App Store screenshot resolution (1290x2796px) divided by a 2.5x
 * export scale, giving the 516dp x 1118dp below. Android Studio renders `@Preview` at real
 * pixel density, so exporting one of these (right-click the preview -> "Copy Image", or the
 * Preview panel's export action) produces a full-resolution PNG at the target size.
 *
 * Because `stringResource()` inside the annotated composable resolves against whichever
 * `locale` the active preview declares, one composable produces every localized variant —
 * translations stay in sync with the screenshots automatically. Apply this to a composable
 * built from [FTTStoreMarketingScreen] and real app UI, not a static mockup.
 *
 * Use [FTTMarketingPreviewEn] instead while iterating on layout; it renders a single locale
 * so Android Studio doesn't re-render all seven on every keystroke.
 */
@Preview(name = "en-Marketing", locale = "en", widthDp = 516, heightDp = 1118, showBackground = true)
@Preview(name = "es-Marketing", locale = "es", widthDp = 516, heightDp = 1118, showBackground = true)
@Preview(name = "fr-Marketing", locale = "fr", widthDp = 516, heightDp = 1118, showBackground = true)
@Preview(name = "de-Marketing", locale = "de", widthDp = 516, heightDp = 1118, showBackground = true)
@Preview(name = "it-Marketing", locale = "it", widthDp = 516, heightDp = 1118, showBackground = true)
@Preview(name = "pt-Marketing", locale = "pt", widthDp = 516, heightDp = 1118, showBackground = true)
@Preview(name = "ja-Marketing", locale = "ja", widthDp = 516, heightDp = 1118, showBackground = true)
annotation class FTTMarketingPreview

/**
 * Single-locale variant of [FTTMarketingPreview] for fast layout iteration. Swap to the full
 * annotation once the design is settled and you're ready to export every locale.
 */
@Preview(name = "en-Marketing", locale = "en", widthDp = 516, heightDp = 1118, showBackground = true)
annotation class FTTMarketingPreviewEn
