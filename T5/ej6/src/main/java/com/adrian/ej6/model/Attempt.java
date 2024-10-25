package com.adrian.ej6.model;

public class Attempt {

    private String combination;
    private int correctlyPlaced;
    private int wronglyPlaced;

    public Attempt(String combination, int correctlyPlaced, int wronglyPlaced) {
        this.combination = combination;
        this.correctlyPlaced = correctlyPlaced;
        this.wronglyPlaced = wronglyPlaced;
    }

    public String getCombination() {
        return combination;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public int getCorrectlyPlaced() {
        return correctlyPlaced;
    }

    public void setCorrectlyPlaced(int correctlyPlaced) {
        this.correctlyPlaced = correctlyPlaced;
    }

    public int getWronglyPlaced() {
        return wronglyPlaced;
    }

    public void setWronglyPlaced(int wronglyPlaced) {
        this.wronglyPlaced = wronglyPlaced;
    }

}
