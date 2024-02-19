package views;

import java.sql.ResultSet;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatabaseMethods  {
    String url = "jdbc:postgresql://localhost:5432/parking";
    String user = "postgres";
    String password = "cata2002";
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Statement statement;

    {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createParkingLot(int id, boolean isAvailable, int nrOfBlocks, String address){
        String query=String.format("INSERT INTO public.parking_lot (id, is_available, number_of_blocks, address)\n" +
                "VALUES (DEFAULT, %b, %d, '%s')",isAvailable,nrOfBlocks,address);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createBlock(int parkingLotId, int numberOfFloors, boolean isFull, int id){
        String query=String.format("INSERT INTO public.block (parking_lot_id, number_of_floors, is_full, id)\n" +
                "VALUES (%d, %d, %b, DEFAULT)",parkingLotId,numberOfFloors,isFull);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLastCustomerId(){
        String query=String.format("select id from customer where id=(select max(id) from customer)");
        ResultSet rs=null;
        try {
            rs= statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                return rs.getInt("id");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return -1;
    }

    public void createCustomer(int id, String vehicleNumber, int contactNumber){
        String query=String.format("INSERT INTO public.customer (id, vehicle_number, contact_number)\n" +
                "VALUES (DEFAULT, '%s', %d)",vehicleNumber,contactNumber);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createReservation(int id, int customerId, String startTime, int parkingSlotId, String bookingDate, String leaveTime, int cost){
        LocalDate date= LocalDate.now();
        String today=date.toString();
        LocalDateTime loc=LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.000000");
        //locGood.replace("T"," " );
        //System.out.println(myFormatObj.format(loc.plusHours(2)));
        String query=String.format("INSERT INTO public.parking_slot_reservation (id, customer_id, start_time, parking_slot_id, booking_date, leave_time)\n" +
                "VALUES (DEFAULT, %d, '%s', %d, '%s', '%s')",customerId,myFormatObj.format(loc),parkingSlotId,today,myFormatObj.format(loc.plusHours(cost)));
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addSlot(int id, int floorId, int row, int column){
        String query=String.format("INSERT INTO public.parking_slot (id, floor_id, slot_line, slot_column)\n" +
                "VALUES (DEFAULT, %d, %d, %d)",floorId, row, column);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPass(int id, int customerId, int cost) {
        LocalDate date= LocalDate.now();
        String today=date.toString();
        String query=String.format("INSERT INTO public.regular_pass (id, customer_id, purchase_date, start_date, cost)\n" +
                "VALUES (DEFAULT, %d, '%s', '%s', %d)",customerId,today,today,cost);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkBlock(int id){
        String query=String.format("select is_full from block where id=%d",id);
        ResultSet rs= null;
        try {
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                return (rs.getBoolean("is_full"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public int computeLastSlot(){
        String query=String.format("select id from parking_slot where id=(select max(id) from parking_slot)");
        ResultSet rs=null;
        try {
            rs= statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                return rs.getInt("id");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return -1;
    }

    public int []rows1=new int[99];
    public int []columns1=new int[99];
    public int []rows2=new int[99];
    public int []columns2=new int[99];
    public int []rows3=new int[99];
    public int []columns3=new int[99];

    public void computeAlreadyParked1() {
        String query="select slot_line, slot_column from parking_slot where floor_id=1";
        ResultSet rs=null;
        int indexLine=0;
        int indexCol=0;
        try {
            rs=statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                columns1[indexCol++]=rs.getInt("slot_column");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                rows1[indexLine++]=rs.getInt("slot_line");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void computeAlreadyParked2() {
        String query="select slot_line, slot_column from parking_slot where floor_id=2";
        ResultSet rs=null;
        int indexLine=0;
        int indexCol=0;
        try {
            rs=statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                columns2[indexCol++]=rs.getInt("slot_column");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                rows2[indexLine++]=rs.getInt("slot_line");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void computeAlreadyParked3() {
        String query="select slot_line, slot_column from parking_slot where floor_id=3";
        ResultSet rs=null;
        int indexLine=0;
        int indexCol=0;
        try {
            rs=statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                columns3[indexCol++]=rs.getInt("slot_column");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                rows3[indexLine++]=rs.getInt("slot_line");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int customersToday(){
        LocalDate date= LocalDate.now();
        String today=date.toString();
        String query=String.format("select count (*) from regular_pass where start_date='%s'",today);
        ResultSet rs=null;
        try {
            rs=statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                return rs.getInt("count");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return -1;
    }

    public void clearBlock(int blockNr){
        String query=String.format("delete from parking_slot where floor_id=%d",blockNr);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateBlock(int id) {
        String query=String.format("UPDATE public.block\n" +
                "SET is_full = false\n" +
                "WHERE id = %d",id);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getBlockHeight(int blockNr){
        String query=String.format("select max_height from floor where block_id=%d",blockNr);
        ResultSet rs=null;
        try {
            rs=statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                return rs.getInt("max_height");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return 0;
    }
}
