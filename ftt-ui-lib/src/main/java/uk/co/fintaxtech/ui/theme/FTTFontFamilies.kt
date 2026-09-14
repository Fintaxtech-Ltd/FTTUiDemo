package uk.co.fintaxtech.ui.theme

import androidx.compose.ui.text.font.FontFamily

/**
 * The two families the design uses. See rr-design/tokens.md.
 *
 * Both currently resolve to [FontFamily.Default] because no font files are in the project
 * yet — the app renders in the system font, which is close enough to keep building against
 * but is **not** what the design specifies.
 *
 * Swapping in the real families is a change to these two declarations and nothing else:
 * every type role in [FTTTextStyles] reads from here.
 */

/**
 * **Manrope** — all prose. Weights 400, 500, 600, 700, 800.
 *
 * To activate: drop the TTFs into `core/designsystem/src/androidMain/res/font/` named
 * `manrope_regular.ttf`, `manrope_medium.ttf`, `manrope_semibold.ttf`, `manrope_bold.ttf`,
 * `manrope_extrabold.ttf`, then replace the body below with a `FontFamily(...)` listing each
 * file against its `FontWeight`.
 */
internal val FTTFontFamily: FontFamily = FontFamily.Default

/**
 * **JetBrains Mono** — every number the user reads or edits: the session timer, weight and
 * rep inputs, volume, set numbers, prices. Weights 500 and 700.
 *
 * Monospace matters here for a specific reason: these values change while the user is
 * looking at them. A proportional font makes digits shift horizontally as the timer ticks
 * or a weight is typed. Tabular figures hold the columns still.
 *
 * To activate: add `jetbrains_mono_medium.ttf` and `jetbrains_mono_bold.ttf` to the same
 * `res/font/` directory and replace the body below.
 */
internal val FTTMonoFontFamily: FontFamily = FontFamily.Monospace
