package com.vincegnv.pset6;
import static org.mockito.Mockito.*;

import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;

import java.util.ArrayList;
import java.util.List;

public class HelpDeskTest extends TestCase {
    private static final String DB_PATH = "src/database/Metrolink.db";
    private static final boolean CONNECTED = true;
    private static final boolean NOT_CONNECTED = false;
    private static final int NUMBER_OF_DISTINCT_METRO_LINK_STOPS = 37;
    private HelpDesk helpDesk;
    private  JodaTime jodaTime;
    private MetrolinkDBQuery query;
    private JodaTime spyJodaTime;
    private MetrolinkDBQuery spyQuery;
    private List<String> mockArrivalTimes;

    public void testConnectToDBShouldReturnCONNECTED() throws Exception {
        HelpDesk helpDesk = new HelpDesk();
        helpDesk.setQuery(new MetrolinkDBQuery());

        assertEquals(CONNECTED, helpDesk.connectToDB(DB_PATH));
    }

    public void testListStations() throws Exception {
        setup();

        assertEquals(NUMBER_OF_DISTINCT_METRO_LINK_STOPS, helpDesk.listStations().size());
    }

    public void testFindNextArrivalTimeShouldReturn19() throws Exception {
        setup();
        mockCurrentTime("6:00:00");

        assertEquals(stringToDateTime("19:00:00"), helpDesk.findNextArrivalTime(mockArrivalTimes));
    }

    public void testFindNextArrivalTimeShouldReturn1() throws Exception {
        setup();
        mockCurrentTime("21:00:00");

        assertEquals(stringToDateTime("01:00:00.000").plus(Period.days(1)), helpDesk.findNextArrivalTime(mockArrivalTimes));
    }

    public void testFindNextArrivalTimeShouldReturn5() throws Exception {
        setup();
        List<String> arrivalTimes = loadArrivalTimesList();
        mockCurrentTime("2:00:00");

        assertEquals(stringToDateTime("05:00:00.000"), helpDesk.findNextArrivalTime(arrivalTimes));
    }

    public void testTimeToNextArrivalShouldReturn60() throws Exception {
        setup();
        mockCurrentTime("4:00:00");
        setupSpies();


        assertEquals(Period.minutes(60).toStandardDuration(), helpDesk.timeToNextArrival("mockStation").toStandardDuration());
    }

    public void testTimeToNextArrivalShouldReturn120() throws Exception {
        setup();
        mockCurrentTime("3:00:00");
        setupSpies();

        assertEquals(Period.minutes(120).toStandardDuration(), helpDesk.timeToNextArrival("mockStation").toStandardDuration());
    }

    public void testTimeToNextArrivalShouldReturn90() throws Exception {
        setup();
        mockCurrentTime("23:30:00");
        setupSpies();

        assertEquals(Period.minutes(90).toStandardDuration(), helpDesk.timeToNextArrival("mockStation").toStandardDuration());
    }

    public void testTimeToNextArrivalShouldReturn30() throws Exception {
        setup();
        mockCurrentTime("00:30:00");
        setupSpies();

        assertEquals(Period.minutes(30).toStandardDuration(), helpDesk.timeToNextArrival("mockStation").toStandardDuration());
    }

    public void testPrintTimeToNextArrival1() throws Exception{
        setup();
        setupSpies();
        mockCurrentTime("12:35:30");

        assertEquals("The next arrival will be in 6 hours, 24 minutes and 30 seconds.", helpDesk.printTimeToNextArrival("mockStation"));
    }

    public void testPrintTimeToNextArrival2() throws Exception{
        setup();
        setupSpies();
        mockCurrentTime("18:35:30");

        assertEquals("The next arrival will be in 24 minutes and 30 seconds.", helpDesk.printTimeToNextArrival("mockStation"));
    }

    public void testPrintTimeToNextArrival3() throws Exception{
        setup();
        setupSpies();
        mockCurrentTime("18:59:30");

        assertEquals("The next arrival will be in 30 seconds.", helpDesk.printTimeToNextArrival("mockStation"));
    }

    private void setupSpies() {
        spyQuery = spy(query);
        helpDesk.setQuery(spyQuery);
        when(spyQuery.getArrivalTimesSorted("mockStation")).thenReturn(mockArrivalTimes);
    }

    private void setup(){
        helpDesk = new HelpDesk();
        query = new MetrolinkDBQuery();
        helpDesk.setQuery(query);
        jodaTime = new JodaTime();
        helpDesk.connectToDB(DB_PATH);
        mockArrivalTimes = loadArrivalTimesList();
    }

    private List<String> loadArrivalTimesList(){
        List<String> arrivalTimes = new ArrayList<String>();
        arrivalTimes.add("5:00:00");
        arrivalTimes.add("6:00:00");
        arrivalTimes.add("19:00:00");
        arrivalTimes.add("20:00:00");
        arrivalTimes.add("25:00:00");
        return arrivalTimes;
    }
    private void mockCurrentTime(String time){
        spyJodaTime = spy(jodaTime);
        helpDesk.setJodaTime(spyJodaTime);
        DateTime mockTime = stringToDateTime(time);
        when(spyJodaTime.currentTime()).thenReturn(mockTime);
    }

    private DateTime stringToDateTime(String time){
        LocalTime localTime = LocalTime.parse(time);
        return new DateTime().withFields(localTime);
    }



}