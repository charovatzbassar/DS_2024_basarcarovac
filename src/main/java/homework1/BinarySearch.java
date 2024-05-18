package homework1;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int[] indices = new int[2];

        indices[0] = findFirstOccurrence(entries, searchableName);
        if (indices[0] == -1) {
            return new int[0]; // searchableName not found
        }

        indices[1] = findLastOccurrence(entries, searchableName);

        return indices;
    }

    private static int findFirstOccurrence(Entry[] entries, String searchableName) {
        int low = 0;
        int high = entries.length - 1;
        int result = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (searchableName.compareTo(entries[middle].getName()) > 0) {
                low = middle + 1;
            } else {
                if (searchableName.equals(entries[middle].getName())) {
                    result = middle;
                }
                high = middle - 1;
            }
        }

        return result;
    }

    private static int findLastOccurrence(Entry[] entries, String searchableName) {
        int low = 0;
        int high = entries.length - 1;
        int result = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (searchableName.compareTo(entries[middle].getName()) < 0) {
                high = middle - 1;
            } else {
                if (searchableName.equals(entries[middle].getName())) {
                    result = middle;
                }
                low = middle + 1;
            }
        }

        return result;
    }
}