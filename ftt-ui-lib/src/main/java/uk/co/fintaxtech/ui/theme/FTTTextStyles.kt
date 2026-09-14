package uk.co.fintaxtech.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

/**
 * The design's type roles, one per row of the table in rr-design/tokens.md.
 *
 * Deliberately `internal`: feature modules select a role through the public
 * `FTTTextStyle` enum rather than reaching for a raw [TextStyle], so the set of
 * legal type treatments stays closed and the design system can restyle them
 * centrally when the font files land.
 *
 * Roles are grouped by family. Everything in the monospace block sets `tnum`
 * (tabular figures) so digits keep a fixed advance width and columns do not
 * shuffle while a timer ticks or a value is edited.
 */
private const val TABULAR_FIGURES = "tnum"

internal object FTTTextStyles {

    val Wordmark = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 26.sp,
        lineHeight = 26.sp,
        letterSpacing = (-0.03).em
    )

    val CardTitle = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 17.sp,
        lineHeight = 20.4.sp,
        letterSpacing = (-0.02).em
    )

    val SectionTitle = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 15.sp,
        lineHeight = 15.sp,
        letterSpacing = (-0.02).em
    )

    val ButtonLabel = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 16.5.sp,
        lineHeight = 16.5.sp,
        letterSpacing = (-0.01).em
    )

    val ListItemTitle = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 14.5.sp,
        lineHeight = 18.1.sp,
        letterSpacing = (-0.01).em
    )

    val ListItemValue = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 14.sp,
        lineHeight = 16.8.sp
    )

    val Body = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.5.sp,
        lineHeight = 16.9.sp
    )

    val Meta = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 15.6.sp
    )

    val Link = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 12.5.sp,
        lineHeight = 12.5.sp
    )

    val Caption = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 10.5.sp,
        lineHeight = 12.6.sp,
        letterSpacing = 0.04.em
    )

    val TabLabelActive = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 10.5.sp,
        lineHeight = 10.5.sp,
        letterSpacing = 0.01.em
    )

    val TabLabelInactive = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 10.5.sp,
        lineHeight = 10.5.sp,
        letterSpacing = 0.01.em
    )

    val DayLabel = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 10.sp,
        lineHeight = 10.sp
    )

    // ---- added for Settings, Onboarding and Paywall ----

    /** Largest prose role. Settings screen title, Onboarding headline. */
    val ScreenTitle = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 30.sp,
        lineHeight = 35.4.sp,
        letterSpacing = (-0.035).em
    )

    val SectionHeader = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 11.sp,
        lineHeight = 11.sp,
        letterSpacing = 0.1.em
    )

    val Badge = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 9.5.sp,
        lineHeight = 9.5.sp,
        letterSpacing = 0.07.em
    )

    val AvatarInitials = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.02.em
    )

    /** The small wordmark, as used on Onboarding. [Wordmark] is the 26sp form. */
    val WordmarkSmall = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 17.sp,
        lineHeight = 17.sp,
        letterSpacing = (-0.03).em
    )

    /** Generous body copy. Onboarding slide bodies. [Body] is the 12.5sp form. */
    val BodyLarge = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 15.sp,
        lineHeight = 24.sp
    )

    val SheetTitle = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 19.sp,
        lineHeight = 22.8.sp,
        letterSpacing = (-0.025).em
    )

    // ---- monospace: every number the user reads or edits ----

    /** Live session timer. */
    val MonoTimer = TextStyle(
        fontFamily = FTTMonoFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 30.sp,
        lineHeight = 30.sp,
        letterSpacing = (-0.02).em,
        fontFeatureSettings = TABULAR_FIGURES
    )

    /** Stat card values — volume, sets done, rest. */
    val MonoLarge = TextStyle(
        fontFamily = FTTMonoFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 18.sp,
        lineHeight = 20.7.sp,
        fontFeatureSettings = TABULAR_FIGURES
    )

    /** Editable weight and rep fields, and Paywall prices. */
    val MonoValue = TextStyle(
        fontFamily = FTTMonoFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 16.sp,
        lineHeight = 19.2.sp,
        fontFeatureSettings = TABULAR_FIGURES
    )

    /** Set ordinal in the logging table. */
    val MonoSetNumber = TextStyle(
        fontFamily = FTTMonoFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 15.sp,
        lineHeight = 15.sp,
        fontFeatureSettings = TABULAR_FIGURES
    )

    /** Previous-performance column — lower emphasis than [MonoValue]. */
    val MonoMeta = TextStyle(
        fontFamily = FTTMonoFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 13.sp,
        lineHeight = 13.sp,
        fontFeatureSettings = TABULAR_FIGURES
    )
}
