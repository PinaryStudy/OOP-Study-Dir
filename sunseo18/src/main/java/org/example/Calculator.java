package org.example;

import java.util.Deque;

public class Calculator {

    private final Deque<Double> operands;
    private final Deque<OperatorEnum> operators;

    public Calculator(Deque<Double> operands, Deque<OperatorEnum> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public Double calculate() {
        while (operands.size() != 1) {
            OperatorEnum operator = operators.removeFirst();
            Double operand1 = operands.removeFirst();
            Double operand2 = operands.removeFirst();

            operands.addFirst(operator.calculate(operand1, operand2));

        }
        return operands.remove();
    }

}
