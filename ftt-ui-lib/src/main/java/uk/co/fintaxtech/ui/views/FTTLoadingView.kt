package uk.co.fintaxtech.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTUiTheme
import uk.co.fintaxtech.ui.theme.PreviewColorPalette

@Composable
fun FTTLoadingView(
    modifier: Modifier = Modifier,
    message: String? = "Loading...",
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )

        message?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

// --- Previews ---
@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun PreviewLoadingViewLight() {
    FTTUiTheme(palette = PreviewColorPalette(), darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTLoadingView(message = "Fetching data...")
        }
    }
}

@Preview(name = "Dark Mode", showBackground = true)
@Composable
private fun PreviewLoadingViewDark() {
    FTTUiTheme(palette = PreviewColorPalette(), darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTLoadingView(message = "Fetching data...")
        }
    }
}