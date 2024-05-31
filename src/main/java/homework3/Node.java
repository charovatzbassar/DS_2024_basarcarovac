package homework3;

import java.util.ArrayList;

public class Node<Entry> {
    public String key;
    public ArrayList<Entry> values;
    public Node<Entry> left, right;
    public int size = 1;
    public boolean color;

    public Node(String key, ArrayList<Entry> values, boolean color) {
        this.key = key;
        this.values = values;
        this.color = color;
    }
}