package ej4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        Scanner input = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Check-in\n2. Check-out\n3. Exit");
            int option = input.nextInt();
            if (option == 1) {
                hotel.checkIn(input);
            } else if (option == 2) {
                System.out.println("You have to pay " + hotel.checkOut(input) + "€");
            } else {
                exit = true;
            }
        }
        input.close();
    }
}
