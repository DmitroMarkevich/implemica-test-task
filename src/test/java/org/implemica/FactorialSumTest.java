package org.implemica;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialSumTest {

    @Test
    void testCalculateFactorial_smallNumbers() {
        assertEquals(BigInteger.ONE, FactorialSum.calculateFactorial(0), "0! should be 1");
        assertEquals(BigInteger.ONE, FactorialSum.calculateFactorial(1), "1! should be 1");
        assertEquals(BigInteger.valueOf(2), FactorialSum.calculateFactorial(2), "2! should be 2");
        assertEquals(BigInteger.valueOf(6), FactorialSum.calculateFactorial(3), "3! should be 6");
        assertEquals(BigInteger.valueOf(24), FactorialSum.calculateFactorial(4), "4! should be 24");
    }

    @Test
    void testCalculateFactorial_largeNumbers() {
        assertEquals(new BigInteger("120"), FactorialSum.calculateFactorial(5), "5! should be 120");
        assertEquals(new BigInteger("3628800"), FactorialSum.calculateFactorial(10), "10! should be 3628800");
    }
}