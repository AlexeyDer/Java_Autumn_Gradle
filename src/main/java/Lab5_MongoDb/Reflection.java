package Lab5_MongoDb;

import Lab1_CSV.Student;
import Lab1_CSV.Teacher;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// * Задание:
// * Вывести всю информацию о студентах и учителях через рефлексию

public class Reflection {
    public void printFields(Field[] fields) {
        for (Field field : fields) {

            System.out.println(field.getType().getName() + " " + field.getName());
        }
    }

    public void printMethod(Method[] methods) {
        for (Method method : methods) {
            System.out.println(method.getReturnType()+ " " + method.getName() + " " + method.getParameterTypes());
        }
    }

    public void getInfo(Class info) {
        try {
            // Выводим открытые поля
            System.out.println("Данные о классе - " + info.getName());

            System.out.println("Поля открытого досутпа: ");
            Field[] fields = info.getFields();
            printFields(fields);

            System.out.println("Поля закрытого или приватного доступа:");
            fields = info.getDeclaredFields();
            printFields(fields);

            System.out.println("\nРодительский класс: " + info.getSuperclass());

            System.out.println("\nМетоды класса: ");

            Method[] method = info.getMethods();
            printMethod(method);


            System.out.println("Конструкторы: ");
            Constructor[] constructors = info.getConstructors();

            for (Constructor constructor : constructors) {
                int i = 1;
                System.out.print(i++ + ": (");
                Class[] paramTypes = constructor.getParameterTypes();
                for (Class paramType: paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println(")");
            }



        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Reflection ref = new Reflection();

        Class infoStud = Student.class;
        Class infoTeach = Teacher.class;

        ref.getInfo(infoStud);

    }
}
