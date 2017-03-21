package com.aquario.data.model;


import java.util.Date;
import java.util.List;

public class AquarioData {

    private String currentTime;
    private String currentDate;
    private String currentDay;
    private String currentTankTemp;
//    private List<DaySchedule> currentLightsSchedule;
//    private List<DaySchedule> currentCo2Schedule;

    public AquarioData(String currentTime,
                       String currentDate,
                       String currentDay,
                       String currentTankTemp) {
        this.currentTime = currentTime;
        this.currentDate = currentDate;
        this.currentDay = currentDay;
        this.currentTankTemp = currentTankTemp;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }

    public String getCurrentTankTemp() {
        return currentTankTemp;
    }

    public void setCurrentTankTemp(String currentTankTemp) {
        this.currentTankTemp = currentTankTemp;
    }
//
//    public List<DaySchedule> getCurrentLightsSchedule() {
//        return currentLightsSchedule;
//    }
//
//    public void setCurrentLightsSchedule(List<DaySchedule> currentLightsSchedule) {
//        this.currentLightsSchedule = currentLightsSchedule;
//    }
//
//    public List<DaySchedule> getCurrentCo2Schedule() {
//        return currentCo2Schedule;
//    }
//
//    public void setCurrentCo2Schedule(List<DaySchedule> currentCo2Schedule) {
//        this.currentCo2Schedule = currentCo2Schedule;
//    }
}
