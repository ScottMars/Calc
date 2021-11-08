package mars.calc.calcver1.mycalcmipt.feature_calc.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation

@Database(
    entities = [Operation::class],
    version = 1
)
abstract class OperationDataBase : RoomDatabase() {

    abstract val operationDao: OperationDao

    companion object {
        const val DATABASE_NAME = "operations_db"
    }
}