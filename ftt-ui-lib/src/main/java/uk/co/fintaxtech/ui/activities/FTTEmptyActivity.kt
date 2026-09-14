package uk.co.fintaxtech.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import uk.co.fintaxtech.ui.theme.FTTColorPalette
import uk.co.fintaxtech.ui.theme.FTTTheme
import uk.co.fintaxtech.ui.theme.PreviewColorPalette

abstract class FTTEmptyActivity: ComponentActivity() {

    /**
     * The color palette used to build [FTTTheme]. Subclasses may override this to supply their
     * own palette, obtained however they like (Hilt on Android, Koin on KMP, or a plain instance).
     * Defaults to [PreviewColorPalette] so the library stays free of any dependency-injection.
     */
    open val colorPalette: FTTColorPalette = PreviewColorPalette()
    abstract val content: @Composable () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FTTTheme(
                palette = colorPalette
            ) {
                content()
            }
        }
    }
}
