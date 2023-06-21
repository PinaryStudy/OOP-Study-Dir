package view

import util.CAR_NAMES_NULL_ERROR
import util.COMMA
import java.util.*

class InputView {
    fun readCarNames(): List<String> {
        val inputString = readLine()
        if (inputString != null) {
            return splitByCommaAndTrim(inputString)
        }
        throw NullPointerException(CAR_NAMES_NULL_ERROR)
    }

    private fun splitByCommaAndTrim(input: String): List<String> {
        return input.split(COMMA).map { it.trim() }
    }

    fun readRepeatNumber(): Int {
        val sc = Scanner(System.`in`)
        return sc.nextInt()
    }
}