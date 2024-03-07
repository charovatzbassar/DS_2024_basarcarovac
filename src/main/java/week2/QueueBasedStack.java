package week2;

public class QueueBasedStack<T> {
    private Queue<T> q1;
    private Queue<T> q2;
    private int size = 0;

    public QueueBasedStack() {
        this.q1 = new Queue<>();
        this.q2 = new Queue<>();
    }

    public void push(T data) {
        this.q2.enqueue(data);

        int q1Size = this.q1.size();

        for (int i = 0; i < q1Size; i++) {
            this.q2.enqueue(this.q1.dequeue());
        }

        Queue<T> temp = this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
        this.size++;
    }

    public T pop() {
        this.size--;
        return this.q1.dequeue();
    }

    public T peek() {
        return this.q1.peek();
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
