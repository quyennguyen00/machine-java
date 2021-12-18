package Service;

import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    private static Connection conn = Utils.getConnection();
    public static User  user = new User();

    public static boolean login (String username, String pass) throws SQLException {

        PreparedStatement stm = conn.prepareStatement("SELECT * FROM user WHERE username  = ? and password = ?");
        stm.setString(1,username);
        stm.setString(2,pass);

        ResultSet rs = stm.executeQuery();

        if(rs.next()){
            user.setId(rs.getInt("id"));
            user.setUsername(username);
            user.setPassword(pass);
            user.setMoney(rs.getDouble(4));
            return true;
        }
        return false;
    }
    public static double getMoney(User u) throws SQLException {

        double wallet = 0;
        PreparedStatement stm = conn.prepareStatement("SELECT money FROM user WHERE id= ?");
        stm.setInt(1,user.getId());

        ResultSet rs = stm.executeQuery();
        if(rs.next()){
            wallet = rs.getDouble(4);
        }
        return wallet;
    }
    public static boolean updateMoney(double m) throws SQLException {

        conn.setAutoCommit(false);
        PreparedStatement stm = conn.prepareStatement("UPDATE user SET money=? WHERE id= ?");

        stm.setDouble(1, m);
        stm.setInt(2,user.getId());
        stm.executeUpdate();

        conn.commit();
        return true;
    }
}
