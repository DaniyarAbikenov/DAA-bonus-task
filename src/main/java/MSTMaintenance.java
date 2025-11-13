import java.util.*;

public class MSTMaintenance {

    public static void removeEdge(List<Edge> mst, Edge toRemove) {
        mst.removeIf(e -> e.u == toRemove.u && e.v == toRemove.v && e.w == toRemove.w);
    }

    public static Edge findReplacement(List<Edge> mst, Graph graph, Edge removed) {

        DSU dsu = new DSU(graph.n);
        for (Edge e : mst) {
            dsu.union(e.u, e.v);
        }

        int compA = dsu.find(removed.u);
        int compB = dsu.find(removed.v);

        Edge best = null;

        for (Edge e : graph.edges) {
            int cu = dsu.find(e.u);
            int cv = dsu.find(e.v);

            if (cu != cv) {
                if (best == null || e.w < best.w) {
                    best = e;
                }
            }
        }
        return best;
    }
}
