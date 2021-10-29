package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = ColorPrimary,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = DarkGray
)
private val LightColorPalette = lightColors(
    primary = ColorPrimary,
    background = Color.White,
    onBackground = TextWhite,
    onPrimary = DarkGray
)

@Composable
fun CalcAppTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(colors = colors, typography = Typography, content = content)
}