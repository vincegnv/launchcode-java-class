package com.vincegnv.pset4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.util.Scanner;


/**
 * Created by Vince on 5/25/2014.
 */
public class Mario {
    static final int MAX_HEIGHT = 23;
    private Printer printer;
    private ShapeBuilder shapeBuilder;

    public static void main(String[] args){

        System.out.println("Welcome to Mario world!");

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Mario obj = (Mario)context.getBean("mario");
        obj.start();

//        Mario mario = new Mario(ShapeBuilder.getInstance(), Printer.getInstance());
//        mario.start();
    }

    public Mario(ShapeBuilder shapeBuilder, Printer printer) {
        this.shapeBuilder = shapeBuilder;
        this.printer = printer;
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        String choice = "";

        do {
            int height = -1;
            //validate
            do {
                System.out.print(String.format("\nEnter the pyramid's height (0-%s): ", MAX_HEIGHT));
                if (in.hasNextInt()) {
                    height = in.nextInt();
                } else {
                    in.next();
                }
                in.nextLine();
            } while (height < 0 || height > MAX_HEIGHT);

            Pyramid pyramid = shapeBuilder.pyramid(height);

            //ask the user to make a choice for print
            System.out.println("\nDo you want to print the half pyramid to the console or to a text file?");
            do {
                System.out.print("Press 'c' for console or 'f' for file: ");
                choice = in.next();
            } while (choice.compareToIgnoreCase("c") != 0 && choice.compareToIgnoreCase("f") != 0);

//            ShapePrinter pyramidPrinter;
            if(choice.compareToIgnoreCase("c") == 0){
                printer.setPrinter(ConsolePrinter.getInstance());
            } else {
                printer.setPrinter(FilePrinter.getInstance("pyramid.txt"));
            }
            printer.print(pyramid);
            //ask the user if he wants to build another
            System.out.println("\nDo you want to build another half pyramid?");
            do {
                System.out.print("Press 'n' to exit or 'y' to build another pyramid: ");
                choice = in.next();
            } while(choice.compareToIgnoreCase("n") != 0 && choice.compareToIgnoreCase("y") != 0);
        } while(choice.compareToIgnoreCase("y") == 0);

    }

}

