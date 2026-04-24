package uk.co.fintaxtech.feature.demo

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.ComposableFunction0
import androidx.compose.ui.Modifier
import uk.co.fintaxtech.ui.activities.FTTEmptyActivity
import uk.co.fintaxtech.ui.components.FTTTopAppBar

class DemoActivity: FTTEmptyActivity() {
    override val content: @Composable ComposableFunction0<Unit>
        get() = { DemoActivityContent() }
}

@Composable
fun DemoActivityContent() {
        Scaffold(
            topBar = {
                FTTTopAppBar(
                    title = R.string.demo_activity_name
                )
            },
        ) {
            innerPadding ->
            Text(
                text = "Android",
                modifier = Modifier.padding(innerPadding)
            )
        }
}