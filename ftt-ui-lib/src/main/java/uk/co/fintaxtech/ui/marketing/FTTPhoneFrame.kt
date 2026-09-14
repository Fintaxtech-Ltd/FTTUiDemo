package uk.co.fintaxtech.ui.marketing

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uk.co.fintaxtech.ui.theme.FTTPreview

/**
 * A floating device mockup: rounded bezel, drop shadow and an optional Dynamic-Island-style
 * notch, with [content] clipped to the screen area.
 *
 * Part of the marketing-screenshot toolkit — see [FTTMarketingPreview] and
 * [FTTStoreMarketingScreen]. Designed to wrap real app UI so exported screenshots always
 * match what ships, never a static mockup.
 */
@Composable
fun FTTPhoneFrame(
    modifier: Modifier = Modifier,
    bezelColor: Color = Color(0xFF1C1C1E),
    borderColor: Color = Color(0xFF2C2C2E),
    showNotch: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .aspectRatio(0.462f)
            .shadow(
                elevation = 40.dp,
                shape = RoundedCornerShape(44.dp),
                spotColor = Color.Black.copy(alpha = 0.6f)
            )
            .clip(RoundedCornerShape(44.dp))
            .background(bezelColor)
            .border(12.dp, borderColor, RoundedCornerShape(44.dp))
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(32.dp))
        ) {
            content()
        }

        if (showNotch) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 14.dp)
                    .size(width = 100.dp, height = 32.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Black)
            )
        }
    }
}

@FTTMarketingPreviewEn
@Composable
private fun FTTPhoneFramePreview() {
    FTTPreview {
        Box(modifier = Modifier.padding(40.dp)) {
            FTTPhoneFrame {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface)
                )
            }
        }
    }
}
