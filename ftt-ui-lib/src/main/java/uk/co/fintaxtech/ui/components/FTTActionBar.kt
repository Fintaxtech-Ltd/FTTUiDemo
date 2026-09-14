package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * Compatibility shim for the top bar published in `ftt-android-ui-lib:0.0.2`.
 *
 * The component was renamed to [FTTTopBar] and reworked (see its KDoc for why the accent
 * band was dropped). Consumer projects — QuickInvoice among them — still call
 * `FTTActionBar`, so removing the name outright would break them the moment a new version
 * is published. This shim keeps those call sites compiling and delegates to [FTTTopBar],
 * so there is exactly one top bar implementation rather than two that can drift apart.
 *
 * **Appearance changes when consumers pick up this version.** The 0.0.2 bar was a
 * `TopAppBar` filled with `colorScheme.primary` and white content; [FTTTopBar] draws on
 * `background` and takes its colours from the theme. That is the intended redesign, not a
 * regression — but it is a visual change, not a drop-in no-op.
 *
 * The original parameter contract is preserved exactly: `onNavigationClick` is nullable and
 * `null` means *no navigation icon*, which maps onto [FTTTopBar]'s nullable
 * `navigationIconResId`.
 *
 * @param title String resource for the bar title.
 * @param onNavigationClick Invoked when the back icon is pressed. `null` hides the icon.
 * @param modifier Optional [Modifier] for layout adjustments.
 */
@Deprecated(
    message = "Renamed to FTTTopBar. Migrate to FTTTopBar(titleResId = ...); pass " +
        "navigationIconResId = R.drawable.ic_chevron_left to keep a back icon. " +
        "This shim exists only so existing FTT projects keep compiling and will be removed " +
        "in a future release.",
    level = DeprecationLevel.WARNING
)
@Composable
fun FTTActionBar(
    @StringRes title: Int,
    onNavigationClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    FTTTopBar(
        titleResId = title,
        modifier = modifier,
        // Preserves the 0.0.2 contract: a null callback meant the icon was not drawn at all.
        navigationIconResId = onNavigationClick?.let { R.drawable.ic_chevron_left },
        onNavigationClick = onNavigationClick ?: {}
    )
}

@Suppress("DEPRECATION")
@PreviewLightDark
@Composable
private fun FTTActionBarWithNavigationPreview() {
    FTTPreview(padded = false) {
        FTTActionBar(
            title = R.string.standard_title,
            onNavigationClick = {}
        )
    }
}

@Suppress("DEPRECATION")
@PreviewLightDark
@Composable
private fun FTTActionBarWithoutNavigationPreview() {
    FTTPreview(padded = false) {
        FTTActionBar(title = R.string.standard_title)
    }
}
