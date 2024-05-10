package week10;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {3,4,6,2,9,1};
        HeapSort.sort(arr);

        for (int num : arr) {
            System.out.println(num);
        }
    }
}