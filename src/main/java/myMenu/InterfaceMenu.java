package myMenu;

public interface InterfaceMenu {
    public final int menuSize = 4;
    public final String templateMenu[] = {
            "Добавить запись", " Удалить запись", "Посмотреть все записи", "Выход"
    };

    public default void printMenu(Menu menu, int size) {
        for (int i = 0; i < size; i++) {
            if (i == menu.getMenuIndex())
                System.out.printf("=> ");
            else
                System.out.printf("%d ", i + 1);

            System.out.println(templateMenu[i]);
        }
    }

}
