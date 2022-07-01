package Database;


import java.sql.*;

public class DBConnection {
   
    public static Connection connectDB()
    {
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/n_e", "root", "Bibhuti1996%#xxe");
        }
        catch(SQLException ex){
            System.out.println("Es konnte keine Verbindung zum Datenbank Server aufgebaut werden.");
            System.out.println(ex);
            return null;
        }
    }
}