package org.example;

public class EmptyExpressionException extends RuntimeException{
    private static final String message = "계산식은 빈 문자열일 수 없습니다";

    public EmptyExpressionException(String operator){
        super(String.format(message, operator));
    }
}
