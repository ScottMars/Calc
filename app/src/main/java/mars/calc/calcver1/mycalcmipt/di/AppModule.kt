package mars.calc.calcver1.mycalcmipt.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mars.calc.calcver1.mycalcmipt.feature_calc.data.data_source.OperationDataBase
import mars.calc.calcver1.mycalcmipt.feature_calc.data.repository.OperationRepositoryImpl
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.repository.OperationRepository
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case.AddOperationUseCase
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case.DeleteOperationUseCase
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case.GetOperationUseCase
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case.OperationUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOperationDataBase(app: Application): OperationDataBase {
        return Room.databaseBuilder(
            app,
            OperationDataBase::class.java,
            OperationDataBase.DATABASE_NAME,
        )
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: OperationDataBase): OperationRepository {
        return OperationRepositoryImpl(db.operationDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: OperationRepository): OperationUseCase {
        return OperationUseCase(
            addOperationUseCase = AddOperationUseCase(repository),
            deleteOperationUseCase = DeleteOperationUseCase(repository),
            getOperationUseCase = GetOperationUseCase(repository)
        )
    }
}