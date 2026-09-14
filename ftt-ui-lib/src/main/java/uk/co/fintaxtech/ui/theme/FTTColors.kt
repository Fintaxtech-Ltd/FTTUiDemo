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
// Design-accurate tokens, extracted from the Claude Design project "RepRocket App".
// Source of truth: rr-design/tokens.md
// ---------------------------------------------------------------------------

// Accent is mode-invariant.
val FTTAccent = Color(0xFFFF5722)
val FTTOnAccent = Color(0xFFFFFFFF)

// Structural accent, also mode-invariant.
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
 *  plan cards, the Android navigation-bar active pill. */
val FTTDarkAccentContainer = Color(0xFF3E2723)
val FTTLightAccentContainer = Color(0xFFFBE9E7)

/** Subtle accent wash behind an icon. */
val FTTDarkAccentTintSubtle = Color(0x1FFF5722)
val FTTLightAccentTintSubtle = Color(0x17FF5722)

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

/** Brand gradient stops, 150 degrees, at 0% / 55% / 100%. */
val FTTBrandGradientStart = Color(0xFFFF8A50)
val FTTBrandGradientMid = Color(0xFFFF5722)
val FTTBrandGradientEnd = Color(0xFFE64100)
