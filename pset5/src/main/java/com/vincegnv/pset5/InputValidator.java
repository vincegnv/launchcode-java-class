package com.vincegnv.pset5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vince on 6/20/2014.
 */
public class InputValidator {
    private final List<String> CurrencySymbols;
    private static InputValidator inputValidator;

    private InputValidator(){
        CurrencySymbols = new ArrayList<String>(){{add("$");add("€");}};
    }

    public static InputValidator getInstance(){
        if(inputValidator == null){
            inputValidator = new InputValidator();
        }
        return inputValidator;
    }


    public boolean isValidCurrencyAmount(String input){
        if(hasCurrencySymbol(input) && input.length() > 1){
            //remove the currency symbol
            input = input.substring(1);
            int decimalPointEncounters = 0;

            for(int i = 0; i<input.length(); i++){
                char symbol = input.charAt(i);
                if(!isDigit(symbol) && !isDecimalPoint(symbol)){
                    return false;
                }else if(isDecimalPoint(symbol)){
                    decimalPointEncounters++;
                    if(decimalPointEncounters > 1){
                        return false;
                    }
                }
            }
        } else{
            return false;
        }
        return true;
    }


    public boolean hasCurrencySymbol(String input){
        if(CurrencySymbols.contains(input.substring(0,1))){
            return true;
        }
        return false;
    }
    
    private boolean isDigit(char symbol){
        if(Character.isDigit(symbol)){
            return true;
        } else{
            return false;
        }
    }

    private boolean isDecimalPoint(char symbol){
        if(symbol == '.'){
            return true;
        } else{
            return false;
        }
    }
}
