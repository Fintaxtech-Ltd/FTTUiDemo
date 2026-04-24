package uk.co.fintaxtech.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTTheme
import uk.co.fintaxtech.ui.theme.PreviewColorPalette

@Composable
fun FTTErrorView(
    title: String,
    description: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.Warning
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Error Icon
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.error
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Error Title
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Error Description
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Custom Action Button
        Button(
            onClick = onButtonClick
        ) {
            Text(text = buttonText)
        }
    }
}

// --- Previews ---
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun PreviewErrorViewLight() {
    FTTTheme(palette = PreviewColorPalette(), darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTErrorView(
                title = "Something went wrong",
                description = "We encountered an error while loading the data. Check your internet connection.",
                buttonText = "Try Again",
                onButtonClick = {}
            )
        }
    }
}

@Preview(name = "Dark Mode", showBackground = true)
@Composable
fun PreviewErrorViewDark() {
    FTTTheme(palette = PreviewColorPalette(), darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTErrorView(
                title = "Something went wrong",
                description = "We encountered an error while loading the data. Check your internet connection.",
                buttonText = "Try Again",
                onButtonClick = {}
            )
        }
    }
}