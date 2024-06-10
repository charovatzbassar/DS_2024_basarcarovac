package week13;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KruskalMST {
    private ArrayList<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.addAll(G.edges());

        UnionFind uf = new UnionFind(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);

            if (uf.connected(v, w)) continue;

            uf.union(v, w);
            mst.add(e);
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
