package com.vincegnv.pset7;

import java.util.List;

/**
 * Created by Vince on 7/6/2014.
 */

public interface MetrolinkDBQuery {
    public List<String> getStations();

    public List<String> getArrivalTimesSorted(String currentStation);

}