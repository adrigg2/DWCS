package com.adrian.ej2;

import java.time.LocalDate;
import java.util.ArrayList;

public class DateForm {
    private LocalDate date1;
    private LocalDate date2;
    private Integer daysBetweenDates;
    private ArrayList<Integer> leapYears;
    private Integer yearsStartOnSunday;
    private State state;
    
    public LocalDate getDate1() {
        return date1;
    }
    
    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }
    
    public LocalDate getDate2() {
        return date2;
    }
    
    public void setDate2(LocalDate date2) {
        this.date2 = date2;
    }
    
    public Integer getDaysBetweenDates() {
        return daysBetweenDates;
    }
    
    public void setDaysBetweenDates(Integer daysBetweenDates) {
        this.daysBetweenDates = daysBetweenDates;
    }
    
    public ArrayList<Integer> getLeapYears() {
        return leapYears;
    }
    
    public void setLeapYears(ArrayList<Integer> leapYears) {
        this.leapYears = leapYears;
    }
    
    public Integer getYearsStartOnSunday() {
        return yearsStartOnSunday;
    }
    
    public void setYearsStartOnSunday(Integer yearsStartOnSunday) {
        this.yearsStartOnSunday = yearsStartOnSunday;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
