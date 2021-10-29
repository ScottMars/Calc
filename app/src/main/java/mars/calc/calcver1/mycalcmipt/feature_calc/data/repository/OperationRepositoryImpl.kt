package mars.calc.calcver1.mycalcmipt.feature_calc.data.repository

import kotlinx.coroutines.flow.Flow
import mars.calc.calcver1.mycalcmipt.feature_calc.data.data_source.OperationDao
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.repository.OperationRepository

class OperationRepositoryImpl(private val dao: OperationDao): OperationRepository
{
    override fun getOperations(): Flow<List<Operation>> {
        return dao.getOperations()
    }

    override suspend fun insertOperation(operation: Operation) {
        return dao.insertOperation(operation)
    }

    override suspend fun deleteOperation(operation: Operation) {
        return dao.deleteOperation(operation)
    }

}