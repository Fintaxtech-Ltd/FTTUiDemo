package uk.co.fintaxtech.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Design tokens the Material 3 [androidx.compose.material3.ColorScheme] has no slot for.
 *
 * Read these through [LocalFTTColors] rather than referencing the raw `FTT*` values in
 * Color.kt, so components stay theme-driven and respond to light/dark automatically.
 */
@Immutable
data class FTTExtendedColors(
    val hairline: Color,
    val navSurface: Color,
    val success: Color,
    val successTint: Color,
    val errorTint: Color,
    val slate: Color,
    val barTrack: Color,
    val accentContainer: Color,
    val accentTintSubtle: Color,
    val fieldTrack: Color,
    val controlIdle: Color,
    val successRowTint: Color,
    val scrim: Color
)

val FTTDarkExtendedColors = FTTExtendedColors(
    hairline = FTTDarkHairline,
    navSurface = FTTDarkNavSurface,
    success = FTTDarkSuccess,
    successTint = FTTDarkSuccessTint,
    errorTint = FTTDarkErrorTint,
    slate = FTTSlate,
    barTrack = FTTDarkBarTrack,
    accentContainer = FTTDarkAccentContainer,
    accentTintSubtle = FTTDarkAccentTintSubtle,
    fieldTrack = FTTDarkFieldTrack,
    controlIdle = FTTDarkControlIdle,
    successRowTint = FTTDarkSuccessRowTint,
    scrim = FTTDarkScrim
)

val FTTLightExtendedColors = FTTExtendedColors(
    hairline = FTTLightHairline,
    navSurface = FTTLightNavSurface,
    success = FTTLightSuccess,
    successTint = FTTLightSuccessTint,
    errorTint = FTTLightErrorTint,
    slate = FTTSlate,
    barTrack = FTTLightBarTrack,
    accentContainer = FTTLightAccentContainer,
    accentTintSubtle = FTTLightAccentTintSubtle,
    fieldTrack = FTTLightFieldTrack,
    controlIdle = FTTLightControlIdle,
    successRowTint = FTTLightSuccessRowTint,
    scrim = FTTLightScrim
)

val LocalFTTColors = staticCompositionLocalOf { FTTDarkExtendedColors }
