package Lab1_CSV;

import java.util.List;

public interface CSV {
	String toCSV(List<User> users);
	List<User> fromCSV (String str, List<User> users);
}
