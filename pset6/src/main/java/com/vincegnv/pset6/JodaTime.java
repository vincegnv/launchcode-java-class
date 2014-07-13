package com.vincegnv.pset6;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;

import java.util.*;

/**
 * Created by Vince on 7/10/2014.
 */
public class JodaTime {

    public DateTime currentTime(){
        return new DateTime();
    }

    protected List<DateTime> convertStringListToLocalTimeList(List<String> timesAsString) {
        List<DateTime> timesAsDateTime = new ArrayList<DateTime>();
        DateTime now = new DateTime();
        for(String timeString : timesAsString){
            if(isHourBiggerThen23(timeString)) {
                timeString = subtract24Hours(timeString);
            }
            LocalTime timeAsLocalTime = LocalTime.parse(timeString);
            timesAsDateTime.add(now.withFields(timeAsLocalTime));
        }

        return timesAsDateTime;
    }

    protected String subtract24Hours(String timeString) {
        String[] timeArray = timeString.split(":");
        int hour = Integer.parseInt(timeArray[0]) - 24;
        timeArray[0] = Integer.toString(hour);
        String newTime = Arrays.toString(timeArray);
        newTime = newTime.substring(1, newTime.length() - 1).replace(',', ':').replace(" ", "");

        return newTime;
    }

    protected boolean isHourBiggerThen23(String time) {
        String[] timeArray = time.split(":");
        return Integer.parseInt(timeArray[0]) > 23;
    }


}
