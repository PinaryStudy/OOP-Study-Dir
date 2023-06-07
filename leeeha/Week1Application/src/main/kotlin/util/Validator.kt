package util

class Validator(
    private val input: String?,
    private val values: List<String>
) {
    fun checkNullOrEmpty() {
        if (input == null) {
            throw NullPointerException(NULL_INPUT_ERROR)
        }

        if (input.trim().isEmpty()) {
            throw IllegalArgumentException(EMPTY_INPUT_ERROR)
        }
    }

    fun checkInvalidSpace() {
        for (str in values) {
            if (str.trim().isEmpty()) throw IllegalArgumentException(INVALID_SPACE_ERROR)
        }
    }

    fun checkOperatorType() {
        for (str in values) {
            if (!isNumeric(str)) {
                isValidOperator(str)
            }
        }
    }

    private fun isValidOperator(operator: String) {
        for (value in Operator.values()) {
            if (value.op == operator) return
        }
        throw IllegalArgumentException(INVALID_OPERATOR_ERROR)
    }

    fun checkFormulas() {
        // 숫자나 문자가 연달아 입력된 경우
        checkContinuousType()

        // 문자열의 시작과 끝이 숫자가 아닌 경우
        checkStartEnd()
    }

    private fun checkContinuousType() {
        val types = mutableListOf<Type>()

        for (str in values) {
            if (isNumeric(str)) {
                if (types.isNotEmpty() && types.last() == Type.NUMBER) {
                    throw IllegalArgumentException(CONTINUOUS_NUMBER_ERROR)
                }
                types.add(Type.NUMBER)
            } else {
                if (types.isNotEmpty() && types.last() == Type.OPERATOR) {
                    throw IllegalArgumentException(CONTINUOUS_OPERATOR_ERROR)
                }
                types.add(Type.OPERATOR)
            }
        }
    }

    private fun checkStartEnd() {
        if (!isNumeric(values[0]) || !isNumeric(values.last()))
            throw IllegalArgumentException(INVALID_FORMULAS_ERROR)
    }

    private fun isNumeric(str: String): Boolean {
        return str.all { ch -> ch.isDigit() }
    }
}