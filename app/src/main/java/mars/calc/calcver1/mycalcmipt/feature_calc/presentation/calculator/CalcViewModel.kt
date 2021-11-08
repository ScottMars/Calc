package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Operation
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.use_case.OperationUseCase
import javax.inject.Inject

@HiltViewModel
class CalcViewModel @Inject constructor(
    private val operationUseCase: OperationUseCase
) : ViewModel() {


    private var currentOperationId: Int? = null
    private val _state = mutableStateOf(CalcState())

    val state: State<CalcState> = _state

    private var getNotesJob: Job? = null

    init {
        getHistory()
    }

    private fun getHistory() {
        getNotesJob?.cancel()
        getNotesJob =
            operationUseCase
                .getOperationUseCase()
                .onEach { op ->
                    _state.value = state.value.copy(history = op)
                }
                .launchIn(viewModelScope)
    }

    fun onEvent(event: CalcEvent) {
        when (event) {
            is CalcEvent.CalculateButtonPressed -> {
                viewModelScope.launch {
                    operationUseCase.addOperationUseCase(
                        Operation(
                            expr = event.expr,
                            id = currentOperationId
                        )
                    )
                }
            }
        }
    }
}