package Lab4_MySQL;

import Lab1_CSV.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public List<User> read(ResultSet rs, List<User> users) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String fio = rs.getString("fio");
            String phone = rs.getString("phone");
            users.add(new User(id, fio, phone));
        }
        return users;
    }

    public void print(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Id: " + users.get(i).getId()
                    + " Fio: " + users.get(i).getFio() + " Phone: "
                    + users.get(i).getPhone());
        }
    }


    public static void main(String[] args) {
        App app = new App();
        User u = new User();
        List<User> users = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/univ",
                    "root", "sport1337");
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("DELETE FROM user");

            //////////////////////////////////////////////////////////////////////
            ////////**** Из CSV в БД ****/////////

            // Считываем данные из CSV файла
            users = u.fromCSV("CSV.csv", users);

            // Проверка на существетвание таблицы
            stmt.execute("CREATE TABLE IF NOT EXISTS user(id INT, fio VARCHAR(24), phone VARCHAR(12))");

            // Добавление в БД
            for (int i = 0; i < users.size(); i++) {
                stmt.executeUpdate("INSERT INTO user(id, fio, phone) VALUE(" + users.get(i).getId() + "," +
                        "\"" + users.get(i).getFio()+ "\"" + "," + users.get(i).getPhone() + ");");
            }

            app.print(users);
            users.clear();
            
            ////////////////////////////////////////////////////////////////////////
            //////////**** Из БД в CSV ****/////////

            users = new ArrayList<>();

            // Считываем таблицу
            ResultSet rs = stmt.executeQuery("SELECT* FROM user;");
            users = app.read(rs, users);
            u.toCSV(users);


            conn.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
