package Lab2_Jackson;


public class App {
    public static void main(String[] args) {
        User us = new User();
        us.toJSON();
        us.fromJSON("JSON.json");

    }
}
