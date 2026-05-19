import java.util.*;

public class UnweightedGraph<T> {
    private final boolean undirected;
    private final Map<Vertex<T>, List<Vertex<T>>> map = new HashMap<>();

    public UnweightedGraph() {
        this(true);
    }

    public UnweightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<T> v) {
        if (!hasVertex(v)) {
            map.put(v, new ArrayList<>());
        }
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest) {
        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);

        if (source.equals(dest) || hasEdge(source, dest)) {
            return;
        }

        map.get(source).add(dest);
        if (undirected) {
            map.get(dest).add(source);
        }
    }

    public boolean hasVertex(Vertex<T> v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex<T> source, Vertex<T> dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }

    public List<Vertex<T>> adjacencyList(Vertex<T> v) {
        if (!hasVertex(v)) return Collections.emptyList();
        return map.get(v);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<T> v : map.keySet()) {
            count += map.get(v).size();
        }
        if (undirected) count /= 2;
        return count;
    }
}