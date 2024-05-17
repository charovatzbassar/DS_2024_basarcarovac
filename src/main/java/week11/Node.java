package week11;

public class Node<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value value;

    public Node<Key, Value> left, right;
    public int size = 1;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }
}
