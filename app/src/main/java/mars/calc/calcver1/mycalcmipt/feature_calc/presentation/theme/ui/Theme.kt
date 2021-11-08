package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.theme.ui.Shapes

private val DarkColorPalette = darkColors(
    primary = Yellow600,
    primaryVariant = Color.Yellow,
    secondary = Gray700,
    secondaryVariant = Gray500,
    background = Color.Black
)

private val LightColorPalette = lightColors(
    primary = Yellow600,
    primaryVariant = Color.Yellow,
    secondary = Gray700,
    secondaryVariant = Gray500,
    background = Color.White,
)

@Composable
fun CalcAppTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(colors = colors, typography = Typography, content = content, shapes = Shapes,)
}