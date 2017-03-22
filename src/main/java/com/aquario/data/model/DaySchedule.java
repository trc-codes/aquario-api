package com.aquario.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DaySchedule {

    private String type;
    private String day;
    private String firstStartTime;
    private String firstStopTime;
    private String secondStartTime;
    private String secondStopTime;

    public DaySchedule(@JsonProperty("type") String type,
                       @JsonProperty("day") String day,
                       @JsonProperty("firstStartTime") String firstStartTime,
                       @JsonProperty("firstStopTime") String firstStopTime,
                       @JsonProperty("secondStartTime") String secondStartTime,
                       @JsonProperty("secondStopTime") String secondStopTime) {
        this.type = type;
        this.day = day;
        this.firstStartTime = firstStartTime;
        this.firstStopTime = firstStopTime;
        this.secondStartTime = secondStartTime;
        this.secondStopTime = secondStopTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFirstStartTime() {
        return firstStartTime;
    }

    public void setFirstStartTime(String firstStartTime) {
        this.firstStartTime = firstStartTime;
    }

    public String getFirstStopTime() {
        return firstStopTime;
    }

    public void setFirstStopTime(String firstStopTime) {
        this.firstStopTime = firstStopTime;
    }

    public String getSecondStartTime() {
        return secondStartTime;
    }

    public void setSecondStartTime(String secondStartTime) {
        this.secondStartTime = secondStartTime;
    }

    public String getSecondStopTime() {
        return secondStopTime;
    }

    public void setSecondStopTime(String secondStopTime) {
        this.secondStopTime = secondStopTime;
    }
}
