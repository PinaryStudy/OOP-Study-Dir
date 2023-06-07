package domain

import util.Operator.*

class Calculator {
    fun calcString(values: List<String>): Int {
        var sum = values[0].toInt()

        for (i in 1 until values.size - 1 step (2)) {
            when (values[i]) {
                ADD.op -> sum += values[i + 1].toInt()
                SUB.op -> sum -= values[i + 1].toInt()
                MUL.op -> sum *= values[i + 1].toInt()
                DIV.op -> sum /= values[i + 1].toInt()
            }
        }

        return sum
    }
}