package Database;

import Classes.Product;
import Helper.Cart;

import java.sql.*;
import java.time.LocalDate;

public class OrderService {
    private final static Connection myConn = DBConnection.connectDB();
    //INSERT into ORDERS table attributes : user_id,order_date,total_price.
   static public void InsertOrder() {
        String sql = "INSERT INTO ORDERS (user_id,order_date,total_price)VALUES(?,?,?)";
        try {
            PreparedStatement  statement = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, Cart.user.getId());
            statement.setString(2, String.valueOf(LocalDate.now()));
            statement.setString(3,String.valueOf(Cart.totalPrice)+"$");
            statement.executeUpdate();
            ResultSet generatedKeysResultSet = statement.getGeneratedKeys();
            generatedKeysResultSet.next();
            Cart.orderId = generatedKeysResultSet.getInt(1);
        } catch (SQLException e) {
            System.out.println("Fehlernmeldung bei OrderCart Button order :"+e);
        }
    }
    //UPDATE product table attributes : quantity
    static public void UpdateQuantity() {
        int i = 0;
        for(Product test:
                Cart.cartProducts){
            try {
                System.out.println(test.getStock());
                System.out.println(Cart.cartProductQuantity.get(i));
                String sql = "update BOOK set quantity = ? where book_id = ?";
                PreparedStatement statement = myConn.prepareStatement(sql);
                statement.setInt(1, test.getStock() - Cart.cartProductQuantity.get(i));
                statement.setInt(2, test.getId());
                statement.executeUpdate();
                test.setStock(test.getStock() - Cart.cartProductQuantity.get(i));
                i++;
            } catch (SQLException e) {
                System.out.println("Fehler"+e);
            }
        }
    }
    static public void addToTable() throws SQLException {
        String sql = "INSERT INTO ORDER_BOOK (order_id, book_id, quantity) VALUES (?,?,?);\n";
        for (Product p :
                Cart.cartProducts) {
                PreparedStatement  statement = myConn.prepareStatement(sql);
                statement.setInt(1, Cart.orderId);
                statement.setInt(2, p.getId());
                statement.setInt(3,p.getStock());
                statement.executeUpdate();
        }
    }

    }

