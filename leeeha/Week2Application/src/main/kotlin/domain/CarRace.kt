package domain

import domain.model.Car
import util.FORWARD_CHAR

class CarRace(carNames: List<String>) {
    private val movingStatePerCar = mutableListOf<Car>()

    init {
        for (name in carNames) {
            movingStatePerCar.add(Car(name, ""))
        }
    }

    fun moveForwardRepeatTimes(repeatNumber: Int) {
        // 각 자동차마다
        for (car in movingStatePerCar) {
            // 랜덤 숫자를 repeatNumber 만큼 반복해서 뽑는다.
            for (i in 0 until repeatNumber) {
                val randomNumberGenerator = RandomNumberGenerator()
                val rand = randomNumberGenerator.generate()

                // 랜덤 숫자가 4~9이면 전진한다.
                if (rand in MIN_FORWARD_NUM..MAX_FORWARD_NUM) {
                    car.movingState += FORWARD_CHAR
                }
            }
        }
    }

    fun judgeWinner(): List<String> {
        sortByMovingDistance()
        val maxLength = movingStatePerCar.first().movingState.length

        val winners = mutableListOf<String>()
        for(car in movingStatePerCar){
            if(car.movingState.length == maxLength){
                winners.add(car.name)
            }
        }

        return winners
    }

    private fun sortByMovingDistance() {
        movingStatePerCar.sortByDescending { it.movingState.length }
    }

    fun getMovingStatePerCar() : List<Car> {
        return movingStatePerCar
    }

    companion object {
        private const val MIN_FORWARD_NUM = 4
        private const val MAX_FORWARD_NUM = 9
    }
}