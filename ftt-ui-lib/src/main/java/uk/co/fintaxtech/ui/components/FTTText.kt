package uk.co.fintaxtech.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.theme.FTTTheme

/**
 * A title text component for the FTT UI library.
 *
 * @param text The text to be displayed.
 * @param modifier Optional modifier for the component.
 * @param color Optional text color.
 * @param textAlign Optional text alignment.
 * @param maxLines Optional maximum number of lines.
 * @param overflow Optional text overflow behavior.
 */
@Composable
fun FTTTextTitle(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = stringResource(textId),
        modifier = modifier,
        color = color,
        style = MaterialTheme.typography.titleLarge,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        fontWeight = FontWeight.Bold
    )
}

/**
 * A body text component for the FTT UI library.
 *
 * @param text The text to be displayed.
 * @param modifier Optional modifier for the component.
 * @param color Optional text color.
 * @param textAlign Optional text alignment.
 * @param maxLines Optional maximum number of lines.
 * @param overflow Optional text overflow behavior.
 */
@Composable
fun FTTTextBody(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = stringResource(textId),
        modifier = modifier,
        color = color,
        style = MaterialTheme.typography.bodyLarge,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Preview(showBackground = true)
@Composable
private fun FTTTextPreview() {
    FTTTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FTTTextTitle(textId = R.string.standard_title)
            FTTTextBody(textId = R.string.standard_title)
        }
    }
}
