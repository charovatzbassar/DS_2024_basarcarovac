package week1;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size = 0;

    public void addToFront(T data) {
        DoubleNode<T> node = new DoubleNode<>();
        node.data = data;
        node.next = this.head;
        node.previous = null;

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.head.previous = node;
            this.head = node;
        }


        this.size++;
    }

    public void removeFromFront() {
        if (this.head == null || this.tail == null) {
            throw new IndexOutOfBoundsException("You cannot remove from an empty list!");
        } else if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.previous = null;
        }

        this.size--;
    }

    public void addToRear(T data) {
        DoubleNode<T> node = new DoubleNode<>();
        node.data = data;
        node.previous = this.tail;
        node.next = null;

        if (this.tail == null) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }

    public void removeFromRear() {
        if (this.tail == null || this.head == null) {
            throw new IndexOutOfBoundsException("You cannot remove from an empty list!");
        } else if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.previous;
            this.tail.next = null;
        }

        this.size--;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index does not exist!");
        }

        DoubleNode<T> current = this.head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void add(int index, T data) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index does not exist!");
        }

        if (index == 0) {
            this.addToFront(data);
            return;
        }

        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.data = data;

        DoubleNode<T> current = this.head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        newNode.next.previous = newNode;
        current.next = newNode;
        newNode.previous = current;

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

        DoubleNode<T> current = this.head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        current.next.next.previous = current;

        this.size--;

    }

    public int count() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<T> {
        DoubleNode<T> current = head;

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

    public DoubleNode<T> getHead() {
        return this.head;
    }

    public DoubleNode<T> getTail() {
        return this.tail;
    }
}
