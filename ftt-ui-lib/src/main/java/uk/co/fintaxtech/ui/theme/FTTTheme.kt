package uk.co.fintaxtech.ui.theme

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = FTTDarkAccent,
    onPrimary = FTTDarkOnAccent,
    background = FTTDarkBackground,
    onBackground = FTTDarkOnSurface,
    surface = FTTDarkCard,
    onSurface = FTTDarkOnSurface,
    surfaceVariant = FTTDarkCard,
    onSurfaceVariant = FTTDarkOnSurfaceVariant,
    outline = FTTDarkHairline,
    outlineVariant = FTTDarkHairline,
    error = FTTDarkError,
    onError = FTTDarkOnError
)

private val LightColorScheme = lightColorScheme(
    primary = FTTLightAccent,
    onPrimary = FTTLightOnAccent,
    background = FTTLightBackground,
    onBackground = FTTLightOnSurface,
    surface = FTTLightCard,
    onSurface = FTTLightOnSurface,
    surfaceVariant = FTTLightCard,
    onSurfaceVariant = FTTLightOnSurfaceVariant,
    outline = FTTLightHairline,
    outlineVariant = FTTLightHairline,
    error = FTTLightError,
    onError = FTTLightOnError
)

/**
 * Applies the design system's appearance.
 *
 * This is the token-driven theme from the RepRocket design system: a fixed accent-based
 * [androidx.compose.material3.ColorScheme] plus the [FTTExtendedColors] carried in
 * [LocalFTTColors]. For the palette-injectable variant see the [FTTTheme] overload that
 * takes an [FTTColorPalette].
 */
@Composable
fun FTTTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
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

/**
 * Keeps the status- and navigation-bar icons legible against whatever the app is painting
 * behind them.
 *
 * It lives here rather than in `MainActivity` because the appearance is a *stored* choice,
 * not the device's: a user on [ThemeMode.Light] with the system in dark mode needs dark
 * icons, and `enableEdgeToEdge` is called long before that preference has been read.
 * `MainActivity` used to pin the icons light, which was correct only while the bars behind
 * them were always accent.
 *
 * A no-op in previews and tests, which have no window to configure.
 */
@Composable
internal fun SystemBarIcons(darkTheme: Boolean) {
    val view = LocalView.current
    if (view.isInEditMode) return

    val window = view.context.findActivity()?.window ?: return
    SideEffect {
        WindowCompat.getInsetsController(window, view).apply {
            // Light *icons* are what a dark background needs, hence the inversion.
            isAppearanceLightStatusBars = !darkTheme
            isAppearanceLightNavigationBars = !darkTheme
        }
    }
}

/**
 * A view's context is often a `ContextThemeWrapper` around the activity rather than the activity
 * itself, so a plain `as? Activity` cast silently skipped the bar update.
 */
private tailrec fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}
