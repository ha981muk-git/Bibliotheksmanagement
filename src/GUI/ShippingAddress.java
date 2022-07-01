package GUI;
import Database.DBConnection;
import Database.OrderService;
import Database.UserService;
import Helper.Cart;
import Helper.MailService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;


public class ShippingAddress extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;

    public ShippingAddress() throws IOException {
        initComponents();
        setSize(600, 500);
        this.getContentPane().setBackground(Color.black);
        setVisible(true);
        validate();
        this.setLocationRelativeTo(null); // centers the form
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() throws IOException {

        BufferedImage buffered = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));
        BufferedImage buffered2 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("smooth.jpg"));
        //BufferedImage buffered3 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));

        final ImageIcon icon = new ImageIcon(buffered);
        final ImageIcon icon2 = new ImageIcon(buffered2);
        //final ImageIcon icon3 = new ImageIcon(buffered3);

        JPanel jPanel1 = new JPanel(){ // added background image
            final Image img = icon.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        JPanel jPanel2 = new JPanel(){ // added background image
            final Image img = icon2.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        JPanel jPanel3 = new JPanel(){ // added background image
            final Image img = icon.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };


        jLabel1 = new javax.swing.JLabel();

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Enter Shipping Information");

        //jPanel3.setBackground(new java.awt.Color(231, 246, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("City:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Zip:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Street and Housenumber:");

        jButton1.setText("Order");
        jButton1.addActionListener(actionEvent -> {
            MailService mailService = new MailService();
            mailService.createOrderMessage(Cart.user.getFirstName(), Cart.user.getLastName(), Cart.user.getUsername());
            dispose();
            OrderConfirmation orderConfirmation = new OrderConfirmation();
            orderConfirmation.setVisible(true);
            orderConfirmation.setLocationRelativeTo(null);
            OrderService.InsertOrder();
            try {
                OrderService.addToTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            OrderService.UpdateQuantity();
            UserService.updateUser(jTextField3.getText(),jTextField4.getText(),jTextField5.getText(),jTextField6.getText());
            Cart.removeEverything();
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Bank_information:");

        jPanel1.setLocation(0,0);
        jPanel1.setSize(600,60);
        jPanel1.add(Box.createVerticalStrut(70));
        jPanel1.add(jLabel1);
        add(jPanel1);

        jPanel2.setLocation(0,70);
        jPanel2.setSize(600,300);
        jPanel2.setLayout(null);
        add(jPanel2);

        jPanel3.setLocation(0,320);
        jPanel3.setSize(600,50);
        add(jPanel3);

        jPanel2.add(jLabel4);
        jLabel4.setLocation(100,50);
        jLabel4.setSize(200,20);
        jLabel4.setVisible(true);

        jPanel2.add(jTextField3);
        jTextField3.setLocation(290,50);
        jTextField3.setSize(200,20);
        jTextField3.setVisible(true);

        jPanel2.add(jLabel5);
        jLabel5.setLocation(100,80);
        jLabel5.setSize(200,20);
        jLabel5.setVisible(true);

        jPanel2.add(jTextField4);
        jTextField4.setLocation(290,80);
        jTextField4.setSize(200,20);
        jTextField4.setVisible(true);

        jPanel2.add(jLabel6);
        jLabel6.setLocation(100,110);
        jLabel6.setSize(200,20);
        jLabel6.setVisible(true);

        jPanel2.add(jTextField5);
        jTextField5.setLocation(290,110);
        jTextField5.setSize(200,20);
        jTextField5.setVisible(true);

        jPanel2.add(jLabel7);
        jLabel7.setLocation(100,140);
        jLabel7.setSize(200,20);
        jLabel7.setVisible(true);

        jPanel2.add(jTextField6);
        jTextField6.setLocation(290,140);
        jTextField6.setSize(200,20);
        jTextField6.setVisible(true);

        jPanel2.add(jButton1);
        jButton1.setLocation(290,230);
        jButton1.setSize(200,20);
        jButton1.setVisible(true);

    }



}
