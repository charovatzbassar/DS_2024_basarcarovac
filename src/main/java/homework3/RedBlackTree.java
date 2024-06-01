package homework3;

import java.util.ArrayList;
import java.util.Arrays;

public class RedBlackTree<Entry> {
    private Node<Entry> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private final int[] lastPath = new int[]{0, 0};

    public ArrayList<Entry> get(String searchableName) {
        Node<Entry> x = root;
        lastPath[0] = lastPath[1] = 0;

        while (x != null) {
            int cmp = searchableName.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
                if (x.color == RED) {
                    lastPath[0]++;
                } else {
                    lastPath[1]++;
                }
            } else if (cmp > 0) {
                x = x.right;
                lastPath[1]++;
            } else return x.values;
        }

        return null;
    }


    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.color = BLACK;
    }

    private Node<Entry> put(Node<Entry> n, String searchableName, Entry entry) {
        if (n == null) return new Node<>(searchableName, new ArrayList<>(Arrays.asList(entry)), RED);

        int cmp = searchableName.compareTo(n.key);

        if (cmp < 0) {
            n.left = put(n.left, searchableName, entry);
        } else if (cmp > 0) {
            n.right = put(n.right, searchableName, entry);
        } else n.values.add(entry);

        if (isRed(n.right) && !isRed(n.left)) n = rotateLeft(n);

        if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);

        if (isRed(n.left) && isRed(n.right)) flipColors(n);

        n.size = 1 + size(n.left) + size(n.right);
        return n;
    }

    public ArrayList<Entry> sort() {
        Node<Entry> x = root;
        ArrayList<Node<Entry>> arr = new ArrayList<>();
        ArrayList<Entry> sorted = new ArrayList<>();

        sort(arr, x);

        for (Node<Entry> n : arr) {
            sorted.addAll(n.values);
        }


        return sorted;
    }

    private void sort(ArrayList<Node<Entry>> arr, Node<Entry> n) {
        if (n != null) {
            sort(arr, n.left);
            arr.add(n);
            sort(arr, n.right);
        }
    }

    public int[] countRedAndBlackEdges() {
        Node<Entry> x = root;

        int redEdgeCount = countRedAndBlackEdges(x);

        return new int[]{ redEdgeCount, size(x) - 1 - redEdgeCount };
    }

    private int countRedAndBlackEdges(Node<Entry> n) {
        if (n == null) return 0;

        int redEdgeCount = n.color == RED ? 1 : 0;

        redEdgeCount += countRedAndBlackEdges(n.left) + countRedAndBlackEdges(n.right);

        return redEdgeCount;
    }

    private Node<Entry> rotateLeft(Node<Entry> n) {
        Node<Entry> x = n.right;
        n.right = x.left;
        x.left = n;
        x.color = n.color;
        n.color = RED;
        n.size = 1 + size(n.left) + size(n.right);
        return x;
    }

    private Node<Entry> rotateRight(Node<Entry> n) {
        Node<Entry> x = n.left;
        n.left = x.right;
        x.right = n;
        x.color = n.color;
        n.color = RED;
        n.size = 1 + size(n.left) + size(n.right);
        return x;
    }

    private void flipColors(Node<Entry> n) {
        n.color = RED;
        n.right.color = BLACK;
        n.left.color = BLACK;
    }

    private boolean isRed(Node<Entry> n) {
        if (n == null) return false;
        return n.color == RED;
    }

    private int size(Node<Entry> n) {
        if (n == null) return 0;
        return n.size;
    }

    public int[] getLastPath() {
        return lastPath;
    }

}