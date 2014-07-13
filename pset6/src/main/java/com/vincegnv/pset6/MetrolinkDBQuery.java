package com.vincegnv.pset6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vince on 7/6/2014.
 */
public class MetrolinkDBQuery {

    public static final String SQLITE_CLASS_NAME = "org.sqlite.JDBC";
    public static final boolean CONNECTED = true;
    public static final boolean NOT_CONNECTED = false;

    private Connection connection;

    public MetrolinkDBQuery(){
        connection = null;
    }

    public boolean connect(String dbPath) {
        try {
            String url = "jdbc:sqlite:" + dbPath;
            Class.forName(SQLITE_CLASS_NAME);
            this.connection = DriverManager.getConnection(url);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return NOT_CONNECTED;
        }
        return CONNECTED;
    }

    public List<String> getStations(){
        List<String> stations = new ArrayList<String>();

        if(this.connection != null){
            String sql = "SELECT DISTINCT stop_name FROM metrolink_stops;";
            PreparedStatement listAllStations = null;
            ResultSet resultSet = null;

            try{
                listAllStations = this.connection.prepareStatement(sql);
                resultSet = listAllStations.executeQuery();
                stations = convertResultSetToList(resultSet);
            }catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    close(listAllStations);
                    close(resultSet);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return stations;
    }

    public List<String> getArrivalTimesSorted(String currentStation){
        List<String> arrivalTimes = new ArrayList<String>();
        if(this.connection != null){
            String sql = String.format("SELECT arrival_time FROM metrolink_stops WHERE stop_name=\"%s\" ORDER BY arrival_time;", currentStation);
            PreparedStatement listAllArrivalTimes = null;
            ResultSet resultSet = null;

            try{
                listAllArrivalTimes = this.connection.prepareStatement(sql);
                resultSet = listAllArrivalTimes.executeQuery();
                arrivalTimes = convertResultSetToList(resultSet);
            }catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    close(listAllArrivalTimes);
                    close(resultSet);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrivalTimes;
    }

    private List<String> convertResultSetToList(ResultSet resultSet) throws SQLException {
        List<String> list = new ArrayList<String>();
        while(resultSet.next()){
            list.add(resultSet.getString(1));
        }

        return list;
    }

    private void close(AutoCloseable wrapper) throws Exception {
        if(wrapper != null){
            wrapper.close();
        }
    }
}
