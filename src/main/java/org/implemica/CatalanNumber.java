package org.implemica;

import java.util.Scanner;

public class CatalanNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pairs of brackets: ");
        int numberOfPairs = scanner.nextInt();

        long totalCombinations = calculateCatalan(numberOfPairs);

        System.out.println("Correct expressions for " + numberOfPairs + " pairs: " + totalCombinations);

        scanner.close();
    }

    /**
     * Calculates the Catalan number for the given number of bracket pairs.
     * <p>
     * The Catalan number is calculated using this formula:
     * C(n+1) = (C(n) * 2 * (2n + 1)) / (n + 2)
     *
     * @param numberOfPairs the number of bracket pairs
     * @return the Catalan number for the given number of pairs
     * @throws IllegalArgumentException if the {@code numberOfPairs} is negative
     */
    public static long calculateCatalan(int numberOfPairs) {
        if (numberOfPairs < 0) {
            throw new IllegalArgumentException("Number of pairs cannot be negative.");
        }

        if (numberOfPairs == 0) {
            return 1;
        }

        long catalan = 1;
        for (int n = 0; n < numberOfPairs; n++) {
            catalan = catalan * 2 * (2L * n + 1) / (n + 2);
        }

        return catalan;
    }

}