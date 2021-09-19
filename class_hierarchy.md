data class NumButton(
    val value: Number
)

data class EnteredNumber(
    val value: Double
)

sealed class Operation

data class Add(val num1: Double, val num2: Double) : Operation
data class Sub(val num1: Double, val num2: Double) : Operation
data class Div(val num1: Double, val num2: Double) : Operation
data class Mult(val num1: Double, val num2: Double) : Operation
data class Pow(val num1: Double, val num2: Double) : Operation
data class Sqrt(val num1: Double, val num2: Double) : Operation

data class Expression(
    val e1: EnteredNumber,
    val e2: EnteredNumber? = null,
    val operation: Operation,
    val result: Result? = null
)

data class OperationHistory(
    var history: List<Expression> = emptyList()
)

fun restoreFromHistory(index: Int): Expression {
    return OperationHistory.elementAt(index)
}

interface CalcRepository() {
    fun calculate(expr: Expression): Result

    fun round(result: Result): Result
}


class RepositoryImpl: CalcRepository  {
    fun calculate(expr: Expression): Result {
        OperationHistory.add(expr)
        when (Operation) {
            Add -> round(EnteredNumber + EnteredNumber2)
            Div -> round(EnteredNumber / EnteredNumber2)
            Sub -> round(EnteredNumber - EnteredNumber2)
            Mult -> round(EnteredNumber * EnteredNumber2)
            Pow -> round(EnteredNumber.pow(EnteredNumber2))
            Sqrt -> round(sqrt(EnteredNumber))
        }
    }

    fun round(decimals: Int = 2): Double = "%.${decimals}f".format(this).toDouble()

}
