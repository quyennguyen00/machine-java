package Service;

import pojo.Order;
import pojo.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderService {
    private static Connection conn = Utils.getConnection();

    public static boolean addOrder(Order d, int userId, int p,double m) throws SQLException {
        conn.setAutoCommit(false);
        PreparedStatement stm = conn.prepareStatement("INSERT INTO order (id,created_date,user_id, product_id, amount) VALUES (?,?,?,?,?)");
        stm.setInt(1, d.getId());
        stm.setDate(2, Date.valueOf(java.time.LocalDate.now()));
        stm.setInt(3, userId);
        stm.setInt(4, p);
        stm.setDouble(5,m);

        stm.executeUpdate();
        conn.commit();

        return true;
    }
}
