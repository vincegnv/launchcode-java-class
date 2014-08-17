package com.vincegnv.pset7;

import org.joda.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vince on 7/8/2014
 */
@Component
public class HelpDesk {
    @Autowired
    private MetrolinkDBQuery query;
    @Autowired
    private JodaTime jodaTime;

    public HelpDesk(){}

    public void setQuery(MetrolinkDBQuery query) {
        this.query = query;
    }

    public void setJodaTime(JodaTime jodaTime) {
        this.jodaTime = jodaTime;
    }

    public List<String> listStations() {
        return query.getStations();
    }

    public String printTimeToNextArrival(String stationName){
        Period period = timeToNextArrival(stationName);
        StringBuilder message = new StringBuilder();
        message.append("The next arrival will be in ");
        if(period.getHours() > 0){
            message.append(String.format("%d hours, ", period.getHours()));
        }
        if(period.getMinutes() > 0){
            message.append(String.format("%d minutes ", period.getMinutes()));
        }
        if(period.getHours() > 0 || period.getMinutes() > 0){
            message.append("and ");
        }
        message.append(String.format("%d seconds.", period.getSeconds()));

        return message.toString();
    }

    protected Period timeToNextArrival(String stationName) {
        List<String> arrivalTimes = query.getArrivalTimesSorted(stationName);
        DateTime currentTime = jodaTime.currentTime();
        DateTime nextArrivalTime = findNextArrivalTime(arrivalTimes);
        Period periodToNextArrival = new Period(currentTime, nextArrivalTime);

        return periodToNextArrival;
    }

    protected DateTime findNextArrivalTime(List<String> arrivalTimes){
        DateTime nextArrivalTime = null;
        boolean isNextArrivalTommorow = true;
        if(arrivalTimes != null) {
            List<DateTime> times = jodaTime.convertStringListToLocalTimeList(arrivalTimes);
            Collections.sort(times);
            nextArrivalTime = times.get(0);
            DateTime currentTime = jodaTime.currentTime();

            for(DateTime time : times){
                if(currentTime.compareTo(time) < 0){
                    nextArrivalTime = time;
                    isNextArrivalTommorow = false;
                    break;
                }
            }
        }
        if(isNextArrivalTommorow){
            nextArrivalTime = nextArrivalTime.plus(Period.days(1));//using Period fixes the problem with daylight time change
        }
        return nextArrivalTime;
    }




}