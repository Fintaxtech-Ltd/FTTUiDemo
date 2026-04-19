package uk.co.fintaxtech.demo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import uk.co.fintaxtech.ui.activities.FTTEmptyActivity
import uk.co.fintaxtech.ui.components.FTTActionBar
import uk.co.fintaxtech.ui.theme.FTTUiTheme

class MainActivity : FTTEmptyActivity() {

    override val content: @Composable (() -> Unit)
        get() = { MainActivityContent() }
}

@Composable
fun MainActivityContent(){
    Scaffold(
            topBar = {
                FTTActionBar(
                    title = R.string.app_name
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Greeting(
                name = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    FTTUiTheme {

    }
}
