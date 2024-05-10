package week10;

import java.util.Arrays;

public class HeapSort {

    /* Heap sort algorithm for generic-type data */
    public static <Data extends Comparable<Data>> void sort(Data[] elements) {
        // your code here
        BinaryHeap<Data> heap = new BinaryHeap<>();
        Arrays.stream(elements).forEach(heap::insert);

        for (int i = elements.length - 1; i >= 0; i--) {
            elements[i] = heap.deleteMax();
        }

    }
}