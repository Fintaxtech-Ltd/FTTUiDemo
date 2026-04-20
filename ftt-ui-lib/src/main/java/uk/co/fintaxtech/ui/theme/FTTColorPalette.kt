package uk.co.fintaxtech.ui.theme

import androidx.compose.ui.graphics.Color

interface FTTColorPalette {
    // Primary
    val primaryLight: Color
    val primaryDark: Color
    val onPrimaryLight: Color
    val onPrimaryDark: Color
    val primaryContainerLight: Color
    val primaryContainerDark: Color
    val onPrimaryContainerLight: Color
    val onPrimaryContainerDark: Color
    val inversePrimaryLight: Color
    val inversePrimaryDark: Color

    // Secondary
    val secondaryLight: Color
    val secondaryDark: Color
    val onSecondaryLight: Color
    val onSecondaryDark: Color
    val secondaryContainerLight: Color
    val secondaryContainerDark: Color
    val onSecondaryContainerLight: Color
    val onSecondaryContainerDark: Color

    // Tertiary
    val tertiaryLight: Color
    val tertiaryDark: Color
    val onTertiaryLight: Color
    val onTertiaryDark: Color
    val tertiaryContainerLight: Color
    val tertiaryContainerDark: Color
    val onTertiaryContainerLight: Color
    val onTertiaryContainerDark: Color

    // Background & Surface
    val backgroundLight: Color
    val backgroundDark: Color
    val onBackgroundLight: Color
    val onBackgroundDark: Color
    val surfaceLight: Color
    val surfaceDark: Color
    val onSurfaceLight: Color
    val onSurfaceDark: Color
    val surfaceVariantLight: Color
    val surfaceVariantDark: Color
    val onSurfaceVariantLight: Color
    val onSurfaceVariantDark: Color
    val surfaceTintLight: Color
    val surfaceTintDark: Color
    val inverseSurfaceLight: Color
    val inverseSurfaceDark: Color
    val inverseOnSurfaceLight: Color
    val inverseOnSurfaceDark: Color

    // Error
    val errorLight: Color
    val errorDark: Color
    val onErrorLight: Color
    val onErrorDark: Color
    val errorContainerLight: Color
    val errorContainerDark: Color
    val onErrorContainerLight: Color
    val onErrorContainerDark: Color

    // Utility
    val outlineLight: Color
    val outlineDark: Color
    val outlineVariantLight: Color
    val outlineVariantDark: Color
    val scrimLight: Color
    val scrimDark: Color

    // Modern Surface Containers
    val surfaceBrightLight: Color
    val surfaceBrightDark: Color
    val surfaceContainerLight: Color
    val surfaceContainerDark: Color
    val surfaceContainerHighLight: Color
    val surfaceContainerHighDark: Color
    val surfaceContainerHighestLight: Color
    val surfaceContainerHighestDark: Color
    val surfaceContainerLowLight: Color
    val surfaceContainerLowDark: Color
    val surfaceContainerLowestLight: Color
    val surfaceContainerLowestDark: Color
    val surfaceDimLight: Color
    val surfaceDimDark: Color

    // Fixed Accent Colors
    val primaryFixedLight: Color
    val primaryFixedDark: Color
    val primaryFixedDimLight: Color
    val primaryFixedDimDark: Color
    val onPrimaryFixedLight: Color
    val onPrimaryFixedDark: Color
    val onPrimaryFixedVariantLight: Color
    val onPrimaryFixedVariantDark: Color

    val secondaryFixedLight: Color
    val secondaryFixedDark: Color
    val secondaryFixedDimLight: Color
    val secondaryFixedDimDark: Color
    val onSecondaryFixedLight: Color
    val onSecondaryFixedDark: Color
    val onSecondaryFixedVariantLight: Color
    val onSecondaryFixedVariantDark: Color

    val tertiaryFixedLight: Color
    val tertiaryFixedDark: Color
    val tertiaryFixedDimLight: Color
    val tertiaryFixedDimDark: Color
    val onTertiaryFixedLight: Color
    val onTertiaryFixedDark: Color
    val onTertiaryFixedVariantLight: Color
    val onTertiaryFixedVariantDark: Color
}