package org.implemica;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find its factorial digit sum: ");
        int inputNumber = scanner.nextInt();

        BigInteger factorial = calculateFactorial(inputNumber);
        int sumOfDigits = calculateSumOfDigits(factorial);

        System.out.println("The sum of the digits in " + inputNumber + "! is: " + sumOfDigits);

        scanner.close();
    }

    /**
     * Calculates the factorial of a given number.
     * This method uses the BigInteger class to handle quite large results.
     *
     * @param number the number to calculate the factorial
     * @return the factorial of the given number as a BigInteger
     */
    public static BigInteger calculateFactorial(int number) {
        if (number < 0) {
            return BigInteger.ONE;
        }

        BigInteger factorialResult = BigInteger.ONE;

        for (int n = 2; n <= number; n++) {
            factorialResult = factorialResult.multiply(BigInteger.valueOf(n));
        }

        return factorialResult;
    }

    /**
     * Calculates the sum of the digits in a BigInteger.
     *
     * @param number the BigInteger whose digits are to be summed
     * @return the sum of the digits in the given BigInteger
     */
    private static int calculateSumOfDigits(BigInteger number) {
        int digitSum = 0;

        for (char digit : number.toString().toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }

        return digitSum;
    }

}