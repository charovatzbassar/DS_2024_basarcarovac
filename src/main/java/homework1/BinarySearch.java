package homework1;


import java.lang.reflect.Field;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchTerm, String field) throws NoSuchFieldException, IllegalAccessException {
        int[] indices = new int[2];

        indices[0] = findFirstOccurrence(entries, searchTerm, field);
        indices[1] = findLastOccurrence(entries, searchTerm, field);

        return indices;
    }

    public static int[] search(Entry[] entries, String searchableName) throws NoSuchFieldException, IllegalAccessException {
        int[] indices = new int[2];

        indices[0] = findFirstOccurrence(entries, searchableName, "name");
        indices[1] = findLastOccurrence(entries, searchableName, "name");

        return indices;
    }

    private static int findFirstOccurrence(Entry[] entries, String searchTerm, String field) throws NoSuchFieldException, IllegalAccessException {
        int low = 0;
        int high = entries.length - 1;
        int result = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            Field searchField = entries[middle].getClass().getDeclaredField(field);

            searchField.setAccessible(true);
            String searchFieldValue = (String) searchField.get(entries[middle]);

            if (searchTerm.compareTo(searchFieldValue) > 0) {
                low = middle + 1;
            } else {
                if (searchTerm.equals(searchFieldValue)) {
                    result = middle;
                }
                high = middle - 1;
            }
        }

        return result;
    }

    private static int findLastOccurrence(Entry[] entries, String searchTerm, String field) throws IllegalAccessException, NoSuchFieldException {
        int low = 0;
        int high = entries.length - 1;
        int result = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            Field searchField = entries[middle].getClass().getDeclaredField(field);

            searchField.setAccessible(true);
            String searchFieldValue = (String) searchField.get(entries[middle]);


            if (searchTerm.compareTo(searchFieldValue) < 0) {
                high = middle - 1;
            } else {
                if (searchTerm.equals(searchFieldValue)) {
                    result = middle;
                }
                low = middle + 1;
            }
        }

        return result;
    }
}