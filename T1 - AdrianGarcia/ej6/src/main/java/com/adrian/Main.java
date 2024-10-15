package com.adrian;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Primitiva primitiva = new Primitiva();
        TreeSet<Integer> guesses = new TreeSet<>();

        System.out.println("Introduce yout guesses, one by one, and without repeating numbers:\n");

        while (guesses.size() < 6) {
            guesses.add(input.nextInt());
        }

        System.out.println("Correct guesses: " + primitiva.tryCombination(guesses));
    }
}