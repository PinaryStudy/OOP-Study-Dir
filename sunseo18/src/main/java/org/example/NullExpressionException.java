package org.example;

public class NullExpressionException extends RuntimeException {

    private static final String message = "계산식은 null일 수 없습니다.";

    public NullExpressionException(String expression) {
        super(String.format(message, expression));
    }

}
