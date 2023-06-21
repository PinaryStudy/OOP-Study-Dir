import domain.CarRacing
import util.Validator
import view.InputView
import view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val validator = Validator()

    val carNames = inputView.readCarNames()
    validator.validateLengthOfCarName(carNames)
    val repeatNumber = inputView.readRepeatNumber()

    val carRacing = CarRacing(carNames)
    carRacing.moveForwardRepeatTimes(repeatNumber)

    val racingResult = carRacing.getMovingStatePerCar()
    val winners = carRacing.judgeWinner()

    outputView.printRacingResult(racingResult)
    outputView.printWinners(winners)
}