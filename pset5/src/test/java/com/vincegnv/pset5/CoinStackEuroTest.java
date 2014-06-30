package com.vincegnv.pset5;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinStackEuroTest {

    @Test
    public void testPrintChange() throws Exception {
        CoinStackEuro coinStack = new CoinStackEuro();

        coinStack.setTwoCents(7);
        coinStack.setFiveCents(6);
        coinStack.setTenCents(5);
        coinStack.setTwentyCents(4);
        coinStack.setFiftyCents(3);
        coinStack.setOneEuro(2);
        coinStack.setTwoEuros(1);

        String printed = coinStack.printChange();

        assertEquals("1 two euro coin\n2 one euro coins\n3 fifty euro cents\n4 twenty euro cents\n5 ten euro cents\n6 five euro cents\n7 two euro cents\n", printed);
    }

    @Test
    public void test5CentsShouldReturn1FiveEuroCents() throws Exception {
        CoinStackEuro coinStack = new CoinStackEuro();

        coinStack.setFiveCents(1);

        String printed = coinStack.printChange();

        assertEquals("1 five euro cent\n", printed);
    }
}