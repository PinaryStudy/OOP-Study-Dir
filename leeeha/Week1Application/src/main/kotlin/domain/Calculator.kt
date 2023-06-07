package domain

import util.DIVIDE_ZERO_ERROR
import util.Operator.*

class Calculator {
    fun calcString(values: List<String>): Int {
        var sum = values[0].toInt()

        for (i in 1 until values.size - 1 step (2)) {
            when (values[i]) {
                ADD.op -> sum += values[i + 1].toInt()
                SUB.op -> sum -= values[i + 1].toInt()
                MUL.op -> sum *= values[i + 1].toInt()
                DIV.op -> {
                    val num = values[i + 1].toInt()
                    if(num == 0){
                        throw ArithmeticException(DIVIDE_ZERO_ERROR)
                    }
                    sum /= num
                }
            }
        }

        return sum
    }
}