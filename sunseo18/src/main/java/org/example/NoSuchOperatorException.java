package org.example;

public class NoSuchOperatorException extends RuntimeException {
    private static final String message = "%s는 지원하지 않는 연산자입니다.";

    public NoSuchOperatorException(String operator){
        super(String.format(message, operator));
    }
}
