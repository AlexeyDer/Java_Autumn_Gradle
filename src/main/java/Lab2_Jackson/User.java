package Lab2_Jackson;

import java.util.List;

public class User {
    private int id;
    private String fio;
    List<String> lessons;

    public User(int id, String fio) {
		this.fio = fio;
		this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFIO() {
        return fio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFIO(String fio) {
        this.fio = fio;
    }
}
