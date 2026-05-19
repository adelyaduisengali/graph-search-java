import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<T> extends Search<T> {
    private final Set<Vertex<T>> unsettledNodes;
    private final Map<Vertex<T>, Double> distances;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        this.unsettledNodes = new HashSet<>();
        this.distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<T> currentNode = getVertexWithMinimumWeight(unsettledNodes);
            unsettledNodes.remove(currentNode);
            marked.add(currentNode);

            for (Vertex<T> neighbor : graph.adjacencyList(currentNode)) {
                if (marked.contains(neighbor)) continue;

                double newDistance = getShortestDistance(currentNode) + graph.getWeight(currentNode, neighbor);

                if (newDistance < getShortestDistance(neighbor)) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getShortestDistance(Vertex<T> destination) {
        return distances.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;

        for (Vertex<T> vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;
                continue;
            }

            if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }

        return minimum;
    }

    public double getDistanceTo(Vertex<T> v) {
        return getShortestDistance(v);
    }
}