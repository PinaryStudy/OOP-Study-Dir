package view

import domain.Car
import util.COMMA
import util.DIVIDER
import util.WINNER

class OutputView {
    fun printRacingResult(movingStatePerCar: List<Car>) {
        for(car in movingStatePerCar){
            print("${car.name} : ")
            println(car.movingState)
        }
        println(DIVIDER)
    }

    fun printWinners(winners: List<String>) {
        print(WINNER)
        for ((index, winner) in winners.withIndex()) {
            print(winner)
            if (index == winners.size - 1) continue
            print(COMMA)
        }
        println()
    }
}