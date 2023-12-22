package com.example.airlineticketmanagementsys;

import java.sql.Time;
import java.util.Date;

public class flight {
    public int getFlightNo() {
        return flightNo;
    }
    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public String getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
    public String getDepartFrom() {
        return departFrom;
    }
    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }
    public String getArriveTo() {
        return arriveTo;
    }
    public void setArriveTo(String arriveTo) {
        this.arriveTo = arriveTo;
    }
    public String getAirlineName() {
        return airlineName;
    }
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    public Time getDetartTime() {
        return detartTime;
    }
    public void setDetartTime(Time detartTime) {
        this.detartTime = detartTime;
    }
    private Time detartTime;
    public Time getArriveTime() {
        return arriveTime;
    }
    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    private int flightNo;
    private Date arrivalDate;
    private String departureDate;
    private  String departFrom;
    private String arriveTo;
    private String airlineName;
    private Time arriveTime;
    private String time;

}
