package uk.co.fintaxtech.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
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
import uk.co.fintaxtech.ui.theme.FTTUiTheme
import uk.co.fintaxtech.ui.theme.PreviewColorPalette

@Composable
fun FTTNoContentView(
    title: String,
    description: String,
    icon: ImageVector = Icons.Default.Info,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

// --- Previews ---
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun PreviewNoContentViewLight() {
    FTTUiTheme(palette = PreviewColorPalette(), darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTNoContentView(
                title = "No Data Found",
                description = "We couldn't find any information to display at this moment. Please try again later."
            )
        }
    }
}

@Preview(name = "Dark Mode", showBackground = true)
@Composable
fun PreviewNoContentViewDark() {
    FTTUiTheme(palette = PreviewColorPalette(), darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTNoContentView(
                title = "No Data Found",
                description = "We couldn't find any information to display at this moment. Please try again later."
            )
        }
    }
}