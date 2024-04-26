package calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        // If the exponent is negative, convert it to positive
        // It's important to handle this if you intend to support negative exponents.
        int result = 1;
        for (int i = 1; i <= Math.abs(b); i++) {
            result *= a;
        }
        // If the exponent was negative, return the reciprocal as an integer.
        // Note: This will not be accurate for non-integer results.
        return b > 0 ? result : 1 / result;
    }

}

