package Lab1_CSV;

import java.util.ArrayList;
import java.util.List;

public class App{

    public static void main(String[] args) {
        User us = new User();
        List<User> users = new ArrayList<>();

        users = us.fromCSV("CSV.csv", users);

        for (int i = 0; i < users.size(); i++) {
            System.out.println(
                    "Id : " + users.get(i).getId() +
                            ", Fio: " + users.get(i).getFio() +
                            ", Phone: " + users.get(i).getPhone()
            );
        }

        String newFile = us.toCSV(users);




    }
}
