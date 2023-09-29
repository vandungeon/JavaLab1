import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int listSize = 100000;
        int elementsToInsert = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        fill(arrayList, listSize, "ArrayList");
        fill(linkedList, listSize, "LinkedList");

        randomAccess(arrayList, "ArrayList");
        randomAccess(linkedList, "LinkedList");
        sequentialAccess(arrayList, "ArrayList");
        sequentialAccess(linkedList, "LinkedList");

        insertAtBeginning(arrayList, elementsToInsert, "ArrayList");
        insertAtBeginning(linkedList, elementsToInsert, "LinkedList");
        insertInMiddle(arrayList, elementsToInsert, "ArrayList");
        insertInMiddle(linkedList, elementsToInsert, "LinkedList");
        insertAtEnd(arrayList, elementsToInsert, "ArrayList");
        insertAtEnd(linkedList, elementsToInsert, "LinkedList");
    }

    private static void fill(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));
        }
        System.out.printf("Fill of %s took: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void randomAccess(List<Integer> list, String listType) {
        int listSize = list.size();
        long time = System.currentTimeMillis();
        for (int i = 0; i < listSize; i++) {
            int element = list.get(i);
        }
        System.out.printf("Random access in %s took: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void sequentialAccess(List<Integer> list, String listType) {
        long time = System.currentTimeMillis();
        for (Integer element : list) {
            int value = element;
        }
        System.out.printf("Sequential access in %s took: %d ms%n", listType, System.currentTimeMillis() - time);
    }

    private static void insertAtBeginning(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(0, i);
        }
        System.out.printf("Insert at the beginning of %s took: %d ms%n", listType, System.currentTimeMillis() - time);
    }
    private static void insertInMiddle(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        int listSize = list.size();
        for (int i = 0; i < count; i++) {
            list.add(listSize / 2, i);
        }
        System.out.printf("Insert in the middle of %s took: %d ms%n", listType, System.currentTimeMillis() - time);
    }
    private static void insertAtEnd(List<Integer> list, int count, String listType) {
        long time = System.currentTimeMillis();
        int listSize = list.size();
        for (int i = 0; i < count; i++) {
            list.add(listSize + i, i);
        }
        System.out.printf("Insert at the end of %s took: %d ms%n", listType, System.currentTimeMillis() - time);
    }
}
