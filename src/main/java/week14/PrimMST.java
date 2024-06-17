package week14;

import week13.Edge;
import week13.EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimMST {
    private boolean[] marked;
    private ArrayList<Edge> mst;
    private PriorityQueue<Edge> pq;

    public PrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new ArrayList<>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);

            if (marked[v] && marked[w]) continue;

            mst.add(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

    public ArrayList<Edge> edges() {
        return mst;
    }

    public double weight() {
        double total = 0;
        for (Edge e : mst) {
            total += e.weight();
        }
        return total;
    }
}
