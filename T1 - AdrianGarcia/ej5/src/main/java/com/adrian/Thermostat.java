package com.adrian;

import java.time.LocalDate;

public class Thermostat extends SmartAppliance {
    private LocalDate lastRevision;
    private int temperature;

    public Thermostat() {
        temperature = 20;
    }

    @Override
    public boolean raise() {
        if (temperature < 80) {
            temperature++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean lower() {
        if (temperature > 15) {
            temperature--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reset() {
        temperature = 20;
    }

    @Override
    public String checkState() {
        return "Thermostat with " + temperature + "ºC. Last revised at " + lastRevision;
    }

    public void revise() {
        lastRevision = LocalDate.now();
    }
}
