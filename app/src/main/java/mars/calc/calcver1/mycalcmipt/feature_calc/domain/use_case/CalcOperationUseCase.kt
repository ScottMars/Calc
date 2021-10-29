package mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case

import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Sign

class CalcOperationUseCase() {
    suspend operator fun invoke(operation: Operation) {
        if (operation.eq == null) {
            when (operation.sign) {
                is Sign.Add -> {
                    operation.eq = operation.num1 + operation.num2
                }
            }
        }
    }
}