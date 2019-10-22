package ru.Eltex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Student extends User implements CSV {
	public void fromCSV() {

	}

	@Override
	public String toCSV() {
		return null;
	}

	@Override
	public void fromCSV(String str) {
		try {
			char c = 0;
			FileReader fr = new FileReader(str);
			Scanner in = new Scanner(fr);

			while (in.hasNextLine()) {

				fr.close();
			}
			} catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
}

