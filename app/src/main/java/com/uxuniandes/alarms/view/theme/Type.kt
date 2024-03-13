package com.uxuniandes.alarms.view.theme

import android.os.Build
import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uxuniandes.alarms.R


val fontFamily = FontFamily(
    Font(
        R.font.montserrat_regular,
        weight = FontWeight.Bold
    )
)

@OptIn(ExperimentalTextApi::class)
val fontFamilyRegular = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    FontFamily(
        Font(
            R.font.montserrat_wght,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(400)
            )
        )
    )
} else {
    fontFamily
}

@OptIn(ExperimentalTextApi::class)
val fontFamilyMedium = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    FontFamily(
        Font(
            R.font.montserrat_wght,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(500)
            )
        )
    )
} else {
    fontFamily
}


@OptIn(ExperimentalTextApi::class)
val fontFamilyBold = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    FontFamily(
        Font(
            R.font.montserrat_wght,
            variationSettings = FontVariation.Settings(
                FontVariation.weight(700)
            )
        )
    )
} else {
    fontFamily
}


val AlarmTypography = Typography(

    bodyLarge = TextStyle(
        fontFamily = fontFamilyRegular,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    //Titulo Largo
    titleLarge = TextStyle(
        fontFamily = fontFamilyBold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    /*Subtítulo*/
    titleMedium = TextStyle(
        fontFamily = fontFamilyRegular,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    /*Título interno*/
    titleSmall = TextStyle(
        fontFamily = fontFamilyRegular,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    /*cuerpo*/
    bodyMedium = TextStyle(
        fontFamily = fontFamilyRegular,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),

    /*boton*/
    labelLarge = TextStyle(
        fontFamily = fontFamilyBold,
        fontSize = 14.sp,
        lineHeight = 18.sp
    ),

    /*Acción*/
    labelMedium = TextStyle(
        fontFamily = fontFamilyMedium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    /*Acción*/
    labelSmall = TextStyle(
        fontFamily = fontFamilyRegular,
        fontSize = 12.sp,
        lineHeight = 18.sp
    )
)