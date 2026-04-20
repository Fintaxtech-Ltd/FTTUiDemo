package uk.co.fintaxtech.demo.ui

import androidx.compose.ui.graphics.Color
import uk.co.fintaxtech.ui.theme.FTTColorPalette
import javax.inject.Inject

class AppColorPalette @Inject constructor() : FTTColorPalette {
    override val primaryLight = Color(0xFF670000)
    override val primaryDark = Color(0xFF671000)
    override val onPrimaryLight = Color(0xFFFFFFFF)
    override val onPrimaryDark = Color(0xFF381E72)
    override val primaryContainerLight = Color(0xFFEADDFF)
    override val primaryContainerDark = Color(0xFF4F378B)
    override val onPrimaryContainerLight = Color(0xFF21005D)
    override val onPrimaryContainerDark = Color(0xFFEADDFF)
    override val inversePrimaryLight = Color(0xFFD0BCFF)
    override val inversePrimaryDark = Color(0xFF6750A4)

    // Secondary
    override val secondaryLight = Color(0xFF625B71)
    override val secondaryDark = Color(0xFFCCC2DC)
    override val onSecondaryLight = Color(0xFFFFFFFF)
    override val onSecondaryDark = Color(0xFF332D41)
    override val secondaryContainerLight = Color(0xFFE8DEF8)
    override val secondaryContainerDark = Color(0xFF4A4458)
    override val onSecondaryContainerLight = Color(0xFF1D192B)
    override val onSecondaryContainerDark = Color(0xFFE8DEF8)

    // Tertiary
    override val tertiaryLight = Color(0xFF7D5260)
    override val tertiaryDark = Color(0xFFEFB8C8)
    override val onTertiaryLight = Color(0xFFFFFFFF)
    override val onTertiaryDark = Color(0xFF492532)
    override val tertiaryContainerLight = Color(0xFFFFD8E4)
    override val tertiaryContainerDark = Color(0xFF633B48)
    override val onTertiaryContainerLight = Color(0xFF31111D)
    override val onTertiaryContainerDark = Color(0xFFFFD8E4)

    // Background & Surface
    override val backgroundLight = Color(0xFFFEF7FF)
    override val backgroundDark = Color(0xFF141218)
    override val onBackgroundLight = Color(0xFF1D1B20)
    override val onBackgroundDark = Color(0xFFE6E1E5)
    override val surfaceLight = Color(0xFFFEF7FF)
    override val surfaceDark = Color(0xFF141218)
    override val onSurfaceLight = Color(0xFF1D1B20)
    override val onSurfaceDark = Color(0xFFE6E1E5)
    override val surfaceVariantLight = Color(0xFFE7E0EB)
    override val surfaceVariantDark = Color(0xFF49454F)
    override val onSurfaceVariantLight = Color(0xFF49454F)
    override val onSurfaceVariantDark = Color(0xFFCAC4D0)
    override val surfaceTintLight = primaryLight
    override val surfaceTintDark = primaryDark
    override val inverseSurfaceLight = Color(0xFF313033)
    override val inverseSurfaceDark = Color(0xFFE6E1E5)
    override val inverseOnSurfaceLight = Color(0xFFF4EFF4)
    override val inverseOnSurfaceDark = Color(0xFF313033)

    // Error
    override val errorLight = Color(0xFFB3261E)
    override val errorDark = Color(0xFFF2B8B5)
    override val onErrorLight = Color(0xFFFFFFFF)
    override val onErrorDark = Color(0xFF601410)
    override val errorContainerLight = Color(0xFFF9DEDC)
    override val errorContainerDark = Color(0xFF8C1D18)
    override val onErrorContainerLight = Color(0xFF410E0B)
    override val onErrorContainerDark = Color(0xFFF9DEDC)

    // Utility
    override val outlineLight = Color(0xFF79747E)
    override val outlineDark = Color(0xFF938F99)
    override val outlineVariantLight = Color(0xFFCAC4D0)
    override val outlineVariantDark = Color(0xFF49454F)
    override val scrimLight = Color(0xFF000000)
    override val scrimDark = Color(0xFF000000)

    // Modern Surface Containers
    override val surfaceBrightLight = Color(0xFFFEF7FF)
    override val surfaceBrightDark = Color(0xFF3B383E)
    override val surfaceContainerLight = Color(0xFFF3EDF7)
    override val surfaceContainerDark = Color(0xFF211F26)
    override val surfaceContainerHighLight = Color(0xFFECE6F0)
    override val surfaceContainerHighDark = Color(0xFF2B2930)
    override val surfaceContainerHighestLight = Color(0xFFE6E0E9)
    override val surfaceContainerHighestDark = Color(0xFF36343B)
    override val surfaceContainerLowLight = Color(0xFFF7F2FA)
    override val surfaceContainerLowDark = Color(0xFF1D1B22)
    override val surfaceContainerLowestLight = Color(0xFFFFFFFF)
    override val surfaceContainerLowestDark = Color(0xFF0F0D13)
    override val surfaceDimLight = Color(0xFFDED8E1)
    override val surfaceDimDark = Color(0xFF141218)

    // Fixed Accent Colors
    override val primaryFixedLight = Color(0xFFEADDFF)
    override val primaryFixedDark = Color(0xFFEADDFF)
    override val primaryFixedDimLight = Color(0xFFD0BCFF)
    override val primaryFixedDimDark = Color(0xFFD0BCFF)
    override val onPrimaryFixedLight = Color(0xFF21005D)
    override val onPrimaryFixedDark = Color(0xFF21005D)
    override val onPrimaryFixedVariantLight = Color(0xFF4F378B)
    override val onPrimaryFixedVariantDark = Color(0xFF4F378B)

    override val secondaryFixedLight = Color(0xFFE8DEF8)
    override val secondaryFixedDark = Color(0xFFE8DEF8)
    override val secondaryFixedDimLight = Color(0xFFCCC2DC)
    override val secondaryFixedDimDark = Color(0xFFCCC2DC)
    override val onSecondaryFixedLight = Color(0xFF1D192B)
    override val onSecondaryFixedDark = Color(0xFF1D192B)
    override val onSecondaryFixedVariantLight = Color(0xFF4A4458)
    override val onSecondaryFixedVariantDark = Color(0xFF4A4458)

    override val tertiaryFixedLight = Color(0xFFFFD8E4)
    override val tertiaryFixedDark = Color(0xFFFFD8E4)
    override val tertiaryFixedDimLight = Color(0xFFEFB8C8)
    override val tertiaryFixedDimDark = Color(0xFFEFB8C8)
    override val onTertiaryFixedLight = Color(0xFF31111D)
    override val onTertiaryFixedDark = Color(0xFF31111D)
    override val onTertiaryFixedVariantLight = Color(0xFF633B48)
    override val onTertiaryFixedVariantDark = Color(0xFF633B48)
}