package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator.components

import androidx.compose.runtime.Composable

data class CalculatorButton(
    val type: ButtonType = ButtonType.Number,
    val text: String,
    val size: ButtonSize = ButtonSize.Normal,
    val onClick: () -> Unit
)


val ButtonList = listOf(
    CalculatorButton(type = ButtonType.Special, text = "AC", onClick = {}),
    CalculatorButton(type = ButtonType.Special, text = "±", onClick = {}),
    CalculatorButton(type = ButtonType.Special, text = "%", onClick = {}),
    CalculatorButton(type = ButtonType.Operator, text = "÷", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "7", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "8", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "9", onClick = {}),
    CalculatorButton(type = ButtonType.Operator, text = "×", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "4", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "5", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "6", onClick = {}),
    CalculatorButton(type = ButtonType.Operator, text = "–", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "1", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "2", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = "3", onClick = {}),
    CalculatorButton(type = ButtonType.Operator, text = "+", onClick = {}),
    CalculatorButton(type = ButtonType.Number, size = ButtonSize.Wide, text = "0", onClick = {}),
    CalculatorButton(type = ButtonType.Number, text = ".", onClick = {}),
    CalculatorButton(type = ButtonType.Operator, text = "=", onClick = {}),
)

@Composable
fun CalculatorButton.ToCButton(onClick: () -> Unit, isActive: Boolean = false) {
    CalcButton(text = text, size = size, onClick = onClick, type = type, isActive = isActive)
}