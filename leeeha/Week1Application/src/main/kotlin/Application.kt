import domain.Calculator
import util.SPACE
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

    val values = input!!.split(SPACE)
    validator.apply {
        checkSpace(values)
        checkOperatorType(values)
        checkFormulas(values)
    }

    val calculator = Calculator()
    val sum = calculator.calcString(values)
    outputView.printResult(sum)
}