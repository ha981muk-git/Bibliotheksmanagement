package Database;

import java.sql.*;
import java.util.ArrayList;

import Classes.*;
import Database.DBConnection;

import javax.swing.*;

public class ProductService {
    private static final Connection myConn = DBConnection.connectDB();
    private ArrayList<Product> products = new ArrayList<>();

    public ProductService(String productType) throws SQLException {
        switch (productType) {
            case "Literature" -> this.fillArray(products, 1);
        }
    }
   
    public void fillArray(ArrayList<Product> products, int product_type) throws SQLException {
        assert myConn != null;
        Statement myStatement = myConn.createStatement();
        products.clear();
        ResultSet myResult = myStatement.executeQuery("select * from books,genre WHERE books.genre_id = " + product_type);
        // Process the result
        while(myResult.next()){
            products.add(new Product(myResult.getInt("book_id"), myResult.getString("book_title"),myResult.getDouble("price"),myResult.getInt("quantity"),myResult.getInt("genre_id"), myResult.getString("ISBN"), myResult.getString("author"), myResult.getString("genre_name")));
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public static int checkQuantity(Product product, int quantity) throws SQLException {
        Connection myConn = DBConnection.connectDB();
        Statement myStatement = myConn.createStatement();
        ResultSet myResult = myStatement.executeQuery("select * from books WHERE book_title = \"" + product.getName() + "\"");
        // Process the result
        while(myResult.next()){
            if(myResult.getInt("quantity") - quantity < 0){
                JOptionPane.showMessageDialog(null, "We currently only have "
                        + myResult.getInt("quantity") + " " + myResult.getString("book_title") + " in our stock");
                return myResult.getInt("quantity");
            }
        }
        return quantity;
    }
 // Three Methods for register, delete Entry by isbn und product id
    public static void register(Product product) throws SQLException {
       // int id, String name, double price, int stock, int type, String isbn, String author, String genre)
        String sql = "INSERT INTO books (genre_id, book_title, price, book_id, quantity, ISBN, author) VALUES(?,?,?,?,?,?,?);";
        PreparedStatement statement = myConn.prepareStatement(sql);

        //statement.setInt(   5, product.getType());
        statement.setString(1, product.getGenre());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.setInt(   4, product.getId());
        statement.setInt(   5, product.getStock());
        statement.setString(6, product.getIsbn());
        statement.setString(7, product.getAuthor());

        statement.executeUpdate();
        myConn.close();
    }
    public static void deleteEntryByBookID(int id) throws SQLException {
        // int id, String name, double price, int stock, int type, String isbn, String author, String genre)
        String sql = "DELETE FROM books WHERE  book_id = ?";
        PreparedStatement statement = myConn.prepareStatement(sql);

        statement.setInt(   4, id);
        statement.executeUpdate();
        myConn.close();
    }
    public static void deleteEntryByBookISBN(String isbn) throws SQLException {
        // int id, String name, double price, int stock, int type, String isbn, String author, String genre)
        String sql = "DELETE FROM books WHERE  ISBN = ?";
        PreparedStatement statement = myConn.prepareStatement(sql);

        statement.setString(6, isbn);
        statement.executeUpdate();
        //myConn.close();
    }
}