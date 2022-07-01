package GUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

import Database.UserService;
import Helper.Cart;

import static java.awt.Color.black;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;


/**
 *
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login(String str) throws IOException {
        super("Bookstore application");
        initComponents();
        pack();
        setSize(600, 500);
        validate();

        //center the Form
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);

        //create black border for the username & password text field
        Border field_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jTextField_Username_Log.setBorder(field_border);
        jPasswordField_Password_Log.setBorder(field_border);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     */

    private void initComponents() throws IOException {
        BufferedImage buffered = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));
        BufferedImage buffered2 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("smooth.jpg"));
        BufferedImage buffered3 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));
        final ImageIcon icon = new ImageIcon(buffered);
        final ImageIcon icon2 = new ImageIcon(buffered2);
        final ImageIcon icon3 = new ImageIcon(buffered3);

        JPanel panel1 = new JPanel(){ // added background image
            final Image img = icon.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        javax.swing.JLabel jLabel_Login_Log = new javax.swing.JLabel();
        jLabel_hideScreen_Log = new javax.swing.JLabel();
        jLabel_Exit_Log = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel(){ //added background image
            final Image img = icon2.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        javax.swing.JLabel jLabel_Username_Log = new javax.swing.JLabel();
        javax.swing.JLabel jLabel_Password_Log = new javax.swing.JLabel();
        jTextField_Username_Log = new javax.swing.JTextField();
        jPasswordField_Password_Log = new javax.swing.JPasswordField();
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
        javax.swing.JLabel jLabel_LogToRegistration_Log = new javax.swing.JLabel();
        jButton_Login_Log = new javax.swing.JButton();

        javax.swing.JButton jButton_Cancel_Log = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // ends program when closing window
        setUndecorated(false); // adds standard "frame" with minimize, enlarge and close button


        // adding "Login" text to upper panel
        jLabel_Login_Log.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel_Login_Log.setText("Bookstore Login");


        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190) // Login text position horizontal
                                .addComponent(jLabel_Login_Log)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap(35, Short.MAX_VALUE) // Login text position vertical
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel_Login_Log)))

        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255)); // mid panel background

        jLabel_Username_Log.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_Username_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // "Email or Username:" font
        jLabel_Username_Log.setText("Email or Username:");

        jLabel_Password_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // "Password:" font
        jLabel_Password_Log.setText("Password:");

        jTextField_Username_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // text field font
        jTextField_Username_Log.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_Username_LogFocusGained();
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Username_LogFocusLost();
            }
        });
        jTextField_Username_Log.addActionListener(evt -> jTextField_Username_LogActionPerformed());

        jPasswordField_Password_Log.setFont(new java.awt.Font("Tahoma", 0, 14)); // text field font
        jPasswordField_Password_Log.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField_Password_LogFocusGained();
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField_Password_LogFocusLost();
            }
        });
        jPasswordField_Password_Log.addActionListener(evt -> jPasswordField_Password_LogActionPerformed());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255)); // background lower panel

        jLabel_LogToRegistration_Log.setText("click here to create a new account");
        jLabel_LogToRegistration_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_LogToRegistration_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    jLabel_LogToRegistration_LogMouseClicked();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton_Login_Log.setBackground(new java.awt.Color(255, 255, 255)); // color login-button
        jButton_Login_Log.setFont(new java.awt.Font("Tahoma", 1, 14)); // font login-button
        jButton_Login_Log.setText("Login");
        jButton_Login_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Login_Log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    jButton_Login_LogMouseClicked();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_Login_LogMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_Login_LogMouseExited();
            }
        });
        jButton_Login_Log.addActionListener(evt -> {
            try {
                jButton_Login_LogActionPerformed();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        });

        jButton_Cancel_Log.setFont(new java.awt.Font("Tahoma", 1, 14)); // font cancel button
        jButton_Cancel_Log.setText("cancel");
        jButton_Cancel_Log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Cancel_Log.addActionListener(evt -> jButton_Cancel_LogActionPerformed());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jButton_Cancel_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_Login_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(100, Short.MAX_VALUE)
                                .addComponent(jLabel_LogToRegistration_Log)
                                .addGap(190, 190, 190)) // distance "click here to create a new account" from right border
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton_Login_Log, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton_Cancel_Log))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel_LogToRegistration_Log)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(95, 95, 95) // distance username/password texts from left border
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_Username_Log)
                                        .addComponent(jLabel_Password_Log))
                                .addGap(80, 80, 80) // distance text-fields from texts
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPasswordField_Password_Log, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                        .addComponent(jTextField_Username_Log))
                                .addContainerGap(200, Short.MAX_VALUE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField_Username_Log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_Username_Log))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jPasswordField_Password_Log, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel_Password_Log))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    private void jTextField_Username_LogActionPerformed() {
    }

    private void jPasswordField_Password_LogActionPerformed() {
    }

    private void jButton_Cancel_LogActionPerformed() {
        System.exit(0); //close the Login window
    }


    private void jLabel_LogToRegistration_LogMouseClicked() throws IOException {
        Registration rg = new Registration();   // change from the Login screen to the Registration window
        rg.setVisible(true);
        //rg.pack();
        rg.setLocationRelativeTo(null);
        rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private void jTextField_Username_LogFocusGained() {
        // clears text field on focus if the text is "username"

        if (jTextField_Username_Log.getText().trim().equalsIgnoreCase("username")) {
            jTextField_Username_Log.setText("");
            jTextField_Username_Log.setForeground(Color.black);
            Border field_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
            jTextField_Username_Log.setBorder(field_border);
        }
    }

    private void jTextField_Username_LogFocusLost() {
        //if username field is empty, default text "username" will be provided when focus is lost
        if (jTextField_Username_Log.getText().trim().equals("") ||
                jTextField_Username_Log.getText().trim().equalsIgnoreCase("username")) {
            jTextField_Username_Log.setText("username");
            jTextField_Username_Log.setForeground(new Color(153, 153, 153));
        }
    }

    private void jLabel_hideScreen_LogMouseEntered() {//GEN-FIRST:event_jLabel_hideScreen_LogMouseEntered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_hideScreen_Log.setBorder(label_border);
        jLabel_hideScreen_Log.setForeground(Color.white);
    }

    private void jLabel_hideScreen_LogMouseExited() {
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        jLabel_hideScreen_Log.setBorder(label_border);
        jLabel_hideScreen_Log.setForeground(Color.black);
    }

    private void jPasswordField_Password_LogFocusGained() {
        //compares and clears the password field on focus if the text is "password"
        String pass_log = String.valueOf(jPasswordField_Password_Log.getPassword());

        if (pass_log.trim().equalsIgnoreCase("password")) {
            jPasswordField_Password_Log.setText("");
            jPasswordField_Password_Log.setForeground(black);
        }
    }

    private void jPasswordField_Password_LogFocusLost() {
        String pass_log = String.valueOf(jPasswordField_Password_Log.getPassword());
        if (pass_log.trim().equals("") ||
                pass_log.trim().equalsIgnoreCase("password")) {
            jPasswordField_Password_Log.setText("password");
            jTextField_Username_Log.setForeground(new Color(153, 153, 153));
        }
    }

    private void jButton_Login_LogMouseEntered() { // Login button green on mouseover
        //set button backround
        jButton_Login_Log.setBackground(Color.green);
    }

    private void jButton_Login_LogMouseExited() { // Login Button white on mouse exit
        jButton_Login_Log.setBackground(Color.white);
    }

    private void jButton_Login_LogMouseClicked() throws IOException { // Switches to Registration screen and removes Login screen
        Registration rg = new Registration();
        rg.setVisible(true);
        //rg.pack();
        rg.setLocationRelativeTo(null);
        rg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private void jButton_Login_LogActionPerformed() throws SQLException, IOException {
        //check if Username and password are correct
        String sb = UserService.hashPassword(String.valueOf(jPasswordField_Password_Log.getPassword()));


        System.out.println(sb);
        Cart.user = UserService.login(jTextField_Username_Log.getText(), sb.toString());
        if (Cart.user != null) {
            dispose();
            Mainpage m = new Mainpage();
            m.setSize(615, 500);
        }

    }

    private javax.swing.JButton jButton_Login_Log;
    private javax.swing.JLabel jLabel_Exit_Log;
    private javax.swing.JLabel jLabel_hideScreen_Log;
    private javax.swing.JPasswordField jPasswordField_Password_Log;
    private javax.swing.JTextField jTextField_Username_Log;

}
