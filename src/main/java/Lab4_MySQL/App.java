package Lab4_MySQL;

import Lab1_CSV.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            System.out.println("1. From CSV to DB and from DB to CSV");
            System.out.println("2. Time insert in DB with transaction and without");


            switch (new Scanner(System.in).nextInt()) {
                case 1:
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
                                "\"" + users.get(i).getFio() + "\"" + "," + users.get(i).getPhone() + ");");
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
                    rs.close();
                    break;
                case 2:
                    stmt.executeUpdate("DELETE FROM testTime");

                    long a = System.nanoTime();
                    // Добавление в БД
                    for (int i = 0; i < 1000; i++) {
                        stmt.executeUpdate("INSERT INTO testTime(id, fio) VALUE(" + (i + 1) + ", \"Alexey Derevtsov\"" + ");");
                    }
                    long b = System.nanoTime();

                    System.out.println("Время добавления 1000 элементов без транзакций в БД\nСекунды: " + (b - a)/1000000000.0);

                    conn.setAutoCommit(false);

                    long start = System.nanoTime();
                    // Добавление в БД
                    for (int i = 0; i < 1000; i++) {
                        stmt = conn.createStatement();
                        stmt.executeUpdate("INSERT INTO testTime(id, fio) VALUE(" + (i + 1) + ", \"Alexey Derevtsov\"" + ");");
                    }
                    conn.commit();
                    long end = System.nanoTime();

                    System.out.println("Время добавления 1000 элементов c транзакциями в БД\nСекунды: " + (end - start)/1000000000.0);


                    break;
            }

            conn.close();
            stmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
