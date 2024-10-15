package com.adrian;

public class Elevator extends SmartAppliance {
    private int currentFloor;

    public Elevator() {
        currentFloor = 0;
    }

    @Override
    public boolean raise() {
        if (currentFloor < 8) {
            currentFloor++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean lower() {
        if (currentFloor > 0) {
            currentFloor--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reset() {
        currentFloor = 0;
    }

    @Override
    public String checkState() {
        return "Elevator at floor " + currentFloor;
    }
    
}
