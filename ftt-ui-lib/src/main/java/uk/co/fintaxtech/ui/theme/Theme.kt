package uk.co.fintaxtech.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

/**
 * Palette-injectable theme: the caller supplies an [FTTColorPalette] (via Koin, Hilt, or a
 * plain instance) that is expanded into a full Material 3 colour scheme.
 *
 * Typography, shapes, [LocalFTTColors], and the status-/navigation-bar icon adjustment are
 * shared with the [FTTTheme] overload in FTTTheme.kt that takes only `darkTheme` — a caller
 * supplying its own palette should not also lose every other part of the design system's
 * appearance. `LocalFTTColors` in particular has no palette equivalent: [FTTColorPalette]
 * only covers the Material [androidx.compose.material3.ColorScheme] surface, so the
 * `accentContainer`/`hairline`/`success`/… tokens it carries still come from this library's
 * own [FTTDarkExtendedColors]/[FTTLightExtendedColors] regardless of which palette is
 * injected — without providing it here, every reader of `LocalFTTColors` would silently fall
 * back to its `staticCompositionLocalOf` default (always the dark set) in light mode.
 */
@Composable
fun FTTTheme(
    palette: FTTColorPalette,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = palette.primaryDark,
            onPrimary = palette.onPrimaryDark,
            primaryContainer = palette.primaryContainerDark,
            onPrimaryContainer = palette.onPrimaryContainerDark,
            inversePrimary = palette.inversePrimaryDark,
            secondary = palette.secondaryDark,
            onSecondary = palette.onSecondaryDark,
            secondaryContainer = palette.secondaryContainerDark,
            onSecondaryContainer = palette.onSecondaryContainerDark,
            tertiary = palette.tertiaryDark,
            onTertiary = palette.onTertiaryDark,
            tertiaryContainer = palette.tertiaryContainerDark,
            onTertiaryContainer = palette.onTertiaryContainerDark,
            background = palette.backgroundDark,
            onBackground = palette.onBackgroundDark,
            surface = palette.surfaceDark,
            onSurface = palette.onSurfaceDark,
            surfaceVariant = palette.surfaceVariantDark,
            onSurfaceVariant = palette.onSurfaceVariantDark,
            surfaceTint = palette.surfaceTintDark,
            inverseSurface = palette.inverseSurfaceDark,
            inverseOnSurface = palette.inverseOnSurfaceDark,
            error = palette.errorDark,
            onError = palette.onErrorDark,
            errorContainer = palette.errorContainerDark,
            onErrorContainer = palette.onErrorContainerDark,
            outline = palette.outlineDark,
            outlineVariant = palette.outlineVariantDark,
            scrim = palette.scrimDark,
            surfaceBright = palette.surfaceBrightDark,
            surfaceContainer = palette.surfaceContainerDark,
            surfaceContainerHigh = palette.surfaceContainerHighDark,
            surfaceContainerHighest = palette.surfaceContainerHighestDark,
            surfaceContainerLow = palette.surfaceContainerLowDark,
            surfaceContainerLowest = palette.surfaceContainerLowestDark,
            surfaceDim = palette.surfaceDimDark,
            primaryFixed = palette.primaryFixedDark,
            primaryFixedDim = palette.primaryFixedDimDark,
            onPrimaryFixed = palette.onPrimaryFixedDark,
            onPrimaryFixedVariant = palette.onPrimaryFixedVariantDark,
            secondaryFixed = palette.secondaryFixedDark,
            secondaryFixedDim = palette.secondaryFixedDimDark,
            onSecondaryFixed = palette.onSecondaryFixedDark,
            onSecondaryFixedVariant = palette.onSecondaryFixedVariantDark,
            tertiaryFixed = palette.tertiaryFixedDark,
            tertiaryFixedDim = palette.tertiaryFixedDimDark,
            onTertiaryFixed = palette.onTertiaryFixedDark,
            onTertiaryFixedVariant = palette.onTertiaryFixedVariantDark
        )
    } else {
        lightColorScheme(
            primary = palette.primaryLight,
            onPrimary = palette.onPrimaryLight,
            primaryContainer = palette.primaryContainerLight,
            onPrimaryContainer = palette.onPrimaryContainerLight,
            inversePrimary = palette.inversePrimaryLight,
            secondary = palette.secondaryLight,
            onSecondary = palette.onSecondaryLight,
            secondaryContainer = palette.secondaryContainerLight,
            onSecondaryContainer = palette.onSecondaryContainerLight,
            tertiary = palette.tertiaryLight,
            onTertiary = palette.onTertiaryLight,
            tertiaryContainer = palette.tertiaryContainerLight,
            onTertiaryContainer = palette.onTertiaryContainerLight,
            background = palette.backgroundLight,
            onBackground = palette.onBackgroundLight,
            surface = palette.surfaceLight,
            onSurface = palette.onSurfaceLight,
            surfaceVariant = palette.surfaceVariantLight,
            onSurfaceVariant = palette.onSurfaceVariantLight,
            surfaceTint = palette.surfaceTintLight,
            inverseSurface = palette.inverseSurfaceLight,
            inverseOnSurface = palette.inverseOnSurfaceLight,
            error = palette.errorLight,
            onError = palette.onErrorLight,
            errorContainer = palette.errorContainerLight,
            onErrorContainer = palette.onErrorContainerLight,
            outline = palette.outlineLight,
            outlineVariant = palette.outlineVariantLight,
            scrim = palette.scrimLight,
            surfaceBright = palette.surfaceBrightLight,
            surfaceContainer = palette.surfaceContainerLight,
            surfaceContainerHigh = palette.surfaceContainerHighLight,
            surfaceContainerHighest = palette.surfaceContainerHighestLight,
            surfaceContainerLow = palette.surfaceContainerLowLight,
            surfaceContainerLowest = palette.surfaceContainerLowestLight,
            surfaceDim = palette.surfaceDimLight,
            primaryFixed = palette.primaryFixedLight,
            primaryFixedDim = palette.primaryFixedDimLight,
            onPrimaryFixed = palette.onPrimaryFixedLight,
            onPrimaryFixedVariant = palette.onPrimaryFixedVariantLight,
            secondaryFixed = palette.secondaryFixedLight,
            secondaryFixedDim = palette.secondaryFixedDimLight,
            onSecondaryFixed = palette.onSecondaryFixedLight,
            onSecondaryFixedVariant = palette.onSecondaryFixedVariantLight,
            tertiaryFixed = palette.tertiaryFixedLight,
            tertiaryFixedDim = palette.tertiaryFixedDimLight,
            onTertiaryFixed = palette.onTertiaryFixedLight,
            onTertiaryFixedVariant = palette.onTertiaryFixedVariantLight
        )
    }

    val extendedColors = if (darkTheme) FTTDarkExtendedColors else FTTLightExtendedColors

    SystemBarIcons(darkTheme = darkTheme)

    CompositionLocalProvider(LocalFTTColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = FTTTypography,
            shapes = FTTShapes,
            content = content
        )
    }
}
