package week3;

public class Sort {
    private static boolean swapped = false;
    public static <Data extends Comparable<Data>> void bubbleSort(Data[] elements) {
        for (int i = 0; i < elements.length; i++) {
            swapped = false;
            for (int j = 1; j < elements.length - i; j++) {
                if (elements[j-1].compareTo(elements[j]) > 0) {
                    Data temp = elements[j-1];
                    elements[j-1] = elements[j];
                    elements[j] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
