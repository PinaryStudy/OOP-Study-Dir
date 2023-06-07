import domain.Calculator
import util.Splitter
import util.Validator
import view.InputView
import view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val validator = Validator()

    outputView.printInputGuide()
    val input = inputView.readInputString()
    validator.checkNullOrEmpty(input)

    val values = Splitter().splitStringBySpace(input!!)
    validator.apply {
        checkSpace(values)
        checkOperatorType(values)
        checkFormulas(values)
    }

    val calculator = Calculator()
    val sum = calculator.calcString(values)
    outputView.printResult(sum)
}