//
//  Caculator.swift
//  OOP-Study
//
//  Created by 강윤서 on 2023/06/07.
//

import Foundation

enum OperationType: String {
    case plus = "+"
    case minus = "-"
    case multiple = "*"
    case divide = "/"
}

class Calculator {
    private var utils = Utils()
    
    public func calculate(operation: [String], numbers: [Float]) -> Float {
        var left = numbers[0]
        
        for index in 0...operation.count-1 {
            let op = operation[index]
            switch op {
            case OperationType.plus.rawValue:
                left = utils.plus(firstNumber: left,
                                  secondNumber: numbers[index+1])
            case OperationType.minus.rawValue:
                left = utils.minus(firstNumber: left,
                                   secondNumber: numbers[index+1])
            case OperationType.multiple.rawValue:
                left = utils.multiple(firstNumber: left,
                                      secondNumber: numbers[index+1])
            default:
                left = utils.divide(firstNumber: left,
                                    secondNumber: numbers[index+1])
            }
        }
        return left
    }
}
