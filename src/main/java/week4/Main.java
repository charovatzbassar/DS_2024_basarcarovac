package week4;

public class Main {
    public static void main(String[] args) {
        int[] elements = {5, -1, 7, 5, 3, 11, 9};
        InsertionSort.sort(elements);

        for (int element:
             elements) {
            System.out.println(element);
        }
    }
}
