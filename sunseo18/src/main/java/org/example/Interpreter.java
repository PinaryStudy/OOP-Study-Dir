package org.example;

import java.util.Deque;
import java.util.LinkedList;

public class Interpreter {

    private String[] stripString(final String input) {
        return input.split("\\s+");
    }

    public Deque<Double> getOperands(final String input) {
        String[] expression = stripString(input);
        Deque<Double> operands = new LinkedList<>();

        for (int i = 0; i < expression.length; i += 2) {
            operands.add(checkOperand(expression[i]));
        }
        return operands;
    }

    public Deque<OperatorEnum> getOperators(final String input) {
        String[] expression = stripString(input);

        Deque<OperatorEnum> operators = new LinkedList<>();
        for (int i = 1; i < expression.length; i += 2) {
            operators.add(checkOperator(expression[i]));
        }

        return operators;
    }

    private Double checkOperand(final String operand) {
        try {
            return Double.parseDouble(operand);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException(operand);
        }
    }

    private OperatorEnum checkOperator(final String operator) {
        return OperatorEnum.find(operator);
    }

}
