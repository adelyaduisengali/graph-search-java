public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, new Vertex<>("Almaty"));
        outputPath(djk, new Vertex<>("Kyzylorda"));

        System.out.println("--------------------------------");

        UnweightedGraph<String> graph = new UnweightedGraph<>(true);
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, new Vertex<>("Almaty"));
        outputPath(dfs, new Vertex<>("Kyzylorda"));

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, new Vertex<>("Almaty"));
        outputPath(bfs, new Vertex<>("Kyzylorda"));
    }

    public static void fillWithoutWeights(UnweightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"));
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"));
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"));
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"));
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"));
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"));
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"));
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Astana"), 2.1);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Atyrau"), 7.8);
        graph.addEdge(new Vertex<>("Atyrau"), new Vertex<>("Astana"), 7.1);
        graph.addEdge(new Vertex<>("Almaty"), new Vertex<>("Shymkent"), 7.2);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Astana"), 3.9);
        graph.addEdge(new Vertex<>("Astana"), new Vertex<>("Kostanay"), 3.5);
        graph.addEdge(new Vertex<>("Shymkent"), new Vertex<>("Kyzylorda"), 5.4);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        Iterable<Vertex<String>> path = search.pathTo(key);

        if (path == null) {
            System.out.println("No path found");
            return;
        }

        for (Vertex<String> v : path) {
            System.out.print(v + " -> ");
        }
        System.out.println("END");
    }
}