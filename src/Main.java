import models.*;
import views.DatabaseMethods;
import views.ParkingView;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws java.sql.SQLException{
        String url = "jdbc:postgresql://localhost:5432/parking";
        String user = "postgres";
        String password = "cata2002";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();
        //String insert="insert into "
        String tableBlock = "\"public\".\"block\"";
        String tableCustomer= "\"public\".\"customer\"";
        String tableFloor= "\"public\".\"floor\"";
        String tablePass= "\"public\".\"regular_pass\"";
        Block b=new Block(1,4,false,6);
        Customer c=new Customer(1,"mama69",1234);
        Floor f=new Floor(3,5,2,2,200,false);
        RegularPass p=new RegularPass(1,1,"12-02-2022","13-02-2022",10);
        String insertQuery=b.createBlock(tableBlock);
        String insertCustomer=c.insertCustomer(tableCustomer);
        String insertFloor=f.createFloor(tableFloor);
        String insertPass=p.createBlock(tablePass);
        //String insertQuery="insert into "+tableName+" values("+null+","+2+","+false+","+1+")";
        //statement.execute(insertQuery);
        //statement.execute(insertCustomer);
        //statement.execute(insertFloor);
        //statement.execute(insertPass);
        //System.out.println("Hello world!");
        //Parking p1=new Parking();
        //System.out.println(p1.block3[6][6]);
        ParkingView park=new ParkingView();
        /*LocalDate date= LocalDate.now();
        String today=date.toString();
        LocalDateTime loc=LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.000000");
        //locGood.replace("T"," " );
        loc.plusHours(2);

        System.out.println(myFormatObj.format(loc.plusHours(2)));
        DatabaseMethods date1=new DatabaseMethods();*/
        //System.out.println(date1.getBlockHeight(1));
        //System.out.println(date.computeLastSlot());
        //String str=date.createReservation(1,1,"acum",2,"ieri","atuunci");
        //String str= date.createParkingLot(1,true,2,"acasa");
        //date.createCustomer(9,"mama12334",694200);
        //date.addSlot(1,1,1,1);
        //System.out.println(date.getLastCustomerId());
        /*ResultSet rs= statement.executeQuery(str);
        while(rs.next()){
            System.out.println(rs.getBoolean("is_full"));
        }*/
        //System.out.println(str);

    }
}