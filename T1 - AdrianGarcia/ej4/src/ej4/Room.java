package ej4;

import java.time.Instant;
import java.time.Duration;

public class Room {
    private RoomType type;
    private boolean occupied;
    private Instant checkInDate;

    public RoomType getType() {
        return type;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public Instant getcheckInDate() {
        return checkInDate;
    }

    public Room(RoomType type) {
        this.type = type;

        occupied = false;
    }

    public void checkIn() {
        occupied = true;
        checkInDate = Instant.now();
    }

    public int checkOut() {
        int days = (int) Duration.between(checkInDate, Instant.now()).getSeconds();

        if (type == RoomType.LOWCOST) {
            return type.getPrice() * days;
        } else if (type == RoomType.DOUBLE) {
            return type.getPrice() * days;
        } else if (type == RoomType.SUITE) {
            int returnPrice = type.getPrice() * days;
            if (days > 10) {
                returnPrice *= 0.8;
            }
            return returnPrice;
        }

        occupied = false;

        return 0;
    }
}
