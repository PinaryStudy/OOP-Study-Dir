package subeen;

public enum Error {
    NULLORBLANK("입력값이 NULL OR BLANK 입니다."),
    EXPRESSION("올바르지 않은 수식입니다.")
    ;
    Error(String error) {
        this.error = error;
    }

    private final String error;

    public static Error checkError(String value) {
        //TODO 오류처리 분기
        return null;
    }
}