import domain.CarRace
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

    val carRace = CarRace(carNames)
    carRace.moveForwardRepeatTimes(repeatNumber)

    val raceResult = carRace.getMovingStatePerCar()
    val winners = carRace.judgeWinner()

    outputView.printRaceResult(raceResult)
    outputView.printWinners(winners)
}