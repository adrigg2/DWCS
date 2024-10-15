package ej4;

public enum RoomType {
    LOWCOST(50),
    DOUBLE(100),
    SUITE(200);

    private int price;

    private RoomType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
