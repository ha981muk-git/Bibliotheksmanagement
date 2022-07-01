package Database;

import Classes.User;
import Helper.Cart;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserService {
    static Connection myConn = DBConnection.connectDB();

    public UserService() {
    }

    public static void register(User user) throws SQLException {
        String sql = "INSERT INTO USER(first_name,last_name,username,email,password)VALUES(?,?,?,?,?)";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());
        statement.executeUpdate();
    }

    public static User login(String username, String password) throws SQLException {
        Statement myStatement = myConn.createStatement();
        ResultSet myResult;
        if (username.contains("@") && username.contains(".")) {
            myResult = myStatement.executeQuery("SELECT * FROM USER WHERE email = \"" + username + "\" AND password = \"" + password + "\"");
        } else {
            myResult = myStatement.executeQuery("SELECT * FROM USER WHERE username = \"" + username + "\" AND password = \"" + password + "\"");
        }
        if (myResult.next()) {
            JOptionPane.showMessageDialog(null, "Welcome User");
            return new User(myResult.getInt("user_id"),
                    myResult.getString("first_name"),
                    myResult.getString("last_name"),
                    myResult.getString("username"),
                    myResult.getString("email"),
                    password);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Access denied", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    public static void changeInformation(int id,String oldPassword,String newPassword) throws SQLException {
        Statement myStatement = myConn.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT * FROM USER WHERE password = \"" + hashPassword(oldPassword) +"\"");

        if(myResult.next()){
        	String sql=  "UPDATE `USER` SET `password` = ? WHERE (`user_id` = ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1,hashPassword(newPassword));
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
    
    public static void updateUser(String city, String postcode, String address, String bankInformation){
        String sql = "UPDATE USER SET street = ?, postcode = ?, city = ?, bank_information = ? WHERE user_id = ?";
        try {
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setString(1,(city));
            statement.setString(2,(postcode));
            statement.setString(3,(address));
            statement.setString(4,(bankInformation));
            statement.setInt(5, Cart.user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fehlernmeldung bei ShippingAdress order Button :"+e);
        }
    }

    public static String hashPassword(String password){
        MessageDigest messagedigest = null; //Hash-Funktion Encryption
        try {
            messagedigest = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
        }
        
        messagedigest.update(password.getBytes());
        StringBuffer sb= new StringBuffer();
        byte[] b = messagedigest.digest();
        for(byte b1:b){
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        }
        return sb.toString();
    }
}