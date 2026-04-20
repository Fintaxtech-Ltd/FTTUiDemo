package uk.co.fintaxtech.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import uk.co.fintaxtech.ui.theme.ColorSchemes.DarkColorScheme
import uk.co.fintaxtech.ui.theme.ColorSchemes.LightColorScheme
import uk.co.fintaxtech.ui.theme.FTTColorPalette
import uk.co.fintaxtech.ui.theme.FTTUiTheme
import javax.inject.Inject

@AndroidEntryPoint
abstract class FTTEmptyActivity: ComponentActivity() {

    @Inject
    lateinit var colorPalette: FTTColorPalette
    abstract val content: @Composable () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FTTUiTheme(
                palette = colorPalette
            ) {
                content()
            }
        }
    }
}
