package com.vincegnv.pset5;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
         public void hasDollarSignReturnsTrue() throws Exception {
        InputValidator inputValidator = InputValidator.getInstance();

        boolean valid = inputValidator.hasCurrencySymbol("$123");

        assertEquals(true, valid);
    }

    @Test
    public void hasEuroSignReturnsTrue() throws Exception {
        InputValidator inputValidator = InputValidator.getInstance();

        boolean valid = inputValidator.hasCurrencySymbol("€123");

        assertEquals(true, valid);
    }

    @Test
    public void hasNoCurrencySignReturnsTrue() throws Exception {
        InputValidator inputValidator = InputValidator.getInstance();

        boolean valid = inputValidator.isValidCurrencyAmount("123");

        assertEquals(false, valid);
    }

    @Test
         public void hasCurrencySignReturnsTrue() throws Exception {
        boolean valid = InputValidator.getInstance().isValidCurrencyAmount("$33.00");

        assertEquals(true, valid);
    }

    @Test
    public void hasTwoDecimalPointsReturnsFalse() throws Exception {
        boolean valid = InputValidator.getInstance().isValidCurrencyAmount("$3..20");

        assertEquals(false, valid);
    }

    @Test
    public void hasNoNumbersAfterCurrencySignReturnsFalse() throws Exception {
        boolean valid = InputValidator.getInstance().isValidCurrencyAmount("$");

        assertEquals(false, valid);
    }

    @Test
    public void hasLetterReturnsFalse() throws Exception {
        boolean valid = InputValidator.getInstance().isValidCurrencyAmount("$1e.22");

        assertEquals(false, valid);
    }

}