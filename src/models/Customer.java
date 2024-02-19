package models;

import java.util.Locale;

public class Customer {
    private int id;
    private String vehicleNumber;
    private int contactNumber;

    public Customer() {
    }

    public Customer(int id, String vehicleNumber, int contactNumber) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String insertCustomer(String tableName){
        String col=this.vehicleNumber;
        String insert="insert into "+tableName+" values(2,1,123)";
        return insert;
    }
}
