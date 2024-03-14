package week3;

public class Search {
    public static int linearSearch(int[] elements, int key) {
        int length = elements.length;
        for (int i = 0; i < length; i++) {
            if (elements[i] == key) return i;
        }

        return -1;
    }

    public static int binarySearch(int[] elements, int key) {
        int low = 0;
        int high = elements.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (elements[middle] == key) return middle;

            if (elements[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
}
