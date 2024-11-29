package org.implemica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CatalanNumberTest {

    @Test
    void testCalculateCatalan_smallNumbers() {
        assertEquals(5, CatalanNumber.calculateCatalan(3), "Catalan(3) should be 5");
        assertEquals(14, CatalanNumber.calculateCatalan(4), "Catalan(4) should be 14");
        assertEquals(42, CatalanNumber.calculateCatalan(5), "Catalan(5) should be 42");
        assertEquals(132, CatalanNumber.calculateCatalan(6), "Catalan(6) should be 132");
    }

    @Test
    void testCalculateCatalan_largeNumbers() {
        assertEquals(1430, CatalanNumber.calculateCatalan(7), "Catalan(7) should be 1430");
        assertEquals(4862, CatalanNumber.calculateCatalan(8), "Catalan(8) should be 4862");
        assertEquals(16796, CatalanNumber.calculateCatalan(9), "Catalan(9) should be 16796");
        assertEquals(58786, CatalanNumber.calculateCatalan(10), "Catalan(10) should be 58786");
    }

    @Test
    void testCalculateCatalan_boundaryCases() {
        assertThrows(IllegalArgumentException.class, () -> CatalanNumber.calculateCatalan(-1),
                "An exception should be thrown for negative numbers of pairs");
    }
}