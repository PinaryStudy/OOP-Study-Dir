package org.example;

public class InvalidNumberException extends RuntimeException {
    private static final String message = "%s는 올바르지 않은 숫자입니다.";

    public InvalidNumberException(String operand){
        super(String.format(message, operand));
    }
}
