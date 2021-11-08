package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val Typography = Typography(

    h1 = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp),
    h2 = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 24.sp),
    h3 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 20.sp),
    h4 = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )

)