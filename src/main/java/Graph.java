import java.util.*;

public class Graph {
    int n;
    List<Edge> edges = new ArrayList<>();

    public Graph(int n) {
        this.n = n;
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new Edge(u, v, w));
    }
}
