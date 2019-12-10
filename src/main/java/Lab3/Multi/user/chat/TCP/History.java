package Lab3.Multi.user.chat.TCP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class History {
    private List<String> storage;
    private Scanner in;

    public History() {
        this.storage = new ArrayList<>();
    }

    public void addMsg(String msg) {
        if (storage.size() == 4) {
            storage.remove(0);
            storage.add(msg);
        }
    }


    public void printStory(List<String> hist ){
        for (int i = 0; i < hist.size(); i++)
            System.out.println(hist.get(i));

    }

    public List<String> getStorage() {
        return storage;
    }

    public void setStorage(List<String> storage) {
        this.storage = storage;
    }
}