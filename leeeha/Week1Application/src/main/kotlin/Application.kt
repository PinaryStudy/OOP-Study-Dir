import domain.Calculator
import util.Splitter
import exception.Validator
import view.InputView
import view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printInputGuide()
    val input = inputView.readInputString()
    val values = Splitter().splitStringBySpace(input)

    val validator = Validator(input, values)
    validator.apply {
        checkNullOrEmpty()
        checkInvalidSpace()
        checkOperatorType()
        checkFormulas()
    }

    val calculator = Calculator()
    val sum = calculator.calcString(values)
    outputView.printResult(sum)
}