package ru.Eltex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Student extends User implements CSV {

	public Student(int id, String fio, String phone) {
		super(id, fio, phone);
	}

	public void fromCSV() {

	}

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

			while (in.hasNextLine()) {
				setId(in.nextInt());
                setFio(in.next());
                setPhone(in.next());

                users.add(new User(getId(), getFio(), getPhone()));
			}
			fr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return users;
	}
}

