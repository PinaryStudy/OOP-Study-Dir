//
//  Utils.swift
//  OOP-Study
//
//  Created by 강윤서 on 2023/06/07.
//

import Foundation

class Utils {
    
    public func plus(firstNumber: Float, secondNumber: Float) -> Float {
        return firstNumber + secondNumber
    }
    
    public func minus(firstNumber: Float, secondNumber: Float) -> Float {
        return firstNumber - secondNumber
    }
    
    public func divide(firstNumber: Float, secondNumber: Float) -> Float {
        if secondNumber == 0 {
            print(ErrorType.DivideByZeroError.rawValue)
            exit(0)
        }
        return firstNumber / secondNumber
    }
    
    public func multiple(firstNumber: Float, secondNumber: Float) -> Float {
        return firstNumber * secondNumber
    }
}
