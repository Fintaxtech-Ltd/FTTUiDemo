package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A themed modal bottom sheet.
 *
 * **Never give this a fixed or fractional height.** `ModalBottomSheet` measures its
 * content and derives the expanded anchor from that measurement, so forcing the sheet's
 * height with something like `fillMaxHeight(0.85f)` desynchronises the drawn surface from
 * the anchor it is positioned against: the sheet lands too high, its rounded top runs off
 * the top of the screen, and a band of sheet colour is left below the content. Cap the
 * height inside [content] instead — a scrollable region with
 * `Modifier.weight(1f, fill = false)` grows only as far as the sheet allows.
 *
 * [content] is a `ColumnScope`, so weights inside it resolve against the sheet.
 *
 * @param onDismissRequest Invoked when the sheet should be dismissed.
 * @param sheetState The state of the sheet.
 * @param content The content to display inside the sheet.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FTTBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    content: @Composable ColumnScope.() -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        scrimColor = LocalFTTColors.current.scrim,
        // The content supplies its own grabber via FTTSheetGrabber.
        dragHandle = null,
        content = content
    )
}

/** Defaults shared by everything that fills an [FTTBottomSheet]. */
object FTTSheetDefaults {

    /**
     * How much of the screen a sheet may cover.
     *
     * Leaves enough of the surface behind visible that the sheet still reads as a layer
     * over the app rather than a new screen.
     */
    const val MAX_HEIGHT_FRACTION: Float = 0.85f
}

/**
 * Caps sheet content at [fraction] of the screen height.
 *
 * Apply this to the content inside an [FTTBottomSheet], never to the sheet itself — see
 * the warning on [FTTBottomSheet] for what happens when the sheet's own height is forced.
 *
 * Pair it with `Modifier.weight(1f)` on the scrollable region for a sheet that stays a
 * fixed size while its contents change — a searchable list should not resize on every
 * keystroke. Use `weight(1f, fill = false)` instead where the sheet should hug content
 * that is shorter than the cap.
 */
@Composable
fun Modifier.fttSheetMaxHeight(fraction: Float = FTTSheetDefaults.MAX_HEIGHT_FRACTION): Modifier {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    return heightIn(max = screenHeight * fraction)
}
