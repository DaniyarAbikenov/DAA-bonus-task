import java.util.*;

public class KruskalMST {

    public static List<Edge> buildMST(Graph g) {
        List<Edge> result = new ArrayList<>();
        Collections.sort(g.edges);

        DSU dsu = new DSU(g.n);

        for (Edge e : g.edges) {
            if (dsu.union(e.u, e.v)) {
                result.add(e);
            }
        }
        return result;
    }
}
