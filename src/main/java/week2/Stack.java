package week2;

import java.util.NoSuchElementException;

public class Stack<T> {
    private Node<T> top = null;
    private int size = 0;

    public void push(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;

        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    public T pop() {
        if (this.size == 0) {
            throw new NoSuchElementException("You cannot pop from an empty stack!");
        }

        T data = this.top.data;
        this.top = this.top.next;
        this.size--;

        return data;
    }

    public T peek() {
        if (this.size == 0) {
            throw new NoSuchElementException("You cannot peek from an empty stack!");
        }

        return this.top.data;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

}
