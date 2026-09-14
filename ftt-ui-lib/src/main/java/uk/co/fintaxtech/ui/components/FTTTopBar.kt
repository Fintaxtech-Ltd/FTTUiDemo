package uk.co.fintaxtech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * The app's top bar: the page's own background, with themed content.
 *
 * Theme-derived rather than fixed. It was an accent bar with white content in both themes
 * until now — a saturated band pinned under the status bar, which is the dated look this
 * deliberately drops. Taking `background` rather than `surface` makes the bar seamless with
 * the content beneath it, so the title reads as the top of the page rather than as a
 * separate chrome element sitting on it.
 *
 * The brand has not gone anywhere; it just stops being a field. It stays where it means
 * something — the primary action, accent row titles, the selected tab — rather than
 * colouring a strip that carries no action at all.
 *
 * It still draws **behind** the status bar and pads its content clear of it, so the page
 * runs to the top edge. The status bar's icons now follow the theme, set from `FTTTheme`;
 * forcing them light, as this bar's accent version required, would make them vanish against
 * a light background.
 *
 * [FTTDataTopBar] is the same bar for a title that comes from data — a session name, a plan.
 * Split for the same reason [FTTText] and [FTTDataText] are: a `@StringRes` parameter here
 * keeps fixed titles localizable, and a `String` one would quietly permit a hardcoded label.
 */
@Composable
fun FTTTopBar(
    @StringRes titleResId: Int,
    modifier: Modifier = Modifier,
    @StringRes subtitleResId: Int? = null,
    @DrawableRes navigationIconResId: Int? = null,
    @StringRes navigationContentDescriptionResId: Int? = null,
    onNavigationClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    FTTTopBarSurface(
        modifier = modifier,
        navigationIconResId = navigationIconResId,
        navigationContentDescriptionResId = navigationContentDescriptionResId,
        onNavigationClick = onNavigationClick,
        actions = actions
    ) {
        FTTDataText(
            text = stringResource(titleResId),
            // ScreenTitle (800/30sp), not SheetTitle (700/19sp). This bar carries screen
            // names — "Settings", "History", the wordmark — and 19sp read as a label rather
            // than a heading. It is also what the design already specifies: the Settings IR
            // calls for ScreenTitle at 30sp, so the bar was under-sized against its own spec.
            // FTTDataTopBar keeps the smaller style, because its titles are data — a session
            // date such as "Mon 12 Aug · 18:04" would truncate at this size.
            style = FTTTextStyle.ScreenTitle,
            color = FTTTextColor.Primary,
            maxLines = 1
        )
        if (subtitleResId != null) {
            FTTDataText(
                text = stringResource(subtitleResId),
                style = FTTTextStyle.Meta,
                // Secondary, not Primary. White-on-accent gave the subtitle its separation
                // for free; on a themed bar it needs the quieter tone to stop competing
                // with the title.
                color = FTTTextColor.Secondary,
                maxLines = 1
            )
        }
    }
}

/** [FTTTopBar] for a title that comes from data rather than from a resource. */
@Composable
fun FTTDataTopBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    /**
     * Overridable because one bar's title is a running clock, which wants the monospaced
     * face so the digits stop jittering as they tick.
     */
    titleStyle: FTTTextStyle = FTTTextStyle.SheetTitle,
    @DrawableRes navigationIconResId: Int? = null,
    @StringRes navigationContentDescriptionResId: Int? = null,
    onNavigationClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    FTTTopBarSurface(
        modifier = modifier,
        navigationIconResId = navigationIconResId,
        navigationContentDescriptionResId = navigationContentDescriptionResId,
        onNavigationClick = onNavigationClick,
        actions = actions
    ) {
        FTTDataText(
            text = title,
            style = titleStyle,
            color = FTTTextColor.Primary,
            maxLines = 1
        )
        if (subtitle != null) {
            FTTDataText(
                text = subtitle,
                style = FTTTextStyle.Meta,
                color = FTTTextColor.Secondary,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun FTTTopBarSurface(
    modifier: Modifier,
    @DrawableRes navigationIconResId: Int?,
    @StringRes navigationContentDescriptionResId: Int?,
    onNavigationClick: () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    title: @Composable () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            // `background`, matching the Scaffold beneath it, rather than `surface` — a
            // card-coloured band would read as chrome the page has to sit under.
            .background(MaterialTheme.colorScheme.background)
            // Padding inside the background, so the fill runs behind the status bar rather
            // than leaving a strip of bare window above it.
            .statusBarsPadding()
            // Height before padding, so the bar is a standard height *including* its padding
            // rather than that much content plus padding on top of it.
            //
            // 72dp with 12dp of vertical padding, up from 56dp and 6dp. The vertical padding
            // is doubled — the bar had been squeezed flat when it stopped being an accent
            // band, and a 30sp title needs roughly 35dp of line box before any breathing room
            // at all. This restores the height the bar carried originally.
            .heightIn(min = 72.dp)
            .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (navigationIconResId != null) {
            FTTIconButton(
                iconResId = navigationIconResId,
                onClick = onNavigationClick,
                contentDescriptionResId = navigationContentDescriptionResId
                    ?: R.string.ftt_top_bar_back,
                tint = FTTIconTint.Primary
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = if (navigationIconResId == null) 12.dp else 0.dp)
        ) {
            title()
        }

        actions()
    }
}

@PreviewLightDark
@Composable
private fun FTTTopBarPreview() {
    FTTPreview(padded = false) {
        FTTTopBar(titleResId = R.string.ftt_preview_top_bar_title)
    }
}

@PreviewLightDark
@Composable
private fun FTTTopBarWithNavigationPreview() {
    FTTPreview(padded = false) {
        FTTTopBar(
            titleResId = R.string.ftt_preview_top_bar_title,
            navigationIconResId = R.drawable.ic_chevron_left,
            actions = {
                FTTTextButton(
                    textResId = R.string.ftt_preview_top_bar_action,
                    onClick = {},
                    color = FTTTextColor.Accent
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTDataTopBarPreview() {
    FTTPreview(padded = false) {
        FTTDataTopBar(
            title = "Push Day A",
            subtitle = "Mon 12 Aug · 18:04",
            navigationIconResId = R.drawable.ic_chevron_left
        )
    }
}

/** Shared measurements for screens built around [FTTTopBar]. */
object FTTTopBarDefaults {

    /**
     * The gap between the bar and the first thing under it.
     *
     * It kept content from reading as clipped against the old accent bar. The bar is now
     * the same colour as the page, so the gap is doing plain typographic work instead —
     * separating a title from its content. Still defined here rather than typed into each
     * screen, so it cannot drift apart across the app.
     */
    val ContentSpacing: Dp = 16.dp
}
