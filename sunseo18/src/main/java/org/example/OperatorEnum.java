package org.example;

import java.util.Arrays;
import java.util.Optional;

public enum OperatorEnum {
    ADD("+") {
        @Override
        Double calculate(Double operand1, Double operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACT("-") {
        @Override
        Double calculate(Double operand1, Double operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        Double calculate(Double operand1, Double operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        @Override
        Double calculate(Double operand1, Double operand2) {
            return operand1 / operand2;
        }
    };

    abstract Double calculate(Double operand1, Double operand2);

    private final String operator;

    OperatorEnum(String operator) {
        this.operator = operator;
    }

    static OperatorEnum find(String op) {
        return Arrays.stream(values()).filter(e -> e.operator.equals(op)).findFirst()
            .orElseThrow(() -> new NoSuchOperatorException(op));
    }
}
