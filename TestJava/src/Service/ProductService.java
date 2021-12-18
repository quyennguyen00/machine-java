package Service;

import pojo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService {
    private static Connection conn = Utils.getConnection();

    public static Product getProductByName(String name) throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM product WHERE name=?");
        stm.setString(1,name);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            int idd = rs.getInt("id");
            String nameProduct = rs.getString("name");
            double price = rs.getDouble("price");

            Product d = new Product(idd, nameProduct, price);

            return d;
        }

        return null;
    }
}
