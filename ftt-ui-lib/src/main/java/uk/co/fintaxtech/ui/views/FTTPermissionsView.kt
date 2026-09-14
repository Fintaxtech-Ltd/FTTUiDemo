package uk.co.fintaxtech.ui.views

import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.core.content.ContextCompat
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * Checks for a single Android runtime permission.
 *
 * If the permission is granted this renders nothing. If not, it shows an [FTTErrorView]
 * with an action that launches the system permission prompt; granting it recomposes the
 * caller with the permission now held.
 *
 * @param permission     The Android permission string (e.g. `android.permission.CAMERA`).
 * @param titleResId     Display copy shown while the permission is denied.
 * @param requestLabelResId Display copy for the request action.
 * @param detail         Optional supporting text. Genuine data, so a plain [String].
 */
@Composable
fun FTTPermissionsView(
    permission: String,
    @StringRes titleResId: Int,
    modifier: Modifier = Modifier,
    @StringRes requestLabelResId: Int = R.string.ftt_retry,
    detail: String? = null
) {
    val context = LocalContext.current

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
            titleResId = titleResId,
            modifier = modifier,
            detail = detail,
            onRetry = { launcher.launch(permission) },
            retryLabelResId = requestLabelResId
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTPermissionsViewPreview() {
    FTTPreview {
        FTTPermissionsView(
            permission = "android.permission.CAMERA",
            titleResId = R.string.ftt_preview_error_title,
            requestLabelResId = R.string.ftt_retry,
            detail = "Camera access is needed to scan barcodes."
        )
    }
}
