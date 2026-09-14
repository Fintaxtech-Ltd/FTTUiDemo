package uk.co.fintaxtech.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Shape scale extracted from the Claude Design project "RepRocket App".
 * Source of truth: rr-design/tokens.md
 */
val FTTShapes = Shapes(
    // Session accent bars
    extraSmall = RoundedCornerShape(3.dp),
    // Week activity bars
    small = RoundedCornerShape(7.dp),
    // Icon containers
    medium = RoundedCornerShape(12.dp),
    // Cards, banners, hero button
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(16.dp)
)
