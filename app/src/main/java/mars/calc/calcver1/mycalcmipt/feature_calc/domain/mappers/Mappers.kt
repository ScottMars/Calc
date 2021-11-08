package mars.calc.calcver1.mycalcmipt.feature_calc.domain.mappers

import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Sign

fun Sign?.toSymbol(): String {
    return when (this) {
        Sign.Add -> "+"
        Sign.Sub -> "–"
        Sign.Mod -> "%"
        Sign.Div -> "÷"
        Sign.Mul -> "×"
        null -> ""
    }
}
