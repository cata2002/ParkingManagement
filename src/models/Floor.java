package models;

public class Floor {
    private int id;
    private int blockId;
    private int floorNumber;
    private int numberOfFloors;
    private int maxHeight;
    private boolean isFull;

    public Floor() {
    }

    public Floor(int id, int blockId, int floorNumber, int numberOfFloors, int maxHeight, boolean isFull) {
        this.id = id;
        this.blockId = blockId;
        this.floorNumber = floorNumber;
        this.numberOfFloors = numberOfFloors;
        this.maxHeight = maxHeight;
        this.isFull = isFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public String createFloor(String tableName){
        String insertQuery="insert into "+tableName+" values("+this.getId()+","+null+","+this.getFloorNumber()+","+this.getNumberOfFloors()+","+this.getMaxHeight()+","+this.isFull+")";
        return insertQuery;
    }
}
