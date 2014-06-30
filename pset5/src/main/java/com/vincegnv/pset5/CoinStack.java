package com.vincegnv.pset5;

/**
 * Created by Vince on 6/29/2014.
 */
public abstract class CoinStack {
    public abstract String printChange();
    protected abstract void initializeStack();
    protected abstract void calculateChange(Integer change);
    protected String printCoins(String coinCall, int coinAmount){

        if(coinAmount > 0){
            String plural = "s";
            if(coinAmount == 1) plural = "";
            if(coinAmount > 0) return String.format("%d %s%s\n", coinAmount, coinCall, plural);
        }
        return "";
    }
}
