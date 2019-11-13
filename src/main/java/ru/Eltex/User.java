package ru.Eltex;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements CSV {
    protected int id;
    protected String fio;
    protected String phone;

    public User() {
        this.id = 0;
        this.fio = null;
        this.phone = null;
    }

    public User(int id, String fio, String phone) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;
    }

    @Override
    public String toCSV(List<User> users) {
        try {
            FileWriter fw = new FileWriter("writeCSV.csv", false);

            for (int i = 0; i < users.size(); i++) {
                fw.write(users.get(i).getId() + "," + users.get(i).getFio() + "," + users.get(i).getPhone() + "\n");
            }

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "writeCSV.csv";
    }

    @Override
    public List<User> fromCSV(String str, List<User> users) {
        try {
            FileReader fr = new FileReader(str);
            Scanner in = new Scanner(fr).useDelimiter(",|\n");

            while ((in.hasNext())) {
                id = in.nextInt();
                fio = in.next();
                phone = in.next();

                users.add(new User(id, fio, phone));
            }
            fr.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getPhone() {
        return phone;
    }
}
