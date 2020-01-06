package stream;

import java.util.ArrayList;
import java.util.List;

public class app {

//    Задание:
//    Пользуясь стримом нужно создать список и выбрать из него простые числа и получить их квадраты.

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i + 1);
        }

        list.stream().filter(x -> {
            int i;

           for(i = 2; i <= x / 2; i++) {
               int k = x % i;
               if (k == 0) break;
           }
           if (i > x / 2) {
               return true;
           } else
               return false;
        }).map(x -> x * x).forEach(System.out::println);

    }
}
