package uk.co.fintaxtech.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

val FTTTypography = Typography(
    // Wordmark — 800 / 26sp / -0.03em
    displaySmall = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 26.sp,
        lineHeight = 26.sp,
        letterSpacing = (-0.03).em
    ),
    // Card title — 800 / 17sp / 1.2 / -0.02em
    titleMedium = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 17.sp,
        lineHeight = 20.4.sp,
        letterSpacing = (-0.02).em
    ),
    // Section title — 800 / 15sp / -0.02em
    titleSmall = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 15.sp,
        lineHeight = 15.sp,
        letterSpacing = (-0.02).em
    ),
    // Hero button label — 800 / 16.5sp / -0.01em
    labelLarge = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W800,
        fontSize = 16.5.sp,
        lineHeight = 16.5.sp,
        letterSpacing = (-0.01).em
    ),
    // List item title — 700 / 14.5sp / 1.25 / -0.01em
    bodyLarge = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = 14.5.sp,
        lineHeight = 18.1.sp,
        letterSpacing = (-0.01).em
    ),
    // Summary copy — 500 / 12.5sp / 1.35
    bodyMedium = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.5.sp,
        lineHeight = 16.9.sp
    ),
    // List item meta — 500 / 12sp / 1.3
    bodySmall = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
        lineHeight = 15.6.sp
    ),
    // Link / inline action — 600 / 12.5sp
    labelMedium = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 12.5.sp,
        lineHeight = 12.5.sp
    ),
    // Caption, uppercase — 500 / 10.5sp / 0.04em
    labelSmall = TextStyle(
        fontFamily = FTTFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 10.5.sp,
        lineHeight = 12.6.sp,
        letterSpacing = 0.04.em
    )
)
