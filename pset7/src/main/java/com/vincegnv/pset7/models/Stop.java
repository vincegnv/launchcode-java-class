package com.vincegnv.pset7.models;

import javax.persistence.*;

/**
 * Created by Vince on 8/3/2014.
 */
@Entity
@Table(name="metrolink_stops")
public class Stop {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "stop_name")
    private String stopName;

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }
}
