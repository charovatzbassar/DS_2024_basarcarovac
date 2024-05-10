package week10;

public class BinaryHeap<Data extends Comparable<Data>> {
    @SuppressWarnings("unchecked")
    private Data[] pq = (Data[]) new Comparable[2]; // because you cannot declare a generic array
    private int size = 0;

    public void insert(Data data) {
        if (this.pq.length == this.size + 1) {
            resize(2 * this.pq.length); // if full, double the size
        }
        pq[++this.size] = data;
        swim(this.size);
    }

    public Data deleteMax() {
        Data max = pq[1];

        swap(1, this.size);
        pq[this.size] = null;
        this.size--;

        // 1/4 of size, half the size
        if (this.size == this.pq.length / 4 && this.size > 0) {
            resize(this.pq.length / 2);
        }

        sink(1);

        return max;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Data findMax() {
        return this.pq[1];
    }

    private void sink(int k) {
        while (2 * k <= this.size) {
            int j = 2*k;
            if (j < this.size && less(j,j + 1)) {
                j++;
            }

            if (!less(k, j)) break;

            swap(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private boolean less(int i, int j) {
        return this.pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        Data tmp = this.pq[i];
        this.pq[i] = this.pq[j];
        this.pq[j] = tmp;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Data[] copy = (Data[]) new Comparable[capacity];
        if (this.size >= 0) System.arraycopy(pq, 1, copy, 1, this.size); // array copy
        this.pq = copy;
    }

}
