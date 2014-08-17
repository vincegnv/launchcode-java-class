package com.vincegnv.pset7.models;

import javax.persistence.*;

/**
 * Created by Vince on 8/13/2014.
 */

@Entity
@Table(name="metrolink_stops")
public class ArrivalTime {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name="stop_name")
    private String stopName;
    @Column(name = "arrival_time")
    private String arrivalTime;

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }
}
