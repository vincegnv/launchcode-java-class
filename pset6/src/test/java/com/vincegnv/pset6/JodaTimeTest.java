package com.vincegnv.pset6;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JodaTimeTest extends TestCase {

    public void testIsHourBiggerThen23ShouldReturnTrue() throws Exception{
        JodaTime jodaTime = new JodaTime();

        assertEquals(true, jodaTime.isHourBiggerThen23("24:00:00"));
    }

    public void testIsHourBiggerThen23ShouldReturnFalse() throws Exception{
        JodaTime jodaTime = new JodaTime();

        assertEquals(false, jodaTime.isHourBiggerThen23("22:00:00"));
    }

    public void testConvertStringListToLocalTimeList() throws Exception {
        JodaTime jodaTime = new JodaTime();
        List<String> arrivalTimesString = loadArrivalTimesListString();
        List<DateTime> arrivalTimesLocalTime = loadArrivalTimesListDateTime();

        assertEquals(arrivalTimesLocalTime, jodaTime.convertStringListToLocalTimeList(arrivalTimesString));
    }

    public void testSubtract24HoursShouldReturn1() throws Exception{
        JodaTime jodaTime = new JodaTime();

        assertEquals("1:00:00", jodaTime.subtract24Hours("25:00:00"));
    }

    private List<String> loadArrivalTimesListString(){
        List<String> arrivalTimes = new ArrayList<String>();
        arrivalTimes.add("5:00:00");
        arrivalTimes.add("6:00:00");
        arrivalTimes.add("19:00:00");
        arrivalTimes.add("20:00:00");
        arrivalTimes.add("25:00:00");
        return arrivalTimes;
    }

    private List<DateTime> loadArrivalTimesListDateTime(){
        List<DateTime> arrivalTimes = new ArrayList<DateTime>();
        arrivalTimes.add(stringToDateTime("5:00:00"));
        arrivalTimes.add(stringToDateTime("6:00:00"));
        arrivalTimes.add(stringToDateTime("19:00:00"));
        arrivalTimes.add(stringToDateTime("20:00:00"));
        arrivalTimes.add(stringToDateTime("1:00:00"));
        return arrivalTimes;
    }

    private DateTime stringToDateTime(String time){
        LocalTime localTime = LocalTime.parse(time);
        return new DateTime().withFields(localTime);
    }


}