package uk.co.fintaxtech.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A card displaying a labelled value, used for session stats.
 *
 * @param label The category name (e.g. "VOLUME").
 * @param value The numerical value (e.g. "1,200").
 * @param unit  Optional unit suffix (e.g. "kg").
 */
@Composable
fun FTTStatCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    unit: String? = null
) {
    FTTCard(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 13.dp)
    ) {
        Column {
            FTTDataText(
                text = label.uppercase(),
                style = FTTTextStyle.Caption,
                color = FTTTextColor.Secondary
            )
            Spacer(modifier = Modifier.height(7.dp))
            Row(verticalAlignment = Alignment.Bottom) {
                FTTDataText(
                    text = value,
                    style = FTTTextStyle.MonoLarge,
                    color = FTTTextColor.Primary
                )
                if (unit != null) {
                    FTTDataText(
                        text = unit,
                        style = FTTTextStyle.Caption,
                        color = FTTTextColor.Secondary,
                        modifier = Modifier.padding(start = 2.dp, bottom = 2.dp)
                    )
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun FTTStatCardPreview() {
    FTTPreview {
        FTTStatCard(label = "Volume", value = "1,200", unit = "kg")
    }
}
