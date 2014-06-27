package com.vincegnv.pset4;

/**
 * Created by Vince on 6/19/2014.
 */
public class Printer{

    private ShapePrinter shapePrinter;

    private Printer() {}

    public void setPrinter(ShapePrinter shapePrinter){
        this.shapePrinter = shapePrinter;
    }

    public void print(PrintedShape shape){
        this.shapePrinter.print(shape);
    }
}
