package mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case

import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.repository.OperationRepository

class DeleteOperationUseCase(private val repository: OperationRepository) {

    suspend fun invoke(operation: Operation) {
        repository.deleteOperation(operation)
    }

}