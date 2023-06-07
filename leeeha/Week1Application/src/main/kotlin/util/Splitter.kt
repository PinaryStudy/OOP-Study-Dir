package util

class Splitter {
    fun splitStringBySpace(str: String?): List<String> {
        if (str != null) {
            return str.split(SPACE)
        }
        throw NullPointerException(NULL_INPUT_ERROR)
    }
}