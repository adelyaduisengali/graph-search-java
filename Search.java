import java.util.*;

public class Search<T> {
    protected Set<Vertex<T>> marked;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected final Vertex<T> source;

    public Search(Vertex<T> source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> v) {
        return marked.contains(v);
    }

    public Iterable<Vertex<T>> pathTo(Vertex<T> v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex<T>> path = new LinkedList<>();
        for (Vertex<T> x = v; !x.equals(source); x = edgeTo.get(x)) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}