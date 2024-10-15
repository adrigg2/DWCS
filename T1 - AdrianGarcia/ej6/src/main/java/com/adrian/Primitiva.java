package com.adrian;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class Primitiva {
    TreeSet<Integer> results;

    public Primitiva() {
        Random random = new Random(1);
        results = new TreeSet<>();
        while (results.size() < 6) {
            results.add(random.nextInt(49) + 1);
        }
    }

    public int tryCombination(TreeSet<Integer> combination) {
        if (combination.size() != 6) {
            return 0;
        }

        int rightGuesses = 0;
        Iterator<Integer> correctGuesses = results.iterator();
        Iterator<Integer> triedGuesses = combination.iterator();
        
        while (correctGuesses.hasNext()) {
            if (correctGuesses.next() == triedGuesses.next()) {
                rightGuesses++;
            }
        }
        return rightGuesses;
    }
}
