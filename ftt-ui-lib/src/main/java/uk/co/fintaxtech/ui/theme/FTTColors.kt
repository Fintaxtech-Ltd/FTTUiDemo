package uk.co.fintaxtech.ui.theme

import androidx.compose.ui.graphics.Color

val OrangePrimary = Color(0xFFFF5722)
val OrangeDark = Color(0xFFC41C00)
val OrangeLight = Color(0xFFFF8A50)

val DarkGray = Color(0xFF121212)
val SurfaceGray = Color(0xFF1E1E1E)
val LightGray = Color(0xFFF5F5F5)

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

// Primary Action Accent - Energetic Blaze
val EnergeticBlaze = Color(0xFFFF5722)
val OnEnergeticBlaze = Color(0xFFFFFFFF)

// Surface Hierarchy (Dark Mode Foundation)
val SurfaceDim = Color(0xFF131313)
val SurfaceContainerLow = Color(0xFF1C1B1B)
val SurfaceContainer = Color(0xFF201F1F)
val SurfaceContainerHigh = Color(0xFF2A2A2A)
val SurfaceContainerHighest = Color(0xFF353534)
val OnSurface = Color(0xFFE5E2E1)
val OnSurfaceVariant = Color(0xFFE4BEB4)

// Functional Accents
val SuccessMint = Color(0xFF83DA85)
val OnSuccessMint = Color(0xFF00390E)
val SteelySlate = Color(0xFF82939C)
val OnSteelySlate = Color(0xFF1C2C33)
val ErrorRed = Color(0xFFFFB4AB)
val OnError = Color(0xFF690005)

// ---------------------------------------------------------------------------
// Design-accurate tokens, extracted from the Claude Design project "Metoni App".
// Source of truth: rr-design/tokens.md (in the Metoni/RepRocket repo)
//
// SYNCED 2026-09-16 from core:designsystem's current Color.kt. That file's own history
// notes a since-reverted excursion to a teal accent — RepRocket.Metoni went orange ->
// teal -> back to orange for the *accent* itself, which is why FTTAccent/FTTOnAccent
// below are mode-specific pairs (a holdover from the teal migration, when a single
// mode-invariant value stopped being possible) even though both modes currently resolve
// to the same 0xFFFF5722. The accent-container/tint-subtle/brand-gradient tokens below
// are copied faithfully from the current source file, which is STILL teal-derived
// (0x00352F / 0xD7EFEB / 0x4DB6AC / 0x00897B / 0x00695C) — i.e. the accent reverted to
// orange but these near-accent tokens did not. That looks like an incomplete revert on
// the source side rather than an intentional two-tone design; flagged upstream rather
// than silently "fixed" here, since this file exists to mirror core:designsystem, not to
// correct it.
// ---------------------------------------------------------------------------

/** Dark-mode accent. 6.83:1 on FTTDarkCard, 7.67:1 on FTTDarkBackground. */
val FTTDarkAccent = Color(0xFFFF5722)

/** Label on FTTDarkAccent. Dark-on-light, per Material 3: white would give only
 *  2.44:1 here, which fails. This ink gives 7.03:1. */
val FTTDarkOnAccent = Color(0xFF00201C)

/** Light-mode accent. 5.32:1 on FTTLightCard, 5.00:1 on FTTLightBackground —
 *  so it is safe for "See all" links and plan titles, not only for large
 *  button labels. */
val FTTLightAccent = Color(0xFFFF5722)

/** Label on FTTLightAccent. 5.32:1. */
val FTTLightOnAccent = Color(0xFFFFFFFF)

// Structural accent, mode-invariant. Hue 205 but only 24% saturated, so it reads as grey
// rather than competing with the accent.
val FTTSlate = Color(0xFF37474F)

// Dark palette
val FTTDarkBackground = Color(0xFF121212)
val FTTDarkCard = Color(0xFF1E1E1E)
val FTTDarkOnSurface = Color(0xFFE0E0E0)
val FTTDarkOnSurfaceVariant = Color(0xFF9E9E9E)
val FTTDarkHairline = Color(0xFF333333)
val FTTDarkNavSurface = Color(0xE0121212)
val FTTDarkSuccess = Color(0xFF66BB6A)
val FTTDarkSuccessTint = Color(0x2966BB6A)
val FTTDarkBarTrack = Color(0x12FFFFFF)

// Light palette
val FTTLightBackground = Color(0xFFF8F9FA)
val FTTLightCard = Color(0xFFFFFFFF)
val FTTLightOnSurface = Color(0xFF212121)
val FTTLightOnSurfaceVariant = Color(0xFF757575)
val FTTLightHairline = Color(0xFFE0E0E0)
val FTTLightNavSurface = Color(0xE0F8F9FA)
val FTTLightSuccess = Color(0xFF2E7D32)
val FTTLightSuccessTint = Color(0x1F2E7D32)
val FTTLightBarTrack = Color(0x0D212121)

// Error, aligned to the Material baseline in each mode.
val FTTDarkError = Color(0xFFFFB4AB)
val FTTDarkOnError = Color(0xFF690005)
val FTTLightError = Color(0xFFB3261E)
val FTTLightOnError = Color(0xFFFFFFFF)

// Error tints, mirroring the success tints: the same hue at low opacity, so a destructive
// control reads as destructive without a solid red block shouting from every row.
val FTTDarkErrorTint = Color(0x24FFB4AB)
val FTTLightErrorTint = Color(0x1FB3261E)

// ---------------------------------------------------------------------------
// Consolidated surface tokens.
// Each of these appeared under two or three different names across the seven
// screen designs. See the "Consolidated surface tokens" table in
// rr-design/tokens.md for what each was previously called and which outlier
// value was discarded.
// ---------------------------------------------------------------------------

/** Filled container behind accent-tinted content: suggestion banners, selected
 *  plan cards, the Android navigation-bar active pill. Still teal-derived in the
 *  source file — see the sync note above. */
val FTTDarkAccentContainer = Color(0xFF00352F)
val FTTLightAccentContainer = Color(0xFFD7EFEB)

/** Subtle accent wash behind an icon. Still teal-derived — see the sync note above. */
val FTTDarkAccentTintSubtle = Color(0x1F4DB6AC)
val FTTLightAccentTintSubtle = Color(0x1700796B)

/** Recessed track: text-field backgrounds, segmented-control and chip tracks. */
val FTTDarkFieldTrack = Color(0x12FFFFFF)
val FTTLightFieldTrack = Color(0x0D212121)

/** Idle state of a two-state control: switch-off track, unselected radio border,
 *  sheet grabber. */
val FTTDarkControlIdle = Color(0x29FFFFFF)
val FTTLightControlIdle = Color(0x29212121)

/** Row background for a completed or selected item. */
val FTTDarkSuccessRowTint = Color(0x1A66BB6A)
val FTTLightSuccessRowTint = Color(0x122E7D32)

/** Dimming layer behind a modal sheet. */
val FTTDarkScrim = Color(0x8C000000)
val FTTLightScrim = Color(0x59212121)

/** Brand gradient stops, 150 degrees, at 0% / 55% / 100%. Still teal-derived — see the
 *  sync note above. */
val FTTBrandGradientStart = Color(0xFF4DB6AC)
val FTTBrandGradientMid = Color(0xFF00897B)
val FTTBrandGradientEnd = Color(0xFF00695C)
