package homework2;

public class ProcessQueue {
    public Process[] pq = new Process[2];
    public int length = 0;

    public void addProcess(Process process) {
        if (this.pq.length == this.length + 1) {
            resize(2 * this.pq.length);
        }
        pq[++this.length] = process;
        swim(this.length);
    }

    public Process runNextProcess() {
        Process max = pq[1];

        swap(1, this.length);
        pq[this.length] = null;
        this.length--;

        if (this.length == this.pq.length / 4 && this.length > 0) {
            resize(this.pq.length / 2);
        }

        sink(1);
        return max;
    }

    public Process peekNextProcess() {
        return this.pq[1];
    }

    private void swim(int k) {
        while (k > 1 && higherPriority(k / 2, k)) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= this.length) {
            int j = 2*k;
            if (j < this.length && higherPriority(j,j + 1)) {
                j++;
            }

            if (!higherPriority(k, j)) break;

            swap(k, j);
            k = j;
        }
    }

    private boolean higherPriority(int i, int j) {
        return this.pq[i].compareTo(pq[j]) > 0;
    }

    private void swap(int i, int j) {
        Process tmp = this.pq[i];
        this.pq[i] = this.pq[j];
        this.pq[j] = tmp;
    }

    private void resize(int capacity) {
        Process[] copy = new Process[capacity];
        if (this.length >= 0) System.arraycopy(pq, 1, copy, 1, this.length);
        this.pq = copy;
    }
}