package homework1;

import java.util.Comparator;

public class MergeSort {
    public static void sort(Entry[] entries, Comparator<Entry> comparator) {
        Entry[] aux = new Entry[entries.length];

        sort(entries, aux, 0, entries.length - 1, comparator);
    }

    private static void sort(Entry[] entries, Entry[] aux, int low, int high, Comparator<Entry> comparator) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;

        sort(entries, aux, low, mid, comparator);
        sort(entries, aux, mid + 1, high, comparator);

        merge(entries, aux, low, mid, high, comparator);
    }

    private static void merge(Entry[] entries, Entry[] aux, int low, int mid, int high, Comparator<Entry> comparator) {
        for (int i = low; i <= high ; i++) {
            aux[i] = entries[i];
        }

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                entries[k] = aux[j++];
            } else if (j > high) {
                entries[k] = aux[i++];
            } else if (comparator.compare(aux[j], aux[i]) < 0) {
                entries[k] = aux[j++];
            } else {
                entries[k] = aux[i++];
            }
        }
    }


}