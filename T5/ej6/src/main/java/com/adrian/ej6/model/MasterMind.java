package com.adrian.ej6.model;

import java.util.ArrayList;

public class MasterMind {
    private String secretNumber;
    private ArrayList<Attempt> attemptList;
    private GameState gameState;
    private int numSize;
    private int maxAttempts;

    public MasterMind() {
        attemptList = new ArrayList<>();
    }

    public String getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    public ArrayList<Attempt> getAttemptList() {
        return attemptList;
    }

    public void setAttemptList(ArrayList<Attempt> attemptList) {
        this.attemptList = attemptList;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNumSize() {
        return numSize;
    }

    public void setNumSize(int numSize) {
        this.numSize = numSize;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }
}
