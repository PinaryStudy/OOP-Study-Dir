package subeen;

public enum Operator {
    ADD("+") {
        @Override
        public int result(int num1, int num2) {
            return num1 + num2;
        }
    },
    SUB("-") {
        @Override
        public int result(int num1, int num2) {
            return num1 - num2;
        }
    },
    MULTI("*") {
        @Override
        public int result(int num1, int num2) {
            return num1 * num2;
        }
    },
    DIV("/") {
        @Override
        public int result(int num1, int num2) {
            return num1 / num2;
        }
    };

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public abstract int result(int num1, int num2);

    public static Operator checkOperator(String value) {
        for (Operator operator : values())
            if (operator.value.equals(value)) return operator;
        return null;
    }


}
