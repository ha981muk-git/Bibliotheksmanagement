/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Helper.ProductFrameGen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 */
public class Mainpage extends javax.swing.JFrame {

    /**
     * Creates new form Hauptseite
     */
    public Mainpage() throws IOException {
        initComponents();
        setSize(615, 500);
        this.getContentPane().setBackground(Color.black);
        setVisible(true);
        validate();
        this.setLocationRelativeTo(null); // centers the form
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */

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

        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton5 = new JButton();
        JButton jButtonEdit = new JButton();
        JLabel jLabel1 = new JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        jLabel1.setText("<html><body><center>Welcome!</center/<br><center>Please select the desired service</center></body></html>");
        jLabel1.setSize(300,60);

        jPanel1.setLocation(0,0);
        jPanel1.setSize(600,60);
        jPanel1.add(Box.createVerticalStrut(70));
        jPanel1.add(jLabel1);
        add(jPanel1);

        jPanel2.setLocation(0,70);
        jPanel2.setSize(600,300);
        add(jPanel2);

        jPanel3.setLocation(0,320);
        jPanel3.setSize(600,50);
        add(jPanel3);

        jButton1.setText("Go to Cart");
        //jPanel2.add(Box.createVerticalStrut(150));
        jPanel2.add(jButton1);
        //jPanel2.add(Box.createHorizontalStrut(20));

        //jButton2.setBounds(450,210,94,30);
        jButton2.setText("Literature");
        jPanel2.add(jButton2);
        jPanel2.add(Box.createHorizontalStrut(20));




        //jButton5.setBounds(10,260,94,30);
        jButton5.setText("Account");
        jPanel2.add(jButton5,BorderLayout.PAGE_END);
        jPanel2.add(Box.createVerticalStrut(150));
        //jButtonEdit.setBounds(60, 60, 600, 20);
        jPanel2.add(jButtonEdit,BorderLayout.CENTER);
        //jPanel2.add(Box.createVerticalStrut(70));
        jButtonEdit.setText("Edit");



        jButton2.addActionListener(actionEvent -> {
            dispose();
            ProductFrameGen literature = null;
            try {
                literature = new ProductFrameGen("Literature");
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
            assert literature != null;
            literature.setLocationRelativeTo(null);
        });

        jButton5.addActionListener(actionEvent -> {
            dispose();
            Account account = null;
            try {
                account = new Account();
            } catch (IOException e) {
                e.printStackTrace();
            }
            account.setLocationRelativeTo(null);
            account.setVisible(true);
        });

        jButton1.addActionListener(actionEvent -> {
            dispose();
            OrderCart cart = null;
            try {
                cart = new OrderCart();
            } catch (IOException e) {
                e.printStackTrace();
            }
            cart.setLocationRelativeTo(null);
        });

        jButtonEdit.addActionListener(actionEvent -> {
            dispose();
            ProductRegistration productRegistration= null;

            try {
                productRegistration = new ProductRegistration();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            productRegistration.setLocationRelativeTo(null);
            productRegistration.setVisible(true);
        });

    }

}
