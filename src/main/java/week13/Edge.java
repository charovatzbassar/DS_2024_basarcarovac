package week13;

public class Edge implements Comparable<Edge> {
    private int v, w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public int either() {
        return this.v;
    }

    public int other(int vertex) {
        if (vertex == this.w) return this.v;
        else if (vertex == this.v) return this.w;
        else throw new RuntimeException("Inconsistent edge.");
    }

    @Override
    public int compareTo(Edge o) {
        double diff = this.weight - o.weight();
        if (diff > 0) return 1;
        else if (diff < 0) return -1;
        else return 0;
    }
}
