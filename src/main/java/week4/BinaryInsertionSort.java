package week4;


public class BinaryInsertionSort {

    public static <Data extends Comparable<Data>> void sort(LinkedList<Data> ll) {
        for (int i = 1; i < ll.count(); i++) {
            if (ll.get(i).compareTo(ll.get(i - 1)) < 0) {
                Data current = ll.get(i);
                int insertionPoint = findInsertionPoint(ll, i - 1, current);
                ll.remove(i);
                ll.add(insertionPoint, current);
            }
        }
    }

    public static <Data extends Comparable<Data>> int findInsertionPoint(LinkedList<Data> ll, int high, Data key) {
        int low = 0;
        int middle = 0;

        while (low <= high) {
            middle = low + (high - low) / 2;

            if (key.compareTo(ll.get(middle)) < 0) {
                high = middle - 1;
            } else if (key.compareTo(ll.get(middle)) > 0) {
                low = middle + 1;
            }
        }

        return key.compareTo(ll.get(middle)) < 0 ? middle : middle + 1;

    }
}
