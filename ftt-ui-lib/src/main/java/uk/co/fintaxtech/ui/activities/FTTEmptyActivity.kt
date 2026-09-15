package uk.co.fintaxtech.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import uk.co.fintaxtech.ui.theme.FTTColorPalette
import uk.co.fintaxtech.ui.theme.FTTTheme
import uk.co.fintaxtech.ui.theme.PreviewColorPalette
import uk.co.fintaxtech.ui.theme.SystemBarIcons

abstract class FTTEmptyActivity : ComponentActivity() {

    /**
     * The color palette used to build [FTTTheme]. Subclasses may override this to supply their
     * own palette, obtained however they like (Hilt on Android, Koin on KMP, or a plain instance).
     * Defaults to [PreviewColorPalette] so the library stays free of any dependency-injection.
     */
    open val colorPalette: FTTColorPalette = PreviewColorPalette()
    abstract val content: @Composable () -> Unit

    /**
     * Whether [FTTTheme] renders dark. Follows the system by default.
     *
     * Override to apply a stored appearance preference such as System / Light / Dark. The
     * result also drives the status- and navigation-bar icons: `enableEdgeToEdge` picks their
     * colour from the *system* theme, so a forced-dark app on a light device would otherwise
     * draw dark icons on a dark bar.
     */
    @Composable
    open fun isDarkTheme(): Boolean = isSystemInDarkTheme()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val darkTheme = isDarkTheme()
            SystemBarIcons(darkTheme = darkTheme)
            FTTTheme(
                palette = colorPalette,
                darkTheme = darkTheme
            ) {
                content()
            }
        }
    }
}
