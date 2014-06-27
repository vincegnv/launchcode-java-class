/**
 * Created by Vince on 5/28/2014.
 */

package com.vincegnv.pset4;

public class ConsolePrinter implements ShapePrinter {

//    private static ConsolePrinter consolePrinter;

    public ConsolePrinter(){
    }

//    public static ConsolePrinter getInstance(){
//        if(consolePrinter == null){
//            consolePrinter = new ConsolePrinter();
//        }
//        return consolePrinter;
//    }

    public void print(PrintedShape shape){
        System.out.print(shape);
    }
}
