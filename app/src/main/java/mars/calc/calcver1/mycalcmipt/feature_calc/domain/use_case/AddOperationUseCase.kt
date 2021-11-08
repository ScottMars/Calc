package mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case

import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Sign
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.repository.OperationRepository
import kotlin.math.pow
import kotlin.math.sqrt

class AddOperationUseCase(private val repository: OperationRepository) {

    suspend operator fun invoke(note: Operation) {
        repository.insertOperation(note)
    }
}