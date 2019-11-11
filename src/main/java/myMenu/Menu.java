package myMenu;

import java.io.IOException;

public class Menu implements InterfaceMenu {
    private int menuIndex;
    private String[] menu;

    public Menu(int amountItems) {
        this.menu = new String[amountItems];
        this.menuIndex = 0;
    }

    public Menu() {
        this.menu = new String[menuSize];
        this.menuIndex = 0;
    }


    public static void main(String[] args) throws IOException {

     //   System.out.println("Создать свое меню или выбрать уже готовое? ");

        Menu mainMenu = new Menu();
      //  Scanner sc = new Scanner(System.in);


        while (true) {
            mainMenu.printMenu(mainMenu, menuSize);
            Button button = new Button(System.in.read());
            button.press(mainMenu);
        }
    }

    public String[] getMenu() {
        return menu;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }

//    @Override
//    public void keyTyped(KeyEvent keyEvent) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent keyEvent) {
//        if (keyEvent.getKeyCode() == KeyEvent.VK_UP) {
//            menuIndex--;
//        }
//        if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
//            menuIndex++;
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent keyEvent) {
//
//    }
}
