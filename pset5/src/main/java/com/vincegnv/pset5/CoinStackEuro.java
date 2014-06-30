package com.vincegnv.pset5;

/**
 * Created by Vince on 6/29/2014.
 */
public class CoinStackEuro extends CoinStack{
    private final int ONE_CENT = 1;
    private final int TWO_CENTS = 2;
    private final int FIVE_CENTS = 5;
    private final int TEN_CENTS = 10;
    private final int TWENTY_CENTS = 20;
    private final int FIFTY_CENTS = 50;
    private final int ONE_EURO = 100;
    private final int TWO_EUROS = 200;

    private int oneCent;
    private int twoCents;
    private int fiveCents;
    private int tenCents;
    private int twentyCents;
    private int fiftyCents;
    private int oneEuro;
    private int twoEuros;

    public CoinStackEuro(){
        initializeStack();
    }

    protected void initializeStack() {
        setOneCent(0);
        setTwoCents(0);
        setFiveCents(0);
        setTenCents(0);
        setTwentyCents(0);
        setFiftyCents(0);
        setOneEuro(0);
        setTwoEuros(0);
    }

    public String printChange() {
        String changeMessage = printTwoEuros() + printOneEuro() + printFiftyCents() + printTwentyCents() + printTenCents() +
                               printFiveCents() + printTwoCents() + printOneCent();
        if(changeMessage.isEmpty()){
            changeMessage = "No change.";
        }
        return changeMessage;
    }

    private String printOneCent() {
        return printCoins("one cent coin", this.oneCent);
    }

    private String printTwoCents() {
        return printCoins("two cents coin", this.twoCents);
    }

    private String printFiveCents() {
        return printCoins("five cents coin", this.fiveCents);
    }

    private String printTenCents() {
        return printCoins("ten cents coin", this.tenCents);
    }

    private String printTwentyCents() {
        return printCoins("twenty cents coin", this.twentyCents);
    }

    private String printFiftyCents() {
        return printCoins("fifty cents coin", this.fiftyCents);
    }

    private String printOneEuro() {
        return printCoins("one euro coin", this.oneEuro);
    }

    private String printTwoEuros() {
        return printCoins("two euro coin", this.twoEuros);
    }


    protected void calculateChange(Integer change) {
        while(change > 0){
            if(change >= TWO_EUROS){
                change -= TWO_EUROS;
                this.addTwoEuros();
            } else if(change >= ONE_EURO){
                change -= ONE_EURO;
                this.addOneEuro();
            } else if(change >= FIFTY_CENTS) {
                change -= FIFTY_CENTS;
                this.addFiftyCents();
            } else if(change >= TWENTY_CENTS) {
                change -= TWENTY_CENTS;
                this.addTwentyCents();
            } else if(change >= TEN_CENTS){
                change -= TEN_CENTS;
                this.addTenCents();
            } else if (change >= FIVE_CENTS) {
                change -= FIVE_CENTS;
                this.addFiveCents();
            } else if (change >= TWO_CENTS){
                change -= TWO_CENTS;
                this.addTwoCents();
            } else if (change >= ONE_CENT){
                change -= ONE_CENT;
                this.addOneCent();
            }
        }
    }

    private void addOneCent() {
        this.setOneCent(this.oneCent + 1);
    }

    private void addTwoCents() {
        this.setTwoCents(this.twoCents + 1);
    }

    private void addFiveCents() {
        this.setFiveCents(this.fiveCents + 1);
    }

    private void addTenCents() {
        this.setTenCents(this.tenCents + 1);
    }

    private void addTwentyCents() {
        this.setTwentyCents(this.twentyCents + 1);
    }

    private void addFiftyCents() {
        this.setFiftyCents(this.fiftyCents + 1);
    }

    private void addOneEuro() {
        this.setOneEuro(this.oneEuro + 1);
    }

    private void addTwoEuros() {
        this.setTwoEuros(this.twoEuros + 1);
    }

    protected void setOneCent(int oneCent) {
        this.oneCent = oneCent;
    }

    protected void setTwoCents(int twoCents) {
        this.twoCents = twoCents;
    }

    protected void setFiveCents(int fiveCents) {
        this.fiveCents = fiveCents;
    }

    protected void setTenCents(int tenCents) {
        this.tenCents = tenCents;
    }

    protected void setTwentyCents(int twentyCents) {
        this.twentyCents = twentyCents;
    }

    protected void setFiftyCents(int fiftyCents) {
        this.fiftyCents = fiftyCents;
    }

    protected void setOneEuro(int oneEuro) {
        this.oneEuro = oneEuro;
    }

    protected void setTwoEuros(int twoEuros) {
        this.twoEuros = twoEuros;
    }
}
