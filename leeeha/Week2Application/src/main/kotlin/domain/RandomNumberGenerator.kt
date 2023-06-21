package domain

class RandomNumberGenerator {
    fun generate(): Int {
        return (MIN_RANDOM_NUM..MAX_RANDOM_NUM).random()
    }

    companion object {
        private const val MIN_RANDOM_NUM = 0
        private const val MAX_RANDOM_NUM = 9
    }
}