package Lab2_Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User implements JSON {
    private int id;
    private String fio;
    private List<Lesson> lessons;

    public User() {
    }

    {
        id = 0;
        fio = null;
        lessons = new ArrayList<>();
    }

    public User(int id, String fio) {
        this.fio = fio;
        this.id = id;
    }

    public User(int id, String fio, List<Lesson> lessons) {
        this.fio = fio;
        this.id = id;
        this.lessons = lessons;
    }


    @Override
    public void fromJSON(String str) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue(new File(str), User.class);
            System.out.println(mapper.writeValueAsString(user));
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
            String jsonInString = mapper.writeValueAsString(u1);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "newJson.json";
    }


    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
