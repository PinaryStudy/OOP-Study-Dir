import util.Operator.*

fun main() {
    // view
    print("계산할 문자열 입력: ")
    val input = readLine()

    // exception
    validateInput(input)

    // domain
    val values = input?.split(" ")

    var sum = 0

    if(values != null){
        sum += values[0].toInt()
    }

    if (values != null) {
        for(i in 1 until values.size - 1 step(2)){
            when (values[i]) {
                ADD.op -> sum += values[i + 1].toInt()
                SUB.op -> sum -= values[i + 1].toInt()
                MUL.op -> sum *= values[i + 1].toInt()
                DIV.op -> sum /= values[i + 1].toInt()
            }
        }
    }

    print(sum)
}

fun validateInput(input: String?) {
    checkNullOrEmpty(input)

}

fun checkNullOrEmpty(input: String?) {
    if (input.isNullOrEmpty()) {
        throw IllegalArgumentException()
    }
}