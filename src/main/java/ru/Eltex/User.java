package ru.Eltex;

public class User {
	protected int IO;
	protected String FIO;
	protected String phone;

	User() {

		}

	public int getIO() {
		return IO;
	}

	public String getFIO() {
		return FIO;
	}

	public String getPhone() {
		return phone;
	}

	public void setIO(int IO) {
		this.IO = IO;
	}

	public void setFIO(String FIO) {
		this.FIO = FIO;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
