package uk.co.fintaxtech.ui.views

import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import uk.co.fintaxtech.ui.theme.FTTTheme
import uk.co.fintaxtech.ui.theme.PreviewColorPalette

/**
 * FTTPermissionsView is a screen that checks for a specific Android permission.
 * If granted, it renders nothing. If not granted, it shows an error-style view
 * with a button to request the permission.
 *
 * @param permission The Android permission string (e.g., "android.permission.CAMERA").
 * @param title Title text to show when permission is denied.
 * @param description Description text to show when permission is denied.
 * @param buttonText Text for the request button.
 * @param modifier Optional modifier.
 */
@Composable
fun FTTPermissionsView(
    permission: String,
    title: String,
    description: String,
    buttonText: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    // Internal state to track if permission was just granted to trigger recomposition
    var isGranted by remember(permission) {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { result ->
        isGranted = result
    }

    if (!isGranted) {
        FTTErrorView(
            title = title,
            description = description,
            buttonText = buttonText,
            onButtonClick = { launcher.launch(permission) },
            icon = Icons.Default.Lock,
            modifier = modifier
        )
    }
}

// --- Previews ---
@Preview(name = "Light Mode", showBackground = true)
@Composable
private fun PreviewPermissionsViewLight() {
    FTTTheme(palette = PreviewColorPalette(), darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTPermissionsView(
                permission = "android.permission.CAMERA",
                title = "Camera Permission Required",
                description = "This app needs camera access to scan barcodes. Please grant the permission.",
                buttonText = "Grant Permission"
            )
        }
    }
}

@Preview(name = "Dark Mode", showBackground = true)
@Composable
private fun PreviewPermissionsViewDark() {
    FTTTheme(palette = PreviewColorPalette(), darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            FTTPermissionsView(
                permission = "android.permission.CAMERA",
                title = "Camera Permission Required",
                description = "This app needs camera access to scan barcodes. Please grant the permission.",
                buttonText = "Grant Permission"
            )
        }
    }
}
