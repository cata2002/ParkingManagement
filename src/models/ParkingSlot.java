package models;

public class ParkingSlot {
    private int id;
    private int floorId;
    private int floorNumber;

    public ParkingSlot() {
    }

    public ParkingSlot(int id, int floorId, int floorNumber) {
        this.id = id;
        this.floorId = floorId;
        this.floorNumber = floorNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String createSlot(String tableName){
        String insertQuery="insert into "+tableName+" values("+this.getId()+","+this.getFloorId()+","+this.getFloorNumber()+")";
        return insertQuery;
    }
}
