package Lab2_Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class User implements JSON {
    private int id;
    private String fio;
    private List<String> lessons;

    public User(int id, String fio) {
        this.fio = fio;
        this.id = id;
    }

    public User(int id, String fio, List<String> lessons) {
        this.fio = fio;
        this.id = id;
        this.lessons = lessons;
    }

    public User() {
    }


    @Override
    public void fromJSON(String str) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue("asd", User.class);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toJSON() {
        ObjectMapper mapper = new ObjectMapper();
        User u1 = new User(1, "ivan");
        try {
            mapper.writeValue(new File("newJson.json"), u1);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "newJson.json";
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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setLessons(List<String> lessons) {
        this.lessons = lessons;
    }

    public List<String> getLessons() {
        return lessons;
    }


}
