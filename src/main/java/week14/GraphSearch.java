package week14;

import week13.Graph;
import week2.Queue;

public class GraphSearch {
    private boolean[] marked;
    private int count;
    private Graph G;

    public GraphSearch(Graph G) {
        this.G = G;
        this.marked = new boolean[G.V()];
    }

    public void dfs(int v) {
        marked[v] = true;
        count++;
        System.out.println(v + " ");
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(w);
            }
        }
    }

    public void bfs(int v) {
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);

        while (!queue.isEmpty()) {
            int s = queue.dequeue();
            System.out.println(s + " ");
            for (int w : G.adj(s)) {
                if (!marked[w]) {
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public void reset() {
        marked = new boolean[G.V()];
        count = 0;
    }

    public boolean getMarked(int w) {
        return marked[w];
    }

    public int getCount() {
        return count;
    }
}
