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
    public func checkError(operations: [String], numbers: [Float]) -> ErrorType {
        return ErrorType.none
    }
}
