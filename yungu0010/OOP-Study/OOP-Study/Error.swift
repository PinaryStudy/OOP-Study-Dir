//
//  Error.swift
//  OOP-Study
//
//  Created by 강윤서 on 2023/06/07.
//

import Foundation

enum ErrorType: String {
    case NullError = "공백을 입력하였습니다."                         // 공백 입력
    case InvalidExpressionError = "올바르지 않은 수식입니다."      // 올바르지 않은 수식
    case InvalidNumberError = "올바르지 않은 수를 입력했습니다."     // 올바르지 않은 수
    case DivideByZeroError = "0으로 나눌 수 없습니다."                // 0으로 나누기
    case none = ""
}

class Error {
    let operation = ["+", "-", "/", "*"]
    
    public func checkError(operations: [String], numbers: [Float]) -> ErrorType {
        
        // 공백 입력
        if operations.count == 0 && numbers.count == 0 {
            return ErrorType.NullError
        }
        
        // 올바르지 않은 수식
        if !checkOperation(operations: operations) {
            return ErrorType.InvalidExpressionError
        }
        
        // 올바르지 않은 수 ex) 1 3 + 4
        if operations.count + 1 != numbers.count {
            return ErrorType.InvalidNumberError
        }
        
        return ErrorType.none
    }
    
    private func checkOperation(operations: [String]) -> Bool {
        for op in operations {
            if !operation.contains(op) {
                return false
            }
        }
        return true
    }
}
