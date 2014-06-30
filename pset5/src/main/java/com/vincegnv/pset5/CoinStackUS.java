package com.vincegnv.pset5;

/**
 * Created by Vince on 6/27/2014.
 */
public class CoinStackUS extends CoinStack{
    private final int PENNY = 1;
    private final int NICKEL = 5;
    private final int DIME = 10;
    private final int QUARTER = 25;
    private final int HALF_DOLLAR = 50;
    private final int DOLLAR = 100;

    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int halfDollars;
    private int dollars;

    public CoinStackUS(){
        initializeStack();
    }

    protected void initializeStack(){
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
        halfDollars = 0;
        dollars = 0;
    }

    protected void setPennies(int pennies) {
        this.pennies = pennies;
    }

    protected void setNickels(int nickels) {
        this.nickels = nickels;
    }

    protected void setDimes(int dimes) {
        this.dimes = dimes;
    }

    protected void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    protected void setHalfDollars(int halfDollars) {
        this.halfDollars = halfDollars;
    }

    protected void setDollars(int dollars) {
        this.dollars = dollars;
    }

    private void addPenny(){
        this.pennies++;
    }

    private void addNickel(){
        this.nickels++;
    }

    private void addDime(){
        this.dimes++;
    }

    private void addQuarter(){
        this.quarters++;
    }

    private void addhalfDollar(){
        this.halfDollars++;
    }

    private void addDollar(){
        this.dollars++;
    }

    public String printChange(){
        String changeMessage = printDollars() + printHalfDollars() + printQuarters() + printDimes() + printNickels() + printPennies();
        if(changeMessage.isEmpty()){
            changeMessage = "No change.";
        }
        return changeMessage;
    }

    protected void calculateChange(Integer change) {
        while(change > 0){
            if(change >= DOLLAR){
                change -= DOLLAR;
                this.addDollar();
            } else if(change >= HALF_DOLLAR){
                change -= HALF_DOLLAR;
                this.addhalfDollar();
            } else if(change >= QUARTER) {
                change -= QUARTER;
                this.addQuarter();
            } else if(change >= DIME) {
                change -= DIME;
                this.addDime();
            } else if(change >= NICKEL){
                change -= NICKEL;
                this.addNickel();
            } else if (change >= PENNY) {
                change -= PENNY;
                this.addPenny();
            }
        }
    }

    private String printPennies() {
        String coinCall = "pennies";
        if (this.pennies == 1) coinCall = "penny";
        if (this.pennies > 0) {
            return String.format("%d %s\n", this.pennies, coinCall);
        }
        return "";
    }

    private String printNickels() {
        return printCoins("nickel", this.nickels);
    }

    private String printDimes() {
        return printCoins("dime", this.dimes);
    }

    private String printQuarters() {
        return printCoins("quarter", this.quarters);
    }

    private String printHalfDollars() {
        return printCoins("half dollar coin", this.halfDollars);
    }

    private String printDollars() {
        return printCoins("dollar coin", this.dollars);
    }


}
