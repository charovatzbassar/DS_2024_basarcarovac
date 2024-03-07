package week2;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        if (this.size == 0) {
            this.head = this.tail = newNode; // assign the same value to multiple variables (shorthand)
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    public T dequeue() {
        T data;
        if (this.size == 0) {
            throw new NoSuchElementException("You cannot dequeue an empty queue!");
        } else if (this.size == 1) {
            data = this.head.data;
            this.head = this.tail = null;
        } else {
            data = this.head.data;
            this.head = this.head.next;
        }

        this.size--;
        return data;
    }

    public T peek() {
        if (this.size == 0) {
            throw new NoSuchElementException("You cannot peek from an empty stack!");
        }

        return this.head.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }
}
