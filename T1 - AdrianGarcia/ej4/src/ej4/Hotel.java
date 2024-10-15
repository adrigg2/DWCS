package ej4;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Room> rooms;

    public Hotel() {
        rooms = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            rooms.add(new Room(RoomType.LOWCOST));
        }

        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(RoomType.DOUBLE));
        }

        for (int i = 0; i < 5; i++) {
            rooms.add(new Room(RoomType.SUITE));
        }
    }

    public void checkIn(Scanner input) {
        System.out.println("Choose the room type for check-in.");
        Room lowcost = null;
        Room doubleRoom = null;
        Room suite = null;
        for (Room room : rooms) {
            if (!room.getOccupied()) {
                if (room.getType() == RoomType.LOWCOST) {
                    lowcost = room;
                } else if (room.getType() == RoomType.DOUBLE) {
                    doubleRoom = room;
                } else {
                    suite = room;
                }
            }
        }

        if (lowcost != null) {
            System.out.println("1. Lowcost room.");
        }

        if (doubleRoom != null) {
            System.out.println("2. Double room");
        }

        if (suite != null) {
            System.out.println("3. Suite");
        }

        int option = 0;
        option = input.nextInt();

        if (option == 1) {
            lowcost.checkIn();
        } else if (option == 2) {
            doubleRoom.checkIn();
        } else if (option == 3) {
            suite.checkIn();
        }
    }

    public int checkOut(Scanner input) {
        System.out.println("Choose the room type for check-in.");
        ArrayList<Room> occupiedRooms = new ArrayList<>();
        
        for (Room room : rooms) {
            if (room.getOccupied()) {
                occupiedRooms.add(room);
            }
        }

        for (int i = 0; i < occupiedRooms.size(); i++) {
            Room room = occupiedRooms.get(i);
            System.out.println((i + 1) + ". " + room.getType() + " " + room.getcheckInDate());
        }

        System.out.println("Select a room by number");

        int option = 0;
        option = input.nextInt();
        Room room = occupiedRooms.get(option);
        return room.checkOut();
    }
}
