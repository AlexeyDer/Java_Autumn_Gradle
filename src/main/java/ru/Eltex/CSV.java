package ru.Eltex;

import java.util.List;

public interface CSV {
	String toCSV(List<User> users);
	List<User> fromCSV (String str, List<User> users);
}
