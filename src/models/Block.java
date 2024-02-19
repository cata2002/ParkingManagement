package models;

public class Block {
    private int parkingLotID;
    private int numberOfFloors;
    private boolean isFull;
    private int id;

    public Block() {
    }

    public Block(int parkingLotID, int numberOfFloors, boolean isFull, int id) {
        this.parkingLotID = parkingLotID;
        this.numberOfFloors = numberOfFloors;
        this.isFull = isFull;
        this.id = id;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String createBlock(String tableName){
        String insertQuery="insert into "+tableName+" values("+null+","+this.getNumberOfFloors()+","+this.isFull+","+this.getId()+")";
        return insertQuery;
    }
}
