package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A themed search input field.
 *
 * @param query The current search text.
 * @param onQueryChange Invoked when the user types.
 * @param placeholderResId String resource for the placeholder.
 * @param onClear Invoked when the clear button is tapped.
 */
@Composable
fun FTTSearchField(
    query: String,
    onQueryChange: (String) -> Unit,
    @StringRes placeholderResId: Int,
    onClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(46.dp)
            .background(
                color = LocalFTTColors.current.fieldTrack,
                shape = CircleShape
            )
            .padding(horizontal = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        FTTIcon(
            iconResId = R.drawable.ic_search, // Should be ic_magnifying_glass
            contentDescriptionResId = null,
            size = 17.dp,
            tint = FTTIconTint.Secondary
        )

        Spacer(modifier = Modifier.width(9.dp))

        Box(modifier = Modifier.weight(1f)) {
            if (query.isEmpty()) {
                FTTText(
                    textResId = placeholderResId,
                    style = FTTTextStyle.Body,
                    color = FTTTextColor.Secondary
                )
            }

            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = FTTTextStyle.Body.resolve().copy(
                    color = MaterialTheme.colorScheme.onSurface
                ),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                // Results filter as you type, so the search key has nothing left to do but
                // get out of the way. Compose's default action for Search is to do nothing.
                keyboardActions = KeyboardActions(onSearch = { focusManager.clearFocus() })
            )
        }

        if (query.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .size(48.dp) // Enforce minimum touch target
                    .clickable(onClick = onClear),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(color = MaterialTheme.colorScheme.onSurfaceVariant, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    FTTIcon(
                        // A cross, not the magnifier this was drawing: the button clears the
                        // field, and a second search icon inside the search field said
                        // nothing about what tapping it would do.
                        iconResId = R.drawable.ic_close,
                        contentDescriptionResId = R.string.ftt_search_clear,
                        // 12 rather than 10 in the 20dp circle: a cross reads as a cross at
                        // this size, where the magnifier's detail never did.
                        size = 12.dp,
                        tint = FTTIconTint.OnAccent
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTSearchFieldEmptyPreview() {
    FTTPreview {
        FTTSearchField(
            query = "",
            onQueryChange = {},
            placeholderResId = R.string.ftt_preview_loading,
            onClear = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTSearchFieldFilteredPreview() {
    FTTPreview {
        FTTSearchField(
            query = "Bench",
            onQueryChange = {},
            placeholderResId = R.string.ftt_preview_loading,
            onClear = {}
        )
    }
}
