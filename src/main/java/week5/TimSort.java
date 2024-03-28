package week5;

public class TimSort {
    public static <Data extends Comparable<Data>> void sort(Data[] elements, int threshold) {

        Data[] aux = (Data[]) new Comparable[elements.length];

        int runLength = calculateRunLength(elements.length, threshold);

        for (int i = 0; i < elements.length; i+=runLength) {
            int end = runLength + i - 1;
            if (end > elements.length - 1) end = elements.length;

            insertionSort(elements, i, end);
        }

        int mergeSize = runLength;

        while (mergeSize < elements.length) {
            for (int i = 0; i < elements.length; i+= mergeSize*2) {
                int mid = i + mergeSize - 1;
                int right = i - 1 + 2*mergeSize;
                if (right > elements.length - 1) right = elements.length - 1;

                if (mid < right) merge(elements, aux, i, mid, right);
            }

            mergeSize *= 2;
        }



    }

    public static <Data extends Comparable<Data>> void insertionSort(Data[] elements, int low, int high) {

        if (high >= elements.length) high = elements.length - 1;

        for (int i = low; i <= high; i++) {
            for (int j = i; j > low; j--) {
                if (elements[j].compareTo(elements[j - 1]) < 0) {
                    Data temp = elements[j];
                    elements[j] = elements[j - 1];
                    elements[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static <Data extends Comparable<Data>> void merge(Data[] elements, Data[] aux, int low, int mid, int high) {
        for (int i = low; i <= high ; i++) {
            aux[i] = elements[i];
        }

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > high) {
                elements[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                elements[k] = aux[j++];
            } else {
                elements[k] = aux[i++];
            }
        }
    }

    public static int calculateRunLength(int initialLength, int threshold) {
        int remainder = 0;
        int runLength = initialLength;

        while (runLength > threshold) {
            if (runLength % 2 != 0) {
                remainder = 1;
            }

            runLength /= 2;
        }

        return runLength + remainder;
    }
}
