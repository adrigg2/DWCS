package com.adrian.ej6;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.adrian.ej6.model.GameState;
import com.adrian.ej6.model.Attempt;
import com.adrian.ej6.model.MasterMind;

@Service
@Scope("session")
public class MasterMindService {

    public MasterMind masterMind = new MasterMind();

    public void newGame() {
        do {
            masterMind.setSecretNumber(randomString(masterMind.getNumSize()));
        } while (stringWithDuplicated(masterMind.getSecretNumber()));
        masterMind.getAttemptList().clear();
        masterMind.setGameState(GameState.PLAYING);
        System.out.println("=====> Num secreto: " + masterMind.getSecretNumber());
    }

    public void checkAttempt(String attempt) {
        if (masterMind.getGameState() != GameState.PLAYING)
            return;
        if (stringWithDuplicated(attempt) || attempt.length() != masterMind.getNumSize())
            return;

        int correctlyPlaced = 0, wronglyPlaced = 0;
        String secretNumber = masterMind.getSecretNumber();
        for (int i = 0; i < attempt.length(); i++) {
            char letter = attempt.charAt(i);
            if (letter == secretNumber.charAt(i))
                correctlyPlaced++;
            else if (secretNumber.indexOf(letter) != -1)
                wronglyPlaced++;
        }
        masterMind.getAttemptList().add(new Attempt(attempt, correctlyPlaced, wronglyPlaced));
        if (correctlyPlaced == masterMind.getNumSize())
            masterMind.setGameState(GameState.WON);
        if (masterMind.getAttemptList().size() >= masterMind.getMaxAttempts())
            masterMind.setGameState(GameState.LOST);
    }

    private boolean stringWithDuplicated(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c, i + 1) != -1)
                return true;
        }
        return false;
    }

    private String randomString(int size) {
        Random random = new Random();
        String str = "";
        int x;
        for (int i = 0; i < size; i++) {
            x = random.nextInt(10);
            str += Integer.toString(x);
        }
        return str;
    }
}
