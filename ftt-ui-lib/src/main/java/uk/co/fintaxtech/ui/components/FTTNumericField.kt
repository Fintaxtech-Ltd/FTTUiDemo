package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * A centred numeric input with a monospace face.
 *
 * **A value the user has not yet committed is muted; a value they have is not.** In a
 * planned session every pending row arrives pre-filled from the plan, so without this the
 * targets render exactly like the sets already performed and the card stops being readable
 * as a checklist. Emphasis therefore tracks *what the number means*, not whether the field
 * happens to be editable:
 *
 * | State | Text | Container |
 * |---|---|---|
 * | Completed — a fact | full contrast | no box; the row carries a success tint |
 * | Pending, focused — being entered | full contrast | boxed |
 * | Pending — a target | muted | boxed |
 *
 * Focus lifts the muting so typing feels responsive rather than as though the input is not
 * registering.
 *
 * @param placeholder shown when [value] is blank. A set with nothing planned should look
 *        unset rather than display a literal "0", which reads as a real target of zero.
 */
@Composable
fun FTTNumericField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isComplete: Boolean = false,
    placeholder: String = "–"
) {
    val extendedColors = LocalFTTColors.current
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    /*
     * While the user is typing, their own text is what the field shows.
     *
     * Callers hand back a [value] re-derived from the model — string to number and back —
     * and feeding that straight into the field breaks it twice over. The text arriving is
     * not the text the user typed, so the caret resets to the start and every further
     * character lands in front of the last: typing "12" produced "21". And any partial
     * entry that does not survive a round trip is erased mid-word, so "2." formatted back
     * to "2" and a decimal point could never be entered at all.
     *
     * Holding the raw text locally while focused fixes both: the field echoes exactly what
     * was typed, the caret stays put, and the model still sees every keystroke through
     * [onValueChange]. On focus loss the canonical formatting takes over, so "007" settles
     * to "7" and "2." to "2".
     */
    var localText by remember { mutableStateOf(value) }
    if (!isFocused && localText != value) {
        localText = value
    }

    val isSettled = isComplete || isFocused
    val contentColor = if (isSettled) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Box(
        modifier = modifier
            .height(44.dp)
            .background(
                color = if (isComplete) Color.Transparent else extendedColors.fieldTrack,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = if (isFocused) 2.dp else 1.dp,
                color = when {
                    isComplete -> Color.Transparent
                    isFocused -> MaterialTheme.colorScheme.primary
                    else -> extendedColors.hairline
                },
                shape = RoundedCornerShape(10.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = localText,
            onValueChange = { entered ->
                val filtered = entered.filterNumeric()
                localText = filtered
                onValueChange(filtered)
            },
            modifier = Modifier.fillMaxSize(),
            textStyle = FTTTextStyle.MonoValue.resolve().copy(
                color = contentColor,
                textAlign = TextAlign.Center
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            // The number pad has no return key of its own, so without an explicit done
            // action there is no way to dismiss it but tapping elsewhere. Clearing focus
            // also commits the draft — see the focus handling above.
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            singleLine = true,
            interactionSource = interactionSource,
            decorationBox = { innerTextField ->
                Box(contentAlignment = Alignment.Center) {
                    if (localText.isEmpty()) {
                        FTTDataText(
                            text = placeholder,
                            style = FTTTextStyle.MonoValue,
                            color = FTTTextColor.Secondary
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTNumericFieldTargetPreview() {
    FTTPreview {
        FTTNumericField(value = "100", onValueChange = {}, isComplete = false)
    }
}

@PreviewLightDark
@Composable
private fun FTTNumericFieldLoggedPreview() {
    FTTPreview {
        FTTNumericField(value = "100", onValueChange = {}, isComplete = true)
    }
}

@PreviewLightDark
@Composable
private fun FTTNumericFieldUnsetPreview() {
    FTTPreview {
        FTTNumericField(value = "", onValueChange = {}, isComplete = false)
    }
}

/**
 * Keeps digits and at most one decimal separator.
 *
 * The number keyboard already limits most input, but a paste can carry anything, and a
 * string the caller cannot parse silently becomes 0.0 — wiping a weight the user had
 * already entered. Rejecting the characters is better than accepting them and losing data.
 */
private fun String.filterNumeric(): String {
    var separatorSeen = false
    return buildString {
        for (character in this@filterNumeric) {
            when {
                character.isDigit() -> append(character)
                (character == '.' || character == ',') && !separatorSeen && isNotEmpty() -> {
                    separatorSeen = true
                    append('.')
                }
            }
        }
    }
}
