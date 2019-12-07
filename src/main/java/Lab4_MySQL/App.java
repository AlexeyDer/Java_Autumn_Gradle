package Lab4_MySQL;

import Lab1_CSV.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App{

    public static void main(String[] args) {
        User u = new User();
        List<User> users = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/univ",
                    "root", "sport1337");

            Statement stmt = conn.createStatement();

//            stmt.executeUpdate("DELETE FROM user WHERE id = 2;");
//            stmt.executeUpdate("INSERT INTO user(id, fio, phone) VALUE(3, 'T', '123')");

            ResultSet rs = stmt.executeQuery("SELECT* FROM user;");

            while (rs.next()) {
                int id = rs.getInt("id");
                String fio = rs.getString("fio");
                String phone = rs.getString("phone");
//                System.out.println(id + " " + fio + " " + phone);
                users.add(new User(id, fio, phone));
            }
            u.toCSV(users);

//            stmt.executeUpdate("DELETE FROM user");

            users.clear();
            users = new ArrayList<>();

            users = u.fromCSV("CSV.csv", users);

            for (int i = 0; i < users.size(); i++){
                stmt.executeUpdate("INSERT INTO user(id, fio, phone) " +
                        "VALUE(" + users.get(i).getId() + "," +
                        users.get(i).getFio()+ "," +
                        users.get(i).getPhone() + ");");
            }


            while (rs.next()) {
                int id = rs.getInt("id");
                String fio = rs.getString("fio");
                String phone = rs.getString("phone");
                System.out.println(id + " " + fio + " " + phone);
//                users.add(new User(id, fio, phone));
            }

            conn.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
