package com.adrian;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<SmartAppliance> smartAppliances = new ArrayList<>();
        smartAppliances.add(new Elevator());
        smartAppliances.add(new Radio());
        smartAppliances.add(new Thermostat());

        boolean exit = false;
        while (!exit) {
            System.out.println("0. Exit\n1. Raise an appliance\n2. Lower an appliance\n3. Reset an appliance\n4. Revise thermostat");
            int option = input.nextInt();
            if (option == 0) {
                exit = true;
            } else if (option == 1) {
                showMenu(smartAppliances);
                option = input.nextInt();
                smartAppliances.get(option).raise();
            } else if (option == 2) {
                showMenu(smartAppliances);
                option = input.nextInt();
                smartAppliances.get(option).lower();
            } else if (option == 3) {
                showMenu(smartAppliances);
                option = input.nextInt();
                smartAppliances.get(option).reset();;
            } else if (option == 4) {
                ((Thermostat) smartAppliances.get(2)).revise();
            }
        }
    }

    public static void showMenu(ArrayList<SmartAppliance> smartAppliances) {
        for (SmartAppliance smartAppliance : smartAppliances) {
            System.out.println(smartAppliances.indexOf(smartAppliance) + ". " + smartAppliance.checkState());
        }
    }
}