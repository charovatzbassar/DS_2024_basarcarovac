package week13;

import java.util.ArrayList;
import java.util.Scanner;

public class Digraph {
    private int V, E;
    private ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            this.adj[v] = new ArrayList<>();
        }
    }

    public Digraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();

        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.E++;
    }

    public ArrayList<Integer> adj(int v) {
        return this.adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(this.V);

        for (int v = 0; v < V; v++) {
            for (int w: this.adj(v)) {
                R.addEdge(w, v);
            }
        }

        return R;
    }

}
