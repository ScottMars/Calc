package mars.calc.calcver1.mycalcmipt.feature_calc.domain.repository

import kotlinx.coroutines.flow.Flow
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation

interface OperationRepository

{
    fun getOperations(): Flow<List<Operation>>
    suspend fun insertOperation(operation: Operation)
    suspend fun deleteOperation(operation: Operation)
}