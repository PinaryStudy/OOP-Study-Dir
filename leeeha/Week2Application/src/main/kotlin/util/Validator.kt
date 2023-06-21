package util

class Validator {
    fun validateLengthOfCarName(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException(CAR_NAMES_EMPTY_ERROR)
        }

        if (carNames.size < MIN_CAR_NUM || carNames.size > MAX_CAR_NUM) {
            throw IllegalArgumentException(CAR_TOTAL_NUM_ERROR)
        }

        for (name in carNames) {
            if (name.length < MIN_CAR_NAME_LENGTH || name.length > MAX_CAR_NAME_LENGTH) {
                throw IllegalArgumentException(CAR_NAME_LENGTH_ERROR)
            }
        }
    }

    companion object {
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_CAR_NUM = 2
        private const val MAX_CAR_NUM = 5
    }
}