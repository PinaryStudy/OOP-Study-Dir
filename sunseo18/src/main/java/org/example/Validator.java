package org.example;

public class Validator {

    public void validate(String expression) {
        checkNotEmpty(expression);
        checkNotNull(expression);
    }

    private void checkNotEmpty(String expression) {
        if (expression.isEmpty()) {
            throw new EmptyExpressionException(expression);
        }
    }

    private void checkNotNull(String expression) {
        if (expression == null) {
            throw new NullExpressionException(expression);
        }
    }
}
