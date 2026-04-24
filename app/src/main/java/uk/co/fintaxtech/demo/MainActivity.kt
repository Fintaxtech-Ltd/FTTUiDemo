package uk.co.fintaxtech.demo

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import uk.co.fintaxtech.feature.demo.DemoActivity
import uk.co.fintaxtech.ui.activities.FTTEmptyActivity
import uk.co.fintaxtech.ui.components.FTTTopAppBar
import kotlin.jvm.java

@AndroidEntryPoint
class MainActivity : FTTEmptyActivity() {

    override val content: @Composable (() -> Unit)
        get() = { MainActivityContent() }
}

@Composable
fun MainActivityContent(){
    Scaffold(
            topBar = {
                FTTTopAppBar(
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
    val context  = LocalContext.current
    Column {
        Text(
            text = "Hello $name!",
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier
        )
        Button(onClick = {
            context.startActivity(Intent(context, DemoActivity::class.java))
        }) {
            Text("Press Me")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {

}
