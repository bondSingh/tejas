package saty.learncompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import saty.learncompose.R


@OptIn(ExperimentalTextApi::class)
val montserratFontBold =
    FontFamily(
        Font(
            R.font.montserrat_weighted,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(950),
                FontVariation.width(30f),
                FontVariation.slant(-6f),
            )
        )
    )

@OptIn(ExperimentalTextApi::class)
val montserratFontLight =
    FontFamily(
        Font(
            R.font.montserrat_italic,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(500),
                FontVariation.width(20f),
                FontVariation.slant(-2f),
            )
        )
    )
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = montserratFontLight,
        fontSize = 20.sp

    ),
    displayLarge = TextStyle(
        fontFamily = montserratFontBold,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )



    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


