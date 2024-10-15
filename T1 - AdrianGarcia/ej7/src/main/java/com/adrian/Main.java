package com.adrian;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce a string: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (!letterCount.containsKey(character)) {
                letterCount.put(character, 1);
            } else {
                letterCount.replace(character, letterCount.get(character) + 1);
            }
        }

        System.out.println(letterCount);
    }
}