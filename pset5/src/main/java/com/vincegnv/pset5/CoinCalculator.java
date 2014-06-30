package com.vincegnv.pset5;
/**
 * User: vincegnv
 * Date: 6/18/14
 * Time: 3:06 AM
 */
public class CoinCalculator {

    private CoinStack coinStack;

    private CoinCalculator(){}

    //kept for testing purposes
    public static CoinCalculator getInstance(CoinStack coinStack){
        CoinCalculator cc = new CoinCalculator();
        cc.setCoinStack(coinStack);
        return cc;
    }

    public void setCoinStack(CoinStack coinStack){
        this.coinStack = coinStack;
    }

    private void calculateChange(String amountOfChange) {
        Integer change = convertStringChangeToCents(amountOfChange);
        coinStack.calculateChange(change);
    }

    public Integer convertStringChangeToCentsTest(String amountOfChange){
        return convertStringChangeToCents(amountOfChange);
    }

    private Integer convertStringChangeToCents(String amountOfChange){
        String change = removeCurrencySign(amountOfChange);
        Float changeAsFloat = Float.parseFloat(change);

        return Math.round(changeAsFloat*100);
    }

    private String removeCurrencySign(String amountOfChange) {
        return amountOfChange.substring(1);
    }

    public void printChange(String amountOfChange){
        calculateChange(amountOfChange);
        System.out.println(coinStack.printChange());
    }

}
