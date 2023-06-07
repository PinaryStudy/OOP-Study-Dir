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
        checkContinuousTypes()

        // 문자열의 시작과 끝이 숫자가 아닌 경우
        checkStartEnd()
    }

    private fun checkContinuousTypes() {
        var types = mutableListOf<Type>()
        for (str in values) {
            if (isNumeric(str)) {
                types = updateTypes(types, Type.NUMBER, CONTINUOUS_NUMBER_ERROR)
                continue
            }
            types = updateTypes(types, Type.OPERATOR, CONTINUOUS_OPERATOR_ERROR)
        }
    }

    private fun updateTypes(types: MutableList<Type>, type: Type, message: String): MutableList<Type> {
        if (types.isNotEmpty() && types.last() == type) {
            throw IllegalArgumentException(message)
        }
        types.add(type)
        return types
    }

    private fun checkStartEnd() {
        if (!isNumeric(values[0]) || !isNumeric(values.last()))
            throw IllegalArgumentException(INVALID_FORMULAS_ERROR)
    }

    private fun isNumeric(str: String): Boolean {
        return str.all { ch -> ch.isDigit() }
    }
}