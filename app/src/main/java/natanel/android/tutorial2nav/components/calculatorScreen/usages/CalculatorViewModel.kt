package natanel.android.tutorial2nav.components.calculatorScreen.usages

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.math.RoundingMode

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set // cant change the state but can read it

    fun onAction(action: CalculatorAction){
        when(action){
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()

        }
    }

    private fun performDeletion() {
        when{
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toBigDecimalOrNull()
        val number2 = state.number2.toBigDecimalOrNull()
        if (number1 != null && number2 != null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Divide -> {
                    // Check for division by zero
                    if (number2 == 0.toBigDecimal()) {
                        Log.e("Calculator", "Division by zero error")
                        // Update state to indicate error (implementation omitted here)
                        return
                    }

                    // rounding after 15 digits so we don't get infinite number
                    number1.divide(number2, 15, RoundingMode.HALF_EVEN)
                }
                is CalculatorOperation.Multiply -> number1 * number2
                null -> return
            }

            Log.d("Calculator", "Result of division: $result")

            state = state.copy(
                //plainString - BigDecimal has default behavior for toString and how he shows number so plainString is the regular
                //stripTrailingZeros - removing unnecessary zeros after the dot
                number2 = "",
                number1 = result.stripTrailingZeros().toPlainString().take(15),
                operation = null
            )
        }

    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()){
            state = state.copy(operation = operation) // when using mutableStates you cant change directly like set method(state(operation = operation)) you need to use copy
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()){
            state = state.copy(number1 = state.number1 + ".")
            return
        }

         if(state.number2.isNotBlank() && !state.number2.contains(".")){
            state = state.copy(number2 = state.number2 + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null){
            if (state.number1.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(number1 = state.number1 + number.toString())
            return
        }

        if (state.number1.length >= MAX_NUM_LENGTH){
           return
        }
        state = state.copy(number2 = state.number2 + number.toString())
    }

    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
}