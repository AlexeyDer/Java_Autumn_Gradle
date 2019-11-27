package Lab4_MySQL;

import java.sql.DriverManager;
import java.sql.*;

public class App {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/univ",
                    "root", "sport1337");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM user WHERE id = 2;");
            stmt.executeUpdate("INSERT INTO user(id, fio, phone) VALUE(3, 'T', '123')");

            ResultSet rs = stmt.executeQuery("SELECT* FROM user;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String fio = rs.getString("fio");
                String phone = rs.getString("phone");
                System.out.println(id + " " + fio + " " + phone);
            }

            conn.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
