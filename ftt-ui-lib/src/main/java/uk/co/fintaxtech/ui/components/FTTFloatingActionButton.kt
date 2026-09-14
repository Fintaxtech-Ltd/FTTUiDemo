package uk.co.fintaxtech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * The screen's primary action, as an extended floating action button.
 *
 * Accent container with white content, matching [FTTTopBar] — the two are the only surfaces
 * in the app that carry the accent, and between them they bracket the screen.
 *
 * [isExpanded] shows the label; collapsing to the icon alone while the user scrolls gives
 * the list its width back without the action ever leaving. It is a parameter rather than
 * something this component works out, because a screen may scroll a `ScrollState`, a
 * `LazyListState`, or nothing at all — see [rememberFabExpanded].
 *
 * A screen that does not scroll simply never collapses it, which is why the action can
 * never become unreachable.
 */
@Composable
fun FTTFloatingActionButton(
    @StringRes textResId: Int,
    @DrawableRes iconResId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = true
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            FTTIcon(
                iconResId = iconResId,
                // The label says it when expanded; when collapsed this is the only
                // description there is, so it is never decorative.
                contentDescriptionResId = textResId,
                size = 20.dp,
                tint = FTTIconTint.OnAccent
            )
            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn() + expandHorizontally(),
                exit = fadeOut() + shrinkHorizontally()
            ) {
                FTTDataText(
                    text = stringResource(textResId),
                    style = FTTTextStyle.ButtonLabel,
                    color = FTTTextColor.OnAccent,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

/**
 * Expanded while the list is at the top, collapsed once it has been scrolled.
 *
 * `derivedStateOf` so the button recomposes when the answer changes rather than on every
 * pixel of scroll.
 */
@Composable
fun rememberFabExpanded(listState: LazyListState): State<Boolean> = remember(listState) {
    derivedStateOf {
        listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
    }
}

/** [rememberFabExpanded] for a screen that scrolls a plain column. */
@Composable
fun rememberFabExpanded(scrollState: ScrollState): State<Boolean> = remember(scrollState) {
    derivedStateOf { scrollState.value == 0 }
}

@PreviewLightDark
@Composable
private fun FTTFloatingActionButtonExpandedPreview() {
    FTTPreview {
        FTTFloatingActionButton(
            textResId = R.string.ftt_fab_save,
            iconResId = R.drawable.ic_save,
            onClick = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTFloatingActionButtonCollapsedPreview() {
    FTTPreview {
        FTTFloatingActionButton(
            textResId = R.string.ftt_fab_save,
            iconResId = R.drawable.ic_save,
            onClick = {},
            isExpanded = false
        )
    }
}
