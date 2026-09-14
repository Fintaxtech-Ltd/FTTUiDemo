package uk.co.fintaxtech.ui.views

import androidx.annotation.ArrayRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.R
import uk.co.fintaxtech.ui.components.FTTDataText
import uk.co.fintaxtech.ui.components.FTTTextColor
import uk.co.fintaxtech.ui.components.FTTTextStyle
import uk.co.fintaxtech.ui.theme.FTTPreview
import uk.co.fintaxtech.ui.theme.LocalFTTColors

private const val INTENSITY_BASE = 0.55f
private const val INTENSITY_STEP = 0.075f

/**
 * A week of activity as a row of bars, one per day.
 *
 * @param completion One entry per day, in the same order as [dayLabelsArrayResId].
 *        Entries beyond the label count are ignored; missing entries render incomplete.
 * @param dayLabelsArrayResId String-array resource supplying the day initials, so the
 *        labels and the week's first day can be localized.
 */
@Composable
fun FTTWeekActivityStrip(
    completion: List<Boolean>,
    modifier: Modifier = Modifier,
    @ArrayRes dayLabelsArrayResId: Int = R.array.ftt_day_labels
) {
    val extendedColors = LocalFTTColors.current
    val dayLabels = stringArrayResource(id = dayLabelsArrayResId)

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        dayLabels.forEachIndexed { index, label ->
            DayColumn(
                label = label,
                isComplete = completion.getOrElse(index) { false },
                // Completed bars ramp in intensity across the week, matching the
                // design's sense of building momentum.
                intensity = INTENSITY_BASE + index * INTENSITY_STEP,
                completeColor = extendedColors.success,
                trackColor = extendedColors.barTrack
            )
        }
    }
}

@Composable
private fun RowScope.DayColumn(
    label: String,
    isComplete: Boolean,
    intensity: Float,
    completeColor: Color,
    trackColor: Color
) {
    Column(
        modifier = Modifier.weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(26.dp)
                .background(
                    color = if (isComplete) {
                        completeColor.copy(alpha = intensity.coerceIn(0f, 1f))
                    } else {
                        trackColor
                    },
                    shape = MaterialTheme.shapes.small
                )
        )
        FTTDataText(
            text = label,
            style = FTTTextStyle.DayLabel,
            color = FTTTextColor.Secondary
        )
    }
}

@PreviewLightDark
@Composable
private fun FTTWeekActivityStripPartialPreview() {
    FTTPreview {
        FTTWeekActivityStrip(completion = listOf(false, false, true, true, true, true, false))
    }
}

@PreviewLightDark
@Composable
private fun FTTWeekActivityStripEmptyPreview() {
    FTTPreview {
        FTTWeekActivityStrip(completion = List(7) { false })
    }
}

@PreviewLightDark
@Composable
private fun FTTWeekActivityStripFullPreview() {
    FTTPreview {
        FTTWeekActivityStrip(completion = List(7) { true })
    }
}
