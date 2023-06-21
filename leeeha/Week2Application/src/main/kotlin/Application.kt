import util.Validator
import view.InputView

fun main() {
    val inputView = InputView()
    val validator = Validator()

    val carNames = inputView.readCarNames()
    validator.validateLengthOfCarName(carNames)
    println(carNames)

    val movingNumber = inputView.readMovingNumber()
    println(movingNumber)
}