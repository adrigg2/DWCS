package com.adrian;

public class Radio extends SmartAppliance {
    private float frequency;

    public Radio() {
        frequency = 88.0f;
    }

    @Override
    public boolean raise() {
        if (frequency < 104.0f) {
            frequency += 0.1f;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean lower() {
        if (frequency > 88.0f) {
            frequency -= 0.1f;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reset() {
        frequency = 88.0f;
    }

    @Override
    public String checkState() {
        return "Radio with frequency " + frequency + "Hz.";
    }
}
