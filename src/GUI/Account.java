package GUI;

import Database.UserService;
import Helper.Cart;
import Helper.ProductFrameGen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

public class Account extends javax.swing.JFrame{
    public Account() throws IOException {
        initComponents();
        setSize(615, 500);
        this.getContentPane().setBackground(Color.black);
        setVisible(true);
        validate();
        this.setLocationRelativeTo(null); // centers the form
    }

    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    
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
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jTextField1 = new JLabel();
        JLabel jTextField2 = new JLabel();
        JLabel jTextField3 = new JLabel();
        JLabel jTextField4 = new JLabel();
        //JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        JLabel jLabel8 = new JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        //jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        jLabel1.setText("Account");

        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel2.setText("Firstname");

        jLabel3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel3.setText("Lastname");

        jLabel4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel4.setText("Username");

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel5.setText("E-Mail");

        jTextField1.setText(Cart.user.getFirstName());

        jTextField2.setText(Cart.user.getLastName());

        jTextField3.setText(Cart.user.getUsername());

        jTextField4.setText(Cart.user.getEmail());

        jLabel7.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel7.setText("Old Password");

        jPasswordField1.setText("");
        jPasswordField1.addActionListener(e -> jPasswordField1.setText(jPasswordField1.getText()));

        jLabel8.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jLabel8.setText("New Password");

        jPasswordField2.setText("");
        jPasswordField2.addActionListener(e -> jPasswordField2.setText(jPasswordField2.getText()));

        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton1.setText("Change Password");
        jButton1.addActionListener(e -> {
            try {
                UserService.changeInformation(Cart.user.getId(),jPasswordField1.getText(),jPasswordField2.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        jButton2.setText("Mainpage");
        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        jButton2.addActionListener(actionEvent -> {
            dispose();
            Mainpage m = null;
            try {
                m = new Mainpage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            m.setVisible(true);
        });

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
        jPanel3.setLayout(null);
        add(jPanel3);

        jPanel2.add(jLabel2);
        jLabel2.setLocation(120,50);
        jLabel2.setSize(200,20);
        jLabel2.setVisible(true);

        jPanel2.add(jTextField1);
        jTextField1.setLocation(320,50);
        jTextField1.setSize(200,20);
        jTextField1.setVisible(true);

        jPanel2.add(jLabel3);
        jLabel3.setLocation(120,80);
        jLabel3.setSize(200,20);
        jLabel3.setVisible(true);

        jPanel2.add(jTextField2);
        jTextField2.setLocation(320,80);
        jTextField2.setSize(200,20);
        jTextField2.setVisible(true);

        jPanel2.add(jLabel4);
        jLabel4.setLocation(120,110);
        jLabel4.setSize(200,20);
        jLabel4.setVisible(true);

        jPanel2.add(jTextField3);
        jTextField3.setLocation(320,110);
        jTextField3.setSize(200,20);
        jTextField3.setVisible(true);

        jPanel2.add(jLabel5);
        jLabel5.setLocation(120,140);
        jLabel5.setSize(200,20);
        jLabel5.setVisible(true);

        jPanel2.add(jTextField4);
        jTextField4.setLocation(320,140);
        jTextField4.setSize(200,20);
        jTextField4.setVisible(true);

        jPanel2.add(jLabel7);
        jLabel7.setLocation(120,170);
        jLabel7.setSize(200,20);
        jLabel7.setVisible(true);

        jPanel2.add(jPasswordField1);
        jPasswordField1.setLocation(320,170);
        jPasswordField1.setSize(200,20);
        jPasswordField1.setVisible(true);

        jPanel2.add(jLabel8);
        jLabel8.setLocation(120,200);
        jLabel8.setSize(200,20);
        jLabel8.setVisible(true);

        jPanel2.add(jPasswordField2);
        jPasswordField2.setLocation(320,200);
        jPasswordField2.setSize(200,20);
        jPasswordField2.setVisible(true);

        jPanel3.add(jButton1);
        jButton1.setLocation(80,400);
        jButton1.setSize(200,20);
        jButton1.setVisible(true);

        jPanel3.add(jButton2);
        jButton2.setLocation(320,400);
        jButton2.setSize(200,20);
        jButton2.setVisible(true);

    }


}