package views;
import models.Block;
import models.Parking;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParkingView extends JFrame {
    private JTextField customerField;
    private JTextField carNumberField;

    private JComboBox hoursBox;

    private JComboBox rowsBox;

    private JComboBox columnsBox;

    private JComboBox blocksBox;

    private JButton reserveButton;
    private JButton checkAvailableButton;
    private JButton computeTotalButton;

    private Parking parking=new Parking();

    public ParkingView() throws java.sql.SQLException{
        DatabaseMethods date=new DatabaseMethods();
        this.setBounds(100, 100, 720, 665);
        //this.setSize(1080,720);
        this.setTitle("Parking");
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(new Color(173,216,230));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Choose parking spot");
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        titleLabel.setBounds(220, 70, 400, 35);
        this.getContentPane().add(titleLabel);

        JLabel customerLabel = new JLabel("Customer");
        customerLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        customerLabel.setBounds(80, 160, 80, 20);
        this.getContentPane().add(customerLabel);

        customerField=new JTextField();
        customerField.setColumns(40);
        customerField.setFont(new Font("Tahoma",Font.PLAIN,16));
        customerField.setBounds(180,160,100,20);
        this.getContentPane().add(customerField);

        JLabel carNumberLabel = new JLabel("Car number");
        carNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        carNumberLabel.setBounds(290, 160, 100, 20);
        this.getContentPane().add(carNumberLabel);

        carNumberField=new JTextField();
        carNumberField.setColumns(40);
        carNumberField.setFont(new Font("Tahoma",Font.PLAIN,16));
        carNumberField.setBounds(400,160,100,20);
        this.getContentPane().add(carNumberField);

        JButton customerButton=new JButton("Register");
        customerButton.setBounds(520,160,100,20);
        customerButton.setFont(new Font("Tahoma",Font.PLAIN,16));
        this.getContentPane().add(customerButton);

        customerButton.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {
                if(customerField.getText().isEmpty() || carNumberField.getText().isEmpty())
                    showMessage("Please enter credentials first");
                else if(parking.checkValidPlate(carNumberField.getText())==0)
                    showMessage("Invalid license plate!");
                    else showMessage("Welcome "+customerField.getText()+". Please select where to park");
            }
        });

        JButton adminButton=new JButton("Admin");
        adminButton.setBounds(20,600,100,20);
        adminButton.setFont(new Font("Tahoma",Font.PLAIN,16));
        this.getContentPane().add(adminButton);

        adminButton.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {
                JFrame adminFrame=new JFrame("Login screen");
                adminFrame.setBounds(200,200,300,300);
                adminFrame.setLayout(null);
                adminFrame.setVisible(true);

                JLabel passLabel=new JLabel("Please enter password");
                passLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
                passLabel.setBounds(50, 100, 180, 20);
                adminFrame.getContentPane().add(passLabel);

                JPasswordField passField=new JPasswordField();
                passField.setColumns(40);
                passField.setBounds(50,130,180,20);
                adminFrame.getContentPane().add(passField);

                JButton passButton=new JButton("Login");
                passButton.setBounds(80,160,120,20);
                passButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
                adminFrame.getContentPane().add(passButton);

                passButton.addActionListener(new ActionListener()  {
                    public void actionPerformed(ActionEvent e) {
                        String pass=passField.getText();
                        if(pass.equals("admin")){
                            showMessage("Welcome!");
                            adminFrame.setVisible(false);
                            adminFrame.dispose();
                            JFrame adminPanel=new JFrame("Admin");
                            adminPanel.setLayout(null);
                            adminPanel.setBounds(200,200,350,350);
                            adminPanel.setVisible(true);

                            JLabel controls=new JLabel("Operations:");
                            controls.setBounds(33,20,280,30);
                            controls.setFont(new Font("Tahoma", Font.PLAIN,20));
                            adminPanel.getContentPane().add(controls);

                            JButton todayButton=new JButton("Customers today");
                            todayButton.setBounds(23,55,280,30);
                            todayButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
                            adminPanel.getContentPane().add(todayButton);

                            todayButton.addActionListener(new ActionListener()  {
                                public void actionPerformed(ActionEvent e) {
                                    int nr= date.customersToday();
                                    showMessage("We had "+nr+" customers today");
                                }
                            });

                            JButton bl1Button=new JButton("Clear block 1");
                            bl1Button.setBounds(23,90,280,30);
                            bl1Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
                            adminPanel.getContentPane().add(bl1Button);

                            bl1Button.addActionListener(new ActionListener()  {
                                public void actionPerformed(ActionEvent e) {
                                    date.clearBlock(1);
                                    date.updateBlock(1);
                                    showMessage("Block 1 cleared!");
                                }
                            });

                            JButton bl2Button=new JButton("Clear block 2");
                            bl2Button.setBounds(23,125,280,30);
                            bl2Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
                            adminPanel.getContentPane().add(bl2Button);

                            bl2Button.addActionListener(new ActionListener()  {
                                public void actionPerformed(ActionEvent e) {
                                    //date.clearBlock(2);
                                    //date.updateBlock(2);
                                    showMessage("Block 2 cleared!");
                                }
                            });

                            JButton bl3Button=new JButton("Clear block 3");
                            bl3Button.setBounds(23,160,280,30);
                            bl3Button.setFont(new Font("Tahoma", Font.PLAIN, 16));
                            adminPanel.getContentPane().add(bl3Button);

                            bl3Button.addActionListener(new ActionListener()  {
                                public void actionPerformed(ActionEvent e) {
                                    //date.clearBlock(3);
                                    //date.updateBlock(3);
                                    showMessage("Block 3 cleared!");
                                }
                            });

                        }else{
                            showMessage("Wrong password!");
                            adminFrame.setVisible(false);
                            adminFrame.dispose();
                        }
                    }
                });
            }
        });

        JLabel blockLabel = new JLabel("Block");
        blockLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        blockLabel.setBounds(80, 200, 80, 20);
        this.getContentPane().add(blockLabel);

        String []blocks={"1","2","3"};
        blocksBox=new JComboBox(blocks);
        blocksBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        blocksBox.setBounds(180,200,80,20);
        this.getContentPane().add(blocksBox);

        JButton checkBlock=new JButton("Check availabilty");
        checkBlock.setBounds(280,200,160,20);
        checkBlock.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.getContentPane().add(checkBlock);

        checkBlock.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {
                String blocknr= blocksBox.getItemAt(blocksBox.getSelectedIndex()).toString();
                int block=Integer.parseInt(blocknr);
                int free=parking.checkNrOfSlots(block);
                //parking.addCar(2,1,1);
                //parking.addCar(2,2,2);
                if(!date.checkBlock(block)){
                    showMessage("Block has "+free+" empty slots. Make sure your car is less than "+date.getBlockHeight(block)+" centimeters tall!");
                }else{
                    showMessage("Block is full. Try another one");
                }
                //JOptionPane.showMessageDialog(blockLabel,blocknr);
            }
        });

        JLabel rowLabel = new JLabel("Row");
        rowLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rowLabel.setBounds(80, 240, 80, 20);
        this.getContentPane().add(rowLabel);

        String []rows={"1","2","3","4","5","6","7","8"};
        rowsBox=new JComboBox(rows);
        rowsBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        rowsBox.setBounds(180,240,80,20);
        this.getContentPane().add(rowsBox);

        JLabel columnLabel = new JLabel("Column");
        columnLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        columnLabel.setBounds(80, 280, 80, 20);
        this.getContentPane().add(columnLabel);

        String []columns={"1","2","3","4","5","6","7","8"};
        columnsBox=new JComboBox(columns);
        columnsBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        columnsBox.setBounds(180,280,80,20);
        this.getContentPane().add(columnsBox);

        JLabel durationLabel = new JLabel("Duration in hours");
        durationLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        durationLabel.setBounds(80, 340, 180, 20);
        this.getContentPane().add(durationLabel);

        String []hours={"1","2","3","4","5","6","7","8"};
        hoursBox=new JComboBox(hours);
        hoursBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        hoursBox.setBounds(240,340,80,20);
        this.getContentPane().add(hoursBox);

        checkAvailableButton=new JButton("Check if spot is available");
        checkAvailableButton.setBounds(220,420,260,40);
        checkAvailableButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(checkAvailableButton);

        checkAvailableButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String row = rowsBox.getItemAt(rowsBox.getSelectedIndex()).toString();
                String column = columnsBox.getItemAt(columnsBox.getSelectedIndex()).toString();
                String blocknr = blocksBox.getItemAt(blocksBox.getSelectedIndex()).toString();
                int block = Integer.parseInt(blocknr);
                int r = Integer.parseInt(row);
                int c = Integer.parseInt(column);
                if (customerField.getText().isEmpty() || carNumberField.getText().isEmpty())
                    showMessage("Please enter credentials first");
                else {
                    if (!date.checkBlock(block)) {
                        if (parking.checkSlot(block, r, c) == 1) {
                            showMessage("Selected space is free, continue to book");
                            parking.addCar(block, r, c);
                        } else showMessage("Not a free space! Please try another");
                    } else showMessage("Not a free space! Please try another");
                }
            }
        });

        computeTotalButton=new JButton("Compute fee");
        computeTotalButton.getHorizontalAlignment();
        computeTotalButton.setBounds(220,485,260,40);
        computeTotalButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(computeTotalButton);

        computeTotalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(customerField.getText().isEmpty() || carNumberField.getText().isEmpty())
                    showMessage("Please enter credentials first");
                else {
                    int cost = parking.computeFee(Integer.parseInt(hoursBox.getItemAt(hoursBox.getSelectedIndex()).toString()));
                    showMessage("Your total is " + cost + ". Proceed to checkout");
                }
            }
        });

        reserveButton=new JButton("Checkout");
        reserveButton.setBounds(220,545,260,40);
        reserveButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(reserveButton);

        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (customerField.getText().isEmpty() || carNumberField.getText().isEmpty())
                    showMessage("Please enter credentials first");
                else {
                    String row = rowsBox.getItemAt(rowsBox.getSelectedIndex()).toString();
                    String column = columnsBox.getItemAt(columnsBox.getSelectedIndex()).toString();
                    String blocknr = blocksBox.getItemAt(blocksBox.getSelectedIndex()).toString();
                    int block = Integer.parseInt(blocknr);
                    int r = Integer.parseInt(row);
                    int c = Integer.parseInt(column);
                    int cost = parking.computeFee(Integer.parseInt(hoursBox.getItemAt(hoursBox.getSelectedIndex()).toString()));
                    int hours = Integer.parseInt(hoursBox.getItemAt(hoursBox.getSelectedIndex()).toString());
                    int idToInsert = date.getLastCustomerId();
                    int lastSlotId = date.computeLastSlot();
                    lastSlotId++;
                    idToInsert++;
                    date.addSlot(1, block, r, c);
                    date.createCustomer(1, carNumberField.getText(), parking.computeContactNumber(customerField.getText()));
                    date.createReservation(1, idToInsert, "aba", lastSlotId, "bcd", "cde", hours);
                    date.addPass(1, idToInsert, cost);
                    showMessage("Have a nice day!");
                    refresh();
                }
            }
        });
        this.setVisible(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void refresh() {
        customerField.setText(null);
        carNumberField.setText(null);
        hoursBox.setSelectedIndex(0);
        columnsBox.setSelectedIndex(0);
        rowsBox.setSelectedIndex(0);
        blocksBox.setSelectedIndex(0);
    }
}
