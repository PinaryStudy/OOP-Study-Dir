import util.Operator.*
import util.Validator
import view.InputView
import view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val validator = Validator()

    outputView.printInputGuide()
    val input = inputView.readInput()
    validator.checkNullOrEmpty(input)

    val values = input!!.split(" ")
    validator.checkSpace(values)
    validator.checkOperatorType(values)
    validator.checkFormulas(values)

//    val numbers = mutableListOf<Int>()
//    val operators = mutableListOf<String>()
//
//    for (str in values) {
//        if (isNumeric(str)) {
//            numbers.add(str.toInt())
//            continue
//        }
//        validator.checkOperator(str)
//        operators.add(str)
//    }

//    var sum = values[0].toInt()
//    for (i in 1 until values.size - 1 step (2)) {
//        when (values[i]) {
//            ADD.op -> sum += values[i + 1].toInt()
//            SUB.op -> sum -= values[i + 1].toInt()
//            MUL.op -> sum *= values[i + 1].toInt()
//            DIV.op -> sum /= values[i + 1].toInt()
//        }
//    }
//
//    print(sum)
}

fun isNumeric(str: String): Boolean {
    return str.all { ch -> ch.isDigit() }
}
