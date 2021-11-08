package mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case

data class OperationUseCase(
    val getOperationUseCase: GetOperationUseCase,
    val deleteOperationUseCase: DeleteOperationUseCase,
    val addOperationUseCase: AddOperationUseCase,
)
