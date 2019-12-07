package Lab8.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Учимся создавать экземпляр класса
public class InstanceClass {
    public static void main(String[] args) {
        MyClass myClass = null;

        try {
            // Получаем описание нашего класса
            Class clazz = Class.forName(MyClass.class.getName());

            // Получаем конструкторы класса
            Constructor[] constructors = clazz.getConstructors();

            // Выводим типы конструкторов класса
            for (Constructor constructor : constructors) {
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType: paramTypes) {
                    System.out.println(paramType.getName() + " ");
                }
                System.out.println();
            }


            // Передаем параметры конструктора
            Class[] params = {int.class, String.class};

            // Создаем объект нужного нам класса, и передадим туда параметры в конструктор для инициализации
            // нашего объекта
            myClass = (MyClass) clazz.getConstructor(params).newInstance(1, "defualt2");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(myClass);
    }
}
