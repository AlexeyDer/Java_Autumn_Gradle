package Lab9.TestingCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
        final int n = 1000000;
        final int deleteElemIndex = 666666;
        List<Integer> arrayList = new ArrayList<>(n);
        LinkedList<Integer> linkList = new LinkedList<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        long start, end, rs;

        System.out.println("-------------------------------------------------");
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.add(i + 1);
        }
        end = System.nanoTime();
        rs = end - start;
        System.out.println("Скорость добавления элементов ArrayList: " + rs / 1000000000.0 + " секунд");

        start = System.nanoTime();
        arrayList.remove(deleteElemIndex);
        end = System.nanoTime();
        rs = end - start;
        System.out.println("Удаление из ArrayList: " + rs / 1000000000.0);


        System.out.println("-------------------------------------------------");
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkList.add(i + 1);
        }
        end = System.nanoTime();
        rs = end - start;
        System.out.println("Скорость добавления элементов LinkedList: " + rs / 1000000000.0 + " секунд");

        start = System.nanoTime();
        linkList.remove(deleteElemIndex);
        end = System.nanoTime();
        rs = end - start;
        System.out.println("Удаление из LinkedList: " + rs / 1000000000.0);


        System.out.println("-------------------------------------------------");
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            treeSet.add(i + 1);
        }
        end = System.nanoTime();
        rs = end - start;
        System.out.println("Скорость добавления элементов TreeSet: " + rs / 1000000000.0 + " секунд");

        start = System.nanoTime();
        treeSet.remove(deleteElemIndex);
        end = System.nanoTime();
        rs = end - start;
        System.out.println("Удаление из TreeSet: " + rs / 1000000000.0);

    }
}
