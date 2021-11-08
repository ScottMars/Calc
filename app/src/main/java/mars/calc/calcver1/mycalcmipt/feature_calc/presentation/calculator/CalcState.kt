package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator

import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation

data class CalcState(
    val history: List<Operation> = emptyList()
)