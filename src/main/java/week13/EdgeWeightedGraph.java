package week13;

import java.util.ArrayList;
import java.util.Scanner;

public class EdgeWeightedGraph {
    private int V, E;
    private ArrayList<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (ArrayList<Edge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            this.adj[v] = new ArrayList<>();
        }
    }

    public EdgeWeightedGraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();

        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weight = in.nextDouble();
            addEdge(new Edge(v, w, weight));
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        this.adj[v].add(e);
        this.adj[w].add(e);
        this.E++;
    }

    public ArrayList<Edge> adj(int v) {
        return this.adj[v];
    }

    public ArrayList<Edge> edges() {
        ArrayList<Edge> edges = new ArrayList<>();

        for (int v = 0; v < this.V; v++) {
            for (Edge e: this.adj[v]) {
                if (e.other(v) > v) {
                    edges.add(e);
                }
            }
        }

        return edges;
    }

}
