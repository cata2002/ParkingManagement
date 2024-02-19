package models;

public class ParkingSlotReservation extends RegularPass{
    private String reserveTime;
    private String startTime;
    private String leaveTime;

    public ParkingSlotReservation(int id, int customerId, String startDate, String purchaseDate, double cost, String reserveTime, String startTime, String leaveTime) {
        super(id, customerId, startDate, purchaseDate, cost);
        this.reserveTime = reserveTime;
        this.startTime = startTime;
        this.leaveTime = leaveTime;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
}
