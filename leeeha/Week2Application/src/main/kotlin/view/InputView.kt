package view

import util.CAR_NAMES_NULL_ERROR
import util.COMMA
import java.util.*

class InputView {
    /** 자동차 이름 목록 */
    fun readCarNames(): List<String> {
        val inputString = readLine()
        if (inputString != null) {
            return splitByComma(inputString)
        }

        throw NullPointerException(CAR_NAMES_NULL_ERROR)
    }

    private fun splitByComma(input: String): List<String> {
        return input.split(COMMA).map { it.trim() }
    }

    /** 자동차들의 이동 횟수 */
    fun readRepeatNumber(): Int {
        val sc = Scanner(System.`in`)
        return sc.nextInt()
    }
}