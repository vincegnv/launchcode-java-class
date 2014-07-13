package com.vincegnv.pset6;

import junit.framework.TestCase;

public class MetrolinkDBQueryTest extends TestCase {
    private static final String DB_PATH = "src/database/Metrolink.db";
    private static final boolean CONNECTED = true;
    private static final int NUMBER_OF_DISTINCT_METRO_LINK_STOPS = 37;

    public void testConnectWithDB() throws Exception {
        MetrolinkDBQuery query = new MetrolinkDBQuery();
        assertEquals(CONNECTED, query.connect(DB_PATH));
    }

    public void testGetListOfStations() throws Exception {
        MetrolinkDBQuery query = new MetrolinkDBQuery();
        query.connect(DB_PATH);

        assertEquals(NUMBER_OF_DISTINCT_METRO_LINK_STOPS, query.getStations().size());
    }
}