package uk.co.fintaxtech.ui.components

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTTheme

/**
 * FTTActionBar is a reusable top app bar component for the FTT UI library.
 *
 * @param title String resource ID for the title text.
 * @param modifier Optional modifier for the component.
 * @param onNavigationClick Optional callback for the navigation (back) icon. If null, no icon is shown.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FTTTopAppBar(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    onNavigationClick: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            onNavigationClick?.let { action ->
                IconButton(onClick = action) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.ftt_back_desc)
                    )
                }
            }
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview(name = "Light Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FTTTopAppBarPreviewWithNavigation() {
    FTTTheme {
        FTTTopAppBar(
            title = R.string.standard_title,
            onNavigationClick = { }
        )
    }
}

@Preview(name = "Light Mode No Nav", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode No Nav", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun FTTTopAppBarPreviewWithoutNavigation() {
    FTTTheme {
        FTTTopAppBar(
            title = R.string.standard_title
        )
    }
}
