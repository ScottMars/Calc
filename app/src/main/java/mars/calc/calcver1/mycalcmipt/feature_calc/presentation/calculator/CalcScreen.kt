package mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.mappers.toSymbol
import mars.calc.calcver1.mycalcmipt.feature_calc.domain.model.Sign
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator.components.ButtonList
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator.components.ButtonType
import mars.calc.calcver1.mycalcmipt.feature_calc.presentation.calculator.components.ToCButton

@Composable
fun CalculatorScreen(navController: NavController,
     viewModel: CalcViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val buttonList = ButtonList.chunked(4)
    val expression = remember { mutableStateOf("") }
    var prevOperation : String = if (state.history.isNotEmpty()) state.history.first().expr else ""
    val result = remember { mutableStateOf("") }
    val op = remember { mutableStateOf<Sign?>(null) }
    val clearNext = remember { mutableStateOf(false) }


    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(7.dp)) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        ) {
            Text(
                    text = prevOperation,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            Text(
                text = expression.value,
                fontSize = 85.sp,
                fontWeight = FontWeight.Light,
                color = Color.White
            )
        }
        Column {
            buttonList.forEach { buttons ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    buttons.forEach { button ->
                        val onClick = {
                            when (button.type) {
                                ButtonType.Number -> {
                                    op.value = null
                                    if (clearNext.value) {
                                        expression.value = button.text
                                    } else {
                                        expression.value = expression.value + button.text
                                    }
                                    clearNext.value = false
                                }
                                ButtonType.Special -> {
                                    op.value = null
                                    when (button.text) {
                                        "±" -> {
                                            if (expression.value.startsWith("-")) {
                                                expression.value = expression.value.substring(1)
                                            } else {
                                                expression.value = "-" + expression.value
                                            }
                                        }
                                        "%" -> {
                                            result.value = if (expression.value.isNotEmpty()) {
                                                expression.value + button.text
                                            } else ""
                                            op.value = Sign.Mod
                                            clearNext.value = true
                                        }
                                        "AC" -> {
                                            expression.value = ""
                                            result.value = ""
                                        }
                                    }
                                }
                                ButtonType.Operator -> {
                                    op.value = null;
                                    if (expression.value.isNotEmpty()) {
                                        when (button.text) {
                                            "=" -> {
                                                val res = evaluate(result.value + expression.value)
                                                prevOperation = "${result.value}${expression.value} = $res"
                                                viewModel.onEvent(CalcEvent.CalculateButtonPressed(prevOperation))
                                                print(state.history)
                                                expression.value = res
                                                result.value = ""
                                            }
                                            "÷" -> {
                                                result.value = expression.value + button.text
                                                op.value = Sign.Div
                                            }
                                            "+" -> {
                                                result.value = expression.value + button.text
                                                op.value = Sign.Add
                                            }
                                            "–" -> {
                                                result.value = expression.value + button.text
                                                op.value = Sign.Sub
                                            }
                                            "×" -> {
                                                result.value = expression.value + button.text
                                                op.value = Sign.Mul
                                            }
                                        }
                                    }
                                    clearNext.value = true
                                }
                            }
                        }
                        button.ToCButton(onClick, op.value.toSymbol() == button.text)
                    }
                }
            }
        }
    }
}

fun evaluate(expr: String): String {
    val multiplicative = "÷×%"
    val additive = "+–"
    val floatPattern = """\d+[.]?\d*"""
    val multiplicativePat = Regex("""($floatPattern)([$multiplicative])($floatPattern)""")
    val additivePat = Regex("""($floatPattern)([$additive])($floatPattern)""")
    var result = expr
    while (multiplicativePat.containsMatchIn(result)) {
        result = multiplicativePat.replace(result) {
            when (it.groupValues[2]) {
                "÷" -> (it.groupValues[1].toFloat() / it.groupValues[3].toFloat()).toString()
                "%" -> (it.groupValues[1].toFloat() % it.groupValues[3].toFloat()).toString()
                else -> (it.groupValues[1].toFloat() * it.groupValues[3].toFloat()).toString()
            }
        }
    }
    while (additivePat.containsMatchIn(result)) {
        result = additivePat.replace(result) {
            when (it.groupValues[2]) {
                "+" -> (it.groupValues[1].toFloat() + it.groupValues[3].toFloat()).toString()
                else -> (it.groupValues[1].toFloat() - it.groupValues[3].toFloat()).toString()
            }
        }
    }
    return if (result.endsWith(".0")) result.substringBeforeLast(".0") else result
}