package week6;

import week4.AbstractSort;

import java.util.Random;

public class Sort extends AbstractSort {
    public static void quickSort(int[] elements) {
        shuffle(elements);
        sort(elements, 0, elements.length - 1);
    }

    private static void sort(int[] elements, int low, int high) {
        if (high <= low) return;

        int p = partition(elements, low, high);
        sort(elements, low, p - 1);
        sort(elements, p + 1, high);
    }

    private static int partition(int[] elements, int low, int high) {
        int i = low;
        int j = high + 1;

        while (true) {
            while (elements[++i] < elements[low]) {
                if (i == high) break;
            }
            while (elements[--j] > elements[low]) {
                if (j == low) break;
            }

            if (j <= i) break;

            swap(elements, i, j);
        }

        swap(elements, j, low);

        return j;
    }

    private static void shuffle(int[] elements) {
        Random random = new Random();

        for (int i = 0; i < elements.length; i++) {
            int randInt = i + random.nextInt(elements.length - i);
            swap(elements, i, randInt);
        }
    }
}
