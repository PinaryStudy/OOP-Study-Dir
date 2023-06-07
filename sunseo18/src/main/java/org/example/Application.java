package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

public class Application {

    private static final Validator validator = new Validator();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        calculate(bufferedReader);
    }

    private static void calculate(BufferedReader bufferedReader) throws IOException {
        try {
            Deque<Double> operands;
            Deque<OperatorEnum> operators;
            String input = bufferedReader.readLine();
            validator.validate(input);

            Interpreter interpreter = new Interpreter();
            operands = interpreter.getOperands(input);
            operators = interpreter.getOperators(input);

            Calculator calculator = new Calculator(operands, operators);
            System.out.println(calculator.calculate());

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            System.out.println("다시 입력하세요");
            calculate(bufferedReader);
        }
    }
}