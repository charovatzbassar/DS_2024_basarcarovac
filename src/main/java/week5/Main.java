package week5;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 1, 9, -2, 8, 7, 12, 6, 11};

        Sort.mergeSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
