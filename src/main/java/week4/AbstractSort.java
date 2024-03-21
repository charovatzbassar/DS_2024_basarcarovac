package week4;

public abstract class AbstractSort {
    public static boolean less(int v, int w) {
        return v < w;
    }

    public static void swap (int[] elements, int a, int b) {
        int temp = elements[a];
        elements[a] = elements[b];
        elements[b] = temp;
    }
}
