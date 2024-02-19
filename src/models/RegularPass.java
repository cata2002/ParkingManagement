package models;

public class RegularPass {
    private int id;
    private int customerId;
    private String startDate;
    private String purchaseDate;
    private double cost;

    public RegularPass() {
    }

    public RegularPass(int id, int customerId, String startDate, String purchaseDate, double cost) {
        this.id = id;
        this.customerId = customerId;
        this.startDate = startDate;
        this.purchaseDate = purchaseDate;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String createBlock(String tableName){
        String insertQuery="insert into "+tableName+" values("+this.getId()+","+this.getCustomerId()+','+null+","+null+","+this.getCost()+")";
        return insertQuery;
    }
}
