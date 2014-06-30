package com.vincegnv.pset5;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinCalculatorTest {

    @Test
    public void testConvertStringChangeToIntegerTest() throws Exception {
        CoinCalculator coinCalculator = CoinCalculator.getInstance(new CoinStackEuro());

        Integer change = coinCalculator.convertStringChangeToCentsTest("€.05");

        assertEquals((Integer)5, change);
    }


}