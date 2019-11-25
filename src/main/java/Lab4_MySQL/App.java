package Lab4_MySQL;

import java.sql.DriverManager;
import java.sql.*;

public class App {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/",
                    "root", "sport1337");

            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM user WHERE id = 3;");

            ResultSet rs = stmt.executeQuery("SELECT* FROM user;");

            while (rs.next()) {
                String fio = rs.getString("fio");
                System.out.println(fio);
            }

            conn.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
