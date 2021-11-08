package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.util

sealed class Screen(val route: String) {
    object CalcScreen: Screen("calc_screen")
    object OperationHistory: Screen("operation_screen")
}
