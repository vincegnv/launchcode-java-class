package com.vincegnv.pset5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * User: vincegnv
 * Date: 6/18/14
 * Time: 3:05 AM
 */
public class Greedy {

    private InputValidator validator;
    private CoinCalculator coinCalculator;
    private Scanner in;


    public static void main(String[] varArgs) {
        System.out.println("Welcome to Greedy Change Calculator");

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Greedy obj = (Greedy) context.getBean("greedy");
        obj.start();
    }

    public Greedy(){
        in = new Scanner(System.in);
    }

    public void setValidator(InputValidator validator) {
        this.validator = validator;
    }

    public void setCoinCalculator(CoinCalculator coinCalculator) {
        this.coinCalculator = coinCalculator;
    }

    public void start(){

        String anotherCalculation;
        do {
            String amountOfChange = getChange();

            if(isCurrencyUS(amountOfChange)){
                coinCalculator.setCoinStack(new CoinStackUS());
            } else{
                coinCalculator.setCoinStack(new CoinStackEuro());
            }

            coinCalculator.printChange(amountOfChange);

            anotherCalculation = getChoice();

            if(anotherCalculation.compareToIgnoreCase("y") != 0){
                System.out.println("Thank you for using Greedy Change Calculator!");
            }
        } while(anotherCalculation.compareToIgnoreCase("y") == 0);



    }

    private boolean isCurrencyUS(String amountOfChange){
        if(getCurrencySign(amountOfChange).compareToIgnoreCase("$") == 0){
            return true;
        }
        return false;
    }

    private String getCurrencySign(String amountOfChange){
        return amountOfChange.substring(0,1);
    }

    private String getChoice(){

        String choice = "";
        do {
            System.out.print("Do you want to do one more change calculation? Press 'y' for YES or 'n' for NO.");
            if (in.hasNext()) {
                choice = in.next();
            } else {
                in.next();
            }
            in.nextLine();
        } while(choice.compareToIgnoreCase("y") != 0 && choice.compareToIgnoreCase("n") != 0);
        return choice;
    }

    private String getChange(){
        String change = "";
        do {
            System.out.print("Enter change (use $ for US currency or € for EU currency): ");
            if (in.hasNext()) {
                change = in.next();
            } else {
                in.next();
            }
            in.nextLine();
        } while (!validator.isValidCurrencyAmount(change));
        return change;
    }

}
