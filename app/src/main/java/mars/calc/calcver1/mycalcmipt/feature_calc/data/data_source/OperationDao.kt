package mars.calc.calcver1.mycalcmipt.feature_calc.data.data_source

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation

@Dao
interface OperationDao {
    @Query("SELECT * FROM operation")
    fun getOperations(): Flow<List<Operation>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOperation(operation: Operation)

    @Delete
    suspend fun deleteOperation(operation: Operation)

}