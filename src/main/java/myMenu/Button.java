package myMenu;

import java.io.IOException;

public class Button extends Menu {
    private char ch ;
    private int code;

   public Button (int code) throws IOException {
        this.code = code;
        this.ch = (char) code;
    }

    public void press(Menu mainMenu) {
        if ('s' == ch) {
            if (mainMenu.getMenuIndex() < menuSize - 1)
                mainMenu.setMenuIndex(mainMenu.getMenuIndex() + 1);
        }
        if ('w' == ch) {
            if (mainMenu.getMenuIndex() > 0)
                mainMenu.setMenuIndex(mainMenu.getMenuIndex() - 1);
        }

        if ('q' == ch) {
            switch (mainMenu.getMenuIndex()) {
                case 0:
                    System.out.println("Вы в добавлении!");
                    break;
                case 1:
                    System.out.println("Вы в удалении!");
                    break;
                case 2:
                    System.out.println("Вы в печати");
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
