package myMenu;

public interface InterfaceMenu {
    public final int menuSize = 5;
    public final String templateMenu[] = {
            "Добавить запись", " Удалить запись", "Посмотреть все записи", "Настройки", "Выход"
    };

    public final int choiceMenuSize = 2;
    public final String choiceMenu[] = {
            "Да", "Нет"
    };

    public default void printMenu(Menu menu, String[] notes, int size) {
        for (int i = 0; i < size; i++) {
            if (i == menu.getMenuIndex())
                System.out.printf("=> ");
            else
                System.out.printf("%d ", i + 1);

            System.out.println(notes[i]);
        }
    }

}
