package subeen;

public class Calculator {
    public int calculate(String[] formula) {

        int result = Integer.parseInt(formula[0]);
        Operator operator = null;

        //오류 검사 후 계산 

        for (int i = 1; i < formula.length; i++) {
            if (isOperator(formula[i])) {
                operator = Operator.checkOperator(formula[i]);
            } else {
                result = operator.result(result, Integer.parseInt(formula[i]));
            }
        }

        return result;
    }

    //operator 맞는지
    private boolean isOperator(String operator) {
        return Operator.checkOperator(operator) != null;
    }
}
