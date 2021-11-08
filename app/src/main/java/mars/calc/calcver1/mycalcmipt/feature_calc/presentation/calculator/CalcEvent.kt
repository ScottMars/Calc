package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator

sealed class CalcEvent {
    data class CalculateButtonPressed(val expr: String): CalcEvent()
}