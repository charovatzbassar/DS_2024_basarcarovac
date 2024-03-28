package week5;

public class Sort {
    public static void mergeSort(int[] elements) {
        int[] aux = new int[elements.length];

        sort(elements, aux, 0, elements.length - 1);
    }

    private static void sort(int[] elements, int[] aux, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;

        sort(elements, aux, low, mid);
        sort(elements, aux, mid + 1, high);

        merge(elements, aux, low, mid, high);
    }

    private static void merge(int[] elements, int[] aux, int low, int mid, int high) {
        for (int i = low; i <= high ; i++) {
            aux[i] = elements[i];
        } // Copies elements into the aux

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                elements[k] = aux[j++]; // Copy everything from the second half
            } else if (j > high) {
                elements[k] = aux[i++]; // Copy everything from the first half
            } else if (aux[j] < aux[i]) {
                elements[k] = aux[j++]; // Move from the right
            } else {
                elements[k] = aux[i++]; // Move from the left
            }
        }
    }
}
