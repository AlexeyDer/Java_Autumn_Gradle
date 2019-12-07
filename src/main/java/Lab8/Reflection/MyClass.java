package Lab8.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Создадим класс образец, в котором сделаем поля и метод приватными и попробуем их вывести или изменить

public class MyClass {
    private int number = 2;
    private String name = "default";

    public MyClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printData() {
        System.out.println(number + name);
    }


    // Создадим метод, который будет обращаться к приватному методу в нашем классе
    public static void printData(Object myClass) {
        try {
            // Указываем ссылку к нащему приватному методу
            Method method = myClass.getClass().getDeclaredMethod("printData");

            // Даем доступ
            method.setAccessible(true);

            // Вызываем приватный метод, передавая объект в метод, также можно указать параметры нашего метода,
            // через запятую.
            method.invoke(myClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClass myClass = null;

        // Получаем возможные данные нашего класса
        int number = myClass.getNumber();
        String name = null; // no getter :(

        // Выводим приваный метод в классе
        printData(myClass);

        try {
            // Создаем поле, в котором указываем ссылку на наше приватное поле, которое нам нужно
            Field field = myClass.getClass().getDeclaredField("name");

            // Дадим доступ этому полю
            field.setAccessible(true);

            // И получим данные из этого поля
            name = (String) field.get(myClass);

            // Также можно изменить данные поля
            field.set(myClass, (String) "Hello bro");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Снова выведем данные приватного метода
        printData(myClass);
    }
}
