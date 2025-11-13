import java.util.*;

public class Main {

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 3, 4);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 6);

        List<Edge> mst = KruskalMST.buildMST(g);
        System.out.println("MST before removal:");
        mst.forEach(System.out::println);
        Edge removed = mst.get(2);
        System.out.println("\nRemoved edge: " + removed);
        MSTMaintenance.removeEdge(mst, removed);
        DSU dsu = new DSU(g.n);
        for (Edge e : mst) dsu.union(e.u, e.v);
        System.out.println("\nComponents after removal:");
        Map<Integer, List<Integer>> comps = new HashMap<>();
        for (int i = 0; i < g.n; i++) {
            comps.computeIfAbsent(dsu.find(i), k -> new ArrayList<>()).add(i);
        }
        comps.forEach((k, v) -> System.out.println("Comp " + k + ": " + v));
        Edge replacement = MSTMaintenance.findReplacement(mst, g, removed);
        System.out.println("\nReplacement found: " + replacement);
        mst.add(replacement);
        System.out.println("\nNew MST:");
        mst.forEach(System.out::println);
    }
}
