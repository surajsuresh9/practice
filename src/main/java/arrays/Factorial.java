package arrays;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        factorial(20);
        System.out.println(findDigits(1));
        System.out.println(findDigits(5));
        System.out.println(findDigits(10));
        System.out.println(findDigits(20));
        System.out.println(findDigits(120));
    }

    static BigInteger factorial(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Factorial of: " + n + " = " + res);
        return res;
    }

    static int findDigits(int n) {
        if (n < 0)
            return 0;

        if (n <= 1)
            return 1;

        double digits = 0;
        for (int i = 2; i <= n; i++)
            digits += Math.log10(i);

        return (int) (Math.floor(digits)) + 1;
    }
}