package uk.co.fintaxtech.ui.theme

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

/*
 * Temporary, high-cost preview annotations.
 *
 * These are debugging tools, not part of the standard preview contract in
 * kmp-ai/rules/rules-compose.md. That rule asks for @PreviewLightDark — two cheap
 * renders per state. The annotations here render six or eight, so apply one to a single
 * composable while you are working on it and remove the line when you are done. The
 * definitions stay here; only the usage is temporary.
 *
 * Device specs are written as `spec:` strings rather than `id:pixel_10` on purpose:
 * a spec renders on any Compose version, whereas an id silently falls back to a default
 * device if the running Android Studio does not know that name yet.
 */

private const val PIXEL_10A = "spec:width=1080px,height=2424px,dpi=422"
private const val PIXEL_10 = "spec:width=1080px,height=2424px,dpi=422"
private const val PIXEL_10_PRO = "spec:width=1280px,height=2856px,dpi=495"
private const val PIXEL_10_PRO_XL = "spec:width=1344px,height=2992px,dpi=486"

/**
 * The four Pixel 10 devices, each in light and dark — **eight renders**.
 *
 * Be aware of what this actually buys you. In dp, which is all Compose layout sees:
 *
 * | Device | dp |
 * |---|---|
 * | Pixel 10a | 409 x 919 |
 * | Pixel 10 | 409 x 919 |
 * | Pixel 10 Pro | 414 x 923 |
 * | Pixel 10 Pro XL | 442 x 985 |
 *
 * The 10a and the 10 are **identical**, and the Pro is 5dp wider. Six of these eight
 * renders tell you the same thing. Use this when you specifically want to see the app in
 * each hardware frame; use [FTTResponsivePreviews] when you want to find layout bugs.
 */
@Preview(
    name = "Pixel 10a · Light",
    group = "Pixel 10 family",
    device = PIXEL_10A,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10a · Dark",
    group = "Pixel 10 family",
    device = PIXEL_10A,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 · Light",
    group = "Pixel 10 family",
    device = PIXEL_10,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 · Dark",
    group = "Pixel 10 family",
    device = PIXEL_10,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 Pro · Light",
    group = "Pixel 10 family",
    device = PIXEL_10_PRO,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 Pro · Dark",
    group = "Pixel 10 family",
    device = PIXEL_10_PRO,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 Pro XL · Light",
    group = "Pixel 10 family",
    device = PIXEL_10_PRO_XL,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 Pro XL · Dark",
    group = "Pixel 10 family",
    device = PIXEL_10_PRO_XL,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
annotation class FTTDevicePreviews

/**
 * Six renders that span the variation which actually breaks layouts.
 *
 * Three viewports rather than four near-identical ones, plus the two conditions that
 * cause most real Compose layout bugs and that no Pixel-to-Pixel comparison will ever
 * surface: a genuinely small screen, and a user running large text.
 *
 * - **Compact** — 360 x 800dp, roughly a Pixel 4a. Narrower than any Pixel 10, so this
 *   is where text overflow and cramped rows appear first.
 * - **Pixel 10 Pro** — 414dp, standing in for the whole 409-414dp cluster.
 * - **Pixel 10 Pro XL** — 442dp, the widest phone you ship to.
 * - **Large font** — 200% text scale on the compact device. Catches fixed heights and
 *   clipped labels, which is the single most common accessibility defect.
 */
@Preview(
    name = "Compact · Light",
    group = "Responsive",
    device = "spec:width=360dp,height=800dp,dpi=420",
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Preview(
    name = "Compact · Dark",
    group = "Responsive",
    device = "spec:width=360dp,height=800dp,dpi=420",
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 Pro · Light",
    group = "Responsive",
    device = PIXEL_10_PRO,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Preview(
    name = "Pixel 10 Pro · Dark",
    group = "Responsive",
    device = PIXEL_10_PRO,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(
    name = "Pro XL · Dark",
    group = "Responsive",
    device = PIXEL_10_PRO_XL,
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Preview(
    name = "Large font 200% · Dark",
    group = "Responsive",
    device = "spec:width=360dp,height=800dp,dpi=420",
    uiMode = UI_MODE_NIGHT_YES,
    fontScale = 2.0f,
    showSystemUi = true
)
annotation class FTTResponsivePreviews
