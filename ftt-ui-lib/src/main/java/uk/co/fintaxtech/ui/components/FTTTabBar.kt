package uk.co.fintaxtech.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * One destination in an [FTTTabBar].
 *
 * @param iconResId Drawable for the tab.
 * @param labelResId Display copy. Always a string resource — a raw [String] is never
 *                   accepted, so an unlocalized literal cannot reach the UI.
 */
@Immutable
data class FTTTabItem(
    @DrawableRes val iconResId: Int,
    @StringRes val labelResId: Int
)

/**
 * Bottom navigation bar.
 *
 * The design draws this as a hairline-topped surface at 88% opacity. Compose has no
 * cheap backdrop blur, so the design's 18dp blur is approximated by the opaque nav
 * surface token — visually near-identical over this app's flat backgrounds.
 *
 * Each item exposes itself as a selectable with [Role.Tab], so screen readers announce
 * position and selection state without any extra work at the call site.
 */
@Composable
fun FTTTabBar(
    items: List<FTTTabItem>,
    selectedIndex: Int,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val extendedColors = LocalFTTColors.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(extendedColors.navSurface)
            // The activity draws edge to edge, so this bar sits over the system navigation
            // area. The background must extend behind it — hence padding inside the
            // background rather than outside — while the tabs themselves are pushed clear.
            // Samsung's three-button navigation is far taller than a gesture pill, which is
            // where the overlap showed: the buttons landed on top of the tab labels.
            .navigationBarsPadding()
            .padding(top = 10.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == selectedIndex

            Column(
                modifier = Modifier
                    .weight(1f)
                    .heightIn(min = 48.dp)
                    .selectable(
                        selected = isSelected,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        role = Role.Tab,
                        onClick = { onSelect(index) }
                    )
                    .padding(vertical = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(contentAlignment = Alignment.Center) {
                    if (isSelected) {
                        Box(
                            modifier = Modifier
                                .size(width = 58.dp, height = 32.dp)
                                .background(
                                    color = extendedColors.accentContainer,
                                    shape = RoundedCornerShape(16.dp)
                                )
                        )
                    }
                    FTTIcon(
                        iconResId = item.iconResId,
                        // The label directly beneath states the destination, so repeating it
                        // here would make screen readers announce every tab twice.
                        contentDescriptionResId = null,
                        size = 21.dp,
                        tint = if (isSelected) FTTIconTint.Accent else FTTIconTint.Secondary
                    )
                }

                FTTText(
                    textResId = item.labelResId,
                    style = if (isSelected) {
                        FTTTextStyle.TabLabelActive
                    } else {
                        FTTTextStyle.TabLabelInactive
                    },
                    color = if (isSelected) FTTTextColor.Accent else FTTTextColor.Secondary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

private val PreviewItems = listOf(
    FTTTabItem(R.drawable.ic_tab_home, R.string.ftt_preview_tab_home),
    FTTTabItem(R.drawable.ic_tab_history, R.string.ftt_preview_tab_history),
    FTTTabItem(R.drawable.ic_tab_settings, R.string.ftt_preview_tab_settings)
)

@PreviewLightDark
@Composable
private fun FTTTabBarHomeSelectedPreview() {
    FTTPreview(padded = false) {
        FTTTabBar(items = PreviewItems, selectedIndex = 0, onSelect = {})
    }
}

@PreviewLightDark
@Composable
private fun FTTTabBarHistorySelectedPreview() {
    FTTPreview(padded = false) {
        FTTTabBar(items = PreviewItems, selectedIndex = 1, onSelect = {})
    }
}

@PreviewLightDark
@Composable
private fun FTTTabBarSettingsSelectedPreview() {
    FTTPreview(padded = false) {
        FTTTabBar(items = PreviewItems, selectedIndex = 2, onSelect = {})
    }
}
