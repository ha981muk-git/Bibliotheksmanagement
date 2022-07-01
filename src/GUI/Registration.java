/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.User;
import Database.UserService;
import Helper.MailService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Registration extends javax.swing.JFrame {

    private javax.swing.JTextField user_username;
    private javax.swing.JTextField user_email;
    private javax.swing.JTextField user_firstname;
    private javax.swing.JTextField user_lastname;
    private javax.swing.JPasswordField user_password;
    private javax.swing.JTextField user_emailconfirmation = new javax.swing.JTextField();
    private javax.swing.JPasswordField user_passwordconfirmation = new javax.swing.JPasswordField();

    public Registration() throws IOException {
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
        BufferedImage buffered3 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));

        final ImageIcon icon = new ImageIcon(buffered);
        final ImageIcon icon2 = new ImageIcon(buffered2);
        final ImageIcon icon3 = new ImageIcon(buffered3);

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel(){ // added background image
            final Image img = icon.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        javax.swing.JLabel jLabel_Registration_Reg = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel(){ // added background image
            final Image img = icon2.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        user_firstname = new javax.swing.JTextField();
        user_lastname = new javax.swing.JTextField();
        javax.swing.JLabel jLabel_Firstname_Reg = new javax.swing.JLabel();
        javax.swing.JLabel jLabel_Lastname_Reg = new javax.swing.JLabel();
        JLabel jLabel_Username_Reg = new JLabel();
        javax.swing.JLabel jLabel_Email_Reg = new javax.swing.JLabel();
        user_username = new javax.swing.JTextField();
        user_email = new javax.swing.JTextField();
        JLabel jLabel_EmailConfirmation_Reg = new JLabel();
        JLabel jLabel_Password_Reg = new JLabel();
        JLabel jLabel_PasswordConfirmation_Reg = new JLabel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel(){ // added background image
            final Image img = icon3.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        javax.swing.JButton jButton_Register_Reg = new javax.swing.JButton();
        javax.swing.JButton jButton_Cancel_Reg = new javax.swing.JButton();
        javax.swing.JLabel jLabelChangeToLogIn = new javax.swing.JLabel();
        user_emailconfirmation = new javax.swing.JTextField();
        user_password = new javax.swing.JPasswordField();
        user_passwordconfirmation = new javax.swing.JPasswordField();

        //setUndecorated(true);

        jLabel_Registration_Reg.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        jLabel_Registration_Reg.setText("<html><body>Register</body></html>");


        //set upper panel
        jPanel1.setLocation(0,0);
        jPanel1.setSize(600,60);
        jPanel1.add(Box.createVerticalStrut(80));
        jPanel1.add(jLabel_Registration_Reg);
        add(jPanel1);

        jPanel2.setLocation(0,70);
        jPanel2.setSize(600,280);
        add(jPanel2);
        jPanel2.setLayout(null);
        //jPanel2.setVisible(true);

        jLabel_Firstname_Reg.setLocation(90,20);
        jLabel_Firstname_Reg.setSize(200,20);
        jLabel_Firstname_Reg.setVisible(true);
        jPanel2.add(jLabel_Firstname_Reg);

        user_firstname.setLocation(290,20);
        user_firstname.setSize(200,20);
        user_firstname.setVisible(true);
        jPanel2.add(user_firstname);

        jLabel_Lastname_Reg.setLocation(90,50);
        jLabel_Lastname_Reg.setSize(200,20);
        jLabel_Lastname_Reg.setVisible(true);
        jPanel2.add(jLabel_Lastname_Reg);

        user_lastname.setLocation(290,50);
        user_lastname.setSize(200,20);
        user_lastname.setVisible(true);
        jPanel2.add(user_lastname);

        jLabel_Username_Reg.setLocation(90,80);
        jLabel_Username_Reg.setSize(200,20);
        jLabel_Username_Reg.setVisible(true);
        jPanel2.add(jLabel_Username_Reg);

        user_username.setLocation(290,80);
        user_username.setSize(200,20);
        user_username.setVisible(true);
        jPanel2.add(user_username);

        jLabel_Email_Reg.setLocation(90,110);
        jLabel_Email_Reg.setSize(200,20);
        jLabel_Email_Reg.setVisible(true);
        jPanel2.add(jLabel_Email_Reg);

        user_email.setLocation(290,110);
        user_email.setSize(200,20);
        user_email.setVisible(true);
        jPanel2.add(user_email);

        jLabel_EmailConfirmation_Reg.setLocation(90,140);
        jLabel_EmailConfirmation_Reg.setSize(200,20);
        jLabel_EmailConfirmation_Reg.setVisible(true);
        jPanel2.add(jLabel_EmailConfirmation_Reg);

        user_emailconfirmation.setLocation(290,140);
        user_emailconfirmation.setSize(200,20);
        user_emailconfirmation.setVisible(true);
        jPanel2.add(user_emailconfirmation);

        jLabel_Password_Reg.setLocation(90,170);
        jLabel_Password_Reg.setSize(200,20);
        jLabel_Password_Reg.setVisible(true);
        jPanel2.add(jLabel_Password_Reg);

        user_password.setLocation(290,170);
        user_password.setSize(200,20);
        user_password.setVisible(true);
        jPanel2.add(user_password);

        jLabel_PasswordConfirmation_Reg.setLocation(90,200);
        jLabel_PasswordConfirmation_Reg.setSize(200,20);
        jLabel_PasswordConfirmation_Reg.setVisible(true);
        jPanel2.add(jLabel_PasswordConfirmation_Reg);

        user_passwordconfirmation.setLocation(290,200);
        user_passwordconfirmation.setSize(200,20);
        user_passwordconfirmation.setVisible(true);
        jPanel2.add(user_passwordconfirmation);


        //set lower panel
        jPanel3.setLocation(0,350);
        jPanel3.setSize(600,50);
        add(jPanel3);
        jPanel3.setLayout(null);

        jButton_Cancel_Reg.setSize(100,25);
        jButton_Cancel_Reg.setVisible(true);
        jButton_Cancel_Reg.setLocation(45,390);
        jPanel3.add(jButton_Cancel_Reg);

        jButton_Register_Reg.setSize(100,25);
        jButton_Register_Reg.setVisible(true);
        jButton_Register_Reg.setLocation(440,390);
        jPanel3.add(jButton_Register_Reg);

        jLabelChangeToLogIn.setSize(200,20);
        jLabelChangeToLogIn.setVisible(true);
        jLabelChangeToLogIn.setLocation(250,420);
        jPanel3.add(jLabelChangeToLogIn);


        jLabel_Firstname_Reg.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Firstname_Reg.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel_Firstname_Reg.setText("Firstname:");

        jLabel_Lastname_Reg.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel_Lastname_Reg.setText("Lastname:");

        jLabel_Username_Reg.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel_Username_Reg. setText("Username:");

        jLabel_Email_Reg.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel_Email_Reg.setText("Email:");

        jLabel_EmailConfirmation_Reg.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel_EmailConfirmation_Reg.setText("Email Confirmation:");

        jLabel_Password_Reg.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel_Password_Reg.setText("Password:");

        jLabel_PasswordConfirmation_Reg.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jLabel_PasswordConfirmation_Reg.setText("Password Confirmation:");


        jButton_Register_Reg.setBackground(new java.awt.Color(0, 204, 51));
        jButton_Register_Reg.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        jButton_Register_Reg.setText("register");
        jButton_Register_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Register_Reg.addActionListener(evt -> {
            try {
                jButton_Register_RegActionPerformed();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });

        jButton_Cancel_Reg.setText("cancel");
        jButton_Cancel_Reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cancel_Reg.addActionListener(this::jButton_Cancel_RegActionPerformed);

        jLabelChangeToLogIn.setText("click here to log in");
        jLabelChangeToLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelChangeToLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    jLabelChangeToLogInMouseClicked();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }


    private void jLabelChangeToLogInMouseClicked() throws IOException {
        Login lg = new Login("Bookstore application");
        lg.setVisible(true);
        //lg.pack();
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private void jButton_Register_RegActionPerformed() throws SQLException, IOException {
        User registration;
        String firstname = user_firstname.getText();
        String lastname = user_lastname.getText();
        String username = user_username.getText();
        String email = user_email.getText();
        String emailconfirmation=user_emailconfirmation.getText();
        String password=String.valueOf(user_password.getPassword());
        String passwordconfirmation=String.valueOf(user_passwordconfirmation.getPassword());

        String sb = UserService.hashPassword(password);

        if(firstname.equals("")||lastname.equals("")||email.equals("")||emailconfirmation.equals("")||password.equals("")||passwordconfirmation.equals(""))
        {
            JOptionPane.showMessageDialog(null, "One or more fields are empty.");
        }
        else if(!password.equals(passwordconfirmation))
        {
            JOptionPane.showMessageDialog(null, "Passwords doesn't match","Confirm password", JOptionPane.WARNING_MESSAGE);
        }
        else if(!email.equals(emailconfirmation))
        {
            JOptionPane.showMessageDialog(null, "E-mails doesn't match","Confirm e-mail", JOptionPane.WARNING_MESSAGE);
        }
        else if(!email.contains("@") && !email.contains("."))
        {
            JOptionPane.showMessageDialog(null, "Use a valid e-mail","Invalid e-mail", JOptionPane.WARNING_MESSAGE);
        }
        else{
            registration = new User(firstname, lastname, username, email, sb.toString());
            UserService.register(registration);
            JOptionPane.showMessageDialog(null, "Account succesfully registered. Please login");
            Login lg = new Login("Bookstore application");
            lg.setVisible(true);
            //lg.pack();
            lg.setLocationRelativeTo(null);
            lg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
            MailService testing = new MailService();
            testing.sendEmail("Registration","You are succesfully registered",registration.getEmail());
        }

    }

    private void jButton_Cancel_RegActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }




}   
