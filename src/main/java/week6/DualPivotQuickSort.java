package week6;

import java.util.Random;

public class DualPivotQuickSort {


    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        shuffle(elements);
        sort(elements, 0, elements.length - 1);
    }

    public static <Data extends Comparable<Data>> void shuffle(Data[] elements) {
        Random random = new Random();

        for (int i = 0; i < elements.length; i++) {
            int randInt = i + random.nextInt(elements.length - i);
            swap(elements, i, randInt);
        }
    }

    private static <Data extends Comparable<Data>> void sort(Data[] elements, int low, int high) {
        if (high <= low) return;

        int[] partitions = partition(elements, low, high);

        sort(elements, low, partitions[0] - 1);
        sort(elements, partitions[0] + 1, partitions[1] - 1);
        sort(elements, partitions[1] + 1, high);
    }

    public static <Data extends Comparable<Data>> int[] partition(Data[] elements, int low, int high) {
        if (elements[low].compareTo(elements[high]) > 0) swap(elements, low, high);


        int l = low + 1;
        int iterator = low + 1;
        int r = high - 1;

        while (iterator <= r) {
            if (elements[iterator].compareTo(elements[low]) < 0) swap(elements, iterator++, l++);
            else if (elements[iterator].compareTo(elements[high]) > 0) swap(elements, iterator, r--);
            else iterator++;
        }

        swap(elements, low, --l);
        swap(elements, high, ++r);

        return new int[]{l, r};

    }

    private static <Data extends Comparable<Data>> void swap(Data[] elements, int i, int j) {
        Data tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }
}