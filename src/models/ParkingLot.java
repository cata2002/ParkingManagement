package models;

public class ParkingLot {
    private boolean isAvailable;
    private int numberOfBlocks;
    private String Address;
    private int id;

    public ParkingLot() {
    }

    public ParkingLot(boolean isAvailable, int numberOfBlocks, String address, int id) {
        this.isAvailable = isAvailable;
        this.numberOfBlocks = numberOfBlocks;
        Address = address;
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getNumberOfBlocks() {
        return numberOfBlocks;
    }

    public void setNumberOfBlocks(int numberOfBlocks) {
        this.numberOfBlocks = numberOfBlocks;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String addToDatabase() {
        String toAdd="insert into ";
        return toAdd;
    }
}
