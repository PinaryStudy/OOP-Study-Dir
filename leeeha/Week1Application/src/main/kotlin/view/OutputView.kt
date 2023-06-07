package view

import util.INPUT_GUIDE_MSG

class OutputView {
    fun printInputGuide() {
        print(INPUT_GUIDE_MSG)
    }

    fun printResult(result: Int) {
        println(result)
    }
}