package week2;

public class TwoStackAlgorithm {
    public static Double calculate(String expression) {

        Stack<Double> valueStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (String e : expression.split(" ")) {
            if (Utils.isNumeric(e)) {
                valueStack.push(Double.parseDouble(e));
            } else if (Utils.isOperator(e)) {
                operatorStack.push(e);
            } else if (e.equals(")")) {
                String operator = operatorStack.pop();

                Double v1 = valueStack.pop();
                if (!operator.equals("√")) {
                    Double v2 = valueStack.pop();

                    valueStack.push(Utils.performOperation(v1, v2, operator));
                } else {
                    valueStack.push(Utils.performOperation(v1, 0, operator));
                }


            }

        }

        return valueStack.peek();
    }


}
