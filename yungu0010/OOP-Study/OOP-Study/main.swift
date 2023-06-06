//
//  main.swift
//  OOP-Study
//
//  Created by 강윤서 on 2023/06/07.
//

import Foundation

func main() {
    let input = readLine()!
    let numbers = input.split(separator: " ").compactMap{ str in Float(str) }
    let operations = input.filter{ !$0.isNumber && $0 != " " }.map{String($0)}
    
    let errorCheck = Error()
    let caculator = Calculator()
    
    let isError = errorCheck.checkError(operations: operations, numbers: numbers)
    
    if isError == ErrorType.none {
        print(caculator.calculate(operation: operations, numbers: numbers))
        exit(0)
    }
    
    print(isError.rawValue)
}

main()
