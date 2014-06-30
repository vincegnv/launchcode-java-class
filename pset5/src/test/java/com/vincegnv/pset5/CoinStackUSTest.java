package com.vincegnv.pset5;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinStackUSTest {

    @Test
    public void has3DimesReturnsTrue() throws Exception {
        CoinStackUS coinStack = new CoinStackUS();
        coinStack.setDimes(3);

        String printed = coinStack.printChange();

        assertEquals("3 dimes\n", printed);
    }

    @Test
    public void has1Penny3Dimes5QuartersReturnsTrue() throws Exception {
        CoinStackUS coinStack = new CoinStackUS();
        coinStack.setDimes(3);
        coinStack.setPennies(1);
        coinStack.setQuarters(5);

        String printed = coinStack.printChange();

        assertEquals("5 quarters\n3 dimes\n1 penny\n", printed);
    }

    @Test
    public void has1Penny1Nickel1Dime1Quarter1HalfDollar1DollarReturnsTrue() throws Exception {
        CoinStackUS coinStack = new CoinStackUS();
        coinStack.setDimes(1);
        coinStack.setPennies(1);
        coinStack.setQuarters(1);
        coinStack.setNickels(1);
        coinStack.setHalfDollars(1);
        coinStack.setDollars(1);

        String printed = coinStack.printChange();

        assertEquals("1 dollar coin\n1 half dollar coin\n1 quarter\n1 dime\n1 nickel\n1 penny\n", printed);
    }

    @Test
    public void has2Pennies3Nickels4Dimes5Quarters6HalfDollars7DollarsReturnsTrue() throws Exception {
        CoinStackUS coinStack = new CoinStackUS();
        coinStack.setDimes(4);
        coinStack.setPennies(2);
        coinStack.setQuarters(5);
        coinStack.setNickels(3);
        coinStack.setHalfDollars(6);
        coinStack.setDollars(7);

        String printed = coinStack.printChange();

        assertEquals("7 dollar coins\n6 half dollar coins\n5 quarters\n4 dimes\n3 nickels\n2 pennies\n", printed);
    }

    @Test
    public void hasNoChangeShouldReturnNoChange() throws Exception {
        CoinStackUS coinStack = new CoinStackUS();

        String printed = coinStack.printChange();

        assertEquals("No change.", printed);
    }
}