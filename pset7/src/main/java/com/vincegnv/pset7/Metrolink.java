package com.vincegnv.pset7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Vince on 7/6/2014.
 */
@Component
public class Metrolink {
    private Scanner in;

    private List<String> stations;
    @Autowired
    protected HelpDesk helpDesk;

    public Metrolink(){
        this.in = new Scanner(System.in);
    }

    public static void main(String[] args){
        System.out.println("Welcome to MetroLink");

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Metrolink obj = (Metrolink) context.getBean("metrolink");
        obj.start();
    }

    private void start() {
            stations = helpDesk.listStations();
            if(!stations.isEmpty()) {
                printStations(stations);
                int currentStationNumber = askUserForStationNumber(stations.size());
                String currentStationName = stations.get(currentStationNumber - 1);
                System.out.println(helpDesk.printTimeToNextArrival(currentStationName));
            }
    }

    private int askUserForStationNumber(int lastStationNumber) {
        int stationNumber = 0;
        do {
            System.out.print(String.format("\nEnter the station that you are at (1-%d): ", lastStationNumber));
            if (in.hasNextInt()) {
                stationNumber = in.nextInt();
            } else {
                in.next();
            }
            in.nextLine();
        } while(stationNumber <= 0 || stationNumber > lastStationNumber);
        return stationNumber;
    }

    private void printStations(List<String> stations){
        for (int i = 0; i < stations.size(); i++) {
            System.out.println(String.format("%d. %s", i + 1, stations.get(i)));
        }
    }

}