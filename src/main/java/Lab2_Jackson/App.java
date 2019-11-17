package Lab2_Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) {
        User us = new User();
        us.toJSON();
        us.fromJSON("JSON.json");


    }
}
