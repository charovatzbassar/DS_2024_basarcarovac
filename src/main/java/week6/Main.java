package week6;

public class Main {
    public static void main(String[] args) {
        Integer[] elements = {4,3,-1,-7,7,5,10,1};
        DualPivotQuickSort.sort(elements);


        for (int i : elements) {
            System.out.println(i);
        }

    }

}
