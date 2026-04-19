package uk.co.fintaxtech.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import uk.co.fintaxtech.ui.theme.ColorSchemes.DarkColorScheme
import uk.co.fintaxtech.ui.theme.ColorSchemes.LightColorScheme
import uk.co.fintaxtech.ui.theme.FTTUiTheme

abstract class FTTEmptyActivity: ComponentActivity() {
    abstract val content: @Composable () -> Unit

    open fun lightColorScheme(): ColorScheme = LightColorScheme

    open fun darkColorScheme(): ColorScheme = DarkColorScheme

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FTTUiTheme(
                lightColorScheme = lightColorScheme(),
                darkColorScheme = darkColorScheme()
            ) {
                content()
            }
        }
    }
}
