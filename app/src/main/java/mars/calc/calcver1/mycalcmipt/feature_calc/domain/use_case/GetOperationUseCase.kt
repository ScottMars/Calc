package mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.repository.OperationRepository

class GetOperationUseCase(private val repository: OperationRepository) {

    operator fun invoke(): Flow<List<Operation>> {

        return repository.getOperations()
            .map { operations -> operations.sortedByDescending { it.id } }

    }


}