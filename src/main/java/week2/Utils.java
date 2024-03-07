package week2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isNumeric(String str) {
        try {
            double num = Double.parseDouble(str);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    public static boolean isOperator(String str) {
        Pattern pattern = Pattern.compile("[+*/%^√-]");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static double performOperation(double v1, double v2, String operator) {
        switch (operator) {
            case "+":
                return v1+v2;
            case "-":
                return v2-v1;
            case "*":
                return v1*v2;
            case "/":
                return v2/v1;
            case "%":
                return v2%v1;
            case "^":
                return Math.pow(v2, v1);
            case "√":
                return Math.pow(v2, 1 / v1);
            default:
                return -1;
        }
    }
}
