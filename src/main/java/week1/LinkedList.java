package week1;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void addToFront(T data) {
        Node<T> node = new Node<T>();
        node.data = data;
        node.next = this.head;
        this.head = node;



        this.size++;
    }

    public void removeFromFront() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("You cannot remove from an empty list!");
        }
        this.head = this.head.next;
        this.size--;
    }

    public void addToRear(T data) {
        Node<T> node = new Node<>();
        node.data = data;

        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> current = this.head;

            while(current.next != null) {
                current = current.next;
            }

            current.next = node;
        }
        this.size++;
    }

    public void removeFromRear() {
        if (this.head == null) {
            throw new IndexOutOfBoundsException("You cannot remove from an empty list!");
        } else if (this.size == 1) {
            this.head = null;
        } else {
            Node<T> current = this.head;

            while(current.next.next != null) {
                current = current.next;
            }

            current.next = null;
        }

        this.size--;
    }

    public T get(int index) {

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index does not exist!");
        }

        Node<T> current = this.head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;

    }

    public int count() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void reverse() {
        Node<T> current = this.head;
        Node<T> previous = null;

        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.head = previous;
    }

    public void add(int index, T data) {

        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index does not exist!");
        }

        if (index == 0) {
            this.addToFront(data);
            return;
        }

        Node<T> newNode = new Node<>();
        newNode.data = data;

        Node<T> current = this.head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }


        newNode.next = current.next;
        current.next = newNode;

        this.size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index does not exist!");
        }

        if (this.size == 0) {
            throw new IndexOutOfBoundsException("You cannot remove from an empty list!");
        }

        if (index == 0) {
            this.removeFromFront();
            return;
        }

        Node<T> current = this.head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;

        this.size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }

}
