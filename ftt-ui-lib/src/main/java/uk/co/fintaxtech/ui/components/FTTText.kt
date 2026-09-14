package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.FTTTextStyles
import uk.co.fintaxtech.ui.theme.LocalFTTColors

/**
 * The design's type roles. Feature code selects a role rather than a raw
 * `TextStyle`, so the set of legal treatments stays closed and restyling is central.
 *
 * One role per row of the table in rr-design/tokens.md.
 */
enum class FTTTextStyle {
    // Prose — Manrope
    ScreenTitle,
    SheetTitle,
    SectionHeader,
    Badge,
    AvatarInitials,
    Wordmark,
    WordmarkSmall,
    CardTitle,
    SectionTitle,
    ButtonLabel,
    ListItemTitle,
    ListItemValue,
    Body,
    BodyLarge,
    Meta,
    Link,
    Caption,
    TabLabelActive,
    TabLabelInactive,
    DayLabel,

    // Monospace — every number the user reads or edits. Tabular figures keep
    // columns still while a timer ticks or a value is typed.
    MonoTimer,
    MonoLarge,
    MonoValue,
    MonoSetNumber,
    MonoMeta
}

/**
 * Semantic text colours. Prevents features hardcoding a [Color] or reaching into the
 * colour scheme directly, and keeps light/dark switching automatic.
 */
enum class FTTTextColor {
    Primary,
    Secondary,
    Accent,
    OnAccent,
    Success,
    Error
}

/**
 * Text whose content is **display copy**.
 *
 * Accepts a string resource only, so an unlocalized literal cannot reach the UI.
 * For text that originates from the user or a server, use [FTTDataText].
 *
 * @param textResId  Display copy. Always a string resource.
 * @param formatArgs Optional substitutions for a formatted resource.
 */
@Composable
fun FTTText(
    @StringRes textResId: Int,
    modifier: Modifier = Modifier,
    style: FTTTextStyle = FTTTextStyle.Body,
    color: FTTTextColor = FTTTextColor.Primary,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    vararg formatArgs: Any
) {
    Text(
        text = if (formatArgs.isEmpty()) {
            stringResource(id = textResId)
        } else {
            stringResource(id = textResId, *formatArgs)
        },
        modifier = modifier,
        style = style.resolve(),
        color = color.resolve(),
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

/**
 * Text whose content is **data**, not copy — a name the user typed, a server message,
 * a value already formatted for the current locale by the caller.
 *
 * This is the deliberate, named exception to the string-resource rule. It is separate
 * from [FTTText] rather than an overload so that every dynamic string is greppable and
 * a reviewer can see at a glance that it was an intentional choice.
 *
 * @param text Genuine data. Never a hardcoded display literal.
 */
@Composable
fun FTTDataText(
    text: String,
    modifier: Modifier = Modifier,
    style: FTTTextStyle = FTTTextStyle.Body,
    color: FTTTextColor = FTTTextColor.Primary,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        text = text,
        modifier = modifier,
        style = style.resolve(),
        color = color.resolve(),
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Composable
@ReadOnlyComposable
internal fun FTTTextStyle.resolve() = when (this) {
    FTTTextStyle.ScreenTitle -> FTTTextStyles.ScreenTitle
    FTTTextStyle.SheetTitle -> FTTTextStyles.SheetTitle
    FTTTextStyle.SectionHeader -> FTTTextStyles.SectionHeader
    FTTTextStyle.Badge -> FTTTextStyles.Badge
    FTTTextStyle.AvatarInitials -> FTTTextStyles.AvatarInitials
    FTTTextStyle.Wordmark -> FTTTextStyles.Wordmark
    FTTTextStyle.WordmarkSmall -> FTTTextStyles.WordmarkSmall
    FTTTextStyle.CardTitle -> FTTTextStyles.CardTitle
    FTTTextStyle.SectionTitle -> FTTTextStyles.SectionTitle
    FTTTextStyle.ButtonLabel -> FTTTextStyles.ButtonLabel
    FTTTextStyle.ListItemTitle -> FTTTextStyles.ListItemTitle
    FTTTextStyle.ListItemValue -> FTTTextStyles.ListItemValue
    FTTTextStyle.Body -> FTTTextStyles.Body
    FTTTextStyle.BodyLarge -> FTTTextStyles.BodyLarge
    FTTTextStyle.Meta -> FTTTextStyles.Meta
    FTTTextStyle.Link -> FTTTextStyles.Link
    FTTTextStyle.Caption -> FTTTextStyles.Caption
    FTTTextStyle.TabLabelActive -> FTTTextStyles.TabLabelActive
    FTTTextStyle.TabLabelInactive -> FTTTextStyles.TabLabelInactive
    FTTTextStyle.DayLabel -> FTTTextStyles.DayLabel
    FTTTextStyle.MonoTimer -> FTTTextStyles.MonoTimer
    FTTTextStyle.MonoLarge -> FTTTextStyles.MonoLarge
    FTTTextStyle.MonoValue -> FTTTextStyles.MonoValue
    FTTTextStyle.MonoSetNumber -> FTTTextStyles.MonoSetNumber
    FTTTextStyle.MonoMeta -> FTTTextStyles.MonoMeta
}

@Composable
@ReadOnlyComposable
private fun FTTTextColor.resolve(): Color = when (this) {
    FTTTextColor.Primary -> MaterialTheme.colorScheme.onSurface
    FTTTextColor.Secondary -> MaterialTheme.colorScheme.onSurfaceVariant
    FTTTextColor.Accent -> MaterialTheme.colorScheme.primary
    FTTTextColor.OnAccent -> MaterialTheme.colorScheme.onPrimary
    FTTTextColor.Success -> LocalFTTColors.current.success
    FTTTextColor.Error -> MaterialTheme.colorScheme.error
}

@PreviewLightDark
@Composable
private fun FTTTextWordmarkPreview() {
    FTTPreview {
        FTTText(
            textResId = R.string.ftt_preview_wordmark,
            style = FTTTextStyle.Wordmark,
            color = FTTTextColor.Accent
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTTextCardTitlePreview() {
    FTTPreview {
        FTTText(
            textResId = R.string.ftt_preview_card_title,
            style = FTTTextStyle.CardTitle
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTTextBodySecondaryPreview() {
    FTTPreview {
        FTTText(
            textResId = R.string.ftt_preview_body,
            style = FTTTextStyle.Body,
            color = FTTTextColor.Secondary
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTDataTextPreview() {
    FTTPreview {
        FTTDataText(
            text = "Push Day A",
            style = FTTTextStyle.ListItemTitle
        )
    }
}
